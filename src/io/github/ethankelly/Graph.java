package io.github.ethankelly;


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
@SuppressWarnings("unused")
public class Graph {

	private String name;
	private int numVertices;
	private int numEdges;
	private boolean[][] adjMatrix;

	/**
	 * Class constructor.
	 *
	 * @param numVertices the number of vertices to create in the graph.
	 * @param name        a string representing the type of graph the object is.
	 */
	public Graph(int numVertices, String name) {
		this.numVertices = numVertices;
		this.adjMatrix = new boolean[numVertices][numVertices];
		this.name = name;
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
		IntStream.range(0, n - 1).forEach(k -> s.append(k).append(","));
		s.append(n - 1).append("\n");
		for (int i = 0; i < n; i++) {
			boolean[] booleans = matrix[i];
			for (int k = 0; k < booleans.length - 1; k++) {
				boolean j = booleans[k];
				s.append(j ? 1 : 0).append(",");
			}
			s.append(matrix[i][n - 1] ? 1 : 0);
			s.append("\n");
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
		return (int) IntStream.range(0, this.getNumVertices()).filter(i -> this.isEdge(vertex, i)).count();
	}

	/**
	 * Helper method for calculating the shortest path, returns the minimum value of an array of path lengths if such a
	 * minimum value exists.
	 *
	 * @param pathArray       a collection of minimum distances from some vertex, v.
	 * @param shortestPathSet array containing whether a shortest path exists from v to each vertex.
	 * @return the index of the minimum value path distance from the path array.
	 */
	public int minDistance(int[] pathArray, Boolean[] shortestPathSet) {
		int min = Integer.MAX_VALUE, minIndex = -1;
		for (int i = 0; i < getNumVertices(); i++) {
			if (!shortestPathSet[i] && pathArray[i] <= min) {
				min = pathArray[i];
				minIndex = i;
			}
		}
		return minIndex;
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
		// For ease of computation further into this method
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (adjMatrix[i][j]) matrix[i][j] = 1;

		int[] pathArray = new int[n];

		// Shortest path set contains vertices that have a shortest path, i.e. shortestPathSet[i] is true
		// if i has a shortest path to the parameter 'vertex' and false otherwise.
		Boolean[] shortestPathSet = new Boolean[n];

		// Initially all distances are HUGE and shortestPathSet[] set to false
		// I.e. no vertices have a shortest path to the parameter 'vertex'
		for (int i = 0; i < n; i++) {
			pathArray[i] = Integer.MAX_VALUE;
			shortestPathSet[i] = false;
		}
		pathArray[vertex] = 0; // Path between vertex and itself is always 0

		// Find shortest path for all vertices
		for (int count = 0; count < n - 1; count++) {
			// Call minDistance to find the vertex v with minimum distance to the parameter 'vertex'
			int u = minDistance(pathArray, shortestPathSet);
			shortestPathSet[u] = true;
			// If vertex v is not in shortestPathSet yet, then update it
			for (int v = 0; v < n; v++)
				if (!shortestPathSet[v] && matrix[u][v] != 0 && pathArray[u] !=
				                                                Integer.MAX_VALUE && pathArray[u]
				                                                                     + matrix[u][v] < pathArray[v])
					pathArray[v] = pathArray[u] + matrix[u][v];
		}
		// Return the array of minimum distances to each vertex from the parameter 'vertex'
		return pathArray;
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
	}

	/**
	 * @return The number of vertices in the graph.
	 */
	public int getNumVertices() {
		return numVertices;
	}

	/**
	 * Sets the number of vertices in a given graph.
	 *
	 * @param numVertices the number of vertices to be included in the graph.
	 */
	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}

	/**
	 * An adjacency matrix represents a (finite) graph by indicating whether a pair of vertices share an edge between
	 * them. At the intersection of row i, column j, if the value is 1 there is an edge from i to j and if it's zero
	 * then there is no such edge. In our uses, graphs will mostly be bidirectional, meaning this value will be the same
	 * in row i, column j and row j, column i.
	 *
	 * @return the adjacency matrix of the graph
	 */
	public boolean[][] getAdjMatrix() {
		return adjMatrix;
	}

	/**
	 * Some methods update the adjacency matrix when called - this method makes this update.
	 *
	 * @param adjMatrix the updated version of the adjacency matrix to set.
	 */
	public void setAdjMatrix(boolean[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

	/**
	 * Determines whether there exists an edge between two vertices in a graph.
	 *
	 * @param i first vertex
	 * @param j second vertex
	 * @return true if i and j share an edge, false otherwise
	 */
	public boolean isEdge(int i, int j) {
		return getAdjMatrix()[i][j] || getAdjMatrix()[j][i];
	}

	/**
	 * Adds a given number of vertices to the current graph.
	 *
	 * @param numVertices the number of vertices to append to the graph.
	 */
	public void appendVertices(int numVertices) {
		if (numVertices < 0) throw new IllegalArgumentException("Number of vertices to add must be a positive integer");
		Graph that = new Graph(this.getNumVertices() + numVertices, this.getName());
		for (int i = 0; i < this.getNumVertices(); i++) {
			for (int j = 0; j < this.getNumVertices(); j++) {
				if (this.isEdge(i, j)) that.addEdge(i, j);
			}
		}
		this.setNumVertices(that.getNumVertices());
		this.setAdjMatrix(that.getAdjMatrix());
	}

	/**
	 * The name of the graph is used to indicate what type of graph structure we specified in generation, for instance a
	 * tree or a simple graph.
	 *
	 * @return the name of the current graph.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * She name of the graph is used to indicate what type of graph structure we specified in generation, for instance a
	 * tree or a simple graph. This method sets the name of the graph to the specified name.
	 *
	 * @param name the name to assign to the current graph.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Selects a random vertex from the set of vertices to begin the setOutbreak.
	 *
	 * @return a pseudo-randomly selected vertex between 0 and numVertices to be the source node.
	 */
	public int getRandomVertex() {
		return new Random().nextInt(this.getNumVertices());
	}

	/**
	 * @return the number of edges in the given graph.
	 */
	public int getNumEdges() {
		return this.numEdges;
	}

	/**
	 * Given a number of edges to associate with a given graph, updates the associated attribute.
	 *
	 * @param numEdges the number of edges to associate with the given graph.
	 */
	public void setNumEdges(int numEdges) {
		this.numEdges = numEdges;
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
		for (int i = 0; i < n; i++) {
			s.append(i).append(": ");
			for (boolean j : matrix[i]) {
				s.append(j ? 1 : 0).append(" ");
			}
			s.append("\n\n");
		}
		return s.toString();
	}
}
