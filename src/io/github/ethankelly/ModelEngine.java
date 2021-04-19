package io.github.ethankelly;

import java.io.*;
import java.util.Arrays;

/**
 * This class contains methods used to determine which type of model to run (which parameters to vary, which graphs to
 * generate and so on) and then uses the methods in other classes to run the appropriate models.
 */
public class ModelEngine {
	static void runPreferentialAttachmentModels() throws IOException {
		// Write an appropriate path name for storing data and results
		Driver.PATH = "data/Preferential Attachment 1 - " + Driver.MAX_MIN_DEGREE;
		// Make sure directory exists
		File dir = new File(Driver.PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();

		int count = 1;
		while (count <= Driver.MAX_MIN_DEGREE) {
			PrintStream winRead = new PrintStream(Driver.PATH + "/" + count + "Winner.md"),
					winData = new PrintStream(Driver.PATH + "/" + count + "WinnerData.csv");
			Model.runMultiGraphTest("Preferential Attachment", Driver.PATH + "/" + count, winRead, winData);
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("\nRunning with minimum degree = " + count);
			System.out.println("--- Results ---" +
			                   "\nRandom: " + Arrays.toString(Driver.winRandom) +
			                   "\nMixed: " + Arrays.toString(Driver.winMixed) +
			                   "\nDeterministic: " + Arrays.toString(Driver.winDeterministic));
			Driver.MIN_DEGREE = count;
			count += 1;
		}
	}

	static void runNoExtraParamModels(String graphName) throws IOException {
		// Write an appropriate path name for storing data and results
		Driver.PATH = "data/" + graphName;
		// Make sure directories exist
		File dir = new File(Driver.PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		PrintStream winRead = new PrintStream(Driver.PATH + "/Winner.md"),
				winData = new PrintStream(Driver.PATH + "/WinnerData.csv");
		Model.runMultiGraphTest(graphName, Driver.PATH + "/", winRead, winData);
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		System.out.println("--- Results ---" +
		                   "\nRandom: " + Arrays.toString(Driver.winRandom) +
		                   "\nMixed: " + Arrays.toString(Driver.winMixed) +
		                   "\nDeterministic: " + Arrays.toString(Driver.winDeterministic));
	}

	static void runIntParamModels(String graphName, int max, int min, int increment) throws IOException {
		// Write an appropriate path name for storing data and results
		Driver.PATH = "data/" + graphName + " " + min + "-" + max;
		// Make sure directories exist
		File dir = new File(Driver.PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		// Loop through all increments from minimum
		String paramType = "";
		if (GraphGenerator.requiresEdgesToGenerate(graphName)) paramType = "edges";
		else if (GraphGenerator.requiresKToGenerate(graphName)) paramType = "k";

		int count = min;
		while (count <= max) {
			PrintStream winRead = new PrintStream(Driver.PATH + "/" + count + "Winner.md"),
					winData = new PrintStream(Driver.PATH + "/" + count + "WinnerData.csv");
			Model.runMultiGraphTest(graphName, Driver.PATH + "/" + count, winRead, winData);
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("\nRunning with " + paramType + " = " + count);
			System.out.println("--- Results ---" +
			                   "\nRandom: " + Arrays.toString(Driver.winRandom) +
			                   "\nMixed: " + Arrays.toString(Driver.winMixed) +
			                   "\nDeterministic: " + Arrays.toString(Driver.winDeterministic));
			if (GraphGenerator.requiresEdgesToGenerate(graphName)) Driver.NUM_EDGES = count;
			else if (GraphGenerator.requiresKToGenerate(graphName)) Driver.K = count;
			count += increment;
		}
	}

	@SuppressWarnings("SameParameterValue")
	static void runErdosRenyiModels() throws IOException {
		// Write an appropriate path name for storing data and results
		Driver.PATH = "data/Erdős–Rényi " +
		              String.format("%.2f", Driver.MAX_PROBABILITY / Driver.P_INCREMENTS) + "-" +
		              String.format("%.2f", Driver.MAX_PROBABILITY);
		// Make sure directories exist
		File dir = new File(Driver.PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		// Loop through the probabilities (dictated by increments)
		float prob = (float) (Driver.MAX_PROBABILITY / Driver.P_INCREMENTS);
		while (Driver.P <= Driver.MAX_PROBABILITY) {
			Driver.P = prob;
			PrintStream winRead = new PrintStream(Driver.PATH + "/" + String.format("%.2f", prob) + "Winner.md"),
					winData = new PrintStream(Driver.PATH + "/" + String.format("%.2f", prob) + "WinnerData.csv");
			Model.runMultiGraphTest("Erdős–Rényi", Driver.PATH + "/" + String.format("%.2f", prob), winRead, winData);
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("\nRunning with p = " + String.format("%.2f", prob));
			System.out.println("--- Results ---" +
			                   "\nRandom: " + Arrays.toString(Driver.winRandom) +
			                   "\nMixed: " + Arrays.toString(Driver.winMixed) +
			                   "\nDeterministic: " + Arrays.toString(Driver.winDeterministic));

			prob += (Driver.MAX_PROBABILITY / Driver.P_INCREMENTS);
		}
	}
}
