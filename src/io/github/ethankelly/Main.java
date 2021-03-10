package io.github.ethankelly;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// Get graph with user input (either generate or load from CSV)
		Graph g = GraphGenerator.createGraph();
		// Print graph in CSV file
		StdOut.setOut(StdOut.graph);
		StdOut.print(Graph.makeCommaSeparated(g));
		// Initialise a model for each defence strategy
		Model mProximity = new Model(g);
		Model mDegree = new Model(g);
		Model mProtection = new Model(g);

		int protectionType = Model.DETERMINISTIC;

		// Print headings for data CSV file
		StdOut.setOut(StdOut.data);
		StdOut.print("OUTBREAK,STRATEGY,END TURN,SUSCEPTIBLE,INFECTED,RECOVERED,PROTECTED\n");

		// Set defence and infection probabilities to 1
		double totalDefence = 1.0, probInfection = 1.0;
		// If graph is small enough, print readable results
		if (Model.printReadable) mProximity.printModelInfo(totalDefence, probInfection);
		for (int i = 0; i < mProximity.getNumVertices(); i++) {
			// Initialise model agents
			mProximity.initialiseAgents(i, protectionType);
			mDegree.initialiseIdenticalModel(i, mProximity);
			mProtection.initialiseIdenticalModel(i, mProximity);

			// If we are generating a readable file, print agent information
			if (Model.printReadable) {
//				StdOut.setOut(StdOut.readable);
				StdOut.readable.print("\n## Outbreak: " + i + "\n");
				mProximity.printAgents();
			}

			String proximityResult = mProximity.runTest(totalDefence, probInfection, Model.PROXIMITY);
			String degreeResult = mDegree.runTest(totalDefence, probInfection, Model.DEGREE);
			String protectionResult = mProtection.runTest(totalDefence, probInfection, Model.PROTECTION);

			// Print the results to a more machine-readable file.
			StdOut.setOut(StdOut.data);
			StdOut.print(proximityResult + "\n" + degreeResult + "\n" + protectionResult + "\n");
		}
		Winner.getWinners();

		Chart.getChart("INFECTED");
		Chart.getChart("END TURN");
		Chart.getChart("PROTECTED");

		StdOut.close();
	}
}
