package io.github.ethankelly;

import io.github.ethankelly.modelling.ModelEngine;

import java.io.IOException;

public class Driver {
	/* General */
	public static final int NUM_VERTICES = 25; // Number of vertices
	public static final int NUM_GRAPHS = 10; // Number of graphs to generate in each increment
	public static final double DEFENCE_QUOTA = 1;
	public static final double PROB_OF_INFECTION = 1;
	public static final double MAX_PROBABILITY = 1; // Maximum probability

	/* Erdős–Rényi graphs */
	public static final int P_INCREMENTS = 20; // Increments to vary probability over.
	public static final int MAX_MIN_BA_DEGREE = 4;

	/* Bipartite graphs */
	public static final int NUM_VERTICES_1 = NUM_VERTICES / 2, NUM_VERTICES_2 = NUM_VERTICES - NUM_VERTICES_1;

	/* Graphs requiring a number of edges */
	public static final int MAX_EDGES = 250, MIN_EDGES = 25, EDGE_INCREMENTS = 25; // Range of number of edges

	/* k-regular graphs */
	public static final int MAX_K = 5, MIN_K = 1, K_INCREMENTS = 1;

	/* Barabási–Albert preferential attachment graphs */
	public static final int INITIAL_NUM_VERTICES = 10;
	/* Watts-Strogatz (small-world) graph */
	public static final int MIN_WS_DEGREE = 5;
	public static final double OFFSET_EXP = 1.0;
	public static String GRAPH_NAME; // The graph type to be generated

	/**
	 * Unit-tests the modelling results.
	 *
	 * @param args the graph type to use in the model.
	 */

	public static void main(String[] args) throws IOException {
		// Logical test to see whether printing to readable output is feasible
		Print.printReadable = NUM_VERTICES < 20;
		System.out.println("  ******* NEW GRAPH ******* ");
		GRAPH_NAME = args[0];
		System.out.println(GRAPH_NAME);
		ModelEngine.runModelFromType();

	}

}
