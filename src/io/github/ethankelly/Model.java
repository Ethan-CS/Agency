package io.github.ethankelly;

import io.github.ethankelly.graphs.Graph;
import io.github.ethankelly.graphs.GraphGenerator;
import io.github.ethankelly.params.Defence;
import io.github.ethankelly.params.Protection;
import io.github.ethankelly.params.State;
import io.github.ethankelly.std.Random;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.*;
import java.text.DecimalFormat;
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
public class Model implements Cloneable {
	/**
	 * The number of strategies that can be used to deploy defence
	 */
	public static final int NUM_STRATEGIES = Defence.values().length;
	private Graph graph; // Underlying graph the model runs on
	private List<Agent> agents; // Agents assigned to each graph vertex

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
	public Model(Graph graph) {
		this.graph = graph;
		this.agents = IntStream.range(0, graph.getNumVertices())
				.mapToObj(i -> new Agent(i, 0.0, 0.0, State.SUSCEPTIBLE))
				.collect(Collectors.toList());
	}

	/**
	 * Run models on several graphs - generates the required number of graphs per increment in the range of the graph
	 * parameter to be varied.
	 *
	 * @param graphName      the graph type to generate at each increment.
	 * @param path           the filepath to save model outputs and graph files.
	 * @param overallWinData the PrintStream to save model output.
	 * @throws IOException if any of the directories cannot be accessed or files not written to.
	 */
	public static void runMultiGraphModel(String graphName, String path, PrintStream overallWinData) throws IOException {
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
		PrintStream degrees = new PrintStream(path + "/Degrees.csv");

		// Print the detailed model results (including graphs and degrees) to relevant output streams
		printModelData(graphName, path, bound, allocationPaths, degrees);

		// Print overall model results (winning strategies) and update relevant static attributes
		printModelResults(overallWinData, bound, allocationPaths);
	}

	//Used to run three models in turn, examining each of the currently available defence strategies.
	private static String[] runModels(Graph g, Protection protectionType) {
		// Print headings for data CSV file
		StringBuilder data = new StringBuilder();
		StringBuilder readable = new StringBuilder();
		data.append("OUTBREAK,STRATEGY,END TURN,SUSCEPTIBLE,INFECTED,RECOVERED,PROTECTED\n");
		if (Print.printReadable) readable.append(new Model(g));

		for (int i = 0; i < g.getNumVertices(); i++) {
			// Initialise parallel models on the generated graph
			Model[] models = new Model[] {new Model(g), new Model(g), new Model(g), new Model(g), new Model(g)};
			// Initialise models
			Model m = new Model(g);
			// TODO this should be done with the new clone() method
			m.initialiseModel(i, protectionType);
			for (Model model : models) model.initialiseIdenticalModel(i, m);

			// Add agent information to the readable string value
			if (Print.printReadable)
				readable.append("\n## Outbreak: ").append(i).append("\n").append(Print.printAgents(models[0]));
			for (int j = 0; j < Defence.values().length; j++) {
				// Run the models
				String[] result = models[j].runTest(Defence.getDefence(j));
				// 0 - data, 1 - readable
				data.append(result[0]).append("\n");
				if (Print.printReadable) readable.append(result[1]).append("\n");
			}
		}
		return new String[] {String.valueOf(data), String.valueOf(readable)};
	}

	// Generates a graph from the String graph type
	private static Graph getGraph(String graphName) {
		// Generate the graph corresponding to the supplied graph name
		return switch (graphName.toLowerCase()) {
			case "complete" -> GraphGenerator.complete(Driver.NUM_VERTICES);
			case "tree" -> GraphGenerator.tree(Driver.NUM_VERTICES);
			case "binary-tree", "binary tree" -> GraphGenerator.binaryTree(Driver.NUM_VERTICES);
			case "path" -> GraphGenerator.path(Driver.NUM_VERTICES);
			case "cycle" -> GraphGenerator.cycle(Driver.NUM_VERTICES);
			case "star" -> GraphGenerator.star(Driver.NUM_VERTICES);
			case "wheel" -> GraphGenerator.wheel(Driver.NUM_VERTICES);
			case "erdős–rényi", "erdos-renyi", "erdos renyi" -> GraphGenerator.erdosRenyi(Driver.NUM_VERTICES, ModelEngine.P);
			case "erdős–rényi bipartite", "erdos-renyi bipartite", "erdos renyi bipartite" -> GraphGenerator.bipartite(Driver.NUM_VERTICES_1, Driver.NUM_VERTICES_2, ModelEngine.P);
			case "complete-bipartite", "complete bipartite" -> GraphGenerator.completeBipartite(Driver.NUM_VERTICES_1, Driver.NUM_VERTICES_2);
			case "regular", "k-regular" -> GraphGenerator.regular(Driver.NUM_VERTICES, ModelEngine.K);
			case "simple" -> GraphGenerator.simple(Driver.NUM_VERTICES, ModelEngine.NUM_EDGES);
			case "bipartite" -> GraphGenerator.bipartite(Driver.NUM_VERTICES_1, Driver.NUM_VERTICES_2, ModelEngine.NUM_EDGES);
			case "eulerian-path", "eulerian path" -> GraphGenerator.eulerianPath(Driver.NUM_VERTICES, ModelEngine.NUM_EDGES);
			case "eulerian-cycle", "eulerian cycle" -> GraphGenerator.eulerianCycle(Driver.NUM_VERTICES, ModelEngine.NUM_EDGES);
			case "preferential attachment", "barabási–albert" -> GraphGenerator.preferentialAttachment(Driver.NUM_VERTICES, Driver.INITIAL_NUM_VERTICES, Driver.OFFSET_EXP, ModelEngine.MIN_DEGREE);
			case "watts-strogatz", "watts strogatz" -> GraphGenerator.wattsStrogatz(Driver.NUM_VERTICES, ModelEngine.WS_K, ModelEngine.P);
			default -> throw new IllegalStateException("Unexpected value: " + graphName);
		};
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
	 * Initialises a model, using methods that determine the peril, protection and state of each agent in the model.
	 *
	 * @param outbreak       the source node of the infection in the current model.
	 * @param protectionType the protection allocation method to use in determining initial protection values (this can
	 *                       be determined randomly, deterministically using proximity to infection or a blend of both
	 *                       determinations).
	 */
	public void initialiseModel(int outbreak, Protection protectionType) {
		// Initialise a list of agents given the starting state of the graph..
		List<Agent> agents = this.getAgents();
		for (int j = 0; j < this.getNumVertices(); j++) {
			agents.set(j, new Agent(j, 0, 0, State.SUSCEPTIBLE));
			agents.get(j).setPeril(agents.get(j).findPerilRating(new int[] {outbreak}, this.getGraph()));
			agents.get(j).setProtection(agents.get(j).protectionRating(protectionType));
			agents.get(j).setState(agents.get(j).findState(new int[] {outbreak}, this));
		}
		agents.get(outbreak).setState(State.INFECTED);
		this.setAgents(agents);
	}

	/**
	 * Initialises this model object to the same attributes as the provided model.
	 *
	 * @param outbreak the source node to assign.
	 * @param that     the model to initialise attributes to equal.
	 */
	public void initialiseIdenticalModel(int outbreak, Model that) {
		// TODO do this with the new clone() method
		for (int j = 0; j < this.getNumVertices(); j++) {
			this.getAgents().set(j, new Agent(j, 0, 0, State.SUSCEPTIBLE));
			this.getAgents().get(j).setPeril(that.getAgents().get(j).getPeril());
			this.getAgents().get(j).setProtection(that.getAgents().get(j).getProtection());
			this.getAgents().get(j).setState(this.getAgents().get(j).findState(new int[] {outbreak}, this));
		}
		this.getAgents().get(outbreak).setState(State.INFECTED);
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
		int outbreak = this.getInfected().get(0).getVertex(); // TODO more than one outbreak?
		data.append(outbreak).append(",");
		// Add appropriate info to readable and data strings, depending on current method of defence
		printWhichDefence(whichDefence, data, readable);

		if (Print.printReadable) readable.append(this.getSIRP());

		int turn = 0;
		while (true) {
			if (!this.getSusceptible().isEmpty()) {
				// Print the strategy we performed, to 2 d.p. for readability
				double[] strategy = this.runDefence(whichDefence);
				printStrategy(readable, strategy);
				turn++;
			} else {
				endModelMessage(data, readable, turn, "protect");
				break;
			}
			if (!this.getSusceptible().isEmpty()) {
				List<Agent> toInfect = this.findNextBurning(Driver.PROB_OF_INFECTION);
				if (toInfect.size() == 0 && Print.printReadable) {
					readable.append("\n\n_Nothing infected._");
				} else {
					if (Print.printReadable) {
						readable.append("\n\n_Infecting:_ ");
						toInfect.stream().map(agent -> agent.getVertex() + " ").forEach(readable::append);
						readable.append("\n\n");
					}
					for (Agent agent : toInfect) {
						this.getAgents().get(agent.getVertex()).setState(State.INFECTED);
					}
				}
				if (Print.printReadable) readable.append(this.getSIRP());
				turn++;
			} else {
				endModelMessage(data, readable, turn, "infect");
				break;
			}
		}
		return new String[] {String.valueOf(data), String.valueOf(readable)};
	}

	// Stores arrays as strings that represent the vertices of the currently susceptible, infected, recovered
	// and protected vertices in order to verify that the model is working as expected.
	private String getSIRP() {
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

	/*
	 * Helper method - given a defence strategy, chooses the appropriate method to determine what should be defended
	 * and returns the result of the selected method.
	 */
	private List<Agent> getToDefend(Defence whichDefence) {
		return switch (whichDefence) {
			case PROXIMITY -> findHighestPeril(getSusceptible(), true);
			case DEGREE -> findHighestDegree(getSusceptible(), true);
			case PROTECTION -> findHighestProtection(getSusceptible());
			case RANDOM -> findRandomAgent(getSusceptible());
			case NO_DEFENCE -> new ArrayList<>();
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

		int highestDegree = 0;
		for (Agent agent : susceptibleAgents) {
			int thisDegree = this.graph.findDegree(agent.getVertex());
			if (thisDegree > highestDegree) {
				highestDegree = thisDegree;
			}
		}
		for (Agent agent : susceptibleAgents) {
			int thisDegree = this.graph.findDegree(agent.getVertex());
			if (thisDegree == highestDegree) {
				toDefend.add(agent);
			}
		}
		// Tie-breaker: if we have more than one vertex with highest degree in the graph,
		// Choose the agent with greatest peril rating and defend that one.
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
				agents.get(j).setState(agents.get(j).findState(fires, this));
			}
		}
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
		boolean infects = Random.uniform() <= probInfection;
		boolean contracts = !(Random.uniform() < defence);

		return infects && contracts;
	}

	// Based on the current defence strategy, prints appropriate information to both data and readable outputs.
	private void printWhichDefence(Defence whichDefence, StringBuilder data, StringBuilder readable) {
		switch (whichDefence) {
			case PROXIMITY -> {
				if (Print.printReadable) readable.append("\n#### Proximity to Infection Defence\n");
				data.append("PROXIMITY,");
			}
			case DEGREE -> {
				if (Print.printReadable) readable.append("\n#### Greatest Degree Defence\n");
				data.append("DEGREE,");
			}
			case PROTECTION -> {
				if (Print.printReadable) readable.append("\n#### Highest Protection Defence\n");
				data.append("PROTECTION,");
			}
			case RANDOM -> {
				if (Print.printReadable) readable.append("\n#### Random Defence Strategy");
				data.append("RANDOM,");
			}
			case NO_DEFENCE -> {
				if (Print.printReadable) readable.append("\n#### No Defence Implementation");
				data.append("NO DEFENCE,");
			}
			default -> throw new IllegalStateException("Unexpected defence strategy: " + whichDefence);
		}
	}

	// Prints a message to readable output (if appropriate) at the end of the model
	private void endModelMessage(StringBuilder data, StringBuilder readable, int turn, String s) {
		if (Print.printReadable) {
			readable.append("\n\n__Nothing more to ").append(s).append(".__\n\nEnding model with ")
					.append(this.getProtected().size()).append(" protected and ")
					.append(this.getInfected().size()).append(" infected vertices in ")
					.append(turn).append(turn == 1 ? " turn.\n\n" : " turns.\n\n");
		}
		data.append(turn).append(",")
				.append(this.getSusceptible().size()).append(",")
				.append(this.getInfected().size()).append(",")
				.append(this.getRecovered().size()).append(",")
				.append(this.getProtected().size());
	}

	// Prints the strategy to 2 d.p. that has been played in a defensive turn to readable output
	private void printStrategy(StringBuilder readable, double[] strategy) {
		double[] strategyToPrint = new double[strategy.length];
		DecimalFormat df = new DecimalFormat("0.00");
		int i = 0;
		for (double d : strategy) strategyToPrint[i++] = Double.parseDouble(df.format(d));
		if (Print.printReadable) {
			readable.append("\n\n_Strategy:_ ").append(Arrays.toString(strategyToPrint)).append("\n");
			readable.append(this.getSIRP());
		}
	}

	// Gets a graph name (type of graphs to generate), path to data output, number of times to loop, paths corresponding
	// to each protection allocation and a file to output the degrees of each vertex in each graph and uses these to
	// output model results when running multi-graph models.
	private static void printModelData(String graphName, String path, int bound,
	                                   String[] allocationPaths, PrintStream degrees) throws IOException {
		for (int i = 0; i < bound; i++) {
			// New data, readable and winning files
			PrintStream[] data = new PrintStream[allocationPaths.length],
					readable = new PrintStream[allocationPaths.length],
					winner = new PrintStream[allocationPaths.length];
			// Initialise the three PrintStream arrays
			for (int j = 0; j < allocationPaths.length; j++) {
				data[j] = new PrintStream(allocationPaths[j] + "Data" + i + ".csv");
				// Only create readable files if graphs are sufficiently small!
				if (Print.printReadable) readable[j] = new PrintStream(allocationPaths[j] + "Readable" + i + ".md");
				winner[j] = new PrintStream(allocationPaths[j] + "Winner" + i + ".csv");
				// Print headings to each win file to avoid duplicated headings when written to again later
				System.setOut(winner[j]);
				System.out.println("OUTBREAK,STRATEGY,END TURN,SUSCEPTIBLE,INFECTED,RECOVERED,PROTECTED");
			}
			// Get required graph and print to file
			Graph g = getGraph(graphName);
			String graphFile = path + "/Graph" + i + ".csv";
			System.setOut(new PrintStream(graphFile));
			System.out.println(Graph.makeCommaSeparated(g));
			// Print degree distribution for this graph
			System.setOut(degrees);
			System.out.println(g.findDegreeDistribution());
			// Run models and print to relevant output files
			for (int j = 0; j < Protection.values().length; j++) {
				// Run models and store data in a String array
				String[] modelResults = Model.runModels(g, Protection.getProtection(j));
				// Print data
				System.setOut(data[j]);
				System.out.println(modelResults[0]);
				// Print readable (if required)
				if (Print.printReadable) {
					System.setOut(readable[j]);
					System.out.println(modelResults[1]);
				}
				// Print winning strategies
				String dataFile = allocationPaths[j] + "Data" + i + ".csv";
				System.setOut(winner[j]);
				System.out.println(Winner.getWinners(dataFile, graphFile)[1]);
			}
		}
	}

	// Gets the file to print overall win data, the number of graphs that were run each time and the array of allocation
	// file paths (strings) to output to and outputs the overall model results (winning strategies).
	private static void printModelResults(PrintStream overallWinData, int bound, String[] allocationPaths) throws IOException {
		for (int i = 0; i < bound; i++) {
			// Get current overall winning strategies
			long[] winRan = Winner.getBestStrategies("%sWinner".formatted(allocationPaths[0]));
			long[] winMix = Winner.getBestStrategies("%sWinner".formatted(allocationPaths[1]));
			long[] winDet = Winner.getBestStrategies("%sWinner".formatted(allocationPaths[2]));
			// Update the overall results
			for (int j = 0; j < Defence.values().length; j++) {
				ModelEngine.winRandom[j] += winRan[j];
				ModelEngine.winMixed[j] += winMix[j];
				ModelEngine.winDeterministic[j] += winDet[j];
			}
			// Add to the list of winning results
			ModelEngine.random.add(winRan);
			ModelEngine.mixed.add(winMix);
			ModelEngine.deterministic.add(winDet);
			// Print the machine readable winning strategy results to the winner data file
			System.setOut(overallWinData);
			System.out.println(Winner.getCsvOverallWinners(winRan, winMix, winDet));
		}
	}

	/**
	 * Gets the results of a model from a CSV data file
	 *
	 * @param filter the heading of the data results we are interested in (number of infected agents, end turn count or
	 *               number of protected agents).
	 * @param path   the filepath where the method should locate the data files in order to obtain the results
	 * @param i      the current model number - used to keep track of which model we are getting the results for, this
	 *               value can be anywhere between zero and the total number of graphs generated in the model.
	 * @return the results of the model that have been obtained from the CSV file.
	 * @throws IOException if a specified file does not exist.
	 */
	public static CategoryDataset getResultsFromCSV(String filter,
	                                                String path,
	                                                int i) throws IOException {
		// Read in the model defence results and associated graph
		Reader in = new FileReader(path + "Data" + i + ".csv");
		List<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in).getRecords();

		// Add each result to our dataset
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		records.forEach(record -> data.addValue(Double.parseDouble(record.get(filter)),
				record.get("STRATEGY"), record.get("OUTBREAK")));
		return data;
	}

	/**
	 * Prints the details of the current model in a human-readable format (i.e. Markdown).
	 *
	 * @return a string to print to a Markdown file to describe the current model in a human-readable way.
	 */
	@Override
	public String toString() {
		Graph g = this.getGraph();
		StringBuilder s = new StringBuilder();
		s.append("# Readable results of SIRP defence strategies on a random graph\n");
		// Print information about the generated graph and modelling values
		DecimalFormat df = new DecimalFormat("0.00");

		if (!g.getName().equals("")) {
			s.append("## Generating ").append(g.getName()).append(" Graph:")
					.append("\n\nGraph generator has generated the specified graph with the following parameters:\n")
					.append("\n * Type of graph: ").append(g.getName());
		} else {
			s.append("## Reading graph from csv file").append("\n\nGraph from file has the following attributes:");
		}

		s.append("\n * Number of vertices: ").append(g.getNumVertices()).append("\n * Number of edges: ")
				.append(g.getNumEdges()).append("\n * Probability: ").append(g.getNumEdges()).append(" / ")
				.append("(").append(g.getNumVertices()).append(" * (").append(g.getNumVertices())
				.append(" - 1) / 2) = ")
				.append(Double.parseDouble(df.format(
						(double) g.getNumEdges() / (g.getNumVertices() * (g.getNumVertices() - 1) / 2.0))));
		if (!g.getName().equals("")) {
			s.append("\n * Random generator seed: ").append(GraphGenerator.getSeed()).append("\n");
		}
		s.append("\nThe graph is represented using the following adjacency matrix:\n\n").append(this.getGraph());

		s.append("\n## Model values\nThe values used in the model are:\n * Total defence quota each turn: ")
				.append(Driver.DEFENCE_QUOTA).append("\n * Probability with which the infection propagates: ")
				.append(Driver.PROB_OF_INFECTION);

		return String.valueOf(s);
	}

	@Override
	public Model clone() {
		try {
			return (Model) super.clone();
		} catch (CloneNotSupportedException e) {
			return new Model(this.getGraph(), this.getAgents());
		}
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

	private void setAgents(List<Agent> agents) {
		this.agents = agents;
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

}
