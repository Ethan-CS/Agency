package io.github.ethankelly;

import io.github.ethankelly.graphs.Graph;
import io.github.ethankelly.params.Defence;
import io.github.ethankelly.params.Protection;
import io.github.ethankelly.params.State;
import io.github.ethankelly.std.Random;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * The {@code Model} class contains all methods involved in storing and updating the state of play. For instance, a
 * method for getting the currently burning vertices (based on a given probability of propagation) and for updating the
 * state of the graph. The model starts with only the source node as infected, any vertices that do not have a path to
 * the source node as protected and any others as susceptible. As the model progresses, if any vertices have been
 * influenced to the level required to deem them immune to the disease (perhaps by a vaccine), then they move to the
 * protected state. Further, any transmissions that occur based on the probability of transmission and the protection
 * rating of the agents the contagion is currently adjacent to have their states updated accordingly. Then, another
 * defence turn is played and so on, until no more moves can be made. This class contains methods that check for this
 * instance after every turn and thereby end the simulation. The methods here are passed probabilities which dictate
 * infection dynamics, depending on the particular context we want to consider.
 *
 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
 */
public class Model implements Cloneable, Serializable {
	private final List<Agent> agents; // Agents assigned to each graph vertex
	private Graph graph; // Underlying graph the model runs on
	private int outbreak; // The source node of the contagion
	private Protection protectionType; // The protection allocation method used in this model

	/**
	 * Class constructor.
	 */
	public Model(Graph graph, List<Agent> agents) {
		this.graph = graph;
		this.agents = agents;
	}

	/**
	 * Class constructor.
	 */
	public Model(Graph graph, int outbreak, Protection protectionType) {
		this.graph = graph;
		// Initialise agents
		agents = IntStream.range(0, graph.getNumVertices())
				.mapToObj(i -> new Agent(i, 0.0, 0.0, State.SUSCEPTIBLE))
				.collect(Collectors.toList());
		// Calculate peril and protection ratings and determine states
		for (int j = 0; j < graph.getNumVertices(); j++) {
			agents.get(j).setPeril(agents.get(j).findPerilRating(new int[] {outbreak}, graph));
			agents.get(j).setProtection(agents.get(j).protectionRating(protectionType));
			agents.get(j).setState(findState(new int[] {outbreak}, agents.get(j)));
		}
		assert agents.get(outbreak).getState() == State.INFECTED : "Outbreak should have been assigned infected state.";
		this.outbreak = outbreak;
		this.protectionType = protectionType;
	}

	/**
	 * Run models on several graphs - generates the required number of graphs per increment in the range of the graph
	 * parameter to be varied.
	 *
	 * @param graphName      the graph type to generate at each increment.
	 * @param path           the filepath to save model outputs and graph files.
	 * @param overallWinData the PrintStream to save model output.
	 */
	public static void runMultiGraphModel(String graphName, String path, PrintStream overallWinData) {
		// Print heading to total win strategies (to avoid printing several headings throughout the file)
		System.setOut(overallWinData);
		System.out.println("PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		// Make sure directories exist (if not, method called will create them)
		createDirectories(path);
		// Check if we're dealing with the complete graph, in which case we only need to run models once.
		int bound = graphName.equalsIgnoreCase("complete") ? 1 : Driver.NUM_GRAPHS;
		// Need three different paths - one for each of the protection allocation types
		String[] allocationPaths = new String[] {
				path + "/Random/Random",
				path + "/Mixed/Mixed",
				path + "/Deterministic/Deterministic"};
		// File to print degrees of each vertex in each graph
		try (PrintStream degrees = new PrintStream(path + "/Degrees.csv")) {
			// Print the detailed model results (including graphs and degrees) to relevant output streams
			IOUtils.printModelData(graphName, path, bound, allocationPaths, degrees);
			// Print overall model results (winning strategies) and update relevant static attributes
			ModelEngine.updateWinData(overallWinData, bound, allocationPaths);
		} catch (IOException e) {
			IOUtils.setOutToConsole();
			System.out.println("Something went wrong trying to print model results: " + e);
		}
	}

	// In a given path, verifies whether the usual protection allocation (random, mixed, deterministic) paths exist.
	// If they don't, attempts to create them. ;
	@SuppressWarnings("ResultOfMethodCallIgnored")
	private static void createDirectories(String path) {
		// Make sure all necessary directories exist
		File directory = new File(path + "/"),
				random = new File(path + "/Random/"),
				mixed = new File(path + "/Mixed/"),
				deter = new File(path + "/Deterministic/");
		if (!directory.exists() || !random.exists() || !mixed.exists() || !deter.exists()) {
			directory.mkdir();
			random.mkdir();
			mixed.mkdir();
			deter.mkdir();
		}
	}

	/**
	 * Runs a test model, with a particular graph and outbreak, so that we can test and monitor the behaviours of each
	 * method and verify that the model runs as expected by printing to a file in a human-readable way.
	 *
	 * @param whichDefence the choice of defence strategy.
	 * @return a string array - string at the first position is the human readable result of the test to be printed to a
	 * Markdown file, the string at the second position is the machine readable result to be printed to a CSV file.
	 */
	public String[] runTest(Defence whichDefence) {
		// Initialise machine and human readable outputs
		StringBuilder data = new StringBuilder();
		StringBuilder readable = new StringBuilder();
		// Get the first element in the list of infected vertices (the outbreak vertex)
		int outbreak = this.getInfected().get(0).getVertex();
		data.append(outbreak).append(",");
		// Add appropriate info to readable and data strings, depending on current method of defence
		IOUtils.printWhichDefence(whichDefence, data, readable);

		if (IOUtils.printReadable) readable.append(this.getSIRP());

		int turn = 0;
		while (true) {
			for (Agent agent : this.getAgents()) {
				if (agent.getPeril() == 0 || agent.getProtection() == 1) agent.setState(State.PROTECTED);
			}
			if (this.getSusceptible().isEmpty()) {
				IOUtils.endModelMessage(this, data, readable, turn, "protect");
				break;
			} else {
				// Print the strategy we performed, to 2 d.p. for readability
				double[] strategy = this.runDefence(whichDefence);
				IOUtils.printStrategy(this, readable, strategy);
				turn++;
			}
			if (this.getSusceptible().isEmpty()) {
				IOUtils.endModelMessage(this, data, readable, turn, "infect");
				break;
			} else {
				List<Agent> toInfect = this.findNextBurning(Driver.PROB_OF_INFECTION);
				if (toInfect.size() == 0 && IOUtils.printReadable) {
					readable.append("\n\n_Nothing infected._");
				} else {
					if (IOUtils.printReadable) {
						readable.append("\n\n_Infecting:_ ");
						toInfect.stream().map(agent -> agent.getVertex() + " ").forEach(readable::append);
						readable.append("\n\n");
					}
					toInfect.forEach(agent -> this.getAgents().get(agent.getVertex()).setState(State.INFECTED));
				}
				if (IOUtils.printReadable) readable.append(this.getSIRP());
				turn++;
			}
		}
		return new String[] {String.valueOf(data), String.valueOf(readable)};
	}

	// Stores arrays as strings that represent the vertices of the currently susceptible, infected, recovered
	// and protected vertices in order to verify that the model is working as expected.
	protected String getSIRP() {
		StringBuilder s = new StringBuilder();
		s.append("\n");
		// Get the vertex locations of currently susceptible agents.
		int[] susceptible = new int[this.getSusceptible().size()];
		Arrays.setAll(susceptible, i -> this.getSusceptible().get(i).getVertex());
		// Get the vertex locations of currently infected, recovered and protected agents.
		int[] infected = new int[this.getInfected().size()];
		Arrays.setAll(infected, i -> this.getInfected().get(i).getVertex());
		int[] recovered = new int[this.getRecovered().size()];
		Arrays.setAll(recovered, i -> this.getRecovered().get(i).getVertex());
		int[] defended = new int[this.getProtected().size()];
		Arrays.setAll(defended, i -> this.getProtected().get(i).getVertex());
		// Return each array as a string (via a string builder)
		s.append(" * S: ").append(Arrays.toString(susceptible)).append("\n * I: ")
				.append(Arrays.toString(infected)).append("\n * R: ").append(Arrays.toString(recovered))
				.append("\n * P: ").append(Arrays.toString(defended));

		return String.valueOf(s);
	}

	/**
	 * We have several (heuristic) defence approaches to the stochastic model that this class instantiates. We choose
	 * one of the defence strategies currently available:
	 * <ul>
	 *      <li> Defend based on proximity to fire, breaking ties by choosing the highest degree vertex;
	 *      <li> Defend based on highest degree vertices, breaking ties with greatest proximity to fire; and
	 *      <li> Defend the agents with the highest protection ratings.
	 * </ul>
	 * <p>
	 * In the proximity approach, we find the vertex closest to fire (if there is more than one candidate, we break ties
	 * by greatest degree) and begin by defending that. We recurse until the total allocated defence is spent. Each
	 * agent has their protection ratings accordingly. When a vertex has a protection rating of 1.0, it moves to the
	 * protected state and cannot contract the infection.
	 * <p>
	 * In the degree based approach, we find the agent which inhabits the highest degree vertex in the graph
	 * underpinning the model (breaking ties this time by proximity to fire) and increase its protection as much as
	 * possible. If there is remaining defence quota after this, we recurse until this allocation is spent. We again
	 * set protection ratings to reflect the strategy to implement and where appropriate re-assign states.
	 * <p>
	 * In the highest protection defence strategy, we find the vertex (or vertices) with highest protection, that is the
	 * vertex (vertices) that would be cheapest to increase their protection rating to 1.0 and move to the protected
	 * state of the model. Then, for as long as there is remaining defence allowance, the strategy reallocates the
	 * remaining quota to the next highest protection rated vertex.
	 *
	 * @param whichDefence a value corresponding to the defence strategy to use.
	 * @return the strategy to deploy based on the defence we have chosen.
	 */
	public double[] runDefence(Defence whichDefence) {
		// Find the agents to defend by first finding the susceptible agents (only ones we are interested in defending)
		List<Agent> susceptibleAgents = this.getSusceptible();
		List<Agent> toDefend = getToDefend(whichDefence);
		double totalDefence = Driver.DEFENCE_QUOTA;

		// Initialise the strategy array to store the increases in defence the method determines
		double[] strategy = new double[this.getNumVertices()];
		// Split the defence quota evenly among the total vertices we have determined should be defended.
		double eachDefence = totalDefence / toDefend.size();
		loop:
		for (int i = 0; i < this.getNumVertices(); i++) {
			if (toDefend.contains(this.getAgents().get(i))) {
				// If increasing protection by the calculated amount will take protection over 1, take the defence
				// up to 1 and then redistribute the remaining defence quota amongst the other agents to defend.
				if (this.getAgents().get(i).getProtection() + eachDefence >= 1) {
					double increase = 1 - this.getAgents().get(i).getProtection();
					strategy[i] = increase;
					this.getAgents().get(i).setState(State.PROTECTED);
					susceptibleAgents.remove(this.getAgents().get(i));
					toDefend.remove(this.getAgents().get(i));
					// Update the remaining defence.
					totalDefence = totalDefence - strategy[i];
				} else {
					strategy[i] += eachDefence;
					break;
				}
				// If we still have defence to use, find the next most appropriate agent(s) and defend them
				while (totalDefence > 0 && !susceptibleAgents.isEmpty()) {
					// Get the agents to defend
					List<Agent> nextToDefend = getToDefend(whichDefence);
					toDefend.addAll(nextToDefend);
					eachDefence = totalDefence / (toDefend.size());
					for (Agent nextDefence : nextToDefend) {
						if (nextDefence.getProtection() + eachDefence >= 1) {
							// Again, if increasing protection by the calculated amount will take protection over 1,
							// take the defence up to 1.0 and then redistribute remaining quota.
							double previous = strategy[nextDefence.getVertex()];
							double increase = 1 - nextDefence.getProtection();
							strategy[nextDefence.getVertex()] += increase;
							// Remove fully defended agents from the susceptible state and add to protected state.
							this.getAgents().get(nextDefence.getVertex()).setState(State.PROTECTED);
							susceptibleAgents.remove(nextDefence);
							toDefend.remove(nextDefence);
							totalDefence = totalDefence - (increase - previous);
						} else {
							strategy[nextDefence.getVertex()] += totalDefence;
							break loop;
						}
					}
				}
			}
		}
		updateRatings(strategy);
		return strategy;
	}

	// Helper method - given a defence strategy, chooses the appropriate method to determine what should be defended
	// and returns the result of the selected method.
	private List<Agent> getToDefend(Defence whichDefence) {
		return switch (whichDefence) {
			case PROXIMITY -> findHighestPeril(getSusceptible(), true);
			case DEGREE -> findHighestDegree(getSusceptible(), true);
			case PROTECTION -> findHighestProtection(getSusceptible());
			case RANDOM -> findRandomAgent(getSusceptible());
//			case NO_DEFENCE -> new ArrayList<>();
		};
	}

	private List<Agent> findRandomAgent(List<Agent> susceptible) {
		List<Agent> toDefend = new ArrayList<>();
		Agent randAgent = susceptible.get(Random.uniform(susceptible.size()));
		toDefend.add(randAgent);

		return toDefend;
	}

	/*
	 * Helper method: determines the vertex with highest peril in the current model. There may be more than one at the
	 * same peril value, so we find all agents with the highest peril and choose which one to return as the agent to
	 * defend by determining first which of the agents has greatest degree and then, if there are still multiple
	 * candidates, we determine which of the choices has the highest degree. If there is more than one such candidate,
	 * we select the lexicographically first agent.
	 */
	private List<Agent> findHighestPeril(List<Agent> susceptibleAgents, boolean breakTies) {
		List<Agent> toDefend = new ArrayList<>();
		// Find the agent(s) with highest peril rating(s) in order to increase protection
		double highestPeril = susceptibleAgents.stream().mapToDouble(Agent::getPeril)
				.filter(agent -> agent >= 0.0).max().orElse(0.0);
		for (Agent agent : susceptibleAgents) if (agent.getPeril() == highestPeril) toDefend.add(agent);
		// Tie-breaker: if we have more than one vertex with highest peril rating in the model,
		// Choose the agent at vertex with greatest degree and defend that one.
		if (toDefend.size() > 1 && breakTies) toDefend = findHighestDegree(toDefend, false);
		return toDefend;
	}

	// Helper: finds the highest degree vertex of the currently susceptible vertices. If we have multiple candidates
	// for highest degree vertex, we break ties based on their proximity to the closest infected agent.
	private List<Agent> findHighestDegree(List<Agent> susceptibleAgents, boolean breakTies) {
		List<Agent> toDefend = new ArrayList<>();
		// Find the highest degree of all susceptible agents
		int highestDegree = 0;
		for (Agent agent : susceptibleAgents) {
			int thisDegree = this.graph.findDegree(agent.getVertex());
			if (thisDegree > highestDegree) {
				highestDegree = thisDegree;
			}
		}
		// Traverse susceptible agents again, adding any with degree equal to highest degree we just found
		for (Agent agent : susceptibleAgents) {
			int thisDegree = this.graph.findDegree(agent.getVertex());
			if (thisDegree == highestDegree) {
				toDefend.add(agent);
			}
		}
		// Tie-breaker: if we have more than one vertex with highest degree, defend the one with greatest peril rating
		if (toDefend.size() > 1 && breakTies) toDefend = findHighestPeril(toDefend, false);
		return toDefend;
	}

	/*
	 * Helper: determines the agent or agents with the highest protection rating and returning a list of the agent or
	 * agents. We don't break ties here because it is generally unusual to find two agents with the same protection
	 * rating (as this generally involves some degree of randomness) and because this is used to determine the cheapest
	 * ways to fully protect agents, so there is usually a good deal of defence quota available that will be distributed
	 * across several candidates for cheapest protection increase.
	 */
	private List<Agent> findHighestProtection(List<Agent> susceptibleAgents) {
		List<Agent> highestProtection = new ArrayList<>();
		// Cycle through all agents, reassign highest protection value everytime we find a greater protection rating
		double highProtection = 0.0;
		for (Agent agent : susceptibleAgents) {
			if (agent.getProtection() > highProtection) {
				highProtection = agent.getProtection();
			}
		}
		// Add any agent/agents with the highest protection rating to the list to return
		for (Agent agent : susceptibleAgents) {
			if (agent.getProtection() == highProtection) {
				highestProtection.add(agent);
			}
		}
		return highestProtection;
	}

	// Helper method: updates the peril ratings of the current model given a particular strategy
	private void updateRatings(double[] strategy) {
		// Get the currently infected vertices, so we can re-calculate peril and assign states.
		int[] fires = new int[this.getNumVertices()];
		List<Agent> onFire = this.getInfected();
		int k = 0;
		for (Agent infected : onFire) {
			fires[k++] = infected.getVertex();
		}
		fires = Arrays.copyOf(fires, k);

		for (int j = 0; j < this.getNumVertices(); j++) {
			agents.get(j).setPeril(agents.get(j).findPerilRating(fires, this.getGraph()));
			agents.get(j).setProtection(agents.get(j).getProtection() + strategy[j]);
			if (agents.get(j).getState().equals(State.SUSCEPTIBLE)) {
				agents.get(j).setState(findState(fires, agents.get(j)));
			}
		}
	}

	/*
	 * determine the state based on whether a path exists between the agent and an infected vertex. If no such path
	 * exists, we say the agent is protected. If one exists, they are susceptible. If the distance to an infected vertex
	 * is zero, then they are infected themselves. If they have been infected for a given number of turns, the agent
	 * becomes recovered for a further given number of turns.
	 */
	private State findState(int[] fires, Agent agent) {
		int vertex = agent.getVertex();
		double peril = getAgents().get(vertex).getPeril();
		double protection = getAgents().get(vertex).getProtection();
		State toSet = Arrays.stream(fires).anyMatch(fire -> vertex == fire) ? State.INFECTED : State.SUSCEPTIBLE;
		if (protection == 1.0 || peril == 0) {
			toSet = State.PROTECTED;
			agent.setProtection(1);
		}
		agent.setState(toSet);
		return toSet;
	}

	/**
	 * Given a rate (probability) of infection, we determine which susceptible vertices contract the infection from any
	 * infected neighbours.
	 *
	 * @param p the probability with which the infection spreads.
	 * @return the vertices that the method determines should be burned.
	 */
	public List<Agent> findNextBurning(double p) {
		// Find the currently infected vertices
		List<Agent> allInfected = this.getInfected();
		// Find the susceptible agents (only agents we could infect).
		List<Agent> susceptibleAgents = this.getSusceptible();

		// For each susceptible agent, if it shares an edge with an infected agent,
		// try the probabilities and see if the susceptible agent becomes infected.
		List<Agent> toInfect = new ArrayList<>();
		susceptibleAgents.forEach(susceptible -> allInfected.stream().filter(infected ->
				!toInfect.contains(susceptible) && getGraph().hasEdge(susceptible.getVertex(), infected.getVertex())
				&& willInfect(p, susceptible.getProtection())).forEachOrdered(infectedAgent -> toInfect.add(susceptible)));

		this.updateRatings(new double[this.getNumVertices()]);
		return toInfect.stream().distinct().collect(Collectors.toList());
	}

	// Helper method: given a probability of infection and the defence rating of the susceptible
	// vertex that that may become infected, determines whether it will become infected.
	private boolean willInfect(double probInfection, double defence) {
		if (probInfection == 1) {
			return true;
		} else {
			boolean infects = Random.uniform() <= probInfection;
			boolean contracts = !(Random.uniform() < defence);
			return infects && contracts;
		}
	}

	/**
	 * Prints the details of the current model in a human-readable format (i.e. Markdown).
	 *
	 * @return a string to print to a Markdown file to describe the current model in a human-readable way.
	 */
	@Override
	public String toString() {
		return this.getSIRP();
	}

	@Override
	public Model clone() {
		try {
			super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return new Model(this.getGraph(), this.getOutbreak(), this.getProtectionType());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Model model = (Model) o;

		if (!getGraph().equals(model.getGraph())) return false;
		return getAgents().equals(model.getAgents());
	}

	@Override
	public int hashCode() {
		int result = getGraph().hashCode();
		result = 31 * result + getAgents().hashCode();
		return result;
	}

	/**
	 * @return the graph on which the model is based.
	 */
	public Graph getGraph() {
		return graph;
	}

	/**
	 * @param graph the graph to associate as an attribute to the current model.
	 */
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	/**
	 * @return the current list of agents.
	 */
	public List<Agent> getAgents() {
		return this.agents;
	}

	/**
	 * @return the assigned number of vertices in the graph model.
	 */
	public int getNumVertices() {
		return getGraph().getNumVertices();
	}

	/**
	 * @return all agents currently in the susceptible state, as a list of agents.
	 */
	public List<Agent> getSusceptible() {
		return this.getAgents().stream().filter(a -> a.getState() == State.SUSCEPTIBLE).collect(Collectors.toList());
	}

	/**
	 * @return the currently infected agents, as a list of agents.
	 */
	public List<Agent> getInfected() {
		return this.getAgents().stream().filter(a -> a.getState() == State.INFECTED).collect(Collectors.toList());
	}

	/**
	 * @return the currently recovered agents, as a list of agents.
	 */
	public List<Agent> getRecovered() {
		return this.getAgents().stream().filter(a -> a.getState() == State.RECOVERED).collect(Collectors.toList());
	}

	/**
	 * @return the currently protected vertices (those who either have a protection rating of 1.0 and so can't contract
	 * or have no path to any currently infected vertex), as a list of agents.
	 */
	public List<Agent> getProtected() {
		return this.getAgents().stream().filter(a -> a.getState() == State.PROTECTED).collect(Collectors.toList());
	}

	public int getOutbreak() {
		return outbreak;
	}

	public void setOutbreak(int outbreak) {
		this.outbreak = outbreak;
	}

	public Protection getProtectionType() {
		return protectionType;
	}

	public void setProtectionType(Protection protectionType) {
		this.protectionType = protectionType;
	}
}
