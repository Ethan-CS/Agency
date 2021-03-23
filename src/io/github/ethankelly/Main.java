package io.github.ethankelly;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class Main {
	// Declare the relevant parameters
	private static final int numVertices = 50;
	private static final int numEdges = 250;
	private static final int numGraphs = 100;
	private static final double p = (double) numEdges / (numVertices * (numVertices - 1) / 2.0);

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
		// Generate new complete graph (only need one)
		Graph complete = GraphGenerator.complete(numVertices);

		PrintStream completeGraphFile = new PrintStream(completePath + "/Graph.csv");
		System.setOut(completeGraphFile);
		System.out.print(Graph.makeCommaSeparated(complete));

		Model cProximity = new Model(complete);
		Model cDegree = new Model(complete);
		Model cProtection = new Model(complete);

		PrintStream completeData = new PrintStream(completePath + "Data.csv");
		PrintStream completeWinner = new PrintStream(completePath + "Winner.csv");
		PrintStream erData = new PrintStream(erPath + "Data.csv");
		PrintStream treeData = new PrintStream(treePath + "Data.csv");
		PrintStream erWinner = new PrintStream(erPath + "Winner.csv");
		PrintStream treeWinner = new PrintStream(treePath + "Winner.csv");

		Model.printOverallModelOutput(cProximity, cDegree, cProtection, Protection.RANDOM,
				completePath, completeData, completeWinner);
		Model.printOverallModelOutput(cProximity, cDegree, cProtection, Protection.MIXED,
				completePath, completeData, completeWinner);
		Model.printOverallModelOutput(cProximity, cDegree, cProtection, Protection.DETERMINISTIC,
				completePath, completeData, completeWinner);

		// Generate required number of Erdos-Renyi graphs
		for (int i = 0; i < numGraphs; i++) {
			Graph erdosRenyi = GraphGenerator.erdosRenyi(numVertices, p);
			System.setOut(new PrintStream(erPath + "/Graph" + i + ".csv"));
			System.out.print(Graph.makeCommaSeparated(erdosRenyi));

			Graph tree = GraphGenerator.tree(numVertices);

			System.setOut(new PrintStream(treePath + "/Graph" + i + ".csv"));
			System.out.print(Graph.makeCommaSeparated(tree));

			Model mProximity = new Model(erdosRenyi);
			Model nProximity = new Model(tree);
			Model mDegree = new Model(erdosRenyi);
			Model nDegree = new Model(tree);
			Model mProtection = new Model(erdosRenyi);
			Model nProtection = new Model(tree);

			Model.printOverallModelOutput(mProximity, mDegree, mProtection, Protection.RANDOM,
					erPath + "/Random/Random", erData, erWinner);
			Model.printOverallModelOutput(nProximity, nDegree, nProtection, Protection.RANDOM,
					treePath + "/Random/Random", treeData, treeWinner);
			Model.printOverallModelOutput(mProximity, mDegree, mProtection, Protection.MIXED,
					erPath + "/Mixed/Mixed", erData, erWinner);
			Model.printOverallModelOutput(nProximity, nDegree, nProtection, Protection.MIXED,
					treePath + "/Mixed/Mixed", treeData, treeWinner);
			Model.printOverallModelOutput(mProximity, mDegree, mProtection, Protection.DETERMINISTIC,
					erPath + "/Deterministic/Deterministic", erData, erWinner);
			Model.printOverallModelOutput(nProximity, nDegree, nProtection, Protection.DETERMINISTIC,
					treePath + "/Deterministic/Deterministic", treeData, treeWinner);
		}
		System.setOut(erWinner);
		System.out.println(Arrays.toString(Winner.getOverallWinners(erPath + "Data.csv")));
		System.setOut(treeWinner);
		System.out.println(Arrays.toString(Winner.getOverallWinners(treePath + "Data.csv")));

	}
}
