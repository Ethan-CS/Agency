package io.github.ethankelly;

import java.io.IOException;

public class Main {
	// Declare the relevant parameters
	public static final int numVertices = 50;
	public static final int numEdges = 250;
	public static final int numGraphs = 100;
	public static final double p = (double) numEdges / (numVertices * (numVertices - 1) / 2.0);
	// File paths
	private static final String completePath = "data/Complete";
	private static final String erPath = "data/Erdős–Rényi";
	private static final String treePath = "data/Tree";

	/**
	 * Tests the modelling results.
	 *
	 * @param args command-line args, ignored.
	 */
	public static void main(String[] args) throws IOException {
		Model.runMultiGraphTest("Complete", completePath);
		Model.runMultiGraphTest("Erdős–Rényi", erPath);
		Model.runMultiGraphTest("Tree", treePath);
	}
}
