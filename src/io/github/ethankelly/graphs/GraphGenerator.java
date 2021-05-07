package io.github.ethankelly.graphs;

import io.github.ethankelly.Driver;
import io.github.ethankelly.ModelEngine;
import io.github.ethankelly.std.Out;
import io.github.ethankelly.std.Random;
import io.github.ethankelly.std.Set;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * The {@code GraphGenerator} class provides several methods for creating various graphs, including Erdos-Renyi random
 * graphs, random bipartite graphs, random k-regular graphs, and random rooted trees.
 *
 * @author Ethan Kelly
 */
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
	@SuppressWarnings("unused")
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
		int numVertices = inputVertices();
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
				  15 * A Barabási–Albert-generated preferential attachment graph (can be non-linear)
				  16 * A Watts-Strogatz model generated small-world graph.
				 Enter the number corresponding to your selected graph to generate it.""");
		int selection = s.nextInt(); // User selection
		switch (selection) {
			case 1 -> { // Simple
				System.out.println("You have selected a Simple graph.");
				int numEdges = inputEdges();
				g = simple(numVertices, numEdges);
				System.out.println(g);
			}
			case 2 -> { // Erdős–Rényi
				System.out.println("You have selected an Erdős–Rényi graph.");
				double p = (double) inputEdges() / (numVertices * (numVertices - 1) / 2.0);
				g = erdosRenyi(numVertices, p);
				System.out.println(g);
			}
			case 3 -> { // Complete
				g = complete(numVertices);
				System.out.println("You have selected a Complete graph.\n" + g);
			}
			case 4 -> { // Bipartite
				System.out.println("You have selected a Bipartite graph.");
				int numEdges = inputEdges();
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
				int numEdges = inputEdges();
				g = eulerianPath(numVertices, numEdges);
				System.out.println(g);
			}
			case 10 -> { // Eulerian cycle
				System.out.println("You have selected an Eulerian Cycle graph.");
				int numEdges = inputEdges();
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
			case 15 -> { // Barabási–Albert Preferential Attachment
				System.out.println("You have selected a Barabási–Albert-generated preferential attachment graph" +
				                   "\nPlease enter an initial number of vertices.");
				int initialNumVertices = 0;
				try {
					initialNumVertices = s.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("The initial number of vertices should be a positive integer" + e);
				}
				System.out.println("""
						Please enter a positive offset exponent, a. Some tips:\s
						 * a ≠ 1 results in non-linear preferential attachment.
						 * 0 < a < 1 is sub-linear
						 * a = 1 reduces attachment probability to that of the Barabási–Albert model (linear)
						 * a > 1 is super-linear.""");
				double offsetExponent = 0;
				try {
					offsetExponent = s.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("The offset exponent should be a floating point value" + e);
				}
				System.out.println("Finally, please enter a minimum degree for each vertex in the generated graph.");
				int minDegree = 0;
				try {
					minDegree = s.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("The minimum degree should be a positive integer" + e);
				}
				g = preferentialAttachment(numVertices, initialNumVertices, offsetExponent, minDegree);
			}
			case 16 -> { // Watts-Strogatz (small-world)
				System.out.println("You have selected a Watts-Strogatz-generated graph (with mall-world properties)." +
				                   "\nPlease enter the number of closest neighbours each vertex should attach to" +
				                   "initially.");
				int k = 0;
				try {
					k = s.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("This should have been a positive integer" + e);
				}
				System.out.println("Please enter the probability of rewiring each edge in the graph.");
				float p = 0;
				try {
					p = s.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("This should have been a floating point (decimal) value" + e);
				}
				g = wattsStrogatz(numVertices, k, p);
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
		Graph g = new Graph(numVertices, "", new boolean[numVertices][numVertices]);

		for (int row = 0; row < numVertices; row++) { // Row in matrix
			for (int column = 0; column < numVertices; column++) { // Entry in row
				if (Integer.parseInt((matrix.get(row)).get(column)) == 1 && !g.hasEdge(row, column))
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
	 * @param n the number of vertices.
	 * @param e the number of vertices.
	 * @return a random simple graph on the given number of vertices with the given number of edges.
	 * @throws AssertionError if no such simple graph can be generated.
	 */
	public static Graph simple(int n, int e) {
		assert e <= n * (n - 1) / 2 : "Too many edges.";
		assert e >= 0 : "Too few edges.";
		Graph g = new Graph(n, "Simple", new boolean[n][n]);
		g.setNumEdges(0);
		Set<Edge> set = new Set<>();
		while (g.getNumEdges() < e) {
			int v = Random.uniform(n);
			int w = Random.uniform(n);
			Edge edge = new Edge(v, w);
			if ((v != w) && !set.contains(edge)) {
				set.add(edge);
				g.addEdge(v, w);
			}
		}
		return g;
	}

	/**
	 * Generates and returns a random Erdős–Rényi graph on a given number of vertices, with an edge between any two
	 * vertices existing with some given p.
	 *
	 * @param n the number of vertices
	 * @param p the p of choosing an edge.
	 * @return a random erdosRenyi graph on {@code n} vertices, with an edge between any two vertices with p {@code p}.
	 * @throws AssertionError if the given p is not between 0 and 1.
	 */
	public static Graph erdosRenyi(int n, double p) {
		assert !(p < 0.0) && !(p > 1.0) : "Probability must be between 0 and 1";
		Graph g = new Graph(n, "Erdős–Rényi", new boolean[n][n]);
		for (int v = 0; v < n; v++)
			for (int w = v + 1; w < n; w++)
				if (Random.bernoulli(p))
					g.addEdge(v, w);
		return g;
	}

	/**
	 * A complete graph is a graph in which every pair of vertices is connected by a single unique edge. This method
	 * generates and returns the complete graph on a given number of vertices.
	 *
	 * @param n the number of vertices.
	 * @return the complete graph on the given number of vertices.
	 */
	public static Graph complete(int n) {
		Graph complete = erdosRenyi(n, 1.0);
		complete.setName("Complete");
		return complete;
	}

	/**
	 * A bipartite graph (or simply bigraph) is a graph where the vertices can be divided into two disjoint, independent
	 * sets such that every edge connects a vertex in the first set to one in the second set. This method generates and
	 * returns a complete bipartite graph with {@code n1} vertices in the first set and {@code n2} vertices in the
	 * second set.
	 *
	 * @param n1 the number of vertices in the first partition.
	 * @param n2 the number of vertices in the second partition.
	 * @return a complete bipartite graph on {@code n1} and {@code n2} vertices.
	 */
	public static Graph completeBipartite(int n1, int n2) {
		Graph bipartite = bipartite(n1, n2, n1 * n2);
		bipartite.setName("Complete Bipartite");
		return bipartite;
	}

	/**
	 * Generates and returns a bipartite graph using the Erdős–Rényi model on {@code n1} and {@code n2} vertices with
	 * {@code e} edges.
	 *
	 * @param n1 the number of vertices in the first partition.
	 * @param n2 the number of vertices in the second partition.
	 * @param e  the number of edges onto which to generate the graph.
	 * @return a random Erdős–Rényi bipartite graph on {@code n1} and {@code n2} vertices, containing a total of {@code
	 * e} edges.
	 * @throws AssertionError if no such Erdős–Rényi bipartite graph can be generated.
	 */
	public static Graph bipartite(int n1, int n2, int e) {
		assert e <= n1 * n2 : "Too many edges";
		assert e >= 0 : "Too few edges";
		Graph g = new Graph(n1 + n2, "Bipartite", new boolean[n1 + n2][n1 + n2]);

		int[] vertices = IntStream.range(0, n1 + n2).toArray();
		Random.shuffle(vertices);

		Set<Edge> set = new Set<>();
		while (g.getNumEdges() < e) {
			int i = Random.uniform(n1);
			int j = n1 + Random.uniform(n2);
			Edge edge = new Edge(vertices[i], vertices[j]);
			if (!set.contains(edge)) {
				set.add(edge);
				g.addEdge(vertices[i], vertices[j]);
			}
		}
		return g;
	}

	/**
	 * Returns a random Erdős–Rényi bipartite graph on {@code n1} and {@code n2} vertices, containing each possible edge
	 * with p {@code p}.
	 *
	 * @param n1 the number of vertices in the first partition.
	 * @param n2 the number of vertices in the second partition.
	 * @param p  the p that the graph contains an edge with one endpoint in either side.
	 * @return a random erdosRenyi bipartite graph on {@code n1} and {@code n2} vertices, containing each possible edge
	 * with p {@code p}.
	 * @throws AssertionError if p is not between 0 and 1.
	 */
	public static Graph bipartite(int n1, int n2, double p) {
		assert !(p < 0.0) && !(p > 1.0) : "Probability must be between 0 and 1";
		int[] vertices = IntStream.range(0, n1 + n2).toArray();
		Random.shuffle(vertices);
		Graph G = new Graph(n1 + n2, "Erdős–Rényi Bipartite", new boolean[n1 + n2][n1 + n2]);
		for (int i = 0; i < n1; i++)
			for (int j = 0; j < n2; j++)
				if (Random.bernoulli(p))
					G.addEdge(vertices[i], vertices[n1 + j]);
		return G;
	}

	/**
	 * A path is a sequence of edges joining a given sequence of vertices. This method generates and returns a path
	 * graph on {@code n} vertices.
	 *
	 * @param n the number of vertices in the path
	 * @return a path graph on {@code n} vertices
	 */
	public static Graph path(int n) {
		Graph g = new Graph(n, "Path", new boolean[n][n]);
		// Generate an array: [0, 1, ..., n] and randomly shuffle it.
		int[] vertices = IntStream.range(0, n).toArray();
		Random.shuffle(vertices);
		// Connect the consecutive vertices to generate the random path graph
		for (int i = 0; i < n - 1; i++) {
			g.addEdge(vertices[i], vertices[i + 1]);
		}
		return g;
	}

	/**
	 * A binary tree is a tree where each vertex has at most two children. A complete binary tree is a binary tree in
	 * which every level is completely filled (every vertex has exactly two children) and all nodes are as far left as
	 * possible. This method generates and returns a complete binary tree graph on {@code n} vertices.
	 *
	 * @param n the number of vertices in the binary tree
	 * @return a complete binary tree graph on {@code n} vertices
	 */
	public static Graph binaryTree(int n) {
		Graph g = new Graph(n, "Binary Tree", new boolean[n][n]);
		// Generate an array: [0, 1, ..., n] and randomly shuffle it.
		int[] vertices = IntStream.range(0, n).toArray();
		Random.shuffle(vertices);
		// Give each vertex two children (if we can)
		for (int i = 1; i < n; i++) {
			g.addEdge(vertices[i], vertices[(i - 1) / 2]);
		}
		return g;
	}

	/**
	 * A cycle in a graph is a non-empty sequence of edges (a trail) in which the only repeated vertices are the first
	 * and last ones. This method generates and returns a cycle graph on {@code n} vertices, a graph composed of a
	 * single cycle.
	 *
	 * @param n the number of vertices in the cycle.
	 * @return a cycle graph on {@code n} vertices.
	 */
	public static Graph cycle(int n) {
		Graph g = new Graph(n, "Cycle", new boolean[n][n]);
		// Generate an array: [0, 1, ..., n] and randomly shuffle it.
		int[] vertices = IntStream.range(0, n).toArray();
		Random.shuffle(vertices);
		// Connect vertices from 0 to 2 less than the number of vertices consecutively
		for (int i = 0; i < n - 1; i++) {
			g.addEdge(vertices[i], vertices[i + 1]);
		}
		// Connect the last and first vertices to complete the cycle.
		g.addEdge(vertices[n - 1], vertices[0]);
		return g;
	}

	/**
	 * An Eulerian path is a path on a graph that visits each edge precisely once. This method generates and returns an
	 * Eulerian path graph on {@code n} vertices.
	 *
	 * @param n the number of vertices in the path
	 * @param e the number of edges in the path
	 * @return a graph that is an Eulerian path on {@code n} vertices and {@code e} edges
	 * @throws AssertionError if either {@code n <= 0} or {@code e < 0}
	 */
	public static Graph eulerianPath(int n, int e) {
		// Catch incorrect input of number of edges or vertices
		assert e >= 0 : "negative number of edges";
		assert n > 0 : "An Eulerian path must have at least one vertex";
		Graph g = new Graph(n, "Eulerian Path", new boolean[n][n]);
		// Fill an array of length equal to the number of edges with uniformly random values
		int[] vertices = IntStream.range(0, e + 1).map(i -> Random.uniform(n)).toArray();
		// Connect consecutive (i, i+1) vertices
		IntStream.range(0, e).forEach(i -> g.addEdge(vertices[i], vertices[i + 1]));
		return g;
	}

	/**
	 * An Eulerian cycle is a graph cycle that has each edge in the cycle exactly once. This method generates and
	 * returns an Eulerian cycle graph on {@code n} vertices.
	 *
	 * @param n the number of vertices in the cycle.
	 * @param e the number of edges in the cycle.
	 * @return a graph that is an Eulerian cycle on {@code n} vertices and {@code e} edges
	 * @throws AssertionError if either {@code n <= 0} or {@code e <= 0}
	 */
	public static Graph eulerianCycle(int n, int e) {
		assert e > 0 : "An Eulerian cycle must have at least one edge";
		assert n > 0 : "An Eulerian cycle must have at least one vertex";
		Graph G = new Graph(n, "Eulerian Cycle", new boolean[n][n]);
		// Fill an array of length equal to the number of edges with uniformly random values
		int[] vertices = IntStream.range(0, e).map(i -> Random.uniform(n)).toArray();
		// Connect consecutive (i, i+1) vertices
		IntStream.range(0, e - 1).forEach(i -> G.addEdge(vertices[i], vertices[i + 1]));
		// Connect the last edge-indexed element in the vertex array to the first vertex to complete the cycle
		G.addEdge(vertices[e - 1], vertices[0]);
		return G;
	}

	/**
	 * A wheel graph is a single vertex connected to every vertex in a cycle. This method generates and returns a wheel
	 * graph on {@code n} vertices.
	 *
	 * @param n the number of vertices in the wheel
	 * @return a wheel graph on {@code n} vertices
	 * @throws AssertionError if the number of vertices provided is not at least 2.
	 */
	public static Graph wheel(int n) {
		assert n > 1 : "Number of vertices must be at least 2";
		Graph g = new Graph(n, "Wheel", new boolean[n][n]);
		// Generate an array: [0, 1, ..., n] and randomly shuffle it.
		int[] vertices = IntStream.range(0, n).toArray();
		Random.shuffle(vertices);

		// Create an Erdős–Rényi cycle on n-1 vertices
		IntStream.range(1, n - 1).forEach(i -> g.addEdge(vertices[i], vertices[i + 1]));
		// Connect the last vertex to the first to complete the cycle
		g.addEdge(vertices[n - 1], vertices[1]);

		// Connect vertices[0] to every vertex on cycle
		IntStream.range(1, n).forEach(i -> g.addEdge(vertices[0], vertices[i]));

		return g;
	}

	/**
	 * A star graph is a tree with a single internal vertex and a given number of leaves. This method generates and
	 * returns a star graph on {@code n} vertices.
	 *
	 * @param n the number of vertices in the star.
	 * @return a star graph on {@code n} vertices.
	 */
	public static Graph star(int n) {
		assert n > 0 : "Number of vertices must be at least 1";
		Graph g = new Graph(n, "Star", new boolean[n][n]);
		// Generate an array: [0, 1, ..., n] and randomly shuffle it.
		int[] vertices = IntStream.range(0, n).toArray();
		Random.shuffle(vertices);

		// Connect vertices[0] to every other vertex
		IntStream.range(1, n).forEach(i -> g.addEdge(vertices[0], vertices[i]));

		return g;
	}

	/**
	 * Returns a uniformly random {@code k}-regular graph on {@code n} vertices. This graph is not necessarily
	 * Erdős–Rényi and is in fact Erdős–Rényi with probability only about <em>e^(-k^2/4)</em>, which is tiny when k =
	 * 14.
	 *
	 * @param n the number of vertices in the graph
	 * @param k degree of each vertex
	 * @return a uniformly random {@code k}-regular graph on {@code n} vertices.
	 * @throws AssertionError if the number of vertices multiplied by k is not even.
	 */
	public static Graph regular(int n, int k) {
		assert n * k % 2 == 0 : "Number of vertices * k must be even";
		Graph g = new Graph(n, k + "-Regular", new boolean[n][n]);

		// Create k copies of each vertex
		int[] vertices = new int[n * k];
		for (int v = 0; v < n; v++) {
			for (int j = 0; j < k; j++) {
				vertices[v + n * j] = v;
			}
		}
		// Pick a random perfect matching:
		// Shuffle the vertices and, for i from 0 to (k*n)/2,
		// add edges between consecutive vertices (2i, 2i + 1)
		Random.shuffle(vertices);
		IntStream.range(0, n * k / 2).forEach(i -> g.addEdge(vertices[2 * i], vertices[2 * i + 1]));
		return g;
	}

	/**
	 * Returns a uniformly random tree on {@code n} vertices. This algorithm uses a Prüfer sequence, which is a unique
	 * sequence associated to a tree, and takes time proportional to <em>n log(n)</em>.
	 *
	 * @param n the number of vertices in the tree.
	 * @return a uniformly random tree on {@code n} vertices.
	 */
	public static Graph tree(int n) {
		Graph g = new Graph(n, "Tree", new boolean[n][n]);

		if (n == 1) return g;

		/*
		 Cayley's theorem: there are n^(n-2) labeled trees on n vertices
		 Prüfer sequence: sequence of n-2 values between 0 and n-1
		 Prüfer's proof of Cayley's theorem: Prüfer sequences are in 1-1 with labeled trees on n vertices
		 Fill a new array of size two less than n with uniformly random integers
		*/

		int[] prufer = IntStream.range(0, n - 2).map(i -> Random.uniform(n)).toArray();

		// Degree of vertex v = 1 + no. times it appears in Prüfer sequence
		int[] degree = IntStream.range(0, n).map(v -> 1).toArray();
		IntStream.range(0, n - 2).forEach(i -> degree[prufer[i]]++);

		// Minimum priority queue object pq contains all vertices of degree 1
		Set.MinPriorityQueue<Integer> pq = new Set.MinPriorityQueue<>();
		IntStream.range(0, n).filter(v -> degree[v] == 1).forEach(pq::insert);

		// Repeatedly call delMin() (removes and returns smallest key on the priority queue)
		// on each degree 1 vertex that has the current minimum index
		for (int i = 0; i < n - 2; i++) {
			int v = pq.delMin();
			g.addEdge(v, prufer[i]);
			degree[v]--;
			degree[prufer[i]]--;
			if (degree[prufer[i]] == 1) pq.insert(prufer[i]);
		}
		g.addEdge(pq.delMin(), pq.delMin());
		return g;
	}

	/**
	 * Generates a random, scale-free graph using a preferential attachment mechanism via the Barabási–Albert model.
	 * This algorithm uses a number of vertices N, an initial number of vertices M, an offset exponent a and a minimum
	 * degree d between 1 and the initial number of vertices. Then, the algorithm for the Barabási–Albert model is as
	 * follows:
	 * <ul>
	 *     <li> Add M vertices to the graph G
	 *     <li> Connect each vertex to every other vertex in G (create a complete graph).
	 *     <li> (†) Create a new vertex, i.
	 *     <li> (*) Select a new vertex j uniformly at random from G and set p = (k(j)/2*numEdges)^a.
	 *     <li> Select a real number r uniformly at random between 0 and 1.
	 *     <li> (*) If p > r, add j an edge between i and j.
	 *     <li> (†) Repeat the steps marked with (*) until i has M vertices adjacent to it.
	 *     <li> Repeat the steps between the (†) symbols until G has N vertices.
	 * </ul>
	 *
	 * @param nTotal    the total number of vertices to be in the generated graph.
	 * @param nInitial  the initial number of vertices to create in the graph.
	 * @param offsetExp a constant and positive exponent, sued for the non-linear preferential attachment model.
	 * @param minDegree the minimum degree of each vertex in the graph.
	 * @return a random, scale-free graph with preferential attachment mechanism generated using the Barabási–Albert
	 * model.
	 */
	public static Graph preferentialAttachment(int nTotal, int nInitial, double offsetExp, int minDegree) {
		// Add initial number of vertex to graph and connect every vertex to every other vertex
		Graph g = complete(nInitial);
		g.setName("Preferential Attachment");

		assert minDegree >= 1 && minDegree <= nInitial : "Minimum degree should be an integer between 1 and initial number of vertices";

		while (g.getNumVertices() < nTotal) {
			// Create a new node i
			g.appendVertices(1);
			int i = g.getNumVertices() - 1;
			// Repeat this until i has m vertices adjacent to it
			while (g.findDegree(i) <= minDegree) {
				// Pick a vertex j at random
				int j = g.getRandomVertex();
				// Set p = (k(j)/2*numEdges)^a.
				double p = Math.pow(((double) g.findDegree(j) / (double) 2 * g.getNumEdges()), offsetExp);
				// Pick a real number r at random between 0 and 1
				double r = Math.random();
				// If p > r, add an edge between i and j
				if (p > r) g.addEdge(i, j);
			}
		}
		return g;
	}

	/**
	 * The Watts-Strogatz model generates a random graph with small-world properties.
	 *
	 * @param n the number of vertices.
	 * @param k connect each node to its k nearest neighbors in a ring.
	 * @param p the probability of re-wiring each edge.
	 * @throws IllegalArgumentException in case of invalid parameters.
	 */
	public static Graph wattsStrogatz(
			int n, int k, double p) {
		// Make sure we have appropriate parameters
		assert n >= 3 : "number of vertices must be at least 3";
		assert k >= 1 : "number of k-nearest neighbors must be positive";
		assert k % 2 != 1 : "number of k-nearest neighbors must be even";
		assert k <= n - 2 + (n % 2) : "invalid k-nearest neighbors";
		assert !(p < 0.0) && !(p > 1.0) : "invalid probability";

		// Start with a ring over n vertices
		Graph g = wheel(n);
		g.setName("Watts-Strogatz");

		// Connect each vertex to k of its closest neighbours
		for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (wsTest(n, k, i, j)) g.addEdge(i, j);
		// For each vertex, rewire each of its edges with probability p
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (g.hasEdge(i, j)) {
					if (Random.uniform() <= p) {
						int randVertex;
						do {
							randVertex = Random.uniform(n);
						} while (i == randVertex || j == randVertex);
						g.removeEdge(i, j);
						g.addEdge(i, randVertex);
					}
				}
			}
		}
		return g;
	}


	private static boolean wsTest(int n, int k, int i, int j) {
		float expr = Math.floorMod(Math.abs(i - j), n - 1 - (k / 2));
		return (0 < expr) && (expr <= ((float) k / 2));
	}

	public static void main(String[] args) throws IOException {
		PrintStream console = System.out;
		Graph g = preferentialAttachment(20, 10, 1, 4);
		System.out.println("Final graph: " + g);

		System.setOut(new PrintStream("data/test.csv"));
		System.out.println(Graph.makeCommaSeparated(g));

		System.setOut(console);
		Graph h = wattsStrogatz(20, 5, 0.2);
		System.out.println(Graph.makeCommaSeparated(h));
	}


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
		seed = Random.getSeed();
	}

	// Tests the generator methods
	@SuppressWarnings("unused")
	private static void testGenerator() {
		Out.setOut(Out.out);

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
		Out.println();
		Out.println("Generating random graphs on " + numVertices + " vertices and " + numEdges + " edges.");
		Out.println();

		// Generate and print each graph from the methods above to the standard output
		Out.println("Complete graph");
		Out.println(complete(numVertices));
		Out.println();

		Out.println("Simple");
		Out.println(simple(numVertices, numEdges));
		Out.println();

		Out.println("Erdős–Rényi");
		Out.println(erdosRenyi(numVertices, p));
		Out.println();

		Out.println("Complete bipartite");
		Out.println(completeBipartite(numVertices1, numVertices2));
		Out.println();

		Out.println("Bipartite");
		Out.println(bipartite(numVertices1, numVertices2, numEdges));
		Out.println();

		Out.println("Erdős–Rényi bipartite");
		Out.println(bipartite(numVertices1, numVertices2, q));
		Out.println();

		Out.println("Path");
		Out.println(path(numVertices));
		Out.println();

		Out.println("Cycle");
		Out.println(cycle(numVertices));
		Out.println();

		Out.println("Binary tree");
		Out.println(binaryTree(numVertices));
		Out.println();

		Out.println("Eulerian Cycle");
		Out.println(eulerianCycle(numVertices, numEdges));
		Out.println();

		Out.println("Eulerian Path ");
		Out.println(eulerianPath(numVertices, numEdges));
		Out.println();

		Out.println("Tree");
		Out.println(tree(numVertices));
		Out.println();

		Out.println("4-Regular");
		Out.println(regular(numVertices, 4));
		Out.println();

		Out.println("Star");
		Out.println(star(numVertices));
		Out.println();

		Out.println("Wheel");
		Out.println(wheel(numVertices));
		Out.println();
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
		       graphName.equalsIgnoreCase("Erdos Renyi") ||
		       graphName.equalsIgnoreCase("Watts-Strogatz") ||
		       graphName.equalsIgnoreCase("Watts Strogatz") ||
		       graphName.equalsIgnoreCase("Small World");
	}

	public static boolean requiresKToGenerate(String graphName) {
		return graphName.equalsIgnoreCase("Regular") ||
		       graphName.equalsIgnoreCase("k-Regular");
	}

	/**
	 * Asks the user to input (in the standard input) a number of vertices to generate a graph and returns it as an int
	 * value.
	 *
	 * @return the user input number of edges.
	 */
	public static int inputVertices() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		return s.nextInt();  // Return user input
	}

	/**
	 * Asks the user to input (in the standard input) a number of edges to generate a graph and returns it as an int
	 * value.
	 *
	 * @return the user input number of edges.
	 */
	public static int inputEdges() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of edges:");
		return s.nextInt(); // Return user input
	}

	// Generates a graph from the String graph type
	public Graph fromType(String graphName) {
		// Generate the graph corresponding to the supplied graph name
		return switch (graphName.toLowerCase()) {
			case "complete" -> complete(Driver.NUM_VERTICES);
			case "tree" -> tree(Driver.NUM_VERTICES);
			case "binary-tree", "binary tree" -> binaryTree(Driver.NUM_VERTICES);
			case "path" -> path(Driver.NUM_VERTICES);
			case "cycle" -> cycle(Driver.NUM_VERTICES);
			case "star" -> star(Driver.NUM_VERTICES);
			case "wheel" -> wheel(Driver.NUM_VERTICES);
			case "erdős–rényi", "erdos-renyi", "erdos renyi" -> erdosRenyi(Driver.NUM_VERTICES, ModelEngine.P);
			case "erdős–rényi bipartite", "erdos-renyi bipartite", "erdos renyi bipartite" -> bipartite(Driver.NUM_VERTICES_1, Driver.NUM_VERTICES_2, ModelEngine.P);
			case "complete-bipartite", "complete bipartite" -> completeBipartite(Driver.NUM_VERTICES_1, Driver.NUM_VERTICES_2);
			case "regular", "k-regular" -> regular(Driver.NUM_VERTICES, ModelEngine.K);
			case "simple" -> simple(Driver.NUM_VERTICES, ModelEngine.NUM_EDGES);
			case "bipartite" -> bipartite(Driver.NUM_VERTICES_1, Driver.NUM_VERTICES_2, ModelEngine.NUM_EDGES);
			case "eulerian-path", "eulerian path" -> eulerianPath(Driver.NUM_VERTICES, ModelEngine.NUM_EDGES);
			case "eulerian-cycle", "eulerian cycle" -> eulerianCycle(Driver.NUM_VERTICES, ModelEngine.NUM_EDGES);
			case "preferential attachment", "barabási–albert" -> preferentialAttachment(Driver.NUM_VERTICES, Driver.INITIAL_NUM_VERTICES, Driver.OFFSET_EXP, ModelEngine.MIN_DEGREE);
			case "watts-strogatz", "watts strogatz" -> wattsStrogatz(Driver.NUM_VERTICES, ModelEngine.WS_K, ModelEngine.P);
			default -> throw new IllegalStateException("Unexpected value: " + graphName);
		};
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
