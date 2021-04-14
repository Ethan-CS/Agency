package io.github.ethankelly;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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
public class Model {
	// The number of strategies that can be used to deploy defence
	public static final int NUM_STRATEGIES = Defence.values().length;
	// Underlying graph the model runs on
	private Graph graph;
	// Agents assigned to each graph vertex
	private List<Agent> agents;

	/**
	 * Class constructor.
	 *
	 * @param graph the graph we use in the model we are creating.
	 */
	public Model(Graph graph) {
		this.graph = graph;
		// Logical test to see whether printing to readable output is feasible
		Print.printReadable = graph.getNumVertices() < 25;
		// This ensures only one instance is created, which we then update,
		// rather than creating multiple instances and so on.
		this.agents = assignAgents(graph.getNumVertices());
	}

	/**
	 * Asks the user to input (in the standard input) a number of vertices to generate a graph and returns it as an int
	 * value.
	 *
	 * @return the user input number of edges.
	 */
	public static int inputVertices() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		return s.nextInt();  // Return user input
	}

	/**
	 * Asks the user to input (in the standard input) a number of edges to generate a graph and returns it as an int
	 * value.
	 *
	 * @return the user input number of edges.
	 */
	public static int inputEdges() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of edges:");
		return s.nextInt(); // Return user input
	}

	/**
	 * This method is used to run three models in turn, examining each of the currently available defence strategies.
	 *
	 * @param models         the array of models to run in parallel.
	 * @param protectionType the method of protection allocation we use.
	 * @return a string array of size 2, the first element being a machine-readable string to print to a CSV file and
	 * the second element a human-readable string to print to a human-readable file (provided this would not be
	 * excessively large).
	 */
	public static String[] runModels(Model[] models, Protection protectionType) {
		// Print headings for data CSV file
		StringBuilder data = new StringBuilder();
		StringBuilder readable = new StringBuilder();
		data.append("OUTBREAK,STRATEGY,END TURN,SUSCEPTIBLE,INFECTED,RECOVERED,PROTECTED\n");

		// Set defence and infection probabilities to 1
		double totalDefence = 1.0, probInfection = 1.0;
		// If graph is small enough, print readable results
		readable.append(models[0].toString(totalDefence, probInfection));
		for (int i = 0; i < models[0].getNumVertices(); i++) {
			// Initialise model agents
			models[0].initialiseModel(i, protectionType);
			for (int j = 1; j < models.length; j++) {
				models[j].initialiseIdenticalModel(i, models[0]);
			}
			// Add agent information to the readable string value
			readable.append("\n## Outbreak: ").append(i).append("\n").append(Print.printAgents(models[0]));

			for (int j = 0; j < models.length; j++) {
				// Run the models
				String[] result = models[j].runTest(totalDefence, probInfection, Defence.getDefence(j));
				// 0 - data, 1 - readable
				data.append(result[0]).append("\n");
				readable.append(result[1]).append("\n");
			}

		}
		return new String[] {String.valueOf(data), String.valueOf(readable)};
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
	public static CategoryDataset getResults(String filter,
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

	public static void runMultiGraphTest(String graphName,
	                                     String path,
	                                     PrintStream overallWin,
	                                     PrintStream overallWinData) throws IOException {
		// Check if we're dealing with the complete graph, in which case we only need to run models once.
		int bound = graphName.equalsIgnoreCase("complete") ? 1 : Main.NUM_GRAPHS;

		createDirectories(path);

		for (int i = 0; i < bound; i++) {
			// Graph CSV file
			PrintStream graphFile = new PrintStream(path + "/Graph" + i + ".csv");
			// Data files
			PrintStream randomData = new PrintStream(path + "/Random/RandomData" + i + ".csv");
			PrintStream mixedData = new PrintStream(path + "/Mixed/MixedData" + i + ".csv");
			PrintStream deterministicData = new PrintStream(path + "/Deterministic/DeterministicData" + i + ".csv");
			// Winning files (print headings to each one, to avoid duplicated headings when written to again later)
			PrintStream randomWinner = new PrintStream(path + "/Random/RandomWinner" + i + ".csv");
			System.setOut(randomWinner);
			System.out.println("OUTBREAK,STRATEGY,END TURN,SUSCEPTIBLE,INFECTED,RECOVERED,PROTECTED");

			PrintStream mixedWinner = new PrintStream(path + "/Mixed/MixedWinner" + i + ".csv");
			System.setOut(mixedWinner);
			System.out.println("OUTBREAK,STRATEGY,END TURN,SUSCEPTIBLE,INFECTED,RECOVERED,PROTECTED");

			PrintStream deterministicWinner = new PrintStream(path + "/Deterministic/DeterministicWinner" + i + ".csv");
			System.setOut(deterministicWinner);
			System.out.println("OUTBREAK,STRATEGY,END TURN,SUSCEPTIBLE,INFECTED,RECOVERED,PROTECTED");

			Graph g = getGraph(graphName);

			// Print the generated graph to the appropriate file
			System.setOut(graphFile);
			System.out.println(Graph.makeCommaSeparated(g));

			// Initialise three models on the generated graph
			Model proximityModel = new Model(g),
					degreeModel = new Model(g),
					protectionModel = new Model(g);

			Model[] models = new Model[] {new Model(g), new Model(g), new Model(g)};

			// Run the models three times (for each protection allocation)
			Print.printOverallModelOutput(models, Protection.RANDOM,
					path + "/Random/Random", path + "/Graph" + i + ".csv",
					i, randomData, randomWinner);
			Print.printOverallModelOutput(models, Protection.MIXED,
					path + "/Mixed/Mixed", path + "/Graph" + i + ".csv",
					i, mixedData, mixedWinner);
			Print.printOverallModelOutput(models, Protection.DETERMINISTIC,
					path + "/Deterministic/Deterministic", path + "/Graph" + i + ".csv",
					i, deterministicData, deterministicWinner);
		}


		for (int i = 0; i < bound; i++) {
			System.setOut(overallWin);
			// Print the human readable winning strategy results to the winner readable file
			long[] winRandom = Winner.getBestStrategies(path + "/Random/RandomWinner");
			long[] winMixed = Winner.getBestStrategies(path + "/Mixed/MixedWinner");
			long[] winDeterministic = Winner.getBestStrategies(path + "/Deterministic/DeterministicWinner");

			// Update the overall results in the Main class attributes
			for (int j = 0; j < winRandom.length; j++) {
				Main.winRandom[j] += winRandom[j];
				Main.winMixed[j] += winMixed[j];
				Main.winDeterministic[j] += winDeterministic[j];
			}

			// Add to the list of winning results
			Main.random.add(winRandom);
			Main.mixed.add(winMixed);
			Main.deterministic.add(winDeterministic);

			System.out.println(Winner.getReadableOverallWinners(graphName, winRandom, winMixed, winDeterministic));

			// Print the machine readable winning strategy results to the winner data file
			System.setOut(overallWinData);
			System.out.println(Winner.getCsvOverallWinners(winRandom, winMixed, winDeterministic)
			);
		}

	}

	private static Graph getGraph(String graphName) {
		// Generate the graph corresponding to the supplied graph name
		Graph g = switch (graphName.toLowerCase()) {
			case "complete" -> GraphGenerator.complete(Main.NUM_VERTICES);
			case "tree" -> GraphGenerator.tree(Main.NUM_VERTICES);
			case "binary-tree", "binary tree" -> GraphGenerator.binaryTree(Main.NUM_VERTICES);
			case "path" -> GraphGenerator.path(Main.NUM_VERTICES);
			case "cycle" -> GraphGenerator.cycle(Main.NUM_VERTICES);
			case "star" -> GraphGenerator.star(Main.NUM_VERTICES);
			case "wheel" -> GraphGenerator.wheel(Main.NUM_VERTICES);
			case "erdős–rényi", "erdos-renyi", "erdos renyi" -> GraphGenerator.erdosRenyi(Main.NUM_VERTICES, Main.P);
			case "erdős–rényi bipartite", "erdos-renyi bipartite", "erdos renyi bipartite" -> GraphGenerator.bipartite(Main.NUM_VERTICES_1, Main.NUM_VERTICES_2, Main.P);
			case "complete-bipartite", "complete bipartite" -> GraphGenerator.completeBipartite(Main.NUM_VERTICES_1, Main.NUM_VERTICES_2);
			case "regular", "k-regular" -> GraphGenerator.regular(Main.NUM_VERTICES, Main.K);
			case "simple" -> GraphGenerator.simple(Main.NUM_VERTICES, Main.NUM_EDGES);
			case "bipartite" -> GraphGenerator.bipartite(Main.NUM_VERTICES_1, Main.NUM_VERTICES_2, Main.NUM_EDGES);
			case "eulerian-path", "eulerian path" -> GraphGenerator.eulerianPath(Main.NUM_VERTICES, Main.NUM_EDGES);
			case "eulerian-cycle", "eulerian cycle" -> GraphGenerator.eulerianCycle(Main.NUM_VERTICES, Main.NUM_EDGES);
			default -> throw new IllegalStateException("Unexpected value: " + graphName);
		};
		return g;
	}

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

	/*
	 * We set the list of agents by creating a new agent for each vertex and setting peril and protection initially to
	 * zero and state to susceptible. We then go on to assign the actual ratings and states to each agent once we
	 * initialise the graph and decide on a vertex location for the outbreak to begin at. This method is called only
	 * once, at the start of the method when we do not have an instance of the field yet.
	 */
	private List<Agent> assignAgents(int numVertices) {
		List<Agent> agents = IntStream.range(0, numVertices)
				.mapToObj(i -> new Agent(i, 0.0, 0.0, State.SUSCEPTIBLE))
				.collect(Collectors.toList());
		this.agents = agents;
		return agents;
	}

	/**
	 * Prints the details of the current model in a human-readable format (i.e. Markdown).
	 *
	 * @param totalDefence  the total defence quota assigned to the model.
	 * @param probInfection the probability with which the infection we are modelling propagates.
	 * @return a string to print to a Markdown file to describe the current model in a human-readable way.
	 */
	public String toString(double totalDefence, double probInfection) {
		Graph g = this.getGraph();
		StringBuilder s = new StringBuilder();
		s.append("# Readable results of SIRP defence strategies on a random graph\n");
		// Print information about the generated graph and modelling values
		DecimalFormat df = new DecimalFormat("0.00");

		if (!g.getName().equals("")) {
			s.append("## Generating ").append(g.getName()).append(" Graph:");
		} else {
			s.append("## Reading graph from csv file");
		}

		if (!g.getName().equals("")) {
			s.append("\n\nGraph generator has generated the specified graph with the following parameters:\n")
					.append("\n * Type of graph: ").append(g.getName());
		} else s.append("\n\nGraph from file has the following attributes:");
		s.append("\n * Number of vertices: ").append(g.getNumVertices()).append("\n * Number of edges: ")
				.append(g.getNumEdges()).append("\n * Probability: ").append(g.getNumEdges()).append(" / ")
				.append("(").append(g.getNumVertices()).append(" * (").append(g.getNumVertices())
				.append(" - 1) / 2) = ")
				.append(Double.parseDouble(df.format(
						(double) g.getNumEdges() / (g.getNumVertices() * (g.getNumVertices() - 1) / 2.0))));
		if (!g.getName().equals("")) {
			s.append("\n * Random generator seed: ").append(GraphGenerator.getSeed()).append("\n");
		}
		s.append("\nThe graph is represented using the following adjacency matrix:\n\n");
		s.append(this.getGraph());

		s.append("\n## Model values");
		s.append("\nThe values used in the model are:\n * Total defence quota each turn: ")
				.append(totalDefence).append("\n * Probability with which the infection propagates: ")
				.append(probInfection);

		return String.valueOf(s);
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
		for (int j = 0; j < this.getNumVertices(); j++) {
			this.getAgents().set(j, new Agent(j, 0, 0, State.SUSCEPTIBLE));
			this.getAgents().get(j).setPeril(this.getAgents().get(j).perilRating(new int[] {outbreak}, this.getGraph()));
			this.getAgents().get(j).setProtection(this.getAgents().get(j).protectionRating(protectionType));
			this.getAgents().get(j).setState(this.getAgents().get(j).findState(new int[] {outbreak}, this));
		}
		this.getAgents().get(outbreak).setState(State.INFECTED);
	}

	/**
	 * Initialises this model object to the same attributes as the provided model.
	 *
	 * @param outbreak the source node to assign.
	 * @param that     the model to initialise attributes to equal.
	 */
	public void initialiseIdenticalModel(int outbreak, Model that) {
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
	 * @param totalDefence           the total amount of protection improvement that can be distributed to susceptible
	 *                               vertices each defensive turn.
	 * @param probabilityOfInfection the probability with which the infection propagates.
	 * @param whichDefence           the choice of defence strategy.
	 * @return a string array - string at the first position is the human readable result of the test to be printed to a
	 * Markdown file, the string at the second position is the machine readable result to be printed to a CSV file.
	 */
	public String[] runTest(double totalDefence, double probabilityOfInfection, Defence whichDefence) {
		StringBuilder data = new StringBuilder();
		StringBuilder readable = new StringBuilder();

		int outbreak = this.getInfected().get(0).getVertex(); // TODO more than one outbreak?
		data.append(outbreak).append(",");
		switch (whichDefence) {
			case PROXIMITY -> {
				readable.append("\n#### Proximity to Infection Defence\n");
				data.append("PROXIMITY,");
			}
			case DEGREE -> {
				readable.append("\n#### Greatest Degree Defence\n");
				data.append("DEGREE,");
			}
			case PROTECTION -> {
				readable.append("\n#### Highest Protection Defence\n");
				data.append("PROTECTION,");
			}
			default -> throw new IllegalStateException("Unexpected value: " + whichDefence);
		}

		readable.append(this.getSIRP());

		int turn = 0;
		while (true) {
			if (!this.getSusceptible().isEmpty()) {
				// Print the strategy we performed. Each increase is to
				// 2 dp when printed, but maintains full length in usage.
				double[] strategy = this.runDefence(totalDefence, whichDefence);

				double[] strategyToPrint = new double[strategy.length];
				DecimalFormat df = new DecimalFormat("0.00");
				int i = 0;
				for (double d : strategy) strategyToPrint[i++] = Double.parseDouble(df.format(d));
				readable.append("\n\n_Strategy:_ ").append(Arrays.toString(strategyToPrint)).append("\n");
				readable.append(this.getSIRP());

				turn++;
			} else {
				readable.append("\n\n__Nothing more to protect.__\n\nEnding model with ")
						.append(this.getProtected().size()).append(" protected and ")
						.append(this.getInfected().size()).append(" infected vertices in ")
						.append(turn).append(turn == 1 ? " turn.\n\n" : " turns.\n\n");
				break;
			}
			if (!this.getSusceptible().isEmpty()) {
				List<Agent> toInfect = this.findNextBurning(probabilityOfInfection);
				if (!toInfect.isEmpty()) {
					readable.append("\n\n_Infecting:_ ");
					toInfect.stream().map(agent -> agent.getVertex() + " ").forEach(readable::append);
					readable.append("\n\n");
				} else {
					readable.append("\n\n_Nothing infected._");
				}
				readable.append(this.getSIRP());
				turn++;
			} else {
				readable.append("\n\n__Nothing more to infect.__\n\nEnding model with ")
						.append(this.getProtected().size()).append(" protected and ")
						.append(this.getInfected().size()).append(" infected vertices in ")
						.append(turn).append(turn == 1 ? " turn.\n\n" : " turns.\n\n");
				break;
			}
		}
		data.append(turn).append(",")
				.append(this.getSusceptible().size()).append(",")
				.append(this.getInfected().size()).append(",")
				.append(this.getRecovered().size()).append(",")
				.append(this.getProtected().size());
		return new String[] {String.valueOf(data), String.valueOf(readable)};
	}

	/*
	 * Stores arrays as strings that represent the vertices of the currently susceptible, infected, recovered
	 * and protected vertices in order to verify that the model is working as expected.
	 */
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
	 * @param totalDefence the total defence quota that we can implement per turn.
	 * @param whichDefence a value corresponding to the defence strategy to use.
	 * @return the strategy to deploy based on the defence we have chosen.
	 */
	public double[] runDefence(double totalDefence, Defence whichDefence) {
		// Find the agents to defend by first finding the susceptible agents (only ones we are interested in defending)
		List<Agent> susceptibleAgents = this.getSusceptible();
		List<Agent> toDefend = getToDefend(whichDefence);

		// Initialise the strategy array to store the increases in defence the method determines
		double[] strategy = new double[this.getNumVertices()];
		// Split the defence quota evenly among the total vertices we have determined should be defended.
		double eachDefence = totalDefence / toDefend.size();
		loop:
		for (int i = 0; i < this.getNumVertices(); i++) {
			if (toDefend.contains(this.getAgents().get(i))) {
				// If increasing protection by the calculated amount will take protection over 1, take the defence
				// up to 1 and then redistribute the remaining defence quota amongst the other agents to defend.
				if (this.getAgents().get(i).getProtection() + eachDefence > 1) {
					double increase = 1 - this.getAgents().get(i).getProtection();
					strategy[i] = increase;
					this.getAgents().get(i).setState(State.PROTECTED);
					susceptibleAgents.remove(this.getAgents().get(i));
					toDefend.remove(this.getAgents().get(i));
					// Update the remaining defence.
					totalDefence -= strategy[i];
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
						if (nextDefence.getProtection() + eachDefence > 1) {
							// Again, if increasing protection by the calculated amount will take protection over 1,
							// take the defence up to 1.0 and then redistribute remaining quota.
							double previous = strategy[nextDefence.getVertex()];
							double increase = 1 - nextDefence.getProtection();
							strategy[nextDefence.getVertex()] += increase;
							// Remove fully defended agents from the susceptible state and add to protected state.
							this.getAgents().get(nextDefence.getVertex()).setState(State.PROTECTED);
							susceptibleAgents.remove(nextDefence);
							toDefend.remove(nextDefence);
							totalDefence -= (increase - previous);
						} else {
							strategy[nextDefence.getVertex()] += totalDefence;
							break loop;
						}
					}
				}
			}
		}
		updatePeril(strategy);
		return strategy;
	}

	/*
	 * Helper method - given a defence strategy, chooses the appropriate method to determine what should be defended
	 * and returns the result of the selected method.
	 */
	private List<Agent> getToDefend(Defence whichDefence) {
		return switch (whichDefence) {
			case PROXIMITY -> findHighestPeril();
			case DEGREE -> findHighestDegree();
			case PROTECTION -> findHighestProtection();
		};
	}

	/*
	 * Helper method: determines the vertex with highest peril in the current model. There may be more than one at the
	 * same peril value (e.g. 1.0 is quite a common peril, when an agent is directly adjacent to an infected agent),
	 * so we find all agents with the highest peril and choose which one to return as the agent to defend by determining
	 * first which of the agents has greatest degree and then, if there are still multiple candidates, we determine
	 * which of the choices has the highest degree. If there is more than one such candidate, we select the
	 * lexicographically first agent.
	 */
	private List<Agent> findHighestPeril() {
		List<Agent> susceptibleAgents =
				this.getAgents().stream().filter(
						agent -> agent.getState() == State.SUSCEPTIBLE).collect(Collectors.toList());
		List<Agent> toDefend = new ArrayList<>();
		// Find the agent or agents with highest peril rating(s) in order to increase their protection.
		double highestPeril = 0.0;
		for (Agent agent : susceptibleAgents) {
			if (agent.getPeril() > highestPeril) {
				highestPeril = agent.getPeril();
			}
		}
		for (Agent agent : susceptibleAgents) {
			if (agent.getPeril() == highestPeril) {
				toDefend.add(agent);
			}
		}
		// Tie-breaker: if we have more than one vertex with highest peril rating in the model,
		// Choose the agent at vertex with greatest degree and defend that one.
		if (toDefend.size() > 1) {
			int highestDegree = 0;
			for (Agent agent : toDefend) {
				int thisDegree = this.graph.findDegree(agent.getVertex());
				if (thisDegree > highestDegree) highestDegree = thisDegree;
			}
			for (Agent agent : toDefend) {
				int thisDegree = this.graph.findDegree(agent.getVertex());
				if (thisDegree == highestDegree) {
					// There may be more than one suitable candidate - select the
					// lexicographically first vertex to defend relative agent.
					toDefend.clear();
					toDefend.add(agent);
					break;
				}
			}
		}
		return toDefend;
	}

	/*
	 * Helper method: finds the highest degree vertex of the currently susceptible vertices. Here, if we have multiple
	 * candidates for highest degree vertex, we break ties based on their proximity to the closest infected agent.
	 */
	private List<Agent> findHighestDegree() {
		List<Agent> susceptibleAgents =
				this.getAgents().stream().filter(
						agent -> agent.getState() == State.SUSCEPTIBLE).collect(Collectors.toList());

		List<Agent> highestDegrees = new ArrayList<>();

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
				highestDegrees.add(agent);
			}
		}
		// Tie-breaker: if we have more than one vertex with highest degree in the graph,
		// Choose the agent with greatest peril rating and defend that one.
		if (highestDegrees.size() > 1) {
			double greatestPeril = 0.0;
			for (Agent agent : highestDegrees) {
				if (agent.getPeril() > greatestPeril) greatestPeril = agent.getPeril();
			}
			for (Agent agent : highestDegrees) {
				if (agent.getPeril() == greatestPeril) {
					// There may be more than one suitable candidate - select the
					// lexicographically first vertex to defend relative agent.
					highestDegrees.clear();
					highestDegrees.add(agent);
					break;
				}
			}
		}
		return highestDegrees;
	}

	/*
	 * Helper method: determines the agent or agents with the highest protection rating and returning a list of the
	 * agent or agents. We don't break ties here because it is generally unusual to find two agents with the same
	 * protection rating (as this generally involves some degree of randomness) and because this is used to determine the
	 * cheapest ways to fully protect agents, so there is usually a good deal of defence quota available that will be
	 * distributed across several candidates for cheapest protection increase.
	 */
	private List<Agent> findHighestProtection() {
		List<Agent> susceptibleAgents =
				this.getAgents().stream().filter(
						agent -> agent.getState() == State.SUSCEPTIBLE).collect(Collectors.toList());

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

	/*
	Helper method: updates the peril ratings of the current model given a particular strategy
 */
	private void updatePeril(double[] strategy) {
		// Get the currently infected vertices, so we can re-calculate peril and assign states.
		int[] fires = new int[this.getNumVertices()];
		List<Agent> onFire = this.getInfected();
		int k = 0;
		for (Agent infected : onFire) {
			fires[k++] = infected.getVertex();
		}
		fires = Arrays.copyOf(fires, k);

		for (int j = 0; j < this.getNumVertices(); j++) {
			agents.get(j).setProtection(agents.get(j).getProtection() + strategy[j]);
			agents.get(j).setState(agents.get(j).findState(fires, this));
		}
	}

	/**
	 * Given a rate (probability) of infection, we determine which susceptible vertices contract the infection from any
	 * infected neighbours.
	 *
	 * @param probabilityOfInfection the probability with which the infection spreads.
	 * @return the vertices that the method determines should be burned.
	 */
	public List<Agent> findNextBurning(double probabilityOfInfection) {
		// Find the currently infected (burning) vertices
		List<Agent> infectedAgents = this.getInfected();
		// Find the susceptible agents (the only agents we could infect).
		List<Agent> susceptibleAgents = this.getSusceptible();

		// For each susceptible agent, if it shares an edge with an infected edge, try the probabilities and see
		// if the susceptible agent becomes infected (represented by adding them to the toInfect list of agents).
		List<Agent> toInfect = new ArrayList<>();
		susceptibleAgents.forEach(susceptibleAgent ->
				infectedAgents.stream().filter(infectedAgent ->
						getGraph().isEdge(susceptibleAgent.getVertex(), infectedAgent.getVertex()) &&
						willInfect(probabilityOfInfection, susceptibleAgent.getProtection())).map(infectedAgent ->
						susceptibleAgent).forEach(toInfect::add));
		toInfect.forEach(agent -> agent.setState(State.INFECTED));
		return toInfect.stream().distinct().collect(Collectors.toList());
	}

	/*
	 * Helper method: given a probability of infection and the defence rating of the susceptible vertex that that may
	 * become infected, determines whether it will become infected.
	 */
	private boolean willInfect(double probInfection, double defence) {
		return (2 - probInfection - (1 - defence) < 1);
	}

	/**
	 * Being a graph (or network) model, we associate each model with a {@code Graph} object. The graph a given model
	 * utilises is saved and stored as an attribute of the model, hence the use of getters and setters to access it.
	 *
	 * @return the graph on which the model is based.
	 */
	public Graph getGraph() {
		return graph;
	}

	/**
	 * Sets a graph to the model attribute - that is, to store a graph object that we instantiate as a permanent
	 * attribute to the model we are working on.
	 *
	 * @param graph the graph to associate as an attribute to the current model.
	 */
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	/**
	 * We maintain a list of agents, one per vertex, that form the basis of the model. Each agent has the usual
	 * attributes of an agent object: a vertex (where it lives), a peril rating, a protection rating and a state
	 * (susceptible, infected, recovered or protected).
	 *
	 * @return the current list of agents.
	 */
	public List<Agent> getAgents() {
		return this.agents;
	}

	/**
	 * An important piece of information in the model is the number of vertices in the graph. This informs how many
	 * agents we need to generate to inhabit each vertex and the range of values we can select from to begin the
	 * outbreak.
	 *
	 * @return the assigned number of vertices in the graph model.
	 */
	public int getNumVertices() {
		return getGraph().getNumVertices();
	}

	/**
	 * Several methods benefit from having access to a List of only the susceptible vertices, such as determining the
	 * next defence strategy or which vertices contract the infection in the next time step. This method returns a List
	 * of all currently susceptible vertices.
	 *
	 * @return all agents currently in the susceptible state, as a list of agents.
	 */
	public List<Agent> getSusceptible() {
		List<Agent> agents = this.getAgents();
		List<Agent> susceptibleAgents = new ArrayList<>();

		for (Agent agent : agents) {
			if (agent.getState() == State.SUSCEPTIBLE)
				susceptibleAgents.add(agent);
		}
		return susceptibleAgents;
	}

	/**
	 * In order to monitor and analyse the progression of the model, we need to be able to view which vertices are in
	 * each state - this method returns the agents currently infected by the contagion.
	 *
	 * @return the currently infected agents, as a list of agents.
	 */
	public List<Agent> getInfected() {
		List<Agent> agents = this.getAgents();
		List<Agent> infectedAgents = new ArrayList<>();

		for (Agent agent : agents) {
			if (agent.getState() == State.INFECTED)
				infectedAgents.add(agent);
		}
		return infectedAgents;
	}

	/**
	 * In order to monitor and analyse the progression of the model, we need to be able to view which vertices are in
	 * each state - this method returns the agents that are currently recovered from the contagion, allowing us to
	 * attribute to them some (potentially zero) increase in protection due to some level of immunity, where
	 * appropriate.
	 *
	 * @return the currently recovered agents, as a list of agents.
	 */
	public List<Agent> getRecovered() {
		List<Agent> agents = this.getAgents();
		List<Agent> recoveredAgents = new ArrayList<>();

		for (Agent agent : agents) {
			if (agent.getState() == State.RECOVERED)
				recoveredAgents.add(agent);
		}
		return recoveredAgents;
	}

	/**
	 * In order to monitor and analyse the progression of the model, we need to be able to view which vertices are in
	 * each state - this method returns the currently protected vertices. These are agents who either have a protection
	 * rating of 1.0 (and can thereby not contract the infection) or have no path on the graph to any currently infected
	 * vertex.
	 *
	 * @return the currently protected vertices, as a list of agents.
	 */
	public List<Agent> getProtected() {
		List<Agent> agents = this.getAgents();
		List<Agent> protectedAgents = new ArrayList<>();

		for (Agent agent : agents) {
			if (agent.getState() == State.PROTECTED)
				protectedAgents.add(agent);
		}
		return protectedAgents;
	}
}
