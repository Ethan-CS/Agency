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
	public static final int NUM_GRAPHS = 10;
	// Number of increments to vary probability over.
	public static final int P_INCREMENTS = 20;
	// Maximum probability for graphs generated using a number of vertices and probability.
	public static final double MAX_PROBABILITY = 1.00;
	// Maximum number of edges for graphs generated using a number of vertices and a number of edges.
	public static final int MAX_EDGES = 250, MIN_EDGES = 5, EDGE_INCREMENTS = 5;
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
		String graphName = args[0];
		System.out.println("  ******* NEW GRAPH ******* ");
		System.out.println(graphName);
		GRAPH_NAME = graphName.strip();

		if (GraphGenerator.requiresProbToGenerate(GRAPH_NAME)) {
			// We generate this graph type with a probability
			runErdosRenyiModels();
		} else if (GraphGenerator.requiresEdgesToGenerate(GRAPH_NAME)) {
			// These all require a number of edges
			runIntParamModels(GRAPH_NAME, MAX_EDGES, MIN_EDGES, EDGE_INCREMENTS);
		} else if (GRAPH_NAME.equalsIgnoreCase("Regular")) {
			// This requires a value of k
			runIntParamModels(GRAPH_NAME, MAX_K, MIN_K, K_INCREMENTS);
		} else {
			PATH = "data/" + GRAPH_NAME;
			File dir = new File(PATH);
			//noinspection ResultOfMethodCallIgnored
			dir.mkdirs();
		}
		printWinData("Random", random);
		printWinData("Mixed", mixed);
		printWinData("Deterministic", deterministic);
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

	private static void runErdosRenyiModels() throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/" + GRAPH_NAME + " " +
		       String.format("%.2f", MAX_PROBABILITY / P_INCREMENTS) + "-" +
		       String.format("%.2f", MAX_PROBABILITY);
		// Make sure directories exist
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		// Loop through the probabilities (dictated by increments)
		P = (float) MAX_PROBABILITY / P_INCREMENTS;
		while (P <= MAX_PROBABILITY) {
			PrintStream winRead = new PrintStream(PATH + "/" + String.format("%.2f", P) + "Winner.md"),
					winData = new PrintStream(PATH + "/" + String.format("%.2f", P) + "WinnerData.csv");
			Model.runMultiGraphTest(GRAPH_NAME, PATH + "/" + String.format("%.2f", P), winRead, winData);
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("\nRunning with p = " + String.format("%.2f", P));
			System.out.println("--- Results ---" +
			                   "\nRandom: " + Arrays.toString(winRandom) +
			                   "\nMixed: " + Arrays.toString(winMixed) +
			                   "\nDeterministic: " + Arrays.toString(winDeterministic));
			P += MAX_PROBABILITY / P_INCREMENTS;
		}
	}

	private static void printProgress(String paramType) {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		System.out.println("\nRunning with " + paramType + " = " + String.format("%.2f", P));
		System.out.println("--- Results ---" +
		                   "\nRandom: " + Arrays.toString(winRandom) +
		                   "\nMixed: " + Arrays.toString(winMixed) +
		                   "\nDeterministic: " + Arrays.toString(winDeterministic));
	}

	private static void printWinData(String allocation, List<long[]> random) throws FileNotFoundException {
		String s = MessageFormat.format("/{0}Winner.csv", allocation);

		System.setOut(new PrintStream(new FileOutputStream(PATH + s)));
		System.out.println("P VALUE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		for (int i = 0; i < random.size(); i++) {
			long[] array = random.get(i);
			System.out.print(MessageFormat.format("""
							{0},{1},PROXIMITY,{2}
							{0},{1},DEGREE,{3}
							{0},{1},PROTECTION,{4}
							""",
					String.format("%.2f",
							(float) (Math.ceil((float) (i + 1) / NUM_GRAPHS) / P_INCREMENTS) * MAX_PROBABILITY),
					allocation.toUpperCase(),
					array[Defence.PROXIMITY.getValue()],
					array[Defence.DEGREE.getValue()],
					array[Defence.PROTECTION.getValue()]
			));
		}
	}
}
