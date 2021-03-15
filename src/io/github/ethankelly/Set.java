package io.github.ethankelly;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

/**
 * The {@code Set} class represents an ordered set of comparable keys. It supports the usual <em>add</em>,
 * <em>contains</em> and <em>delete</em> methods. It also provides ordered methods for finding the
 * <em>minimum</em>,
 * <em>maximum</em>, <em>floor</em> and <em>ceiling</em> and set methods for <em>union</em>, <em>intersection</em>
 * and
 * <em>equality</em>.
 * <p>
 * Even though this implementation includes the method {@code equals()}, it does not support the method {@code
 * hashCode()} because sets are mutable.
 * <p>
 * This implementation uses a balanced binary search tree. It requires that the key type implements the {@code
 * Comparable} interface and calls the {@code compareTo()} and method to compare two keys. It does not call either
 * {@code equals()} or {@code hashCode()}. The <em>add</em>, <em>contains</em>, <em>delete</em>, <em>minimum</em>,
 * <em>maximum</em>, <em>ceiling</em>, and <em>floor</em> methods take
 * logarithmic time in the worst case. The <em>size</em>, and <em>is-empty</em> operations take constant time.
 * Construction takes constant time.
 * <p>
 *
 * @param <Key> the generic type of a key in this set
 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
 */
@SuppressWarnings("rawtypes")
public class Set<Key extends Comparable<Key>> implements Iterable<Key> {
	private final TreeSet<Key> set;

	/**
	 * Initialises an empty set.
	 */
	public Set() {
		set = new TreeSet<>();
	}

	/**
	 * Initialises a new set that is an independent copy of the specified set.
	 *
	 * @param x the set to copy.
	 */
	public Set(Set<Key> x) {
		set = new TreeSet<>(x.set);
	}

	/**
	 * Unit tests the {@code SET} data type.
	 *
	 * @param args the command-line arguments.
	 */
	public static void main(String[] args) {
		Set<String> set = new Set<>();
		Std.StdOut.println("set = " + set);

		// insert some keys
		set.add("www.cs.princeton.edu");
		set.add("www.cs.princeton.edu");    // overwrite old value
		set.add("www.princeton.edu");
		set.add("www.math.princeton.edu");
		set.add("www.yale.edu");
		set.add("www.amazon.com");
		set.add("www.simpsons.com");
		set.add("www.stanford.edu");
		set.add("www.google.com");
		set.add("www.ibm.com");
		set.add("www.apple.com");
		set.add("www.slashdot.com");
		set.add("www.whitehouse.gov");
		set.add("www.espn.com");
		set.add("www.snopes.com");
		set.add("www.movies.com");
		set.add("www.cnn.com");
		set.add("www.iitb.ac.in");


		Std.StdOut.println(set.contains("www.cs.princeton.edu"));
		Std.StdOut.println(!set.contains("www.harvardsucks.com"));
		Std.StdOut.println(set.contains("www.simpsons.com"));
		Std.StdOut.println();

		Std.StdOut.println("ceiling(www.simpsonr.com) = " + set.ceiling("www.simpsonr.com"));
		Std.StdOut.println("ceiling(www.simpsons.com) = " + set.ceiling("www.simpsons.com"));
		Std.StdOut.println("ceiling(www.simpsont.com) = " + set.ceiling("www.simpsont.com"));
		Std.StdOut.println("floor(www.simpsonr.com)   = " + set.floor("www.simpsonr.com"));
		Std.StdOut.println("floor(www.simpsons.com)   = " + set.floor("www.simpsons.com"));
		Std.StdOut.println("floor(www.simpsont.com)   = " + set.floor("www.simpsont.com"));
		Std.StdOut.println();

		Std.StdOut.println("set = " + set);
		Std.StdOut.println();

		// print out all keys in this set in lexicographic order
		for (String s : set) {
			Std.StdOut.println(s);
		}

		Std.StdOut.println();
		Set<String> set2 = new Set<>(set);
		Std.StdOut.println(set.equals(set2));
	}

	/**
	 * Adds the key to this set (if it is not already present).
	 *
	 * @param key the key to add.
	 * @throws IllegalArgumentException if {@code key} is {@code null}.
	 */
	public void add(Key key) {
		if (key == null) throw new IllegalArgumentException("called add() with a null key");
		set.add(key);
	}

	/**
	 * Returns true if this set contains the given key.
	 *
	 * @param key the key.
	 * @return {@code true} if this set contains {@code key}; {@code false} otherwise.
	 * @throws IllegalArgumentException if {@code key} is {@code null}.
	 */
	public boolean contains(Key key) {
		if (key == null) throw new IllegalArgumentException("called contains() with a null key");
		return set.contains(key);
	}

	/**
	 * Removes the specified key from this set (if the set contains the specified key). This is equivalent to {@code
	 * remove()}, but we plan to deprecate {@code delete()}.
	 *
	 * @param key the key.
	 * @throws IllegalArgumentException if {@code key} is {@code null}.
	 */
	public void delete(Key key) {
		if (key == null) throw new IllegalArgumentException("called delete() with a null key");
		set.remove(key);
	}

	/**
	 * Removes the specified key from this set (if the set contains the specified key). This is equivalent to {@code
	 * delete()}, but we plan to deprecate {@code delete()}.
	 *
	 * @param key the key.
	 * @throws IllegalArgumentException if {@code key} is {@code null}.
	 */
	public void remove(Key key) {
		if (key == null) throw new IllegalArgumentException("called remove() with a null key");
		set.remove(key);
	}

	/**
	 * @return the number of keys in this set.
	 */
	public int size() {
		return set.size();
	}

	/**
	 * @return {@code true} if this set is empty; {@code false} otherwise.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Returns all of the keys in this set, as an iterator. To iterate over all of the keys in a set named {@code set},
	 * use the foreach notation: {@code for (Key key : set)}.
	 *
	 * @return an iterator to all of the keys in this set.
	 */
	public @NotNull Iterator<Key> iterator() {
		return set.iterator();
	}

	/**
	 * Returns the largest key in this set.
	 *
	 * @return the largest key in this set.
	 * @throws NoSuchElementException if this set is empty.
	 */
	public Key max() {
		if (isEmpty()) throw new NoSuchElementException("called max() with empty set");
		return set.last();
	}

	/**
	 * Returns the smallest key in this set.
	 *
	 * @return the smallest key in this set.
	 * @throws NoSuchElementException if this set is empty.
	 */
	public Key min() {
		if (isEmpty()) throw new NoSuchElementException("called min() with empty set");
		return set.first();
	}

	/**
	 * Returns the smallest key in this set greater than or equal to {@code key}.
	 *
	 * @param key the key.
	 * @return the smallest key in this set greater than or equal to {@code key}.
	 * @throws IllegalArgumentException if {@code key} is {@code null}.
	 * @throws NoSuchElementException   if there is no such key.
	 */
	public Key ceiling(Key key) {
		if (key == null) throw new IllegalArgumentException("called ceiling() with a null key");
		Key k = set.ceiling(key);
		if (k == null) throw new NoSuchElementException("all keys are less than " + key);
		return k;
	}

	/**
	 * Returns the largest key in this set less than or equal to {@code key}.
	 *
	 * @param key the key.
	 * @return the largest key in this set table less than or equal to {@code key}.
	 * @throws IllegalArgumentException if {@code key} is {@code null}.
	 * @throws NoSuchElementException   if there is no such key.
	 */
	public Key floor(Key key) {
		if (key == null) throw new IllegalArgumentException("called floor() with a null key");
		Key k = set.floor(key);
		if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
		return k;
	}

	/**
	 * Returns the union of this set and that set.
	 *
	 * @param that the other set.
	 * @return the union of this set and that set.
	 * @throws IllegalArgumentException if {@code that} is {@code null}.
	 */
	public Set<Key> union(Set<Key> that) {
		if (that == null) throw new IllegalArgumentException("called union() with a null argument");
		Set<Key> c = new Set<>();
		for (Key x : this) {
			c.add(x);
		}
		for (Key x : that) {
			c.add(x);
		}
		return c;
	}

	/**
	 * Returns the intersection of this set and that set.
	 *
	 * @param that the other set.
	 * @return the intersection of this set and that set.
	 * @throws IllegalArgumentException if {@code that} is {@code null}.
	 */
	public Set<Key> intersects(Set<Key> that) {
		if (that == null) throw new IllegalArgumentException("called intersects() with a null argument");
		Set<Key> c = new Set<>();
		if (this.size() < that.size()) {
			for (Key x : this) {
				if (that.contains(x)) c.add(x);
			}
		} else {
			for (Key x : that) {
				if (this.contains(x)) c.add(x);
			}
		}
		return c;
	}

	/**
	 * Compares this set to the specified set. Note that this method declares two empty sets to be equal even if they
	 * are parameterized by different generic types. This is consistent with the behavior of {@code equals()} within
	 * Java's Collections framework.
	 *
	 * @param other the other set.
	 * @return {@code true} if this set equals {@code other}; {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object other) {
		if (other == this) return true;
		if (other == null) return false;
		if (other.getClass() != this.getClass()) return false;
		Set that = (Set) other;
		return this.set.equals(that.set);
	}

	/**
	 * This operation is not supported because sets are mutable.
	 *
	 * @return does not return a value.
	 * @throws UnsupportedOperationException if called.
	 */
	@Override
	public int hashCode() {
		throw new UnsupportedOperationException("hashCode() is not supported because sets are mutable");
	}

	/**
	 * Returns a string representation of this set.
	 *
	 * @return a string representation of this set, enclosed in curly braces, with adjacent keys separated by a comma
	 * and a space.
	 */
	@Override
	public String toString() {
		String s = set.toString();
		return "{" + s.substring(1, s.length() - 1) + "}";
	}

	/**
	 * The {@code MinPriorityQueue} class represents a priority queue of generic keys. It provides the usual
	 * <em>insert</em> and <em>delete the minimum</em> operations as well as methods for peeking at the minimum key,
	 * testing if the priority queue is empty and iterating through all keys.
	 * <p>
	 * This implementation uses a <em>binary heap</em>. The insert and delete the minimum operations take &Theta;(log
	 * <em>n</em>) amortized time, where <em>n</em> is the number of elements in the priority queue. This is an
	 * amortized bound (not a worst-case bound) because of array resizing operations. The <em>min</em>, <em>size</em>,
	 * and <em>is empty</em> operations take &Theta;(1) time in the worst case. Construction takes time proportional to
	 * the specified capacity or the number of items used to initialize the data structure.
	 * <p>
	 *
	 * @param <Key> the generic type of key on the priority queue.
	 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
	 */
	public static class MinPriorityQueue<Key> implements Iterable<Key> {
		private Key[] pq;                    // Store items at indices 1 to n
		private int n;                       // Number of items on priority queue
		private Comparator<Key> comparator;  // (Optional) comparator

		/**
		 * Initialises an empty priority queue with some specified initial capacity.
		 *
		 * @param initCapacity the initial capacity of this priority queue.
		 */
		@SuppressWarnings("unchecked")
		public MinPriorityQueue(int initCapacity) {
			pq = (Key[]) new Object[initCapacity + 1];
			n = 0;
		}

		/**
		 * Initialises an empty priority queue.
		 */
		public MinPriorityQueue() {
			this(1);
		}

		/**
		 * Initialises an empty priority queue with the given initial capacity using the given comparator.
		 *
		 * @param initCapacity the initial capacity of this priority queue.
		 * @param comparator   the order in which to compare the keys.
		 */
		@SuppressWarnings("unchecked")
		public MinPriorityQueue(int initCapacity, Comparator<Key> comparator) {
			this.comparator = comparator;
			pq = (Key[]) new Object[initCapacity + 1];
			n = 0;
		}

		/**
		 * Initialises an empty priority queue using the given comparator.
		 *
		 * @param comparator the order in which to compare the keys
		 */
		public MinPriorityQueue(Comparator<Key> comparator) {
			this(1, comparator);
		}

		/**
		 * Initialises a priority queue from the array of keys. This takes time proportional to the number of keys,
		 * using sink-based heap construction.
		 *
		 * @param keys the array of keys.
		 */
		@SuppressWarnings("unchecked")
		public MinPriorityQueue(Key[] keys) {
			n = keys.length;
			pq = (Key[]) new Object[keys.length + 1];
			System.arraycopy(keys, 0, pq, 1, n);
			for (int k = n / 2; k >= 1; k--)
				sink(k);
			assert isMinHeap();
		}

		/**
		 * Unit tests the {@code MinPQ} data type.
		 *
		 * @param args the command-line arguments
		 */
		public static void main(String[] args) {
			MinPriorityQueue<Integer> pq = new MinPriorityQueue<>();
			int[] toAdd = new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21};
			for (int i : toAdd) pq.insert(i);
			Std.StdOut.print(pq.delMin() + " ");
			Std.StdOut.println("(" + pq.size() + " left on pq)");
		}

		/**
		 * @return {@code false} if this priority queue is empty, {@code true} otherwise
		 */
		public boolean checkNotEmpty() {
			return n != 0;
		}

		/**
		 * @return the number of keys on this priority queue
		 */
		public int size() {
			return n;
		}

		/**
		 * @return a smallest key on this priority queue
		 * @throws AssertionError if this priority queue is empty
		 */
		public Key min() {
			assert checkNotEmpty() : "Priority queue underflow";
			return pq[1];
		}

		/**
		 * Resizes the underlying array to the given capacity.
		 *
		 * @param capacity the new dimension for the underlying array to take.
		 */
		@SuppressWarnings("unchecked")
		private void resize(int capacity) {
			assert capacity > n;
			Key[] temp = (Key[]) new Object[capacity];
			if (n >= 0) System.arraycopy(pq, 1, temp, 1, n);
			pq = temp;
		}

		/**
		 * Adds a new key to this priority queue.
		 *
		 * @param x the key to add to this priority queue
		 */
		public void insert(Key x) {
			// double size of array if necessary
			if (n == pq.length - 1) resize(2 * pq.length);

			// add x, and percolate it up to maintain heap invariant
			pq[++n] = x;
			swim(n);
			assert isMinHeap();
		}

		/**
		 * Removes and returns the smallest key on this priority queue, which may not be unique.
		 *
		 * @return the smallest key on this priority queue
		 * @throws AssertionError if this priority queue is empty
		 */
		public Key delMin() {
			assert checkNotEmpty() : "Priority queue underflow";
			Key min = pq[1];
			each(1, n--);
			sink(1);
			pq[n + 1] = null;     // to avoid loitering and help with garbage collection
			if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
			assert isMinHeap();
			return min;
		}

		/***************************************************************************
		 * Helper functions to restore the heap invariant.
		 ***************************************************************************/

		private void swim(int k) {
			while (k > 1 && greater(k / 2, k)) {
				each(k, k / 2);
				k = k / 2;
			}
		}

		///////////////////////////////////////////////////////////////////////////
		//  HELPER FUNCTIONS FOR COMPARES AND SWAPS.                             //
		///////////////////////////////////////////////////////////////////////////

		private void sink(int k) {
			while (2 * k <= n) {
				int j = 2 * k;
				if (j < n && greater(j, j + 1)) j++;
				if (!greater(k, j)) break;
				each(k, j);
				k = j;
			}
		}

		@SuppressWarnings("unchecked")
		private boolean greater(int i, int j) {
			if (comparator == null) {
				return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
			} else {
				return comparator.compare(pq[i], pq[j]) > 0;
			}
		}

		private void each(int i, int j) {
			Key swap = pq[i];
			pq[i] = pq[j];
			pq[j] = swap;
		}

		// Is pq[1..n] a min heap?
		private boolean isMinHeap() {
			for (int i = 1; i <= n; i++) {
				if (pq[i] == null) return false;
			}
			for (int i = n + 1; i < pq.length; i++) {
				if (pq[i] != null) return false;
			}
			if (pq[0] != null) return false;
			return isMinHeapOrdered(1);
		}

		// Is subtree of pq[1..n] rooted at k a min heap?
		private boolean isMinHeapOrdered(int k) {
			if (k > n) return true;
			int left = 2 * k;
			int right = 2 * k + 1;
			if (left <= n && greater(k, left)) return false;
			if (right <= n && greater(k, right)) return false;
			return isMinHeapOrdered(left) && isMinHeapOrdered(right);
		}

		/**
		 * @return an iterator that iterates over the keys in ascending order
		 */
		public @NotNull Iterator<Key> iterator() {
			return new HeapIterator();
		}

		private class HeapIterator implements Iterator<Key> {
			// Create a new pq
			private final MinPriorityQueue<Key> copy;

			// Add all items to copy of heap,
			// takes linear time (since already in heap order) so no keys move
			public HeapIterator() {
				if (comparator == null) copy = new MinPriorityQueue<>(size());
				else copy = new MinPriorityQueue<>(size(), comparator);
				for (int i = 1; i <= n; i++)
					copy.insert(pq[i]);
			}

			public boolean hasNext() {
				return copy.checkNotEmpty();
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

			public Key next() {
				if (!hasNext()) throw new NoSuchElementException();
				return copy.delMin();
			}
		}

	}
}
