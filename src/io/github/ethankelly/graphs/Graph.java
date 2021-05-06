package io.github.ethankelly.graphs;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * The {@code Graph} class represents a graph - a collection of vertices connected by edges in some meaningful
 * configuration. While the basis for the model is agency, this agency is represented as interactions of vertices of a
 * graph.
 * <p>
 * Using a graph to represent and examine allows the use of many excellent existing results in graph theory, plus the
 * use of a graph is not an unusual choice of visualisation in models of contagion even intuitively. The graphs to be
 * used in this model, objects of this class, have two important attributes:
 * <ul>
 *     <li> The number of vertices in the graph.
 *     <li> An adjacency matrix - each entry is true if the vertices represented by the row
 *          and column are connected by an edge, false otherwise
 *          (@see <a href ="https://mathworld.wolfram.com/AdjacencyMatrix.html">https://mathworld.wolfram.com/AdjacencyMatrix.html</a>).
 * </ul>
 * In much of the literature, graphs of this kind represent 'contact networks.'
 *
 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
 */
public class Graph {
	/**
	 * The type of graph structure we specified in generation.
	 */
	private String name;
	/**
	 * The number of vertices (nodes) in the graph.
	 */
	private int numVertices;
	/**
	 * The number of edges in the graph object.
	 */
	private int numEdges;
	/**
	 * Represents a (finite) graph as a matrix with true at (i, j) if i and j share an edge, false otherwise.
	 */
	private boolean[][] adjMatrix;

	/**
	 * Class constructor.
	 *
	 * @param numVertices the number of vertices to create in the graph.
	 * @param name        a string representing the type of graph the object is.
	 * @param adjMatrix   represents the graph with true at (i, j) if i and j share an edge (false otherwise).
	 */
	public Graph(int numVertices, String name, boolean[][] adjMatrix) {
		this.numVertices = numVertices;
		assert adjMatrix.length == numVertices && adjMatrix[0].length == numVertices : "Adjacency matrix should be a square matrix with a row and a column per vertex.";
		this.adjMatrix = adjMatrix;
		this.name = name;
	}

	public static void main(String[] args) {
		Graph complete = GraphGenerator.complete(10);
		Graph preferential = GraphGenerator.preferentialAttachment(10, 5, 1, 1);
		System.out.println(complete.findDegreeDistribution());
		System.out.println(preferential.findDegreeDistribution());
	}

	/**
	 * Returns a string (via a string builder) to print a graph as comma separated values, with the first line being a
	 * header, to parse in other files.
	 *
	 * @param g the graph to represent in a csv file.
	 * @return a csv representation of the given graph, to be printed to a file.
	 */
	public static String makeCommaSeparated(Graph g) {
		int n = g.getNumVertices(); // Shorthand for number of vertices
		boolean[][] matrix = g.getAdjMatrix();
		// Initialise string builder - this will create the string to return
		StringBuilder s = new StringBuilder();
		s.append(0);
		IntStream.range(1, g.getNumVertices()).forEach(v -> s.append(",").append(v));
		s.append("\n");
		for (int i = 0; i < n; i++) {
			boolean[] booleans = matrix[i];
			for (int k = 0; k < booleans.length - 1; k++) {
				boolean j = booleans[k];
				s.append(j ? 1 : 0).append(",");
			}
			s.append(matrix[i][n - 1] ? 1 : 0).append("\n");
		}
		return String.valueOf(s);
	}

	/**
	 * Finds the degree of a specified vertex in the given graph.
	 *
	 * @param vertex the vertex of which we want to find the degree.
	 * @return the degree of the specified vertex.
	 */
	public int findDegree(int vertex) {
		return (int) IntStream.range(0, this.getNumVertices()).filter(i -> this.hasEdge(vertex, i)).count();
	}

	/**
	 * Helper method for calculating the shortest path, returns the minimum value of an array of path lengths if such a
	 * minimum value exists.
	 *
	 * @param pathArray       a collection of minimum distances from some vertex, v.
	 * @param shortestPathSet array containing whether a shortest path exists from v to each vertex.
	 * @return the index of the minimum value path distance from the path array.
	 */
	public int minDistance(int[] pathArray, boolean[] shortestPathSet) {
		int min = Integer.MAX_VALUE, minIndex = -1;
		for (int i = 0; i < getNumVertices(); i++) {
			if (!shortestPathSet[i] && pathArray[i] <= min) {
				min = pathArray[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public String findDegreeDistribution() {
		StringBuilder degreesAsString = new StringBuilder();
		degreesAsString.append(findDegree(0));
		IntStream.range(1, this.getNumVertices()).forEach(v -> degreesAsString.append(",").append(findDegree(v)));

		return String.valueOf(degreesAsString);
	}

	/**
	 * Adds a bidirectional edge between two vertices i and j in a graph
	 *
	 * @param i first vertex
	 * @param j second vertex
	 */
	public void addEdge(int i, int j) {
		boolean[][] adjMat = getAdjMatrix();
		adjMat[i][j] = true;
		adjMat[j][i] = true;
		this.setAdjMatrix(adjMat);
		this.setNumEdges(getNumEdges() + 1);
	}

	/**
	 * Removes an edge between the two vertices specified from a graph
	 *
	 * @param i first vertex
	 * @param j second vertex
	 */
	public void removeEdge(int i, int j) {
		boolean[][] adjMat = getAdjMatrix();
		adjMat[i][j] = false;
		adjMat[j][i] = false;
		this.setAdjMatrix(adjMat);
		this.setNumEdges(getNumEdges() - 1);
	}

	/**
	 * Given the current state of the model, calculates the shortest paths from a given vertex to every other vertex
	 *
	 * @param vertex the vertex relative to which we want to calculate paths.
	 * @return the shortest path to each other vertex in the graph (if one exists).
	 */
	public int[] shortestPath(int vertex) {
		int n = this.getNumVertices();
		boolean[][] adjMatrix = this.getAdjMatrix();
		int[][] matrix = new int[n][n];
		// Convert adjacency matrix from boolean to integer (true -> 1, false -> 0)
		for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (adjMatrix[i][j]) matrix[i][j] = 1;
		// Shortest path array contains vertices that have a shortest path,
		// Path array contains the numerical shortest paths
		boolean[] shortestPathSet = new boolean[n];
		int[] pathArray = new int[n];
		// Initially all distances are HUGE and shortestPathSet[] set to false
		for (int i = 0; i < n; i++) {
			pathArray[i] = Integer.MAX_VALUE;
			shortestPathSet[i] = false;
		}
		pathArray[vertex] = 0; // Path between vertex and itself is always 0
		// Find shortest path for all vertices
		// Call minDistance to find the vertex v with minimum distance to the parameter 'vertex'
		// If vertex v is not in shortestPathSet yet, then update it
		IntStream.range(0, n - 1).map(count -> minDistance(pathArray, shortestPathSet)).forEach(u -> {
			shortestPathSet[u] = true;
			IntStream.range(0, n).filter(v ->
					!shortestPathSet[v] && matrix[u][v] != 0 && pathArray[u] != Integer.MAX_VALUE &&
					pathArray[u] + matrix[u][v] < pathArray[v]).forEach(v -> pathArray[v] = pathArray[u] + matrix[u][v]);
		});
		// Return the array of minimum distances to each vertex from the param vertex
		return pathArray;
	}

	/**
	 * Determines whether there exists an edge between two vertices in a graph.
	 *
	 * @param i first vertex
	 * @param j second vertex
	 * @return true if i and j share an edge, false otherwise
	 */
	public boolean hasEdge(int i, int j) {
		return this.getAdjMatrix()[i][j] || this.getAdjMatrix()[j][i];
	}

	/**
	 * Adds a given number of vertices to the current graph.
	 *
	 * @param numVertices the number of vertices to append to the graph.
	 */
	public void appendVertices(int numVertices) {
		assert numVertices >= 0 : "Number of vertices to add must be a positive integer";
		// Create a new graph object with the new number of vertices
		int newNumVert = this.getNumVertices() + numVertices;
		Graph that = new Graph(newNumVert, this.getName(), new boolean[newNumVert][newNumVert]);
		// Ensure all original edges are in the new graph instance
		for (int i = 0; i < this.getNumVertices(); i++) {
			for (int j = 0; j < this.getNumVertices(); j++) if (this.hasEdge(i, j)) that.addEdge(i, j);
		}
		this.setNumVertices(that.getNumVertices());
		this.setAdjMatrix(that.getAdjMatrix());
	}

	/**
	 * Selects a random vertex from the set of vertices to begin the outbreak.
	 *
	 * @return a pseudo-randomly selected vertex.
	 */
	public int getRandomVertex() {
		return new Random().nextInt(this.getNumVertices());
	}

	/**
	 * @return The number of vertices in the graph.
	 */
	public int getNumVertices() {
		return numVertices;
	}

	/**
	 * @param numVertices the number of vertices to be included in the current graph.
	 */
	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}

	/**
	 * @return the adjacency matrix of the graph
	 */
	public boolean[][] getAdjMatrix() {
		return this.adjMatrix;
	}

	/**
	 * @return the name of the current graph.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to assign to the current graph.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the number of edges in the given graph.
	 */
	public int getNumEdges() {
		return this.numEdges;
	}

	/**
	 * @param numEdges the number of edges to associate with the current graph.
	 */
	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
	}

	/**
	 * @param adjMatrix the updated version of the adjacency matrix to set.
	 */
	public void setAdjMatrix(boolean[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

	/**
	 * Returns a textual representation of a graph as an adjacency matrix to be printed to the standard output.
	 *
	 * @return a string representation of the graph.
	 */
	@Override
	public String toString() {
		int n = getNumVertices();
		boolean[][] matrix = getAdjMatrix();
		StringBuilder s = new StringBuilder();
		IntStream.range(0, n).forEach(i -> {
			s.append(i).append(": ");
			for (boolean j : matrix[i]) s.append(j ? 1 : 0).append(" ");
			s.append("\n\n");
		});
		return s.toString();
	}


	/**
	 * Makes a copy of the current Graph object.
	 *
	 * @return a new graph with identical attributes (number of vertices, name, adjacency matrix and transmission
	 * matrix) as the current graph.
	 */
	@Override
	public Graph clone() {
		try {
			return (Graph) super.clone();
		} catch (CloneNotSupportedException e) {
			return new Graph(this.getNumVertices(), this.getName(), this.getAdjMatrix());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Graph graph = (Graph) o;
		return getNumVertices() == graph.getNumVertices() &&
		       getNumEdges() == graph.getNumEdges() &&
		       Objects.equals(getName(), graph.getName()) &&
		       Arrays.deepEquals(getAdjMatrix(), graph.getAdjMatrix());
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(getName(), getNumVertices(), getNumEdges());
		result = 31 * result + Arrays.deepHashCode(getAdjMatrix());
		return result;
	}
}
