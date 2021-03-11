package io.github.ethankelly;

import java.io.IOException;
import java.io.PrintStream;

public class Main {

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

		runModelOutput(mProximity, mDegree, mProtection, Model.RANDOM);
		runModelOutput(mProximity, mDegree, mProtection, Model.MIXED);
		runModelOutput(mProximity, mDegree, mProtection, Model.DETERMINISTIC);
	}

	private static void runModelOutput(Model mProximity, Model mDegree, Model mProtection, int protection) throws IOException {
		String graphFile = "data/Graph.csv";

		PrintStream data;
		PrintStream readable;
		PrintStream winner;
		String name;
		switch (protection) {
			case Model.RANDOM -> name = "Random";
			case Model.MIXED -> name = "Mixed";
			case Model.DETERMINISTIC -> name = "Deterministic";
			default -> throw new IllegalStateException("Unexpected value: " + protection);
		}
		String path = "data/" + name + "/" + name;
		data = new PrintStream(path + "Data.csv");
		readable = new PrintStream(path + "Readable.md");
		winner = new PrintStream(path + "Winner.md");

		String[] modelResults = Model.runModels(mProximity, mDegree, mProtection, protection);

		System.setOut(data);
		System.out.println(modelResults[0]);

		if (Model.printReadable) {
			System.setOut(readable);
			System.out.println(modelResults[1]);
		}
		System.setOut(winner);
		System.out.println(Winner.getWinners(path + "Data.csv", graphFile));

		new Chart("Defence Strategy Comparison", "INFECTED", protection);
		new Chart("Defence Strategy Comparison", "PROTECTED", protection);
		new Chart("Defence Strategy Comparison", "END TURN", protection);

	}
}
