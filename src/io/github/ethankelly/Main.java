package io.github.ethankelly;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	// Declare the relevant parameters
	public static final int NUM_VERTICES = 50;
	public static final int NUM_EDGES = 250;
	public static final int NUM_GRAPHS = 10;
	public static final int NUM_INCREMENTS = 20;
	public static final double MAX_PROBABILITY = 0.20;

	// File path
	private static final String PATH = "data/Erdős–Rényi " + String.format("%.2f", MAX_PROBABILITY / NUM_INCREMENTS)
	                                   + "-" + String.format("%.2f", MAX_PROBABILITY);
	public static double p;

	// Store overall results as fields
	public static long[] winRandom = new long[3];
	public static long[] winMixed = new long[3];
	public static long[] winDeterministic = new long[3];
	public static List<long[]> random = new ArrayList<>();
	public static List<long[]> mixed = new ArrayList<>();
	public static List<long[]> deterministic = new ArrayList<>();

	/**
	 * Unit-tests the modelling results.
	 *
	 * @param args command-line args, ignored.
	 */
	public static void main(String[] args) throws IOException {
		p = (float) MAX_PROBABILITY / NUM_INCREMENTS;
		while (p <= MAX_PROBABILITY) {
			PrintStream winRead = new PrintStream(PATH + "/" + String.format("%.2f", p) + "Winner.md"),
					winData = new PrintStream(PATH + "/" + String.format("%.2f", p) + "WinnerData.csv");
			Model.runMultiGraphTest("Erdős–Rényi", PATH + "/" + String.format("%.2f", p), winRead, winData);
			printProgress();
			p += MAX_PROBABILITY / NUM_INCREMENTS;
		}
		printWinData("Random", random);
		printWinData("Mixed", mixed);
		printWinData("Deterministic", deterministic);
	}

	private static void printProgress() {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		System.out.println("\nRunning with p = " + String.format("%.2f", p));
		System.out.println("--- Results ---" +
		                   "\nRandom: " + Arrays.toString(winRandom) +
		                   "\nMixed: " + Arrays.toString(winMixed) +
		                   "\nDeterministic: " + Arrays.toString(winDeterministic));
	}

	private static void printWinData(String allocation, List<long[]> random) throws FileNotFoundException {
		String s = MessageFormat.format("/{0}Winner.csv", allocation);

		System.setOut(new PrintStream(new FileOutputStream(PATH + s)));
		System.out.println("P VALUE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		for (int i = 0; i < random.size(); i++) {
			long[] array = random.get(i);
			System.out.print(MessageFormat.format("""
							{0},{1},PROXIMITY,{2}
							{0},{1},DEGREE,{3}
							{0},{1},PROTECTION,{4}
							""",
					String.format("%.2f",
							(float) (Math.ceil((float) (i + 1) / NUM_GRAPHS) / NUM_INCREMENTS) * MAX_PROBABILITY),
					allocation.toUpperCase(),
					array[Defence.PROXIMITY.getValue()],
					array[Defence.DEGREE.getValue()],
					array[Defence.PROTECTION.getValue()]
			));
		}
	}
}
