package io.github.ethankelly;

import io.github.ethankelly.graphs.Graph;
import io.github.ethankelly.graphs.GraphGenerator;
import io.github.ethankelly.params.Defence;
import io.github.ethankelly.params.Protection;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class contains methods used to determine which type of model to run (which parameters to vary, which graphs to
 * generate and so on) and then uses the methods in other classes to run the appropriate models.
 */
public class ModelEngine {
	/**
	 * Watts-Strogatz (small-world) model minimum degree of each vertex.
	 */
	public static final int WS_K = 4;
	/**
	 * Current degree, e.g. for k-regular graphs or minimum degree for Watts-Strogatz generated graphs.
	 */
	public static int K;
	/**
	 * Current probability, e.g. for Erdős–Rényi graphs.
	 */
	public static float P;
	/**
	 * Minimum degree for preferential attachment graphs (generated using the Barabási–Albert model).
	 */
	public static int MIN_DEGREE;
	/**
	 * Current number of edges when this is varied in a given model for the underlying graphs.
	 */
	public static int NUM_EDGES;
	/**
	 * The data directory to store model results in.
	 */
	public static String PATH;

	/* Store overall results */
	public static long[] winRandom = new long[Defence.values().length];
	public static long[] winMixed = new long[Defence.values().length];
	public static long[] winDeterministic = new long[Defence.values().length];
	public static List<long[]> random = new ArrayList<>();
	public static List<long[]> mixed = new ArrayList<>();
	public static List<long[]> deterministic = new ArrayList<>();

	public static void runModelFromType() throws IOException {
		if (GraphGenerator.requiresProbToGenerate(Driver.GRAPH_NAME)) {
			// We generate this graph type with a probability
			System.out.println("Identified a graph requiring a probability.");
			runProbModels(Driver.GRAPH_NAME);
		} else if (GraphGenerator.requiresEdgesToGenerate(Driver.GRAPH_NAME)) {
			// These all require a number of edges
			System.out.println("Identified a graph requiring a number of edges.");
			runIntParamModels(Driver.GRAPH_NAME, Driver.MAX_EDGES, Driver.MIN_EDGES, Driver.EDGE_INCREMENTS);
		} else if (Driver.GRAPH_NAME.equalsIgnoreCase("Regular")) {
			// This requires a value of k
			System.out.println("Identified a graph requiring a value of k.");
			runIntParamModels(Driver.GRAPH_NAME, Driver.MAX_K, Driver.MIN_K, Driver.K_INCREMENTS);
		} else if (Driver.GRAPH_NAME.equalsIgnoreCase("preferential attachment")) {
			// Barabási–Albert-generated preferential attachment graph
			System.out.println("Identified a Barabási–Albert-generated preferential attachment graph");
			runPrefAttachModels();
		} else {
			System.out.println("Identified a graph requiring no further parameters.");
			runNoExtraParamModels(Driver.GRAPH_NAME);
		}
		IOUtils.printWinData(Driver.GRAPH_NAME, "Random", random);
		IOUtils.printWinData(Driver.GRAPH_NAME, "Mixed", mixed);
		IOUtils.printWinData(Driver.GRAPH_NAME, "Deterministic", deterministic);
	}

	static void runPrefAttachModels() throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/Preferential Attachment 1 - " + Driver.MAX_MIN_BA_DEGREE;
		// Make sure directory exists
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();

		int count = 1;
		while (count <= Driver.MAX_MIN_BA_DEGREE) {
			PrintStream winData = new PrintStream(PATH + "/" + count + "WinnerData.csv");
			Model.runMultiGraphModel("Preferential Attachment", PATH + "/" + count, winData);

			IOUtils.printCurrentResults("\nRunning with minimum degree = " + count);
			MIN_DEGREE = count;
			count += 1;
		}
	}

	static void runNoExtraParamModels(String graphName) throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/" + graphName;
		// Make sure directories exist
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		PrintStream winData = new PrintStream(PATH + "/WinnerData.csv");
		Model.runMultiGraphModel(graphName, PATH + "/", winData);

		IOUtils.printCurrentResults("");
	}

	static void runIntParamModels(String graphName, int max, int min, int increment) throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/" + graphName + " " + min + "-" + max;
		// Make sure directories exist
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		// Loop through all increments from minimum
		String paramType = "";
		if (GraphGenerator.requiresEdgesToGenerate(graphName)) paramType = "edges";
		else if (GraphGenerator.requiresKToGenerate(graphName)) paramType = "k";

		int count = min;
		while (count < max) {
			PrintStream winData = new PrintStream(PATH + "/" + count + "WinnerData.csv");
			Model.runMultiGraphModel(graphName, PATH + "/" + count, winData);
			IOUtils.printCurrentResults("\nRunning with " + paramType + " = " + count);
			if (GraphGenerator.requiresEdgesToGenerate(graphName)) NUM_EDGES = count;
			else if (GraphGenerator.requiresKToGenerate(graphName)) K = count;
			count += increment;
		}
	}

	static void runProbModels(String graphName) throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/" + graphName + " " +
		       String.format("%.2f", Driver.MAX_PROBABILITY / Driver.P_INCREMENTS) + "-" +
		       String.format("%.2f", Driver.MAX_PROBABILITY);
		// Make sure directories exist
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		// Loop through the probabilities (dictated by increments)
		float prob = (float) (Driver.MAX_PROBABILITY / Driver.P_INCREMENTS);
		while (P < Driver.MAX_PROBABILITY) {
			P = prob;
			PrintStream winData = new PrintStream(PATH + "/" + String.format("%.2f", prob) + "WinnerData.csv");

			Model.runMultiGraphModel(graphName, PATH + "/" +
			                                    String.format("%.2f", prob), winData);
			IOUtils.printCurrentResults("\nRunning with p = " + String.format("%.2f", prob));
			prob += (Driver.MAX_PROBABILITY / Driver.P_INCREMENTS);
		}
	}

	// Run several models in turn, examining each of the currently available defence strategies.
	static String[] runModels(Graph g, Protection protectionType) {
		// Print headings for data CSV file
		StringBuilder data = new StringBuilder();
		data.append("OUTBREAK,STRATEGY,END TURN,SUSCEPTIBLE,INFECTED,RECOVERED,PROTECTED\n");
		StringBuilder readable = new StringBuilder();
		if (IOUtils.printReadable) readable.append(new Model(g, 0, protectionType));
		for (int i = 0; i < g.getNumVertices(); i++) {
			// Initialise models
			Model m = new Model(g, i, protectionType);
			// Initialise parallel models on the generated graph
			Model[] models = new Model[Defence.values().length];
			Arrays.setAll(models, j -> m.clone());
			// Add agent information to the readable string value
			if (IOUtils.printReadable)
				readable.append("\n## Outbreak: ").append(i).append("\n").append(IOUtils.printAgents(models[0]));
			for (int j = 0; j < Defence.values().length; j++) {
				// Run the models
				String[] result = models[j].runTest(Defence.getDefence(j));
				// 0 - data, 1 - readable
				data.append(result[0]).append("\n");
				if (IOUtils.printReadable) readable.append(result[1]).append("\n");
			}
		}
		return new String[] {String.valueOf(data), String.valueOf(readable)};
	}

	// Gets the file to print overall win data, the number of graphs that were run each time and the array of allocation
	// file paths (strings) to output to and outputs the overall model results (winning strategies).
	static void updateWinData(PrintStream overallWinData, int bound, String[] allocationPaths) throws IOException {
		for (int i = 0; i < bound; i++) {
			// Get current overall winning strategies
			long[] winRan = Winner.getBestStrategies("%sWinner".formatted(allocationPaths[0]));
			long[] winMix = Winner.getBestStrategies("%sWinner".formatted(allocationPaths[1]));
			long[] winDet = Winner.getBestStrategies("%sWinner".formatted(allocationPaths[2]));
			// Update the overall results
			for (int j = 0; j < Defence.values().length; j++) {
				winRandom[j] += winRan[j];
				winMixed[j] += winMix[j];
				winDeterministic[j] += winDet[j];
			}
			// Add to the list of winning results
			random.add(winRan);
			mixed.add(winMix);
			deterministic.add(winDet);
			// Print the machine readable winning strategy results to the winner data file
			System.setOut(overallWinData);
			System.out.println(Winner.getCsvOverallWinners(winRan, winMix, winDet));
		}
	}
}
