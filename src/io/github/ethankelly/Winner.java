package io.github.ethankelly;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Winner {

	public static String getWinners(String dataFilePath, String graphFile) throws IOException {
		StringBuilder s = new StringBuilder();
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

		// Print the winning defence strategy from each outbreak
		s.append("# Winning Strategies\n");
		List<CSVRecord> winners = findWinners(recordsByOutbreak, numVertices);
		for (CSVRecord strings : winners) {
			s.append("\n* _").append(strings.get("OUTBREAK")).append(":_ ")
					.append(strings.get("STRATEGY")).append(" with ")
					.append(strings.get("INFECTED")).append(" infected, ")
					.append(strings.get("PROTECTED")).append(" protected in ")
					.append(strings.get("END TURN")).append(" turns.\n\n");
		}
		return String.valueOf(s);
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
		// Filter first by fewest infections (main winning criterion)
		List<CSVRecord> leastInfections = findFewestInfected(recordsByOutbreak, highestInfected);
		// Now filter results by smallest turn count.
		List<CSVRecord> smallestEndTurn = findSmallestTurnCount(byOutbreak(leastInfections, numVertices), highestTurnCount);
		// Finally filter those results by most number of protected vertices and return as our winners
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
}
