package io.github.ethankelly;

import io.github.ethankelly.graphs.GraphGenerator;
import io.github.ethankelly.params.Defence;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class IOUtils {
	// Ensures readable results aren't printed for large graphs
	static boolean printReadable;

	/**
	 * Method to print the winning data of the current model to the specified output.
	 *
	 * @param graphName  the graph type of the graph used in the current model.
	 * @param allocation the type of protection allocation used in the current model.
	 * @param defence    the defence results obtained.
	 * @throws FileNotFoundException if any of the files cannot be found.
	 */
	public static void printWinData(String graphName, String allocation, List<long[]> defence) throws FileNotFoundException {
		String s = MessageFormat.format("/{0}Winner.csv", allocation);

		System.setOut(new PrintStream(new FileOutputStream(ModelEngine.PATH + s)));
		if (GraphGenerator.requiresProbToGenerate(graphName)) {
			System.out.println("P VALUE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		} else if (GraphGenerator.requiresEdgesToGenerate(graphName)) {
			System.out.println("NUMBER OF EDGES,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		} else if (GraphGenerator.requiresKToGenerate(graphName)) {
			System.out.println("K VALUE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		} else if (graphName.equalsIgnoreCase("Preferential Attachment")) {
			System.out.println("MIN DEGREE,PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");
		} else System.out.println("PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS");

		for (int i = 0; i < defence.size(); i++) {
			long[] array = defence.get(i);
			String message;
			if (GraphGenerator.requiresProbToGenerate(graphName)) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								{0},{1},RANDOM,{5}
								""",
						String.format("%.2f", (float) (Math.ceil(
								(float) (i + 1) / Driver.NUM_GRAPHS) / Driver.P_INCREMENTS) * Driver.MAX_PROBABILITY),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()],
						array[Defence.RANDOM.getValue()]);
			} else if (GraphGenerator.requiresEdgesToGenerate(graphName)) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								""",
						((Math.ceil(
								(float) ((i + 1)) / Driver.NUM_GRAPHS) / (Driver.MAX_EDGES / Driver.EDGE_INCREMENTS)) * Driver.MAX_EDGES),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()],
						array[Defence.RANDOM.getValue()]);
			} else if (GraphGenerator.requiresKToGenerate(graphName)) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								{0},{1},RANDOM,{5}
								""",
						((Math.ceil((float) (i + 1) / Driver.NUM_GRAPHS) / Driver.K_INCREMENTS) * Driver.MAX_K),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()],
						array[Defence.RANDOM.getValue()]);
			} else if (graphName.equalsIgnoreCase("Preferential Attachment")) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								{0},{1},RANDOM,{5}
								""",
						((Math.ceil((float) (i + 1) / Driver.NUM_GRAPHS))),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()],
						array[Defence.RANDOM.getValue()]);
			} else {
				message = MessageFormat.format("""
								{0},PROXIMITY,{1}
								{0},DEGREE,{2}
								{0},PROTECTION,{3}
								{0},RANDOM,{4}
								""",
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()],
						array[Defence.RANDOM.getValue()]);
			}
			System.out.print(message);
		}
	}

	/**
	 * Cycles through the agents list field and creates a string representation of them to be printed to the standard
	 * output. Used for testing purposes.
	 *
	 * @param model the model with agents we want to print.
	 * @return the string representation of the agents of the given model.
	 */
	public static String printAgents(Model model) {
		List<Agent> agents = model.getAgents();
		StringBuilder s = new StringBuilder();
		agents.stream().map(agent -> "\n* " + agent).forEach(s::append);
		return String.valueOf(s);
	}

	static void printCurrentResults(String extraParam) {
		setOutToConsole();
		if (!extraParam.isEmpty()) System.out.println(extraParam);
		System.out.println("--- Results ---" +
		                   "\nRandom: " + Arrays.toString(ModelEngine.winRandom) +
		                   "\nMixed: " + Arrays.toString(ModelEngine.winMixed) +
		                   "\nDeterministic: " + Arrays.toString(ModelEngine.winDeterministic));
	}

	public static void setOutToConsole() {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
	}

	static void initialisePrintArrays(String[] allocationPaths, int i, PrintStream[] data, PrintStream[] readable, PrintStream[] winner) throws FileNotFoundException {
		// Initialise the three PrintStream arrays
		for (int j = 0; j < allocationPaths.length; j++) {
			data[j] = new PrintStream(allocationPaths[j] + "Data" + i + ".csv");
			// Only create readable files if graphs are sufficiently small!
			if (printReadable) readable[j] = new PrintStream(allocationPaths[j] + "Readable" + i + ".md");
			winner[j] = new PrintStream(allocationPaths[j] + "Winner" + i + ".csv");
			// Print headings to each win file to avoid duplicated headings when written to again later
			System.setOut(winner[j]);
			System.out.println("OUTBREAK,STRATEGY,END TURN,SUSCEPTIBLE,INFECTED,RECOVERED,PROTECTED");
		}
	}
}
