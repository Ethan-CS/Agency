package io.github.ethankelly;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	// Number of vertices in the generated graph(s)
	public static final int NUM_VERTICES = 50;
	// Partition the vertices for bipartite graphs
	public static final int NUM_VERTICES_1 = NUM_VERTICES / 2, NUM_VERTICES_2 = NUM_VERTICES - NUM_VERTICES_1;
	// Number of graphs to generate for each increment (if relevant).
	public static final int NUM_GRAPHS = 1;
	// Number of increments to vary probability over.
	public static final int P_INCREMENTS = 20;
	// Maximum probability for graphs generated using a number of vertices and probability.
	public static final double MAX_PROBABILITY = 1.00;
	// Maximum number of edges for graphs generated using a number of vertices and a number of edges.
	public static final int MAX_EDGES = 250, MIN_EDGES = 25, EDGE_INCREMENTS = 25;
	// Maximum value of k for k-Regular graphs.
	public static final int MAX_K = 5, MIN_K = 1, K_INCREMENTS = 1;
	// The graph type to be generated to run models on.
	public static String GRAPH_NAME;
	public static float P;
	public static int NUM_EDGES;
	public static int K;

	/* Store overall results */
	public static long[] winRandom = new long[3], winMixed = new long[3], winDeterministic = new long[3];
	public static List<long[]> random = new ArrayList<>(), mixed = new ArrayList<>(), deterministic = new ArrayList<>();
	// File path
	private static String PATH;

	/**
	 * Unit-tests the modelling results.
	 *
	 * @param args the graph type to use in the model.
	 */

	public static void main(String[] args) throws IOException {
		GRAPH_NAME = "Simple";
		System.out.println("  ******* NEW GRAPH ******* ");
		System.out.println(GRAPH_NAME);
		if (GraphGenerator.requiresProbToGenerate(GRAPH_NAME)) {
			// We generate this graph type with a probability
			System.out.println("Identified a graph requiring a probability.");
			runErdosRenyiModels(GRAPH_NAME, MAX_PROBABILITY, P_INCREMENTS);
		} else if (GraphGenerator.requiresEdgesToGenerate(GRAPH_NAME)) {
			// These all require a number of edges
			System.out.println("Identified a graph requiring a number of edges.");
			runIntParamModels(GRAPH_NAME, MAX_EDGES, MIN_EDGES, EDGE_INCREMENTS);
		} else if (GRAPH_NAME.equalsIgnoreCase("Regular")) {
			// This requires a value of k
			System.out.println("Identified a graph requiring a value of k.");
			runIntParamModels(GRAPH_NAME, MAX_K, MIN_K, K_INCREMENTS);
		} else {
			System.out.println("Identified a graph requiring no further parameters.");
			runNoExtraParamModels(GRAPH_NAME);
		}
		printWinData(GRAPH_NAME, "Random", random);
		printWinData(GRAPH_NAME, "Mixed", mixed);
		printWinData(GRAPH_NAME, "Deterministic", deterministic);
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
	private static void runErdosRenyiModels(String graphName, double max, double increment) throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/" + graphName + " " +
		       String.format("%.2f", max / increment) + "-" +
		       String.format("%.2f", max);
		// Make sure directories exist
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		// Loop through the probabilities (dictated by increments)
		float prob = (float) (max / increment);
		while (prob <= max) {
			PrintStream winRead = new PrintStream(PATH + "/" + String.format("%.2f", prob) + "Winner.md"),
					winData = new PrintStream(PATH + "/" + String.format("%.2f", prob) + "WinnerData.csv");
			Model.runMultiGraphTest(graphName, PATH + "/" + String.format("%.2f", prob), winRead, winData);
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("\nRunning with p = " + String.format("%.2f", prob));
			System.out.println("--- Results ---" +
			                   "\nRandom: " + Arrays.toString(winRandom) +
			                   "\nMixed: " + Arrays.toString(winMixed) +
			                   "\nDeterministic: " + Arrays.toString(winDeterministic));
			prob += (max / increment);
		}
	}

	private static void printWinData(String graphName, String allocation, List<long[]> defence) throws FileNotFoundException {
		String s = MessageFormat.format("/{0}Winner.csv", allocation);

		System.setOut(new PrintStream(new FileOutputStream(PATH + s)));
		if (GraphGenerator.requiresProbToGenerate(graphName)) {
			System.out.println("P VALUE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		} else if (GraphGenerator.requiresEdgesToGenerate(graphName)) {
			System.out.println("NUMBER OF EDGES,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		} else if (GraphGenerator.requiresKToGenerate(graphName)) {
			System.out.println("K VALUE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		} else System.out.println("PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");

		for (int i = 0; i < defence.size(); i++) {
			long[] array = defence.get(i);
			String message;
			if (GraphGenerator.requiresProbToGenerate(graphName)) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								""",
						String.format("%.2f", (float) (Math.ceil(
								(float) (i + 1) / NUM_GRAPHS) / P_INCREMENTS) * MAX_PROBABILITY),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()]
				);
			} else if (GraphGenerator.requiresEdgesToGenerate(graphName)) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								""",
						((Math.ceil(
								(float) ((i + 1)) / NUM_GRAPHS) / (MAX_EDGES / EDGE_INCREMENTS)) * MAX_EDGES),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()]
				);
			} else if (GraphGenerator.requiresKToGenerate(graphName)) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								""",
						((Math.ceil((float) (i + 1) / NUM_GRAPHS) / K_INCREMENTS) * MAX_K),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()]
				);
			} else {
				message = MessageFormat.format("""
								{0},PROXIMITY,{1}
								{0},DEGREE,{2}
								{0},PROTECTION,{3}
								""",
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()]
				);
			}
			System.out.print(message);
		}
	}
}
