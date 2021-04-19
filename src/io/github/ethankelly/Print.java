package io.github.ethankelly;

import io.github.ethankelly.std_lib.StdChart;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.List;

public class Print {
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

		System.setOut(new PrintStream(new FileOutputStream(Driver.PATH + s)));
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
								""",
						String.format("%.2f", (float) (Math.ceil(
								(float) (i + 1) / Driver.NUM_GRAPHS) / Driver.P_INCREMENTS) * Driver.MAX_PROBABILITY),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()]
				);
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
						array[Defence.PROTECTION.getValue()]
				);
			} else if (GraphGenerator.requiresKToGenerate(graphName)) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								""",
						((Math.ceil((float) (i + 1) / Driver.NUM_GRAPHS) / Driver.K_INCREMENTS) * Driver.MAX_K),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()]
				);
			} else if (graphName.equalsIgnoreCase("Preferential Attachment")) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								""",
						((Math.ceil((float) (i + 1) / Driver.NUM_GRAPHS))),
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()]
				);
			} else {
				message = MessageFormat.format("""
								{0},PROXIMITY,{1}
								{0},DEGREE,{2}
								{0},PROTECTION,{3}
								""",
						allocation.toUpperCase(),
						array[Defence.PROXIMITY.getValue()],
						array[Defence.DEGREE.getValue()],
						array[Defence.PROTECTION.getValue()]
				);
			}
			System.out.print(message);
		}
	}

	/**
	 * Gets parallel models and a protection strategy and prints the output of the models.
	 *
	 * @param models     an array of all parallel models to be run
	 * @param filePath   the file path to output model result files to.
	 * @param graphFile  the graph file containing the current graph.
	 * @param i          an identifier for use when there is more than one model for each incremented value.
	 * @param data       the PrintStream to output the machine readable results to.
	 * @param winner     the PrintStream to output the human readable results to.
	 * @throws IOException if any of the files cannot be found and/or written to.
	 */
	public static void printOverallModelOutput(Model[] models,
	                                           String filePath,
	                                           String graphFile,
	                                           int i,
	                                           PrintStream[] data,
	                                           PrintStream[] winner) throws IOException {

		for (int j = 0; j < Protection.values().length; j++) {
			String[] modelResults = Model.runModels(models, Protection.getProtection(j));

			System.setOut(data[j]);
			System.out.println(modelResults[0]);

			System.setOut(winner[j]);
			System.out.println(Winner.getWinners(filePath + "Data" + i + ".csv", graphFile)[1]);
		}
	}

	/**
	 * Given three models to run, runs them and outputs required results to the specified directories and files. Used
	 * for testing with single graphs.
	 *
	 * @param models     the array of parallel models that have been run.
	 * @param protection the type of protection allocation used (random, deterministic or mixed).
	 * @param filePath   the path to output the model results to.
	 * @param thisRound  the current model number count, between 0 and the number of models generated in the multi-graph
	 *                   test.
	 * @param readable   the path to output human-readable model results to.
	 * @param data       the file to print machine-parsable complete model results to.
	 * @param winner     the file to print the winning strategy data to.
	 * @param texTable   the file to output tex code with the winning model strategies to.
	 * @throws IOException if any of the files do not exist.
	 */
	@SuppressWarnings("unused")
	public static void printModelOutput(Model[] models,
	                                    Protection protection,
	                                    String filePath,
	                                    int thisRound,
	                                    PrintStream readable,
	                                    PrintStream data,
	                                    PrintStream winner,
	                                    PrintStream texTable) throws IOException {
		String graphFile = filePath + "/Graph" + thisRound + ".csv";

		String[] modelResults = Model.runModels(models, protection);

		System.setOut(data);
		System.out.println(modelResults[0]);

		if (printReadable) {
			System.setOut(readable);
			System.out.println(modelResults[1]);
		}
		System.setOut(winner);
		System.out.println(Winner.getWinners(filePath + "Data.csv", graphFile)[1]);

		System.setOut(texTable);
		System.out.println(Winner.getWinners(filePath + "Data.csv", graphFile)[2]);

		for (Model model : models) {
			new StdChart("Defence Strategy Comparison", model.getGraph(), "INFECTED", protection, filePath, thisRound);
			new StdChart("Defence Strategy Comparison", model.getGraph(), "PROTECTED", protection, filePath, thisRound);
			new StdChart("Defence Strategy Comparison", model.getGraph(), "END TURN", protection, filePath, thisRound);
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
}
