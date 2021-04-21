package io.github.ethankelly.modelling;

import io.github.ethankelly.Driver;
import io.github.ethankelly.Model;
import io.github.ethankelly.graphs.GraphGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class contains methods used to determine which type of model to run (which parameters to vary, which graphs to
 * generate and so on) and then uses the methods in other classes to run the appropriate models.
 */
public class ModelEngine {
	public static int K;
	public static float P;
	public static int MIN_DEGREE;
	public static int NUM_EDGES;
	public static String PATH; // File path

	/* Store overall results */
	public static long[] winRandom = new long[3];
	public static long[] winMixed = new long[3];
	public static long[] winDeterministic = new long[3];
	public static List<long[]> random = new ArrayList<>();
	public static List<long[]> mixed = new ArrayList<>();
	public static List<long[]> deterministic = new ArrayList<>();

	static void runPreferentialAttachmentModels() throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/Preferential Attachment 1 - " + Driver.MAX_MIN_BA_DEGREE;
		// Make sure directory exists
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();

		int count = 1;
		while (count <= Driver.MAX_MIN_BA_DEGREE) {
			PrintStream winData = new PrintStream(PATH + "/" + count + "WinnerData.csv");
			Model.runMultiGraphModel("Preferential Attachment", PATH + "/" + count, winData);

			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("\nRunning with minimum degree = " + count);
			System.out.println("--- Results ---" +
			                   "\nRandom: " + Arrays.toString(winRandom) +
			                   "\nMixed: " + Arrays.toString(winMixed) +
			                   "\nDeterministic: " + Arrays.toString(winDeterministic));
			MIN_DEGREE = count;
			count += 1;
		}
	}

	static void runNoExtraParamModels(String graphName) throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/" + graphName;
		// Make sure directories exist
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		PrintStream winData = new PrintStream(PATH + "/WinnerData.csv");
		Model.runMultiGraphModel(graphName, PATH + "/", winData);

		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		System.out.println("--- Results ---" +
		                   "\nRandom: " + Arrays.toString(winRandom) +
		                   "\nMixed: " + Arrays.toString(winMixed) +
		                   "\nDeterministic: " + Arrays.toString(winDeterministic));
	}

	static void runIntParamModels(String graphName, int max, int min, int increment) throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/" + graphName + " " + min + "-" + max;
		// Make sure directories exist
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		// Loop through all increments from minimum
		String paramType = "";
		if (GraphGenerator.requiresEdgesToGenerate(graphName)) paramType = "edges";
		else if (GraphGenerator.requiresKToGenerate(graphName)) paramType = "k";

		int count = min;
		while (count <= max) {
			PrintStream winData = new PrintStream(PATH + "/" + count + "WinnerData.csv");
			Model.runMultiGraphModel(graphName, PATH + "/" + count, winData);
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("\nRunning with " + paramType + " = " + count);
			System.out.println("--- Results ---" +
			                   "\nRandom: " + Arrays.toString(winRandom) +
			                   "\nMixed: " + Arrays.toString(winMixed) +
			                   "\nDeterministic: " + Arrays.toString(winDeterministic));
			if (GraphGenerator.requiresEdgesToGenerate(graphName)) NUM_EDGES = count;
			else if (GraphGenerator.requiresKToGenerate(graphName)) K = count;
			count += increment;
		}
	}

	//@SuppressWarnings("SameParameterValue")
	static void runProbModels(String graphName) throws IOException {
		// Write an appropriate path name for storing data and results
		PATH = "data/" + graphName + " " +
		       String.format("%.2f", Driver.MAX_PROBABILITY / Driver.P_INCREMENTS) + "-" +
		       String.format("%.2f", Driver.MAX_PROBABILITY);
		// Make sure directories exist
		File dir = new File(PATH);
		//noinspection ResultOfMethodCallIgnored
		dir.mkdirs();
		// Loop through the probabilities (dictated by increments)
		float prob = (float) (Driver.MAX_PROBABILITY / Driver.P_INCREMENTS);
		while (P < Driver.MAX_PROBABILITY) {
			P = prob;
			PrintStream winData = new PrintStream(PATH + "/" + String.format("%.2f", prob) + "WinnerData.csv");

			Model.runMultiGraphModel(graphName, PATH + "/" +
			                                    String.format("%.2f", prob), winData);

			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("\nRunning with p = " + String.format("%.2f", prob));
			System.out.println("--- Results ---" +
			                   "\nRandom: " + Arrays.toString(winRandom) +
			                   "\nMixed: " + Arrays.toString(winMixed) +
			                   "\nDeterministic: " + Arrays.toString(winDeterministic));

			prob += (Driver.MAX_PROBABILITY / Driver.P_INCREMENTS);
		}
	}

	public static void runModelFromType() throws IOException {
		if (GraphGenerator.requiresProbToGenerate(Driver.GRAPH_NAME)) {
			// We generate this graph type with a probability
			System.out.println("Identified a graph requiring a probability.");
			runProbModels(Driver.GRAPH_NAME);
		} else if (GraphGenerator.requiresEdgesToGenerate(Driver.GRAPH_NAME)) {
			// These all require a number of edges
			System.out.println("Identified a graph requiring a number of edges.");
			runIntParamModels(Driver.GRAPH_NAME, Driver.MAX_EDGES, Driver.MIN_EDGES, Driver.EDGE_INCREMENTS);
		} else if (Driver.GRAPH_NAME.equalsIgnoreCase("Regular")) {
			// This requires a value of k
			System.out.println("Identified a graph requiring a value of k.");
			runIntParamModels(Driver.GRAPH_NAME, Driver.MAX_K, Driver.MIN_K, Driver.K_INCREMENTS);
		} else if (Driver.GRAPH_NAME.equalsIgnoreCase("preferential attachment")) {
			// Barabási–Albert-generated preferential attachment graph
			System.out.println("Identified a Barabási–Albert-generated preferential attachment graph");
			runPreferentialAttachmentModels();
		} else {
			System.out.println("Identified a graph requiring no further parameters.");
			runNoExtraParamModels(Driver.GRAPH_NAME);
		}
		io.github.ethankelly.Print.printWinData(Driver.GRAPH_NAME, "Random", random);
		io.github.ethankelly.Print.printWinData(Driver.GRAPH_NAME, "Mixed", mixed);
		io.github.ethankelly.Print.printWinData(Driver.GRAPH_NAME, "Deterministic", deterministic);
	}
}
