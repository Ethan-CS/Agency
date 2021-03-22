package io.github.ethankelly;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Contains a main method used to test the functionality of the wider Agency SIRP modelling project.
 */
public class TestMain {

	/**
	 * Unit tests the entire SIRP Agency based model.
	 *
	 * @param args command line args (ignored).
	 * @throws IOException if specified files/file paths do not exist.
	 */
	public static void main(String[] args) throws IOException {
		// Get graph with user input (either generate or load from CSV)
		Graph g = GraphGenerator.createGraph();
		// Print graph in CSV file
		PrintStream graph = new PrintStream("data/Graph.csv");
		System.setOut(graph);
		System.out.print(Graph.makeCommaSeparated(g));
		// Initialise a model for each defence strategy
		Model mProximity = new Model(g);
		Model mDegree = new Model(g);
		Model mProtection = new Model(g);

		String path = "data/" + g.getName();

		Model.printModelOutput(mProximity, mDegree, mProtection, Protection.RANDOM, path, 1);
		Model.printModelOutput(mProximity, mDegree, mProtection, Protection.MIXED, path, 1);
		Model.printModelOutput(mProximity, mDegree, mProtection, Protection.DETERMINISTIC, path, 1);
	}

}
