package io.github.ethankelly;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * The {@code GraphGenerator} class provides several methods for creating various graphs, including Erdos-Renyi random
 * graphs, random bipartite graphs, random k-regular graphs, and random rooted trees.
 *
 * @author Ethan Kelly
 */
@SuppressWarnings("unused")
public class GraphGenerator {
	private static long seed;

	static {
		setSeed();
	}

	/**
	 * Prints the current graphs that can be (randomly) generated or allows for loading of another graph (in csv
	 * format). Gets user input as to which graph to create and returns the generated graph.
	 *
	 * @return the specified generated or loaded graph.
	 * @throws IOException if the user chooses to load a graph from a file and the specified file cannot be found.
	 */
	public static Graph createGraph() throws IOException {
		// Scanner object to get user selection
		Scanner s = new Scanner(System.in);
		// Initialise the graph
		Graph g = null;

		// Check to see whether user wants to load an existing graph or generate a new (random) graph
		System.out.println("Would you like to generate a graph or load a graph from CSV file?" +
		                   "\n Type 'g' for generate or 'l' for load.");
		String choice = s.nextLine();

		if (choice.equalsIgnoreCase("l")) {
			System.out.println("You have chosen to load a graph from CSV file. Please enter the file path.");
			String filePath = s.nextLine();
			g = readGraphFromFile(filePath);

		} else if (choice.equalsIgnoreCase("g")) {
			g = inputGraphSelection(s);
		}
		s.close();
		return g;
	}

	private static Graph inputGraphSelection(Scanner s) {
		// Get number of vertices and number of edges required
		int numVertices = Model.inputVertices();
		int numVertices1 = numVertices / 2, numVertices2 = numVertices - numVertices1;

		Graph g;
		// Print the menu
		System.out.println("""
				The following graphs can be created:
				   1 * Simple (unweighted, undirected, no loops or multiple edges)
				   2 * Erdős–Rényi (edge between two vertices exists with given probability)
				   3 * Complete (every pair of vertices connected by single unique edge)
				   4 * Bipartite (vertices can be divided into two, disjoint, independent sets)
				   5 * Complete bipartite (every pair in each set connected by single unique edge)
				   6 * Path (graph containing a single path through each vertex)
				   7 * Binary tree (each vertex has at most three children)
				   8 * Cycle (graph containing only a single cycle through all vertices)
				   9 * Eulerian Path (graph containing only a single Eulerian path through all vertices)
				  10 * Eulerian Cycle (graph containing only a single Eulerian cycle through all vertices)
				  11 * Wheel (a single vertex connected to every other vertex in a cycle)
				  12 * Star (a tree with a single internal vertex and a given number of leaves)
				  13 * Regular (regularly uniform k-regular graph)
				  14 * Tree (uniformly random tree, generated using Prüfer sequence)
				 Enter the number corresponding to your selected graph to generate it.""");
		int selection = s.nextInt(); // User selection
		switch (selection) {
			case 1 -> { // Simple
				System.out.println("You have selected a Simple graph.");
				int numEdges = Model.inputEdges();
				g = simple(numVertices, numEdges);
				System.out.println(g);
			}
			case 2 -> { // Erdős–Rényi
				System.out.println("You have selected an Erdős–Rényi graph.");
				double p = (double) Model.inputEdges() / (numVertices * (numVertices - 1) / 2.0);
				g = erdosRenyi(numVertices, p);
				System.out.println(g);
			}
			case 3 -> { // Complete
				g = complete(numVertices);
				System.out.println("You have selected a Complete graph.\n" + g);
			}
			case 4 -> { // Bipartite
				System.out.println("You have selected a Bipartite graph.");
				int numEdges = Model.inputEdges();
				g = bipartite(numVertices1, numVertices2, numEdges);
				System.out.println(g);
			}
			case 5 -> { // Complete bipartite
				g = completeBipartite(numVertices1, numVertices2);
				System.out.println("You have selected a Complete Bipartite graph.\n" + g);
			}
			case 6 -> { // Path
				g = path(numVertices);
				System.out.println("You have selected a Path graph.\n" + g);
			}
			case 7 -> { // Binary tree
				g = binaryTree(numVertices);
				System.out.println("You have selected a Binary Tree graph.\n" + g);
			}
			case 8 -> { // Cycle
				g = cycle(numVertices);
				System.out.println("You have selected a Cycle graph.\n" + g);
			}
			case 9 -> { // Eulerian path
				System.out.println("You have selected an Eulerian Path graph.");
				int numEdges = Model.inputEdges();
				g = eulerianPath(numVertices, numEdges);
				System.out.println(g);
			}
			case 10 -> { // Eulerian cycle
				System.out.println("You have selected an Eulerian Cycle graph.");
				int numEdges = Model.inputEdges();
				g = eulerianCycle(numVertices, numEdges);
				System.out.println(g);
			}
			case 11 -> { // Wheel
				g = wheel(numVertices);
				System.out.println("You have selected a Wheel graph.\n" + g);
			}
			case 12 -> { // Star
				g = star(numVertices);
				System.out.println("You have selected a Star graph.\n" + g);
			}
			case 13 -> { // Regular
				System.out.println("You have selected a k-Regular graph.\nPlease enter your desired value of k:");
				int k = s.nextInt();
				g = regular(numVertices, k);
				System.out.println(g);
			}
			case 14 -> { // Tree
				g = tree(numVertices);
				System.out.println("You have selected a Tree graph.\n" + g);
			}
			default -> throw new IllegalStateException("Unexpected value: " + selection);
		}
		return g;
	}

	// Reads a graph from a CSV file
	private static Graph readGraphFromFile(String filePath) throws IOException {
		// Load the CSV file (with header indicating vertex numbers)
		List<CSVRecord> matrix = CSVFormat
				.DEFAULT
				.withFirstRecordAsHeader()
				.parse(new FileReader(filePath))
				.getRecords();
		int numVertices = matrix.size();
		Graph g = new Graph(numVertices, "");

		for (int row = 0; row < numVertices; row++) { // Row in matrix
			for (int column = 0; column < numVertices; column++) { // Entry in row
				if (Integer.parseInt((matrix.get(row)).get(column)) == 1 && !g.isEdge(row, column))
					g.addEdge(row, column);
			}
		}
		return g;
	}

	/**
	 * A simple graph is an unweighted and undirected graph with no loops or multiple edges.A simple graph may be either
	 * connected or disconnected. This method randomly generates and returns such a simple graph given (valid) numbers
	 * of vertices and edges.
	 *
	 * @param numVertices the number of vertices.
	 * @param numEdges    the number of vertices.
	 * @return a random simple graph on the given number of vertices with the given number of edges.
	 * @throws AssertionError if no such simple graph can be generated.
	 */
	public static Graph simple(int numVertices, int numEdges) {
		assert numEdges <= numVertices * (numVertices - 1) / 2 : "Too many edges.";
		assert numEdges >= 0 : "Too few edges.";
		Graph g = new Graph(numVertices, "Simple");
		g.setNumEdges(0);
		Set<Edge> set = new Set<>();
		while (g.getNumEdges() < numEdges) {
			int v = Std.StdRandom.uniform(numVertices);
			int w = Std.StdRandom.uniform(numVertices);
			Edge e = new Edge(v, w);
			if ((v != w) && !set.contains(e)) {
				set.add(e);
				g.addEdge(v, w);
			}
		}
		return g;
	}

	/**
	 * Generates and returns a random Erdős–Rényi graph on a given number of vertices, with an edge between any two
	 * vertices existing with some given probability.
	 *
	 * @param numVertices the number of vertices
	 * @param probability the probability of choosing an edge.
	 * @return a random erdosRenyi graph on {@code numVertices} vertices, with an edge between any two vertices with
	 * probability {@code probability}.
	 * @throws AssertionError if the given probability is not between 0 and 1.
	 */
	public static Graph erdosRenyi(int numVertices, double probability) {
		assert !(probability < 0.0) && !(probability > 1.0) : "Probability must be between 0 and 1";
		Graph g = new Graph(numVertices, "Erdős–Rényi");
		for (int v = 0; v < numVertices; v++)
			for (int w = v + 1; w < numVertices; w++)
				if (Std.StdRandom.bernoulli(probability))
					g.addEdge(v, w);
		return g;
	}

	/**
	 * A complete graph is a graph in which every pair of vertices is connected by a single unique edge. This method
	 * generates and returns the complete graph on a given number of vertices.
	 *
	 * @param numVertices the number of vertices.
	 * @return the complete graph on the given number of vertices.
	 */
	public static Graph complete(int numVertices) {
		Graph complete = erdosRenyi(numVertices, 1.0);
		complete.setName("Complete");
		return complete;
	}

	/**
	 * A bipartite graph (or simply bigraph) is a graph where the vertices can be divided into two disjoint, independent
	 * sets such that every edge connects a vertex in the first set to one in the second set. This method generates and
	 * returns a complete bipartite graph with {@code numVer1} vertices in the first set and {@code numVer2} vertices in
	 * the second set.
	 *
	 * @param numVer1 the number of vertices in the first partition.
	 * @param numVer2 the number of vertices in the second partition.
	 * @return a complete bipartite graph on {@code numVer1} and {@code numVer2} vertices.
	 */
	public static Graph completeBipartite(int numVer1, int numVer2) {
		Graph bipartite = bipartite(numVer1, numVer2, numVer1 * numVer2);
		bipartite.setName("Complete Bipartite");
		return bipartite;
	}

	/**
	 * Generates and returns a bipartite graph using the Erdős–Rényi model on {@code numVer1} and {@code numVer2}
	 * vertices with {@code numEdges} edges.
	 *
	 * @param numVer1  the number of vertices in the first partition.
	 * @param numVer2  the number of vertices in the second partition.
	 * @param numEdges the number of edges onto which to generate the graph.
	 * @return a random Erdős–Rényi bipartite graph on {@code numVer1} and {@code numVer2} vertices, containing a total
	 * of {@code numEdges} edges.
	 * @throws AssertionError if no such Erdős–Rényi bipartite graph can be generated.
	 */
	public static Graph bipartite(int numVer1, int numVer2, int numEdges) {
		assert numEdges <= numVer1 * numVer2 : "Too many edges";
		assert numEdges >= 0 : "Too few edges";
		Graph g = new Graph(numVer1 + numVer2, "Bipartite");

		int[] vertices = IntStream.range(0, numVer1 + numVer2).toArray();
		Std.StdRandom.shuffle(vertices);

		Set<Edge> set = new Set<>();
		while (g.getNumEdges() < numEdges) {
			int i = Std.StdRandom.uniform(numVer1);
			int j = numVer1 + Std.StdRandom.uniform(numVer2);
			Edge e = new Edge(vertices[i], vertices[j]);
			if (!set.contains(e)) {
				set.add(e);
				g.addEdge(vertices[i], vertices[j]);
			}
		}
		return g;
	}

	/**
	 * Returns a random Erdős–Rényi bipartite graph on {@code numVer1} and {@code numVer2} vertices, containing each
	 * possible edge with probability {@code probability}.
	 *
	 * @param numVer1     the number of vertices in the first partition.
	 * @param numVer2     the number of vertices in the second partition.
	 * @param probability the probability that the graph contains an edge with one endpoint in either side.
	 * @return a random erdosRenyi bipartite graph on {@code numVer1} and {@code numVer2} vertices, containing each
	 * possible edge with probability {@code probability}.
	 * @throws AssertionError if probability is not between 0 and 1.
	 */
	public static Graph bipartite(int numVer1, int numVer2, double probability) {
		assert !(probability < 0.0) && !(probability > 1.0) : "Probability must be between 0 and 1";
		int[] vertices = IntStream.range(0, numVer1 + numVer2).toArray();
		Std.StdRandom.shuffle(vertices);
		Graph G = new Graph(numVer1 + numVer2, "Erdős–Rényi Bipartite");
		for (int i = 0; i < numVer1; i++)
			for (int j = 0; j < numVer2; j++)
				if (Std.StdRandom.bernoulli(probability))
					G.addEdge(vertices[i], vertices[numVer1 + j]);
		return G;
	}

	/**
	 * A path is a sequence of edges joining a given sequence of vertices. This method generates and returns a path
	 * graph on {@code numVertices} vertices.
	 *
	 * @param numVertices the number of vertices in the path
	 * @return a path graph on {@code numVertices} vertices
	 */
	public static Graph path(int numVertices) {
		Graph g = new Graph(numVertices, "Path");
		// Generate an array: [0, 1, ..., numVertices] and randomly shuffle it.
		int[] vertices = IntStream.range(0, numVertices).toArray();
		Std.StdRandom.shuffle(vertices);
		// Connect the consecutive vertices to generate the random path graph
		for (int i = 0; i < numVertices - 1; i++) {
			g.addEdge(vertices[i], vertices[i + 1]);
		}
		return g;
	}

	/**
	 * A binary tree is a tree where each vertex has at most two children. A complete binary tree is a binary tree in
	 * which every level is completely filled (every vertex has exactly two children) and all nodes are as far left as
	 * possible. This method generates and returns a complete binary tree graph on {@code numVertices} vertices.
	 *
	 * @param numVertices the number of vertices in the binary tree
	 * @return a complete binary tree graph on {@code numVertices} vertices
	 */
	public static Graph binaryTree(int numVertices) {
		Graph g = new Graph(numVertices, "Binary Tree");
		// Generate an array: [0, 1, ..., numVertices] and randomly shuffle it.
		int[] vertices = IntStream.range(0, numVertices).toArray();
		Std.StdRandom.shuffle(vertices);
		// Give each vertex two children (if we can)
		for (int i = 1; i < numVertices; i++) {
			g.addEdge(vertices[i], vertices[(i - 1) / 2]);
		}
		return g;
	}

	/**
	 * A cycle in a graph is a non-empty sequence of edges (a trail) in which the only repeated vertices are the first
	 * and last ones. This method generates and returns a cycle graph on {@code numVertices} vertices, a graph composed
	 * of a single cycle.
	 *
	 * @param numVertices the number of vertices in the cycle.
	 * @return a cycle graph on {@code numVertices} vertices.
	 */
	public static Graph cycle(int numVertices) {
		Graph g = new Graph(numVertices, "Cycle");
		// Generate an array: [0, 1, ..., numVertices] and randomly shuffle it.
		int[] vertices = IntStream.range(0, numVertices).toArray();
		Std.StdRandom.shuffle(vertices);
		// Connect vertices from 0 to 2 less than the number of vertices consecutively
		for (int i = 0; i < numVertices - 1; i++) {
			g.addEdge(vertices[i], vertices[i + 1]);
		}
		// Connect the last and first vertices to complete the cycle.
		g.addEdge(vertices[numVertices - 1], vertices[0]);
		return g;
	}

	/**
	 * An Eulerian path is a path on a graph that visits each edge precisely once. This method generates and returns an
	 * Eulerian path graph on {@code numVertices} vertices.
	 *
	 * @param numVertices the number of vertices in the path
	 * @param numEdges    the number of edges in the path
	 * @return a graph that is an Eulerian path on {@code numVertices} vertices and {@code numEdges} edges
	 * @throws AssertionError if either {@code numVertices <= 0} or {@code numEdges < 0}
	 */
	public static Graph eulerianPath(int numVertices, int numEdges) {
		// Catch incorrect input of number of edges or vertices
		assert numEdges >= 0 : "negative number of edges";
		assert numVertices > 0 : "An Eulerian path must have at least one vertex";
		Graph g = new Graph(numVertices, "Eulerian Path");
		// Fill an array of length equal to the number of edges with uniformly random values
		int[] vertices = IntStream.range(0, numEdges + 1).map(i -> Std.StdRandom.uniform(numVertices)).toArray();
		// Connect consecutive (i, i+1) vertices
		IntStream.range(0, numEdges).forEach(i -> g.addEdge(vertices[i], vertices[i + 1]));
		return g;
	}

	/**
	 * An Eulerian cycle is a graph cycle that has each edge in the cycle exactly once. This method generates and
	 * returns an Eulerian cycle graph on {@code numVertices} vertices.
	 *
	 * @param numVertices the number of vertices in the cycle.
	 * @param numEdges    the number of edges in the cycle.
	 * @return a graph that is an Eulerian cycle on {@code numVertices} vertices and {@code numEdges} edges
	 * @throws AssertionError if either {@code numVertices <= 0} or {@code numEdges <= 0}
	 */
	public static Graph eulerianCycle(int numVertices, int numEdges) {
		assert numEdges > 0 : "An Eulerian cycle must have at least one edge";
		assert numVertices > 0 : "An Eulerian cycle must have at least one vertex";
		Graph G = new Graph(numVertices, "Eulerian Cycle");
		// Fill an array of length equal to the number of edges with uniformly random values
		int[] vertices = IntStream.range(0, numEdges).map(i -> Std.StdRandom.uniform(numVertices)).toArray();
		// Connect consecutive (i, i+1) vertices
		IntStream.range(0, numEdges - 1).forEach(i -> G.addEdge(vertices[i], vertices[i + 1]));
		// Connect the last edge-indexed element in the vertex array to the first vertex to complete the cycle
		G.addEdge(vertices[numEdges - 1], vertices[0]);
		return G;
	}

	/**
	 * A wheel graph is a single vertex connected to every vertex in a cycle. This method generates and returns a wheel
	 * graph on {@code numVertices} vertices.
	 *
	 * @param numVertices the number of vertices in the wheel
	 * @return a wheel graph on {@code numVertices} vertices
	 * @throws AssertionError if the number of vertices provided is not at least 2.
	 */
	public static Graph wheel(int numVertices) {
		assert numVertices > 1 : "Number of vertices must be at least 2";
		Graph g = new Graph(numVertices, "Wheel");
		// Generate an array: [0, 1, ..., numVertices] and randomly shuffle it.
		int[] vertices = IntStream.range(0, numVertices).toArray();
		Std.StdRandom.shuffle(vertices);

		// Create an Erdős–Rényi cycle on numVertices-1 vertices
		IntStream.range(1, numVertices - 1).forEach(i -> g.addEdge(vertices[i], vertices[i + 1]));
		// Connect the last vertex to the first to complete the cycle
		g.addEdge(vertices[numVertices - 1], vertices[1]);

		// Connect vertices[0] to every vertex on cycle
		IntStream.range(1, numVertices).forEach(i -> g.addEdge(vertices[0], vertices[i]));

		return g;
	}

	/**
	 * A star graph is a tree with a single internal vertex and a given number of leaves. This method generates and
	 * returns a star graph on {@code numVertices} vertices.
	 *
	 * @param numVertices the number of vertices in the star.
	 * @return a star graph on {@code numVertices} vertices.
	 */
	public static Graph star(int numVertices) {
		assert numVertices > 0 : "Number of vertices must be at least 1";
		Graph g = new Graph(numVertices, "Star");
		// Generate an array: [0, 1, ..., numVertices] and randomly shuffle it.
		int[] vertices = IntStream.range(0, numVertices).toArray();
		Std.StdRandom.shuffle(vertices);

		// Connect vertices[0] to every other vertex
		IntStream.range(1, numVertices).forEach(i -> g.addEdge(vertices[0], vertices[i]));

		return g;
	}

	/**
	 * Returns a uniformly random {@code k}-regular graph on {@code numVertices} vertices. This graph is not necessarily
	 * Erdős–Rényi and is in fact Erdős–Rényi with probability only about <em>e^(-k^2/4)</em>, which is tiny when k =
	 * 14.
	 *
	 * @param numVertices the number of vertices in the graph
	 * @param k           degree of each vertex
	 * @return a uniformly random {@code k}-regular graph on {@code numVertices} vertices.
	 * @throws AssertionError if the number of vertices multiplied by k is not even.
	 */
	public static Graph regular(int numVertices, int k) {
		assert numVertices * k % 2 == 0 : "Number of vertices * k must be even";
		Graph g = new Graph(numVertices, k + "-Regular");

		// Create k copies of each vertex
		int[] vertices = new int[numVertices * k];
		for (int v = 0; v < numVertices; v++) {
			for (int j = 0; j < k; j++) {
				vertices[v + numVertices * j] = v;
			}
		}
		// Pick a random perfect matching:
		// Shuffle the vertices and, for i from 0 to (k*numVertices)/2,
		// add edges between consecutive vertices (2i, 2i + 1)
		Std.StdRandom.shuffle(vertices);
		IntStream.range(0, numVertices * k / 2).forEach(i -> g.addEdge(vertices[2 * i], vertices[2 * i + 1]));
		return g;
	}

	/**
	 * Returns a uniformly random tree on {@code numVertices} vertices. This algorithm uses a Prüfer sequence, which is
	 * a unique sequence associated to a tree, and takes time proportional to <em>numVertices log(numVertices)</em>.
	 *
	 * @param numVertices the number of vertices in the tree.
	 * @return a uniformly random tree on {@code numVertices} vertices.
	 */
	public static Graph tree(int numVertices) {
		Graph g = new Graph(numVertices, "Tree");

		if (numVertices == 1) return g;

		// Cayley's theorem: there are numVertices^(numVertices-2) labeled trees on numVertices vertices
		// Prüfer sequence: sequence of numVertices-2 values between 0 and numVertices-1
		// Prüfer's proof of Cayley's theorem: Prüfer sequences are in 1-1 with labeled trees on numVertices vertices

		// Fill a new array of size two less than numVertices with uniformly random integers
		int[] prufer = IntStream.range(0, numVertices - 2).map(i -> Std.StdRandom.uniform(numVertices)).toArray();

		// Degree of vertex v = 1 + no. times it appears in Prüfer sequence
		int[] degree = IntStream.range(0, numVertices).map(v -> 1).toArray();
		IntStream.range(0, numVertices - 2).forEach(i -> degree[prufer[i]]++);

		// Minimum priority queue object pq contains all vertices of degree 1
		Set.MinPriorityQueue<Integer> pq = new Set.MinPriorityQueue<>();
		IntStream.range(0, numVertices).filter(v -> degree[v] == 1).forEach(pq::insert);

		// Repeatedly call delMin() (removes and returns smallest key on the priority queue)
		// on each degree 1 vertex that has the current minimum index
		for (int i = 0; i < numVertices - 2; i++) {
			int v = pq.delMin();
			g.addEdge(v, prufer[i]);
			degree[v]--;
			degree[prufer[i]]--;
			if (degree[prufer[i]] == 1) pq.insert(prufer[i]);
		}
		g.addEdge(pq.delMin(), pq.delMin());
		return g;
	}

	/*
	TODO PREFERENTIAL ATTACHMENT GRAPH GENERATION

	Input: Number of Nodes N;
        Initial number of nodes m0;
        Offset Exponent a;
        Minimum degree 1 <= d <= m0.
	Output: scale-free multi-graph G = ({0,....,N-1}, E).

	1) Add m0 nodes to G.
	2) Connect every node in G to every other node in G, i.e. create a complete graph.
	3) Create a new node i.
	4) Pick a node j uniformly at random from the graph G. Set P = (k(j)/k_tot)^a.
	5) Pick a real number R uniformly at random between 0 and 1.
	6) If P > R then add j to i's adjacency list.
	7) Repeat steps 4 - 6 until i has m nodes in its adjacency list.
	8) Add i to the adjacency list of each node in its adjacency list.
	9) Add i to to the graph.
	10) Repeat steps 3 - 9 until there are N nodes in the graph.
	 */

	/**
	 * @return the seed from StdRandom used to generate the pseudo-random values used to create random graphs.
	 */
	public static long getSeed() {
		return seed;
	}

	/**
	 * Sets the seed attribute of this class to the seed attribute of the StdRandom instance used to generate random
	 * graphs.
	 */
	public static void setSeed() {
		seed = Std.StdRandom.getSeed();
	}

	// Tests the generator methods
	private static void testGenerator() {
		Std.StdOut.setOut(Std.StdOut.out);

		// Declare a number of vertices and a number of edges
		int numVertices = 8;
		int numEdges = 5;

		// Split vertices into two partitions for bipartite graphs
		int numVertices1 = numVertices / 2;
		int numVertices2 = numVertices - numVertices1;

		// Probabilities for testing Erdős–Rényi and Erdős–Rényi bipartite graphs
		double p = (double) numEdges / (numVertices * (numVertices - 1) / 2.0);
		double q = (double) numEdges / (numVertices1 * numVertices2);

		// Print the numbers of vertices and edges to the standard output
		Std.StdOut.println();
		Std.StdOut.println("Generating random graphs on " + numVertices + " vertices and " + numEdges + " edges.");
		Std.StdOut.println();

		// Generate and print each graph from the methods above to the standard output
		Std.StdOut.println("Complete graph");
		Std.StdOut.println(complete(numVertices));
		Std.StdOut.println();

		Std.StdOut.println("Simple");
		Std.StdOut.println(simple(numVertices, numEdges));
		Std.StdOut.println();

		Std.StdOut.println("Erdős–Rényi");
		Std.StdOut.println(erdosRenyi(numVertices, p));
		Std.StdOut.println();

		Std.StdOut.println("Complete bipartite");
		Std.StdOut.println(completeBipartite(numVertices1, numVertices2));
		Std.StdOut.println();

		Std.StdOut.println("Bipartite");
		Std.StdOut.println(bipartite(numVertices1, numVertices2, numEdges));
		Std.StdOut.println();

		Std.StdOut.println("Erdős–Rényi bipartite");
		Std.StdOut.println(bipartite(numVertices1, numVertices2, q));
		Std.StdOut.println();

		Std.StdOut.println("Path");
		Std.StdOut.println(path(numVertices));
		Std.StdOut.println();

		Std.StdOut.println("Cycle");
		Std.StdOut.println(cycle(numVertices));
		Std.StdOut.println();

		Std.StdOut.println("Binary tree");
		Std.StdOut.println(binaryTree(numVertices));
		Std.StdOut.println();

		Std.StdOut.println("Eulerian Cycle");
		Std.StdOut.println(eulerianCycle(numVertices, numEdges));
		Std.StdOut.println();

		Std.StdOut.println("Eulerian Path ");
		Std.StdOut.println(eulerianPath(numVertices, numEdges));
		Std.StdOut.println();

		Std.StdOut.println("Tree");
		Std.StdOut.println(tree(numVertices));
		Std.StdOut.println();

		Std.StdOut.println("4-Regular");
		Std.StdOut.println(regular(numVertices, 4));
		Std.StdOut.println();

		Std.StdOut.println("Star");
		Std.StdOut.println(star(numVertices));
		Std.StdOut.println();

		Std.StdOut.println("Wheel");
		Std.StdOut.println(wheel(numVertices));
		Std.StdOut.println();
	}

	/**
	 * Determines whether the provided graph type requires provision of a number of edges for generation.
	 *
	 * @param graphName the name of the graph type to check.
	 * @return true if the graph type requires a number of edges, false otherwise.
	 */
	public static boolean requiresEdgesToGenerate(String graphName) {
		return graphName.equalsIgnoreCase("simple") ||
		       graphName.equalsIgnoreCase("bipartite") ||
		       graphName.equalsIgnoreCase("eulerian path") ||
		       graphName.equalsIgnoreCase("eulerian cycle");
	}

	/**
	 * Determines whether the provided graph type requires provision of a probability for generation.
	 *
	 * @param graphName the name of the graph type to check.
	 * @return true if the graph type requires a probability, false otherwise.
	 */
	public static boolean requiresProbToGenerate(String graphName) {
		return graphName.equalsIgnoreCase("Erdős–Rényi") ||
		       graphName.equalsIgnoreCase("Erdos-Renyi") ||
		       graphName.equalsIgnoreCase("Erdos Renyi");
	}

	public static boolean requiresKToGenerate(String graphName) {
		return graphName.equalsIgnoreCase("Regular") ||
		       graphName.equalsIgnoreCase("k-Regular");
	}

	/**
	 * The Edge class is used to represent an edge as a pair of vertex locations (v, w) where v < w, between which the
	 * edge exists.
	 *
	 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
	 */
	private static final class Edge implements Comparable<Edge> {
		private final int v;
		private final int w;


		/**
		 * Class constructor - ensures v is less than w.
		 *
		 * @param v the first vertex the edge is attached to.
		 * @param w the other vertex the edge is attached to.
		 */
		private Edge(int v, int w) {
			if (v < w) {
				this.v = v;
				this.w = w;
			} else {
				this.v = w;
				this.w = v;
			}
		}

		/**
		 * Compares the location of two edges. Returns -1 if either this v is less than the v given as a parameter or
		 * this w is less than the w given as a parameter.
		 *
		 * @param that the edge to which we compare the current edge.
		 * @return 1 if the original v or w are each greater than their parameter counterparts, -1 if at least one of
		 * the original v or w are less than the comparison v or w, 0 if the edges have the same start and end vertices
		 * (i.e. they are the same edge).
		 */
		public int compareTo(Edge that) {
			if (this.v < that.v || this.w < that.w) return -1;
			else if (this.v > that.v || this.w > that.w) return +1;
			else return 0;
		}
	}
}
