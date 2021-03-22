package io.github.ethankelly;

import java.io.IOException;
import java.io.PrintStream;

@SuppressWarnings("DuplicatedCode")
public class Main {
	/**
	 * Tests the modelling
	 *
	 * @param args command-line args, ignored.
	 */
	public static void main(String[] args) throws IOException {
		// Declare the relevant parameters
		int numVertices = 50;
		int numEdges = 250;
		int numGraphs = 100;

		double p = (double) numEdges / (numVertices * (numVertices - 1) / 2.0);

		// Generate new complete graph (only need one)
		Graph complete = GraphGenerator.complete(numVertices);
		String completePath = "data/" + complete.getName();
		System.setOut(new PrintStream(completePath + "/Graph1.csv"));
		System.out.print(Graph.makeCommaSeparated(complete));

		Model cProximity = new Model(complete);
		Model cDegree = new Model(complete);
		Model cProtection = new Model(complete);

		Model.printModelOutput(cProximity, cDegree, cProtection, Protection.RANDOM, completePath, 1);
		Model.printModelOutput(cProximity, cDegree, cProtection, Protection.MIXED, completePath, 1);
		Model.printModelOutput(cProximity, cDegree, cProtection, Protection.DETERMINISTIC, completePath, 1);

		// Generate required number of Erdos-Renyi graphs
		for (int i = 0; i < numGraphs; i++) {
			Graph erdosRenyi = GraphGenerator.erdosRenyi(numVertices, p);
			String erPath = "data/" + erdosRenyi.getName();
			System.setOut(new PrintStream(erPath + "/Graph" + i + ".csv"));
			System.out.print(Graph.makeCommaSeparated(erdosRenyi));

			Graph tree = GraphGenerator.tree(numVertices);
			String treePath = "data/" + tree.getName();
			System.setOut(new PrintStream(treePath + "/Graph" + i + ".csv"));
			System.out.print(Graph.makeCommaSeparated(tree));

			Model mProximity = new Model(erdosRenyi);
			Model nProximity = new Model(tree);
			Model mDegree = new Model(erdosRenyi);
			Model nDegree = new Model(tree);
			Model mProtection = new Model(erdosRenyi);
			Model nProtection = new Model(tree);

			Model.printModelOutput(mProximity, mDegree, mProtection, Protection.RANDOM, erPath, i);
			Model.printModelOutput(nProximity, nDegree, nProtection, Protection.RANDOM, treePath, i);
			Model.printModelOutput(mProximity, mDegree, mProtection, Protection.MIXED, erPath, i);
			Model.printModelOutput(nProximity, nDegree, nProtection, Protection.MIXED, treePath, i);
			Model.printModelOutput(mProximity, mDegree, mProtection, Protection.DETERMINISTIC, erPath, i);
			Model.printModelOutput(nProximity, nDegree, nProtection, Protection.DETERMINISTIC, treePath, i);
		}
	}
}
