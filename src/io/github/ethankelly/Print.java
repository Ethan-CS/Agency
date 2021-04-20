package io.github.ethankelly;

import io.github.ethankelly.graphs.GraphGenerator;
import io.github.ethankelly.model_params.AgentParams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

		System.setOut(new PrintStream(new FileOutputStream(io.github.ethankelly.modelling.ModelEngine.PATH + s)));
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
						array[AgentParams.Defence.PROXIMITY.getValue()],
						array[AgentParams.Defence.DEGREE.getValue()],
						array[AgentParams.Defence.PROTECTION.getValue()]
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
						array[AgentParams.Defence.PROXIMITY.getValue()],
						array[AgentParams.Defence.DEGREE.getValue()],
						array[AgentParams.Defence.PROTECTION.getValue()]
				);
			} else if (GraphGenerator.requiresKToGenerate(graphName)) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								""",
						((Math.ceil((float) (i + 1) / Driver.NUM_GRAPHS) / Driver.K_INCREMENTS) * Driver.MAX_K),
						allocation.toUpperCase(),
						array[AgentParams.Defence.PROXIMITY.getValue()],
						array[AgentParams.Defence.DEGREE.getValue()],
						array[AgentParams.Defence.PROTECTION.getValue()]
				);
			} else if (graphName.equalsIgnoreCase("Preferential Attachment")) {
				message = MessageFormat.format("""
								{0},{1},PROXIMITY,{2}
								{0},{1},DEGREE,{3}
								{0},{1},PROTECTION,{4}
								""",
						((Math.ceil((float) (i + 1) / Driver.NUM_GRAPHS))),
						allocation.toUpperCase(),
						array[AgentParams.Defence.PROXIMITY.getValue()],
						array[AgentParams.Defence.DEGREE.getValue()],
						array[AgentParams.Defence.PROTECTION.getValue()]
				);
			} else {
				message = MessageFormat.format("""
								{0},PROXIMITY,{1}
								{0},DEGREE,{2}
								{0},PROTECTION,{3}
								""",
						allocation.toUpperCase(),
						array[AgentParams.Defence.PROXIMITY.getValue()],
						array[AgentParams.Defence.DEGREE.getValue()],
						array[AgentParams.Defence.PROTECTION.getValue()]
				);
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
}
