package io.github.ethankelly;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver {
	/* General */
	public static final int NUM_VERTICES = 20; // Number of vertices
	public static final int NUM_GRAPHS = 1; // Number of graphs to generate in each increment
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
			ModelEngine.runErdosRenyiModels();
		} else if (GraphGenerator.requiresEdgesToGenerate(GRAPH_NAME)) {
			// These all require a number of edges
			System.out.println("Identified a graph requiring a number of edges.");
			ModelEngine.runIntParamModels(GRAPH_NAME, MAX_EDGES, MIN_EDGES, EDGE_INCREMENTS);
		} else if (GRAPH_NAME.equalsIgnoreCase("Regular")) {
			// This requires a value of k
			System.out.println("Identified a graph requiring a value of k.");
			ModelEngine.runIntParamModels(GRAPH_NAME, MAX_K, MIN_K, K_INCREMENTS);
		} else if (GRAPH_NAME.equalsIgnoreCase("preferential attachment")) {
			// Barabási–Albert-generated preferential attachment graph
			System.out.println("Identified a Barabási–Albert-generated preferential attachment graph");
			ModelEngine.runPreferentialAttachmentModels();

		} else {
			System.out.println("Identified a graph requiring no further parameters.");
			ModelEngine.runNoExtraParamModels(GRAPH_NAME);
		}
		Print.printWinData(GRAPH_NAME, "Random", random);
		Print.printWinData(GRAPH_NAME, "Mixed", mixed);
		Print.printWinData(GRAPH_NAME, "Deterministic", deterministic);
	}

}
