package io.github.ethankelly;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Uses a CSV parser to read the results of a model from a CSV file and determines the winning strategy or strategies
 * for each source node a model was run on. The class outputs these winners as both a human readable Markdown file and
 * machine readable formats, namely CSV files and LaTeX code for use in presentation and reporting of modelling
 * results.
 */
public class Winner {

	/**
	 * Reads in the winning strategy csv files from one or more model instances and returns a summary of the number of
	 * times each strategy performed best.
	 *
	 * @param dataFilePath the path to the winner csv files to be parsed.
	 * @return an array of values representing the numbers of times each strategy won.
	 * @throws IOException if the specified file does not exist or cannot be accessed.
	 */
	public static long[] getBestStrategies(String dataFilePath) throws IOException {
		long protection = 0;
		long proximity = 0;
		long degree = 0;

		// Make sure we only loop for as many times as we need! (Once for complete graph)
		int bound = dataFilePath.toLowerCase().contains("complete") ? 1 : Driver.NUM_GRAPHS;

		// Loop through each graph model that was run
		for (int i = 0; i < bound; i++) {
			// Read in the model defence results
			List<CSVRecord> records = CSVFormat
					.DEFAULT
					.withFirstRecordAsHeader()
					.parse(new FileReader(dataFilePath + i + ".csv"))
					.getRecords();
			// For each winning strategy, find the strategy that won and increment the relevant counter
			for (CSVRecord record : records) {
				String strategy = record.get("STRATEGY");
				switch (strategy) {
					case "PROTECTION" -> protection++;
					case "PROXIMITY" -> proximity++;
					case "DEGREE" -> degree++;
					default -> throw new IllegalStateException("Unexpected value: " + strategy);
				}
			}
		}

		// Initialise an array with size equal to the number of strategies used in the models.
		long[] toReturn = new long[Model.NUM_STRATEGIES];
		// Add each result to the appropriate position in the array
		toReturn[Defence.PROXIMITY.getValue()] = proximity;
		toReturn[Defence.DEGREE.getValue()] = degree;
		toReturn[Defence.PROTECTION.getValue()] = protection;

		return toReturn;
	}

	/**
	 * Finds the winning model strategies from a CSV file of model data and returns a string array with the strategies
	 * in human readable and machine readable forms.
	 *
	 * @param dataFilePath the location of the data file to be parsed.
	 * @param graphFile    the location of the graph file to be parsed.
	 * @return a string array of size 3 - the first location contains a human-readable formatted list of winners (for
	 * printing to a Markdown file), the second contains a machine-readable (csv) formatted list of winners and the
	 * third (final) location contains LaTeX code for inputting into a file later.
	 * @throws IOException if the given files cannot be found.
	 */
	public static String[] getWinners(String dataFilePath, String graphFile) throws IOException {
		// Read in the model defence results
		List<CSVRecord> records = CSVFormat
				.DEFAULT
				.withFirstRecordAsHeader()
				.parse(new FileReader(dataFilePath))
				.getRecords();

		// Read in the graph associated with the model
		List<CSVRecord> matrix = CSVFormat
				.DEFAULT
				.withFirstRecordAsHeader()
				.parse(new FileReader(graphFile))
				.getRecords();
		int numVertices = matrix.size();

		List<List<CSVRecord>> recordsByOutbreak = byOutbreak(records, numVertices);
		List<CSVRecord> winners = findWinners(recordsByOutbreak, numVertices);

		String s = getReadableOverallWinners(winners);
		String m = getCsvOverallWinners(winners);
		String t = getTexTableWinners(winners);

		return new String[] {s, m, t};
	}

	/**
	 * Given the outcome of each defence (organised by source node of the model), determines the winning defence
	 * strategy for each outbreak. This is decided by first determining, for each source node, the fewest number of
	 * infected agents at the close of the model, then of those remaining the fewest number of turns it took to halt the
	 * contagion and finally (in case we still have ties that could be broken) finding the strategies with the greatest
	 * numbers of protected vertices in their outcome.
	 *
	 * @param recordsByOutbreak the outcome of each defence strategy, organised by outbreak vertex.
	 * @param numVertices       the number of vertices in the graph model.
	 * @return the winning defence strategies for each outbreak, determined by fewest infections, fewest turns and most
	 * protected.
	 */
	public static List<CSVRecord> findWinners(List<List<CSVRecord>> recordsByOutbreak, int numVertices) {
		int highestTurnCount = 0;
		int highestInfected = 0;
		for (List<CSVRecord> records : recordsByOutbreak) {
			for (CSVRecord record : records) {
				int infected = Integer.parseInt(record.get("INFECTED"));
				if (infected > highestInfected) highestInfected = infected;
				int turnCount = Integer.parseInt(record.get("END TURN"));
				if (turnCount > highestTurnCount) highestTurnCount = turnCount;
			}
		}
		// Filter first by fewest infections (main winning criterion), then by smallest turn count
		// and finally by greatest number of protected vertices and return as our winners.
		List<CSVRecord> leastInfections = findFewestInfected(recordsByOutbreak, highestInfected);
		List<CSVRecord> smallestEndTurn = findSmallestTurnCount(byOutbreak(leastInfections, numVertices), highestTurnCount);
		return findMostProtected(byOutbreak(smallestEndTurn, numVertices));
	}

	/**
	 * Organises records of a CSV file representing graph model defence strategy results by outbreak vertices, in order
	 * to determine the winning strategy per source node.
	 *
	 * @param toChange    the List of records representing all model strategy outcomes.
	 * @param numVertices the number of vertices in the graph model.
	 * @return the list of model strategy outcomes, separated into sub-lists with the index in the main list of each
	 * sub-list corresponding to the source node of the strategies in the list.
	 */
	public static List<List<CSVRecord>> byOutbreak(List<CSVRecord> toChange, int numVertices) {
		// New List of Lists with an empty list at every index from 0 to number of vertices
		List<List<CSVRecord>> byOutbreak = IntStream.range(0, numVertices)
				.<List<CSVRecord>>mapToObj(i -> new ArrayList<>()).collect(Collectors.toList());
		// Add the records to the appropriate outbreak locations in the list to return
		toChange.forEach(record -> byOutbreak.get(Integer.parseInt(record.get("OUTBREAK"))).add(record));

		return byOutbreak;
	}

	////////////////////////////////////////////////
	// HELPER METHODS USED TO DETERMINE WINNERS. //
	////////////////////////////////////////////////

	/*
	    Helper method - gets the winners in a human readable format.
	 */
	private static String getReadableOverallWinners(List<CSVRecord> winners) {
		// Initialise string builder to construct string to return.
		StringBuilder s = new StringBuilder();
		// Append the winning defence strategy from each outbreak
		s.append("# Winning Strategies\n");

		for (CSVRecord strings : winners) {
			s.append("\n* _").append(strings.get("OUTBREAK")).append(":_ ")
					.append(strings.get("STRATEGY")).append(" with ")
					.append(strings.get("INFECTED")).append(" infected, ")
					.append(strings.get("PROTECTED")).append(" protected in ")
					.append(strings.get("END TURN")).append(" turns.\n\n");
		}
		return String.valueOf(s);
	}

	/*
	    Helper method - gets the winners in a machine-readable CSV format.
	 */
	private static String getCsvOverallWinners(List<CSVRecord> winners) {
		StringBuilder m = new StringBuilder();
		for (CSVRecord w : winners) {
			m.append(w.get("OUTBREAK")).append(",").append(w.get("STRATEGY")).append(",").append(w.get("END TURN"))
					.append(",").append(w.get("SUSCEPTIBLE")).append(",").append(w.get("INFECTED")).append(",")
					.append(w.get("RECOVERED")).append(",").append(w.get("PROTECTED")).append("\n");
		}

		return String.valueOf(m);
	}

	/*
	    Helper method - returns the winners in LaTeX code (namely a tabular environment).
	 */
	@SuppressWarnings("SpellCheckingInspection") // IDE spellcheck doesn't like TeX code too much
	private static String getTexTableWinners(List<CSVRecord> winners) {
		// Initialise string builder to construct string to return.
		StringBuilder t = new StringBuilder();

		// Append the start of the centering and tabular environments
		t.append("""
				\\documentclass[results.tex]{subfiles}
				\\begin{document}
								
				\\begin{center}
				  \\begin{tabular}{| c || c | c | c | c |}
				    \\hline
				    {\\bfseries Source node} & {\\bfseries Winning Strategy} & {\\bfseries Infections} & {\\bfseries Protections} & {\\bfseries End-Turn} \\\\  %[0.5ex]
				    \\hline\\hline""");

		winners.forEach(record -> t.append("\n    ").append(record.get("OUTBREAK")).append(" & ")
				.append(capitaliseWord(record.get("STRATEGY"))).append(" & ")
				.append(record.get("INFECTED")).append(" & ")
				.append(record.get("PROTECTED")).append(" & ")
				.append(record.get("END TURN")).append(" \\\\ \n    \\hline"));
		t.append("""
				   \\end{tabular}
				\\end{center}
								
				\\end{document}
				""");
		return String.valueOf(t);
	}

	/*
	    Returns the records with the fewest infections per outbreak (may be more than one for each)
	 */
	private static List<CSVRecord> findFewestInfected(List<List<CSVRecord>> byOutbreak, int highestInfected) {
		List<CSVRecord> leastInfected = new ArrayList<>();
		int smallest;

		for (List<CSVRecord> list : byOutbreak) {
			smallest = highestInfected;
			for (CSVRecord record : list) {

				int infected = Integer.parseInt(record.get("INFECTED"));
				if (infected < smallest) smallest = infected;
			}
			for (CSVRecord record : list) {
				if (Integer.parseInt(record.get("INFECTED")) == smallest) {
					leastInfected.add(record);
				}
			}
		}
		return leastInfected;
	}

	/*
	    Returns the records with the smallest turn counts per outbreak (may be more than one for each)
	 */
	private static List<CSVRecord> findSmallestTurnCount(List<List<CSVRecord>> byOutbreak, int highestTurnCount) {
		List<CSVRecord> smallestTurnCounts = new ArrayList<>();
		for (List<CSVRecord> list : byOutbreak) {
			int smallest = highestTurnCount;
			for (CSVRecord record : list) {
				int endTurn = Integer.parseInt(record.get("END TURN"));
				if (endTurn < smallest) smallest = endTurn;
			}
			for (CSVRecord record : list) {
				if (Integer.parseInt(record.get("END TURN")) == smallest) {
					smallestTurnCounts.add(record);
				}
			}
		}
		return smallestTurnCounts;
	}

	/*
		Returns the records with the greatest number of protections per outbreak (may be more than one)
	 */
	private static List<CSVRecord> findMostProtected(List<List<CSVRecord>> byOutbreak) {
		List<CSVRecord> mostProtected = new ArrayList<>();
		for (List<CSVRecord> list : byOutbreak) {
			int greatest = 0;
			for (CSVRecord record : list) {
				int defended = Integer.parseInt(record.get("PROTECTED"));
				if (defended > greatest) greatest = defended;
			}
			for (CSVRecord record : list) {
				if (Integer.parseInt(record.get("PROTECTED")) == greatest) {
					mostProtected.add(record);
				}
			}
		}
		return mostProtected;
	}

	/*
	    Used for formatting outputs - capitalises a given word.
	 */
	private static String capitaliseWord(String str) {
		String[] words = str.split("\\s");
		StringBuilder capitalizeWord = new StringBuilder();
		for (String w : words) {
			w = w.toLowerCase();
			String first = w.substring(0, 1);
			String afterFirst = w.substring(1);
			capitalizeWord.append(first.toUpperCase()).append(afterFirst).append(" ");
		}
		return capitalizeWord.toString().trim();
	}

	/**
	 * Returns a human-readable string representing the overall winners when various models have been run on a given
	 * graph class. Each array parameter represents the number of times the named defence strategy won on the graph and
	 * sub-categorised by defence strategies Proximity, Degree and Protection.
	 *
	 * @param graphName        the type of graph on which the models have been run.
	 * @param winRandom        the random protection allocation winners, for each of the three defence strategies.
	 * @param winMixed         the mixed protection allocation win data.
	 * @param winDeterministic the deterministic protection allocation win data.
	 * @return a human-readable (markdown-formatted) string representing a summary of a multi-graph test.
	 */
	public static String getReadableOverallWinners(String graphName, long[] winRandom, long[] winMixed, long[] winDeterministic) {
		return "# " + graphName + " " + "Model Results\n\n" +
		       "## Random\n" +
		       " * " + Defence.PROXIMITY + ": " + winRandom[Defence.PROXIMITY.getValue()] + "\n" +
		       " * " + Defence.DEGREE + ": " + winRandom[Defence.DEGREE.getValue()] + "\n" +
		       " * " + Defence.PROTECTION + ": " + winRandom[Defence.PROTECTION.getValue()] +
		       "\n\n## Mixed\n" +
		       " * " + Defence.PROXIMITY + ": " + winMixed[Defence.PROXIMITY.getValue()] + "\n" +
		       " * " + Defence.DEGREE + ": " + winMixed[Defence.DEGREE.getValue()] + "\n" +
		       " * " + Defence.PROTECTION + ": " + winMixed[Defence.PROTECTION.getValue()] +
		       "\n\n## Deterministic\n" +
		       " * " + Defence.PROXIMITY + ": " + winDeterministic[Defence.PROXIMITY.getValue()] + "\n" +
		       " * " + Defence.DEGREE + ": " + winDeterministic[Defence.DEGREE.getValue()] + "\n" +
		       " * " + Defence.PROTECTION + ": " + winDeterministic[Defence.PROTECTION.getValue()] + "\n\n";
	}

	/**
	 * Returns a machine-readable string representing the overall winners when various models have been run on a given
	 * graph class. Each array parameter represents the number of times the named defence strategy won on the graph and
	 * sub-categorised by defence strategies Proximity, Degree and Protection. the random protection allocation winners,
	 * for each of the three defence strategies.
	 *
	 * @param winMixed         the mixed protection allocation win data.
	 * @param winDeterministic the deterministic protection allocation win data.
	 * @return a machine-readable (comma separated) string representing a summary of a multi-graph test.
	 */
	public static String getCsvOverallWinners(long[] winRandom, long[] winMixed, long[] winDeterministic) {
		return MessageFormat.format("""
						PROTECTION ALLOCATION,DEFENCE STRATEGY,NUMBER OF WINS
						RANDOM,PROXIMITY,{0}
						RANDOM,DEGREE,{1}
						RANDOM,PROTECTION,{2}
						MIXED,PROXIMITY,{3}
						MIXED,DEGREE,{4}
						MIXED,PROTECTION,{5}
						DETERMINISTIC,PROXIMITY,{6}
						DETERMINISTIC,DEGREE,{7}
						DETERMINISTIC,PROTECTION,{8}""",
				winRandom[Defence.PROXIMITY.getValue()],
				winRandom[Defence.DEGREE.getValue()],
				winRandom[Defence.PROTECTION.getValue()],
				winMixed[Defence.PROXIMITY.getValue()],
				winMixed[Defence.DEGREE.getValue()],
				winMixed[Defence.PROTECTION.getValue()],
				winDeterministic[Defence.PROXIMITY.getValue()],
				winDeterministic[Defence.DEGREE.getValue()],
				winDeterministic[Defence.PROTECTION.getValue()]);
	}
}
