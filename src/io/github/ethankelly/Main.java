package io.github.ethankelly;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/* General */
	public static final int NUM_VERTICES = 50; // Number of vertices
	public static final int NUM_GRAPHS = 10; // Number of graphs to generate in each increment
	/* Erdős–Rényi graphs */
	public static final int P_INCREMENTS = 20; // Increments to vary probability over.
	public static final double MAX_PROBABILITY = 0.20; // Maximum probability
	/* Bipartite graphs */
	public static final int NUM_VERTICES_1 = NUM_VERTICES / 2, NUM_VERTICES_2 = NUM_VERTICES - NUM_VERTICES_1;
	/* Graphs requiring a number of edges */
	public static final int MAX_EDGES = 250, MIN_EDGES = 25, EDGE_INCREMENTS = 25; // Range of number of edges
	/* k-regular graphs */
	public static final int MAX_K = 5, MIN_K = 1, K_INCREMENTS = 1;
	/* Barabási–Albert preferential attachment graphs */
	public static final int INITIAL_NUM_VERTICES = 10;
	public static final int MAX_MIN_DEGREE = 4;
	public static final double OFFSET_EXP = 1.0;
	public static String GRAPH_NAME; // The graph type to be generated
	public static String PATH; // File path
	/* Store overall results */
	public static long[] winRandom = new long[3], winMixed = new long[3], winDeterministic = new long[3];
	public static int K;
	public static List<long[]> random = new ArrayList<>(), mixed = new ArrayList<>(), deterministic = new ArrayList<>();
	public static float P;
	public static int NUM_EDGES;
	public static int MIN_DEGREE;

	/**
	 * Unit-tests the modelling results.
	 *
	 * @param args the graph type to use in the model.
	 */

	public static void main(String[] args) throws IOException {
		GRAPH_NAME = "Preferential Attachment";
		System.out.println("  ******* NEW GRAPH ******* ");
		System.out.println(GRAPH_NAME);
		if (GraphGenerator.requiresProbToGenerate(GRAPH_NAME)) {
			// We generate this graph type with a probability
			System.out.println("Identified a graph requiring a probability.");
			runErdosRenyiModels();
		} else if (GraphGenerator.requiresEdgesToGenerate(GRAPH_NAME)) {
			// These all require a number of edges
			System.out.println("Identified a graph requiring a number of edges.");
			runIntParamModels(GRAPH_NAME, MAX_EDGES, MIN_EDGES, EDGE_INCREMENTS);
		} else if (GRAPH_NAME.equalsIgnoreCase("Regular")) {
			// This requires a value of k
			System.out.println("Identified a graph requiring a value of k.");
			runIntParamModels(GRAPH_NAME, MAX_K, MIN_K, K_INCREMENTS);
		} else if (GRAPH_NAME.equalsIgnoreCase("preferential attachment")) {
			// Barabási–Albert-generated preferential attachment graph
			System.out.println("Identified a Barabási–Albert-generated preferential attachment graph");
			runPreferentialAttachmentModels();

		} else {
			System.out.println("Identified a graph requiring no further parameters.");
			runNoExtraParamModels(GRAPH_NAME);
		}
		Print.printWinData(GRAPH_NAME, "Random", random);
		Print.printWinData(GRAPH_NAME, "Mixed", mixed);
		Print.printWinData(GRAPH_NAME, "Deterministic", deterministic);
	}

	private static void runPreferentialAttachmentModels() throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/Preferential Attachment 1 - " + MAX_MIN_DEGREE;
		// Make sure directory exists
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();

		int count = 1;
		while (count <= MAX_MIN_DEGREE) {
			PrintStream winRead = new PrintStream(PATH + "/" + count + "Winner.md"),
					winData = new PrintStream(PATH + "/" + count + "WinnerData.csv");
			Model.runMultiGraphTest("Preferential Attachment", PATH + "/" + count, winRead, winData);
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("\nRunning with minimum degree = " + count);
			System.out.println("--- Results ---" +
			                   "\nRandom: " + Arrays.toString(winRandom) +
			                   "\nMixed: " + Arrays.toString(winMixed) +
			                   "\nDeterministic: " + Arrays.toString(winDeterministic));
			MIN_DEGREE = count;
			count += 1;
		}
	}

	private static void runNoExtraParamModels(String graphName) throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/" + graphName;
		// Make sure directories exist
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		PrintStream winRead = new PrintStream(PATH + "/Winner.md"),
				winData = new PrintStream(PATH + "/WinnerData.csv");
		Model.runMultiGraphTest(graphName, PATH + "/", winRead, winData);
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		System.out.println("--- Results ---" +
		                   "\nRandom: " + Arrays.toString(winRandom) +
		                   "\nMixed: " + Arrays.toString(winMixed) +
		                   "\nDeterministic: " + Arrays.toString(winDeterministic));
	}

	private static void runIntParamModels(String graphName, int max, int min, int increment) throws IOException {
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
		while (count <= max) {
			PrintStream winRead = new PrintStream(PATH + "/" + count + "Winner.md"),
					winData = new PrintStream(PATH + "/" + count + "WinnerData.csv");
			Model.runMultiGraphTest(graphName, PATH + "/" + count, winRead, winData);
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("\nRunning with " + paramType + " = " + count);
			System.out.println("--- Results ---" +
			                   "\nRandom: " + Arrays.toString(winRandom) +
			                   "\nMixed: " + Arrays.toString(winMixed) +
			                   "\nDeterministic: " + Arrays.toString(winDeterministic));
			if (GraphGenerator.requiresEdgesToGenerate(graphName)) NUM_EDGES = count;
			else if (GraphGenerator.requiresKToGenerate(graphName)) K = count;
			count += increment;
		}
	}

	@SuppressWarnings("SameParameterValue")
	private static void runErdosRenyiModels() throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/Erdős–Rényi " +
		       String.format("%.2f", MAX_PROBABILITY / P_INCREMENTS) + "-" +
		       String.format("%.2f", MAX_PROBABILITY);
		// Make sure directories exist
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		// Loop through the probabilities (dictated by increments)
		float prob = (float) (MAX_PROBABILITY / P_INCREMENTS);
		while (P <= MAX_PROBABILITY) {
			P = prob;
			PrintStream winRead = new PrintStream(PATH + "/" + String.format("%.2f", prob) + "Winner.md"),
					winData = new PrintStream(PATH + "/" + String.format("%.2f", prob) + "WinnerData.csv");
			Model.runMultiGraphTest("Erdős–Rényi", PATH + "/" + String.format("%.2f", prob), winRead, winData);
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("\nRunning with p = " + String.format("%.2f", prob));
			System.out.println("--- Results ---" +
			                   "\nRandom: " + Arrays.toString(winRandom) +
			                   "\nMixed: " + Arrays.toString(winMixed) +
			                   "\nDeterministic: " + Arrays.toString(winDeterministic));

			prob += (MAX_PROBABILITY / P_INCREMENTS);
		}
	}

}
