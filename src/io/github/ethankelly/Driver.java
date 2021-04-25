package io.github.ethankelly;

import java.io.IOException;

/**
 * The main class, containing a main method and several changeable parameters that determine the models to be run.
 */
public class Driver {
	/**
	 * Number of vertices in each generated graph.
	 */
	public static final int NUM_VERTICES = 50;
	/**
	 * The number of graphs to generate per increment (where appropriate).
	 */
	public static final int NUM_GRAPHS = 10;
	/**
	 * Total defence that can be deployed in each defensive round.
	 */
	public static final double DEFENCE_QUOTA = 1;
	/**
	 * The probability that an infection occurs.
	 */
	public static final double PROB_OF_INFECTION = 1;
	/**
	 * The maximum probability to generate graphs for models.
	 */
	public static final double MAX_PROBABILITY = 1;
	/**
	 * The number of increments in the range of probabilities we wish to consider.
	 */
	public static final int P_INCREMENTS = 20;
	/**
	 * Partition of the vertices into two sections.
	 */
	public static final int NUM_VERTICES_1 = NUM_VERTICES / 2, NUM_VERTICES_2 = NUM_VERTICES - NUM_VERTICES_1;
	/* Graphs requiring a number of edges */
	public static final int MAX_EDGES = 250;
	public static final int MIN_EDGES = 25;
	public static final int EDGE_INCREMENTS = 25; // Range of number of edges
	/* k-regular graphs */
	public static final int MAX_K = 5;
	public static final int MIN_K = 1;
	public static final int K_INCREMENTS = 1;
	/* Barabási–Albert preferential attachment graphs */
	public static final int INITIAL_NUM_VERTICES = 10;
	public static final double OFFSET_EXP = 1.0;
	public static final int MAX_MIN_BA_DEGREE = 6;
	/**
	 * The name of the graph type to be created.
	 */
	public static String GRAPH_NAME;

	/**
	 * Unit-tests the modelling results.
	 *
	 * @param args the graph type to use in the model.
	 */

	public static void main(String[] args) throws IOException {
		// Logical test to see whether printing to readable output is feasible
		Print.printReadable = false;
		String[] graphs = new String[] {"Preferential Attachment"};
		for (String graph : graphs) {
			GRAPH_NAME = graph;
			ModelEngine.runModelFromType();
		}
	}

}
