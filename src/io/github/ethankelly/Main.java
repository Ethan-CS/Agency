package io.github.ethankelly;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	// Declare the relevant parameters
	public static final int numVertices = 50;
	public static final int numEdges = 250;
	public static final int numGraphs = 10;
	public static final int numIncrements = 20;
	// File path
	private static final String erPath = "data/Erdős–Rényi";
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
		p = (float) 1 / numIncrements;
		while (p <= 1.0) {
			PrintStream winFile = new PrintStream(erPath + "/Winner.md");
			PrintStream winFileData = new PrintStream(erPath + "/WinnerData.csv");
			Model.runMultiGraphTest("Erdős–Rényi", erPath + "/" + String.format("%.2f", p),
					winFile, winFileData);

			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
			System.out.println("\nRunning with p = " + String.format("%.2f", p));
			System.out.println("--- Results ---" +
			                   "\nRandom: " + Arrays.toString(winRandom) +
			                   "\nMixed: " + Arrays.toString(winMixed) +
			                   "\nDeterministic: " + Arrays.toString(winDeterministic));
			p += 0.05;
		}

		System.setOut(new PrintStream(new FileOutputStream(erPath + "/RandomWinner.csv")));
		System.out.println("P VALUE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		for (int i = 0; i < random.size(); i++) {
			long[] array = random.get(i);
			System.out.print(MessageFormat.format("""
							{0},RANDOM,PROXIMITY,{1}
							{0},RANDOM,DEGREE,{2}
							{0},RANDOM,PROTECTION,{3}
							""",
					String.format("%.2f", (float) Math.ceil((float) (i + 1) / numGraphs) / numIncrements),
					array[Defence.PROXIMITY.getValue()],
					array[Defence.DEGREE.getValue()],
					array[Defence.PROTECTION.getValue()]
			));
		}

		System.setOut(new PrintStream(new FileOutputStream(erPath + "/MixedWinner.csv")));
		System.out.println("P VALUE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		for (int i = 0; i < mixed.size(); i++) {
			long[] array = mixed.get(i);
			System.out.print(MessageFormat.format("""
							{0},MIXED,PROXIMITY,{1}
							{0},MIXED,DEGREE,{2}
							{0},MIXED,PROTECTION,{3}
							""",
					String.format("%.2f", (float) Math.ceil((float) (i + 1) / numGraphs) / numIncrements),
					array[Defence.PROXIMITY.getValue()],
					array[Defence.DEGREE.getValue()],
					array[Defence.PROTECTION.getValue()]));
		}

		System.setOut(new PrintStream(new FileOutputStream(erPath + "/DeterministicWinner.csv")));
		System.out.println("P VALUE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		for (int i = 0; i < deterministic.size(); i++) {
			long[] array = deterministic.get(i);
			System.out.print(MessageFormat.format("""
							{0},DETERMINISTIC,PROXIMITY,{1}
							{0},DETERMINISTIC,DEGREE,{2}
							{0},DETERMINISTIC,PROTECTION,{3}
							""",
					String.format("%.2f", (float) Math.ceil((float) (i + 1) / numGraphs) / numIncrements),
					array[Defence.PROXIMITY.getValue()],
					array[Defence.DEGREE.getValue()],
					array[Defence.PROTECTION.getValue()]

			));
		}

	}
}
