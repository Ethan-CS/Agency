package io.github.ethankelly;

import io.github.ethankelly.graphs.Graph;
import io.github.ethankelly.graphs.GraphGenerator;
import io.github.ethankelly.params.Defence;
import io.github.ethankelly.params.Protection;

import java.io.*;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class IOUtils {
	// Ensures readable results aren't printed for large graphs
	static boolean printReadable;

	/**
	 * Method to print the winning data of the current model to the specified output.
	 *
	 * @param graphName  the graph type of the graph used in the current model.
	 * @param allocation the type of protection allocation used in the current model.
	 * @param defence    the defence results obtained.
	 * @throws FileNotFoundException if any of the files cannot be found.
	 */
	public static void printWinData(String graphName, String allocation, List<long[]> defence) throws FileNotFoundException {
		String s = MessageFormat.format("/{0}Winner.csv", allocation);

		System.setOut(new PrintStream(new FileOutputStream(ModelEngine.PATH + s)));
		if (GraphGenerator.requiresProbToGenerate(graphName)) {
			System.out.println("P VALUE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		} else if (GraphGenerator.requiresEdgesToGenerate(graphName)) {
			System.out.println("NUMBER OF EDGES,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		} else if (GraphGenerator.requiresKToGenerate(graphName)) {
			System.out.println("K VALUE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		} else if (graphName.equalsIgnoreCase("Preferential Attachment")) {
			System.out.println("MIN DEGREE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		} else System.out.println("PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");

		for (int i = 0; i < defence.size(); i++) {
			long[] array = defence.get(i);
			String message;
			if (GraphGenerator.requiresProbToGenerate(graphName)) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								{0},{1},RANDOM,{5}
								""",
						String.format("%.2f", (float) (Math.ceil(
								(float) (i + 1) / Driver.NUM_GRAPHS) / Driver.P_INCREMENTS) * Driver.MAX_PROBABILITY),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()],
						array[Defence.RANDOM.getValue()]);
			} else if (GraphGenerator.requiresEdgesToGenerate(graphName)) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								""",
						((Math.ceil(
								(float) ((i + 1)) / Driver.NUM_GRAPHS) / (Driver.MAX_EDGES / Driver.EDGE_INCREMENTS)) * Driver.MAX_EDGES),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()],
						array[Defence.RANDOM.getValue()]);
			} else if (GraphGenerator.requiresKToGenerate(graphName)) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								{0},{1},RANDOM,{5}
								""",
						((Math.ceil((float) (i + 1) / Driver.NUM_GRAPHS) / Driver.K_INCREMENTS) * Driver.MAX_K),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()],
						array[Defence.RANDOM.getValue()]);
			} else if (graphName.equalsIgnoreCase("Preferential Attachment")) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								{0},{1},RANDOM,{5}
								""",
						((Math.ceil((float) (i + 1) / Driver.NUM_GRAPHS))),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()],
						array[Defence.RANDOM.getValue()]);
			} else {
				message = MessageFormat.format("""
								{0},PROXIMITY,{1}
								{0},DEGREE,{2}
								{0},PROTECTION,{3}
								{0},RANDOM,{4}
								""",
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()],
						array[Defence.RANDOM.getValue()]);
			}
			System.out.print(message);
		}
	}

	/**
	 * Cycles through the agents list field and creates a string representation of them to be printed to the standard
	 * output. Used for testing purposes.
	 *
	 * @param model the model with agents we want to print.
	 * @return the string representation of the agents of the given model.
	 */
	public static String printAgents(Model model) {
		List<Agent> agents = model.getAgents();
		StringBuilder s = new StringBuilder();
		agents.stream().map(agent -> "\n* " + agent).forEach(s::append);
		return String.valueOf(s);
	}

	static void printCurrentResults(String extraParam) {
		setOutToConsole();
		if (!extraParam.isEmpty()) System.out.println(extraParam);
		System.out.println("--- Results ---" +
		                   "\nRandom: " + Arrays.toString(ModelEngine.winRandom) +
		                   "\nMixed: " + Arrays.toString(ModelEngine.winMixed) +
		                   "\nDeterministic: " + Arrays.toString(ModelEngine.winDeterministic));
	}

	public static void setOutToConsole() {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
	}

	static void initialisePrintArrays(String[] allocationPaths, int i, PrintStream[] data, PrintStream[] readable, PrintStream[] winner) throws FileNotFoundException {
		// Initialise the three PrintStream arrays
		for (int j = 0; j < allocationPaths.length; j++) {
			data[j] = new PrintStream(allocationPaths[j] + "Data" + i + ".csv");
			// Only create readable files if graphs are sufficiently small!
			if (printReadable) readable[j] = new PrintStream(allocationPaths[j] + "Readable" + i + ".md");
			winner[j] = new PrintStream(allocationPaths[j] + "Winner" + i + ".csv");
			// Print headings to each win file to avoid duplicated headings when written to again later
			System.setOut(winner[j]);
			System.out.println("OUTBREAK,STRATEGY,END TURN,SUSCEPTIBLE,INFECTED,RECOVERED,PROTECTED");
		}
	}

	// Gets a graph name (type of graphs to generate), path to data output, number of times to loop, paths corresponding
	// to each protection allocation and a file to output the degrees of each vertex in each graph and uses these to
	// output model results when running multi-graph models.
	static void printModelData(String graphName, String path, int bound,
	                           String[] allocationPaths, PrintStream degrees) throws IOException {
		for (int i = 0; i < bound; i++) {
			// New data, readable and winning files
			PrintStream[] data = new PrintStream[allocationPaths.length],
					readable = new PrintStream[allocationPaths.length],
					winner = new PrintStream[allocationPaths.length];
			// Initialise data output files
			initialisePrintArrays(allocationPaths, i, data, readable, winner);
			// Get required graph and print to file
			Graph g = new GraphGenerator().fromType(graphName);
			String graphFile = path + "/Graph" + i + ".csv";
			System.setOut(new PrintStream(graphFile));
			System.out.println(Graph.makeCommaSeparated(g));
			// Print degree distribution for this graph
			System.setOut(degrees);
			System.out.println(g.findDegreeDistribution());
			// Run models and print to relevant output files
			for (int j = 0; j < Protection.values().length; j++) {
				// Run models and store data in a String array
				String[] modelResults = ModelEngine.runModels(g, Protection.getProtection(j));
				// Print data
				System.setOut(data[j]);
				System.out.println(modelResults[0]);
				// Print readable (if required)
				if (printReadable) {
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

	@SuppressWarnings("unused")
	private static StringBuilder printModelMD(Model model) {
		Graph g = model.getGraph();
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
		s.append("\nThe graph is represented using the following adjacency matrix:\n\n").append(model.getGraph());

		s.append("\n## Model values\nThe values used in the model are:\n * Total defence quota each turn: ")
				.append(Driver.DEFENCE_QUOTA).append("\n * Probability with which the infection propagates: ")
				.append(Driver.PROB_OF_INFECTION);
		return s;
	}

	// Prints the strategy to 2 d.p. that has been played in a defensive turn to readable output
	static void printStrategy(Model model, StringBuilder readable, double[] strategy) {
		double[] strategyToPrint = new double[strategy.length];
		DecimalFormat df = new DecimalFormat("0.00");
		int i = 0;
		for (double d : strategy) strategyToPrint[i++] = Double.parseDouble(df.format(d));
		if (printReadable) {
			readable.append("\n\n_Strategy:_ ").append(Arrays.toString(strategyToPrint)).append("\n");
			readable.append(model.getSIRP());
		}
	}

	// Prints a message to readable output (if appropriate) at the end of the model
	static void endModelMessage(Model model, StringBuilder data, StringBuilder readable, int turn, String s) {
		if (printReadable) {
			readable.append("\n\n__Nothing more to ").append(s).append(".__\n\nEnding model with ")
					.append(model.getProtected().size()).append(" protected and ")
					.append(model.getInfected().size()).append(" infected vertices in ")
					.append(turn).append(turn == 1 ? " turn.\n\n" : " turns.\n\n");
		}
		data.append(turn).append(",").append(model.getSusceptible().size()).append(",").append(model.getInfected().size())
				.append(",").append(model.getRecovered().size()).append(",").append(model.getProtected().size());
	}

	// Based on the current defence strategy, prints appropriate information to both data and readable outputs.
	static void printWhichDefence(Defence whichDefence, StringBuilder data, StringBuilder readable) {
		switch (whichDefence) {
			case PROXIMITY -> {
				if (printReadable) readable.append("\n#### Proximity to Infection Defence\n");
				data.append("PROXIMITY,");
			}
			case DEGREE -> {
				if (printReadable) readable.append("\n#### Greatest Degree Defence\n");
				data.append("DEGREE,");
			}
			case PROTECTION -> {
				if (printReadable) readable.append("\n#### Highest Protection Defence\n");
				data.append("PROTECTION,");
			}
			case RANDOM -> {
				if (printReadable) readable.append("\n#### Random Defence Strategy");
				data.append("RANDOM,");
			}
//			case NO_DEFENCE -> {
//				if (IOUtils.printReadable) readable.append("\n#### No Defence Implementation");
//				data.append("NO DEFENCE,");
//			}
			default -> throw new IllegalStateException("Unexpected defence strategy: " + whichDefence);
		}
	}
}
