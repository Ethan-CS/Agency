package io.github.ethankelly;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * The {@code Std} class contains several inner classes that are used for standard Java operations. These classes are
 * necessary so that the standard functionality can be directly adjusted and amended for the purposes of the current
 * project.
 */
@SuppressWarnings("ALL")
public class Std {
	/**
	 * The {@code StdIn} class provides static methods for reading strings and numbers from standard input. These
	 * functions fall into one of four categories:
	 * <ul>
	 *      <li> Reading individual tokens from standard input, one at a time and converting each to a number, string, or
	 *           boolean;
	 *      <li> Reading characters from standard input, one at a time;
	 *      <li> Reading lines from standard input, one at a time; and
	 *      <li> Reading a sequence of values of the same type from standard input and returning the values in an array
	 * </ul>
	 *
	 * <b> Reading tokens from standard input and converting to numbers and strings. </b>
	 * We can use the following methods to read numbers, strings, and booleans from standard input one at a time:
	 * <ul>
	 *      <li> {@link #isEmpty()}
	 *      <li> {@link #readInt()}
	 *      <li> {@link #readDouble()}
	 *      <li> {@link #readString()}
	 *      <li> {@link #readShort()}
	 *      <li> {@link #readLong()}
	 *      <li> {@link #readFloat()}
	 *      <li> {@link #readByte()}
	 *      <li> {@link #readBoolean()}
	 * </ul>
	 * <p>
	 * The first method returns true if standard input has no more tokens. The other methods skip over any whitespace in the
	 * input. It then reads the next token and attempts to convert it into a value of the specified type. If it succeeds, it
	 * returns that value; otherwise, it throws an {@link InputMismatchException}.
	 *
	 * <em>Whitespace</em> includes spaces, tabs, and newlines; the full definition is inherited from
	 * {@link Character#isWhitespace(char)}. A <em>token</em> is a maximal sequence of non-whitespace characters. The
	 * precise rules for describing which tokens can be converted to integers and floating-point numbers are inherited from
	 * <a href = "http://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html#number-syntax">Scanner</a>, using the
	 * locale {@link Locale#UK}; the rules for floating-point numbers are slightly different from those in
	 * {@link Double#valueOf(String)}, but unlikely to be of concern.
	 * <p>
	 * As an example, the following code fragment reads integers from standard input, one at a time, and prints them one per
	 * line.
	 * <pre>
	 * while (!StdIn.isEmpty()) {
	 *     double value = StdIn.readDouble();
	 *     StdOut.println(value);
	 * }
	 * </pre>
	 *
	 * <b>Reading characters from standard input.</b>
	 * You can use the following two methods to read characters from standard input one at a time:
	 * <ul>
	 *      <li> {@link #hasNextChar()}
	 *      <li> {@link #readChar()}
	 * </ul>
	 * <p>
	 * The first method returns true if standard input has more input (including whitespace). The second method reads and
	 * returns the next character of input on standard input (possibly a whitespace character).
	 * <p>
	 * As an example, the following code fragment reads characters from standard input, one character at a time, and prints
	 * it to standard output.
	 * <pre>
	 * while (StdIn.hasNextChar()) {
	 *     char c = StdIn.readChar();
	 *     StdOut.print(c);
	 * }
	 * </pre>
	 *
	 * <b>Reading lines from standard input.</b>
	 * You can use the following two methods to read lines from standard input:
	 * <ul>
	 *      <li> {@link #hasNextLine()}
	 *      <li> {@link #readLine()}
	 * </ul>
	 * <p>
	 * The first method returns true if standard input has more input (including whitespace). The second method reads and
	 * returns the remaining portion of the next line of input on standard input (possibly whitespace), discarding the
	 * trailing line separator.
	 * <p>
	 * A <em>line separator</em> is defined to be one of the following strings:
	 * {@code \n} (Linux), {@code \r} (old Macintosh),
	 * {@code \r\n} (Windows),
	 * {@code \}{@code u2028}, {@code \}{@code u2029}, or {@code \}{@code u0085}.
	 * <p>
	 * As an example, the following code fragment reads text from standard input, one line at a time, and prints it to
	 * standard output.
	 * <pre>
	 * while (StdIn.hasNextLine()) {
	 *     String line = StdIn.readLine();
	 *     StdOut.println(line);
	 * }
	 * </pre>
	 *
	 * <b>Reading a sequence of values of the same type from standard input.</b>
	 * You can use the following methods to read a sequence numbers, strings, or booleans (all of the same type) from
	 * standard input:
	 * <ul>
	 *      <li> {@link #readAllDoubles()}
	 *      <li> {@link #readAllInts()}
	 *      <li> {@link #readAllLongs()}
	 *      <li> {@link #readAllStrings()}
	 *      <li> {@link #readAllLines()}
	 *      <li> {@link #readAll()}
	 * </ul>
	 * <p>
	 * The first three methods read of all of remaining token on standard input and converts the tokens to values of the
	 * specified type, as in the corresponding {@code readDouble}, {@code readInt}, and {@code readString()} methods. The
	 * {@code readAllLines()} method reads all remaining lines on standard input and returns them as an array of strings.
	 * The {@code readAll()} method reads all remaining input on standard input and returns it as a string.
	 * <p>
	 * As an example, the following code fragment reads all of the remaining tokens from standard input and returns them as
	 * an array of strings.
	 * <pre>
	 * String[] words = StdIn.readAllStrings();
	 * </pre>
	 *
	 * <b>Differences with Scanner.</b>
	 * {@code StdIn} and {@link Scanner} are both designed to parse tokens and convert them to primitive types and strings.
	 * The main differences are summarized below:
	 * <ul>
	 *      <li> {@code StdIn} is a set of static methods and reads reads input from only standard input. It is suitable for
	 *      use before a programmer knows about objects.
	 *      <li> {@code StdIn} uses whitespace as the delimiter pattern that separates tokens. {@link Scanner} supports
	 *      arbitrary delimiter patterns.
	 *      <li> {@code StdIn} coerces the character-set encoding to UTF-8, which is the most widely used character encoding
	 *      for Unicode.
	 *      <li> {@code StdIn} coerces the locale to {@link Locale#UK}, for consistency with {@link StdOut},
	 *      {@link Double#parseDouble(String)} and floating-point literals.
	 *      <li> {@code StdIn} has convenient methods for reading a single character; reading in sequences of integers,
	 *      doubles, or strings; and reading in all of the remaining input.
	 * </ul>
	 *
	 * <b>Using standard input.</b>
	 * Standard input is a fundamental operating system abstraction. The methods in {@code StdIn} are <em>blocking</em>,
	 * meaning they will wait until the user enters an input on standard input. If the program has a loop that repeats until
	 * the standard input is empty, the user must signal that the input is finished. To do this, depending on your operating
	 * system and IDE, use either {@code <Ctrl/Cmd+d>} or {@code <Ctrl/Cmd+z>} on its own line. If we want to redirect the
	 * standard input from a file, we won't need to do anything to signal that the input is finished.
	 *
	 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
	 */
	@SuppressWarnings("unused")
	public static final class StdIn {
		// Unicode UTF-8 encoding
		private static final String CHARSET_NAME = "UTF-8";
		// Language:  English UK
		private static final Locale LOCALE = Locale.UK;
		// The default token separator; we maintain the invariant that this value
		// is held by the scanner's delimiter between calls
		private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
		// Makes whitespace significant
		private static final Pattern EMPTY_PATTERN = Pattern.compile("");
		// Used to read the entire input
		private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
		// Scanner object
		private static Scanner scanner;

		// Do this once when StdIn is initialized
		static {
			reSync();
		}

		// Doesn't make sense to instantiate this class
		private StdIn() {
		}

		/**
		 * Returns true if standard input is empty (except for whitespace). Use this method to know whether the next
		 * call to {@link #readString()}, {@link #readDouble()}, and so on will succeed.
		 *
		 * @return {@code true} if standard input is empty (except possibly for whitespace); {@code false} otherwise.
		 */
		public static boolean isEmpty() {
			return !scanner.hasNext();
		}

		/**
		 * Returns true if standard input has a next line. We use this method to know whether the next call to {@link
		 * #readLine()} will succeed. This method is functionally equivalent to {@link #hasNextChar()}.
		 *
		 * @return {@code true} if standard input has more input (including whitespace); {@code false} otherwise.
		 */
		public static boolean hasNextLine() {
			return scanner.hasNextLine();
		}

		/**
		 * Returns true if standard input has more input (including whitespace). Use this method to know whether the
		 * next call to {@link #readChar()} will succeed. This method is functionally equivalent to {@link
		 * #hasNextLine()}.
		 *
		 * @return {@code true} if standard input has more input (including whitespace); {@code false} otherwise.
		 */
		public static boolean hasNextChar() {
			scanner.useDelimiter(EMPTY_PATTERN);
			boolean result = scanner.hasNext();
			scanner.useDelimiter(WHITESPACE_PATTERN);
			return result;
		}

		/**
		 * Reads and returns the next line, excluding the line separator if present.
		 *
		 * @return the next line, excluding the line separator if present; {@code null} if no such line.
		 */
		public static String readLine() {
			String line;
			try {
				line = scanner.nextLine();
			} catch (NoSuchElementException e) {
				line = null;
			}
			return line;
		}

		/**
		 * Reads and returns the next character.
		 *
		 * @return the next {@code char}.
		 * @throws NoSuchElementException if standard input is empty.
		 */
		public static char readChar() throws NoSuchElementException {
			try {
				scanner.useDelimiter(EMPTY_PATTERN);
				String ch = scanner.next();
				assert ch.length() == 1 : "Internal (Std)In.readChar() error!"
				                          + " Please contact the author.";
				scanner.useDelimiter(WHITESPACE_PATTERN);
				return ch.charAt(0);
			} catch (NoSuchElementException e) {
				throw new NoSuchElementException("Attempts to read a 'char' value from standard input, "
				                                 + "but no more tokens are available");
			}
		}

		/**
		 * Reads and returns the remainder of the input as a string.
		 *
		 * @return the remainder of the input as a string.
		 * @throws NoSuchElementException if standard input is empty.
		 */
		public static String readAll() throws NoSuchElementException {
			if (!scanner.hasNextLine())
				return "";
			String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
			// Not that important to reset delimiter, since now scanner is empty
			scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway
			return result;
		}

		/**
		 * Reads the next token and returns the {@code String}.
		 *
		 * @return the next {@code String}.
		 * @throws NoSuchElementException if standard input is empty.
		 */
		public static String readString() throws NoSuchElementException {
			try {
				return scanner.next();
			} catch (NoSuchElementException e) {
				throw new NoSuchElementException("attempts to read a 'String' value from standard input, "
				                                 + "but no more tokens are available");
			}
		}

		/**
		 * Reads the next token from standard input, parses it as an integer and returns the integer.
		 *
		 * @return the next integer on standard input.
		 * @throws InputMismatchException if the next token cannot be parsed as an {@code int}.
		 * @throws NoSuchElementException if standard input is empty.
		 */
		public static int readInt() throws InputMismatchException, NoSuchElementException {
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				String token = scanner.next();
				throw new InputMismatchException("attempts to read an 'int' value from standard input, "
				                                 + "but the next token is \"" + token + "\"");
			} catch (NoSuchElementException e) {
				throw new NoSuchElementException("attempts to read an 'int' value from standard input, "
				                                 + "but no more tokens are available");
			}
		}

		/**
		 * Reads the next token from standard input, parses it as a double and returns the double.
		 *
		 * @return the next double on standard input.
		 * @throws InputMismatchException if the next token cannot be parsed as a {@code double}.
		 * @throws NoSuchElementException if standard input is empty.
		 */
		public static double readDouble() throws InputMismatchException, NoSuchElementException {
			try {
				return scanner.nextDouble();
			} catch (InputMismatchException e) {
				String token = scanner.next();
				throw new InputMismatchException("attempts to read a 'double' value from standard input, "
				                                 + "but the next token is \"" + token + "\"");
			} catch (NoSuchElementException e) {
				throw new NoSuchElementException("attempts to read a 'double' value from standard input, "
				                                 + "but no more tokens are available");
			}
		}

		/**
		 * Reads the next token from standard input, parses it as a float and returns the float.
		 *
		 * @return the next float on standard input.
		 * @throws InputMismatchException if the next token cannot be parsed as a {@code float}.
		 * @throws NoSuchElementException if standard input is empty.
		 */
		public static float readFloat() throws InputMismatchException, NoSuchElementException {
			try {
				return scanner.nextFloat();
			} catch (InputMismatchException e) {
				String token = scanner.next();
				throw new InputMismatchException("attempts to read a 'float' value from standard input, "
				                                 + "but the next token is \"" + token + "\"");
			} catch (NoSuchElementException e) {
				throw new NoSuchElementException("attempts to read a 'float' value from standard input, "
				                                 + "but there no more tokens are available");
			}
		}

		/**
		 * Reads the next token from standard input, parses it as a long integer and returns the long integer.
		 *
		 * @return the next long integer on standard input.
		 * @throws InputMismatchException if the next token cannot be parsed as a {@code long}.
		 * @throws NoSuchElementException if standard input is empty.
		 */
		public static long readLong() throws InputMismatchException, NoSuchElementException {
			try {
				return scanner.nextLong();
			} catch (InputMismatchException e) {
				String token = scanner.next();
				throw new InputMismatchException("attempts to read a 'long' value from standard input, "
				                                 + "but the next token is \"" + token + "\"");
			} catch (NoSuchElementException e) {
				throw new NoSuchElementException("attempts to read a 'long' value from standard input, "
				                                 + "but no more tokens are available");
			}
		}

		/**
		 * Reads the next token from standard input, parses it as a short integer and returns the short integer.
		 *
		 * @return the next short integer on standard input.
		 * @throws InputMismatchException if the next token cannot be parsed as a {@code short}.
		 * @throws NoSuchElementException if standard input is empty.
		 */
		public static short readShort() throws InputMismatchException, NoSuchElementException {
			try {
				return scanner.nextShort();
			} catch (InputMismatchException e) {
				String token = scanner.next();
				throw new InputMismatchException("attempts to read a 'short' value from standard input, "
				                                 + "but the next token is \"" + token + "\"");
			} catch (NoSuchElementException e) {
				throw new NoSuchElementException("attempts to read a 'short' value from standard input, "
				                                 + "but no more tokens are available");
			}
		}

		/**
		 * Reads the next token from standard input, parses it as a byte, and returns the byte.
		 *
		 * @return the next byte on standard input.
		 * @throws InputMismatchException if the next token cannot be parsed as a {@code byte}
		 * @throws NoSuchElementException if standard input is empty
		 */
		public static byte readByte() throws InputMismatchException, NoSuchElementException {
			try {
				return scanner.nextByte();
			} catch (InputMismatchException e) {
				String token = scanner.next();
				throw new InputMismatchException("attempts to read a 'byte' value from standard input, "
				                                 + "but the next token is \"" + token + "\"");
			} catch (NoSuchElementException e) {
				throw new NoSuchElementException("attempts to read a 'byte' value from standard input, "
				                                 + "but no more tokens are available");
			}
		}

		/**
		 * Reads the next token from standard input, parses it as a boolean, and returns the boolean.
		 *
		 * @return the next boolean on standard input
		 * @throws InputMismatchException if the next token cannot be parsed as a {@code boolean}: {@code true} or
		 *                                {@code 1} for true, and {@code false} or {@code 0} for false, ignoring case
		 * @throws NoSuchElementException if standard input is empty
		 */
		public static boolean readBoolean() throws InputMismatchException, NoSuchElementException {
			try {
				String token = readString();
				if ("true".equalsIgnoreCase(token)) return true;
				if ("false".equalsIgnoreCase(token)) return false;
				if ("1".equals(token)) return true;
				if ("0".equals(token)) return false;
				throw new InputMismatchException("attempts to read a 'boolean' value from standard input, "
				                                 + "but the next token is \"" + token + "\"");
			} catch (NoSuchElementException e) {
				throw new NoSuchElementException("attempts to read a 'boolean' value from standard input, "
				                                 + "but no more tokens are available");
			}

		}

		/**
		 * Reads all remaining tokens from standard input and returns them as an array of strings.
		 *
		 * @return all remaining tokens on standard input, as an array of strings.
		 */
		public static String[] readAllStrings() {
			// we could use readAll.trim().split(), but that's not consistent
			// because trim() uses characters 0x00..0x20 as whitespace
			String[] tokens = WHITESPACE_PATTERN.split(readAll());
			if (tokens.length == 0 || tokens[0].length() > 0)
				return tokens;

			// don't include first token if it is leading whitespace
			String[] newTokens = new String[tokens.length - 1];
			System.arraycopy(tokens, 1, newTokens, 0, tokens.length - 1);
			return newTokens;
		}

		/**
		 * Reads all remaining lines from standard input and returns them as an array of strings.
		 *
		 * @return all remaining lines on standard input, as an array of strings.
		 */
		public static String[] readAllLines() {
			ArrayList<String> lines = new ArrayList<>();
			while (hasNextLine()) {
				lines.add(readLine());
			}
			return lines.toArray(new String[0]);
		}

		/**
		 * Reads all remaining tokens from standard input, parses them as integers and returns them as an array of
		 * integers.
		 *
		 * @return all remaining integers on standard input, as an array.
		 * @throws InputMismatchException if any token cannot be parsed as an {@code int}.
		 */
		public static int[] readAllInts() {
			String[] fields = readAllStrings();
			int[] values = new int[fields.length];
			for (int i = 0; i < fields.length; i++)
				values[i] = Integer.parseInt(fields[i]);
			return values;
		}

		/**
		 * Reads all remaining tokens from standard input, parses them as longs, and returns them as an array of longs.
		 *
		 * @return all remaining longs on standard input, as an array.
		 * @throws InputMismatchException if any token cannot be parsed as a {@code long}.
		 */
		public static long[] readAllLongs() {
			String[] fields = readAllStrings();
			long[] values = new long[fields.length];
			for (int i = 0; i < fields.length; i++)
				values[i] = Long.parseLong(fields[i]);
			return values;
		}

		/**
		 * Reads all remaining tokens from standard input, parses them as doubles, and returns them as an array of
		 * doubles.
		 *
		 * @return all remaining doubles on standard input, as an array.
		 * @throws InputMismatchException if any token cannot be parsed as a {@code double}.
		 */
		public static double[] readAllDoubles() {
			String[] fields = readAllStrings();
			double[] values = new double[fields.length];
			for (int i = 0; i < fields.length; i++)
				values[i] = Double.parseDouble(fields[i]);
			return values;
		}

		/**
		 * If StdIn changes, use this to reinitialize the scanner.
		 */
		private static void reSync() {
			setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
		}

		private static void setScanner(Scanner scanner) {
			StdIn.scanner = scanner;
			StdIn.scanner.useLocale(LOCALE);
		}

		/**
		 * Reads all remaining tokens, parses them as integers and returns them as an array of integers.
		 *
		 * @return all remaining integers, as an array.
		 * @throws InputMismatchException if any token cannot be parsed as an {@code int}.
		 * @deprecated Replaced by {@link #readAllInts()}.
		 */
		@Deprecated
		public static int[] readInts() {
			return readAllInts();
		}

		/**
		 * Reads all remaining tokens, parses them as doubles and returns them as an array of doubles.
		 *
		 * @return all remaining doubles, as an array.
		 * @throws InputMismatchException if any token cannot be parsed as a {@code double}.
		 * @deprecated Replaced by {@link #readAllDoubles()}.
		 */
		@Deprecated
		public static double[] readDoubles() {
			return readAllDoubles();
		}

		/**
		 * Reads all remaining tokens and returns them as an array of strings.
		 *
		 * @return all remaining tokens, as an array of strings.
		 * @deprecated Replaced by {@link #readAllStrings()}.
		 */
		@Deprecated
		public static String[] readStrings() {
			return readAllStrings();
		}


		/**
		 * Interactive test of basic functionality.
		 *
		 * @param args the command-line arguments
		 */
		public static void main(String[] args) {

			StdOut.print("Type a string: ");
			String s = StdIn.readString();
			StdOut.println("Your string was: " + s);
			StdOut.println();

			StdOut.print("Type an int: ");
			int a = StdIn.readInt();
			StdOut.println("Your int was: " + a);
			StdOut.println();

			StdOut.print("Type a boolean: ");
			boolean b = StdIn.readBoolean();
			StdOut.println("Your boolean was: " + b);
			StdOut.println();

			StdOut.print("Type a double: ");
			double c = StdIn.readDouble();
			StdOut.println("Your double was: " + c);
			StdOut.println();
		}
	}

	/**
	 * The {@code StdOut} class provides numerous methods for printing strings and numbers to standard output.
	 * <p>
	 * Here is an example program that uses {@code StdOut}:
	 * <pre>
	 *   public class TestStdOut {
	 *       public static void main(String[] args) {
	 *           int a = 17;
	 *           int b = 23;
	 *           int sum = a + b;
	 *           StdOut.println("Hello, World");
	 *           StdOut.printf("%d + %d = %d\n", a, b, sum);
	 *       }
	 *   }
	 *  </pre>
	 * <p>
	 * <b>Differences with System.out.</b>
	 * The behavior of {@code StdOut} is similar to that of {@link System#out}, but there are a few technical
	 * differences:
	 * <ul>
	 *      <li> {@code StdOut} coerces the character-set encoding to UTF-8, which is a standard character encoding for
	 *      Unicode.
	 *      <li> {@code StdOut} coerces the locale to {@link Locale#UK}, for consistency with {@link StdIn},
	 *      {@link Double#parseDouble(String)} and floating-point literals.
	 *      <li> {@code StdOut} <em>flushes</em> standard output after each call to {@code print()} so that text will appear
	 *      immediately in the terminal.
	 * </ul>
	 * <p>
	 *
	 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
	 */
	@SuppressWarnings("unused")
	public static final class StdOut {
		// Unicode UTF-8 encoding
		private static final String CHARSET_NAME = "UTF-8";
		// Language = English UK
		private static final Locale LOCALE = Locale.UK;
		/**
		 * The location to which we send the output.
		 */
		public static PrintWriter out;

		// This is called before invoking any methods
		static {
			try {
				// Replace with OutputStreamWriter to print to console
				out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME), true);
				// OSW throws UnsupportedEncodingException, File throws FileNotFound
			} catch (UnsupportedEncodingException e) {
				System.out.println("Unsupported encoding " + e);
			}
		}

		// Doesn't make sense to instantiate this class
		private StdOut() {
		}

		/**
		 * Reassigns the "standard" output stream.
		 *
		 * @param out the new standard output stream
		 */
		public static void setOut(PrintWriter out) {
			StdOut.out = out;
		}

		/**
		 * Terminates the current line by printing the line-separator string.
		 */
		public static void println() {
			out.println();
		}

		/**
		 * Prints an object to this output stream and terminates the line.
		 *
		 * @param x the object to print.
		 */
		public static void println(Object x) {
			out.println(x);
		}

		/**
		 * Prints a boolean to standard output and terminates the line.
		 *
		 * @param x the boolean to print.
		 */
		public static void println(boolean x) {
			out.println(x);
		}

		/**
		 * Prints a character to standard output and terminates the line.
		 *
		 * @param x the character to print.
		 */
		@SuppressWarnings("unused")
		public static void println(char x) {
			out.println(x);
		}

		/**
		 * Prints a double to standard output and terminates the line.
		 *
		 * @param x the double to print.
		 */
		public static void println(double x) {
			out.println(x);
		}

		/**
		 * Prints an integer to standard output and terminates the line.
		 *
		 * @param x the integer to print.
		 */
		public static void println(float x) {
			out.println(x);
		}

		/**
		 * Prints an integer to standard output and terminates the line.
		 *
		 * @param x the integer to print.
		 */
		public static void println(int x) {
			out.println(x);
		}

		/**
		 * Prints a long to standard output and terminates the line.
		 *
		 * @param x the long to print.
		 */
		public static void println(long x) {
			out.println(x);
		}

		/**
		 * Prints a short integer to standard output and terminates the line.
		 *
		 * @param x the short to print.
		 */
		public static void println(short x) {
			out.println(x);
		}

		/**
		 * Prints a byte to standard output and terminates the line.
		 *
		 * @param x the byte to print.
		 */
		public static void println(byte x) {
			out.println(x);
		}

		/**
		 * Flushes standard output.
		 */
		public static void print() {
			out.flush();
		}

		/**
		 * Prints an object to standard output and flushes standard output.
		 *
		 * @param x the object to print.
		 */
		public static void print(Object x) {
			out.print(x);
			out.flush();
		}

		/**
		 * Prints a boolean to standard output and flushes standard output.
		 *
		 * @param x the boolean to print.
		 */
		public static void print(boolean x) {
			out.print(x);
			out.flush();
		}

		/**
		 * Prints a character to standard output and flushes standard output.
		 *
		 * @param x the character to print.
		 */
		public static void print(char x) {
			out.print(x);
			out.flush();
		}

		/**
		 * Prints a double to standard output and flushes standard output.
		 *
		 * @param x the double to print.
		 */
		public static void print(double x) {
			out.print(x);
			out.flush();
		}

		/**
		 * Prints a float to standard output and flushes standard output.
		 *
		 * @param x the float to print.
		 */
		public static void print(float x) {
			out.print(x);
			out.flush();
		}

		/**
		 * Prints an integer to standard output and flushes standard output.
		 *
		 * @param x the integer to print.
		 */
		public static void print(int x) {
			out.print(x);
			out.flush();
		}

		/**
		 * Prints a long integer to standard output and flushes standard output.
		 *
		 * @param x the long integer to print.
		 */
		public static void print(long x) {
			out.print(x);
			out.flush();
		}

		/**
		 * Prints a short integer to standard output and flushes standard output.
		 *
		 * @param x the short integer to print.
		 */
		public static void print(short x) {
			out.print(x);
			out.flush();
		}

		/**
		 * Prints a byte to standard output and flushes standard output.
		 *
		 * @param x the byte to print.
		 */
		public static void print(byte x) {
			out.print(x);
			out.flush();
		}

		/**
		 * Prints a formatted string to standard output, using the specified format string and arguments and flushes
		 * standard output.
		 *
		 * @param format the <a href = "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format
		 *               string.</a>
		 * @param args   the arguments accompanying the format string.
		 */
		public static void printf(String format, Object... args) {
			out.printf(LOCALE, format, args);
			out.flush();
		}

		/**
		 * Prints a formatted string to standard output, using the locale and the specified format string and arguments;
		 * flushes standard output.
		 *
		 * @param locale the locale.
		 * @param format the <a href = "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format
		 *               string.</a>
		 * @param args   the arguments accompanying the format string.
		 */
		public static void printf(Locale locale, String format, Object... args) {
			out.printf(locale, format, args);
			out.flush();
		}

		/**
		 * When we are finished writing characters to the Java PrintWriter we generally need to close it. Closing a
		 * PrintWriter will also close the Writer instance to which the PrintWriter is writing. Closing a PrintWriter is
		 * done by calling its close() method. This method is used to do this.
		 */
		public static void close() {
			out.close();
		}

		/**
		 * Unit tests some of the methods in {@code StdOut}.
		 *
		 * @param args the command-line arguments
		 */
		public static void main(String[] args) {

			// write to stdout
			StdOut.println("Test");
			StdOut.println(17);
			StdOut.println(true);
			StdOut.printf("%.6f\n", 1.0 / 7.0);
		}

	}

	/**
	 * The {@code StdRandom} class provides static methods for generating pseudo-random numbers from various discrete
	 * and continuous distributions, including uniform, Bernoulli, geometric, Gaussian, exponential, Pareto, Poisson,
	 * and Cauchy. It also provides method for shuffling an array or sub-array and generating random permutations.
	 * <p>
	 * By convention, all intervals are half open. For example, <code>uniform(-1.0, 1.0)</code> returns a random number
	 * between <code>-1.0</code> (inclusive) and <code>1.0</code> (exclusive). Similarly, <code>shuffle(a, low,
	 * high)</code> shuffles the <code>high - low</code> elements in the array <code>a[]</code>, starting at index
	 * <code>low</code> (inclusive) and ending at index <code>high</code> (exclusive).
	 * <pre>
	 *  %  java StdRandom 5
	 *  seed = 1316600602069
	 *  59 16.81826  true 8.83954  0
	 *  32 91.32098  true 9.11026  0
	 *  35 10.11874  true 8.95396  3
	 *  92 32.88401  true 8.87089  0
	 *  72 92.55791  true 9.46241  0
	 * </pre>
	 *
	 * <pre>
	 *  % java StdRandom 5
	 *  seed = 1316600616575
	 *  96 60.17070  true 8.72821  0
	 *  79 32.01607  true 8.58159  0
	 *  81 59.49065  true 9.10423  1
	 *  96 51.65818  true 9.02102  0
	 *  99 17.55771  true 8.99762  0
	 * </pre>
	 *
	 * <pre>
	 *  % java StdRandom 5 1316600616575
	 *  seed = 1316600616575
	 *  96 60.17070  true 8.72821  0
	 *  79 32.01607  true 8.58159  0
	 *  81 59.49065  true 9.10423  1
	 *  96 51.65818  true 9.02102  0
	 *  99 17.55771  true 8.99762  0
	 * </pre>
	 *
	 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
	 */
	public static final class StdRandom {

		private static Random random;    // pseudo-random number generator
		private static long seed;        // pseudo-random number generator seed

		// Static initializer
		static {
			// The same way the seed was set in Java 1.4
			seed = System.currentTimeMillis();
			random = new Random(seed);
		}

		// Doesn't make sense to instantiate this class
		private StdRandom() {
		}

		/**
		 * @return the seed of the pseudo-random number generator.
		 */
		public static long getSeed() {
			return seed;
		}

		/**
		 * Sets the seed of the pseudo-random number generator. This method enables us to produce the same sequence of
		 * "random" numbers for each execution of the program. Ordinarily, we should call this method at most once per
		 * program.
		 *
		 * @param s the seed
		 */
		public static void setSeed(long s) {
			seed = s;
			random = new Random(seed);
		}

		/**
		 * Uniformly generates a random real number in [0, 1).
		 *
		 * @return a random real number uniformly in [0, 1).
		 */
		public static double uniform() {
			return random.nextDouble();
		}

		/**
		 * Returns a random integer uniformly in [0, n).
		 *
		 * @param n number of possible integers.
		 * @return a random integer uniformly between 0 (inclusive) and {@code n} (exclusive).
		 * @throws IllegalArgumentException if {@code n <= 0}.
		 */
		public static int uniform(int n) {
			if (n <= 0) throw new IllegalArgumentException("argument must be positive: " + n);
			return random.nextInt(n);
		}


		/**
		 * Returns a random long integer uniformly in [0, n).
		 *
		 * @param n number of possible {@code long} integers.
		 * @return a random long integer uniformly between 0 (inclusive) and {@code n} (exclusive).
		 * @throws IllegalArgumentException if {@code n <= 0}.
		 */
		public static long uniform(long n) throws IllegalArgumentException {
			if (n <= 0L) throw new IllegalArgumentException("argument must be positive: " + n);

			long r = random.nextLong();
			long m = n - 1;

			// Power of two
			if ((n & m) == 0L) {
				return r & m;
			}

			// Reject over-represented candidates
			long u = r >>> 1;
			while (u + m - (r = u % n) < 0L) {
				u = random.nextLong() >>> 1;
			}
			return r;
		}

		///////////////////////////////////////////////////////////////////////////
		//  STATIC METHODS BELOW RELY ON JAVA.UTIL.RANDOM ONLY INDIRECTLY VIA    //
		//  THE STATIC METHODS ABOVE.                                            //
		///////////////////////////////////////////////////////////////////////////

		/**
		 * Returns a random real number uniformly in [0, 1).
		 *
		 * @return a random real number uniformly in [0, 1).
		 * @deprecated Replaced by {@link #uniform()}.
		 */
		@Deprecated
		public static double random() {
			return uniform();
		}

		/**
		 * Returns a random integer uniformly in [a, b).
		 *
		 * @param a the left endpoint.
		 * @param b the right endpoint.
		 * @return a random integer uniformly in [a, b).
		 * @throws IllegalArgumentException if {@code b <= a} or {@code b - a >= Integer.MAX_VALUE}.
		 */
		public static int uniform(int a, int b) throws IllegalArgumentException {
			if ((b <= a) || ((long) b - a >= Integer.MAX_VALUE)) {
				throw new IllegalArgumentException("invalid range: [" + a + ", " + b + ")");
			}
			return a + uniform(b - a);
		}

		/**
		 * Returns a random real number uniformly in [a, b).
		 *
		 * @param a the left endpoint.
		 * @param b the right endpoint.
		 * @return a random real number uniformly in [a, b).
		 * @throws IllegalArgumentException unless {@code a < b}.
		 */
		public static double uniform(double a, double b) throws IllegalArgumentException {
			if (!(a < b)) {
				throw new IllegalArgumentException("invalid range: [" + a + ", " + b + ")");
			}
			return a + uniform() * (b - a);
		}

		/**
		 * Returns a random boolean from a Bernoulli distribution with success probability <em>p</em>.
		 *
		 * @param p the probability of returning {@code true}.
		 * @return {@code true} with probability {@code p} and {@code false} with probability {@code 1 - p}.
		 * @throws IllegalArgumentException unless {@code 0} &le; {@code p} &le; {@code 1.0}.
		 */
		public static boolean bernoulli(double p) throws IllegalArgumentException {
			if (!(p >= 0.0 && p <= 1.0))
				throw new IllegalArgumentException("probability p must be between 0.0 and 1.0: " + p);
			return uniform() < p;
		}

		/**
		 * Returns a random boolean from a Bernoulli distribution with success probability 1/2.
		 *
		 * @return {@code true} with probability 1/2 and {@code false} with probability 1/2.
		 */
		public static boolean bernoulli() {
			return bernoulli(0.5);
		}

		/**
		 * Returns a random real number from a standard Gaussian distribution.
		 *
		 * @return a random real number from a standard Gaussian distribution (mean 0 and standard deviation 1).
		 */
		public static double gaussian() {
			// Uses the polar form of the Box-Muller transform
			double r, x, y;
			do {
				x = uniform(-1.0, 1.0);
				y = uniform(-1.0, 1.0);
				r = x * x + y * y;
			} while (r >= 1 || r == 0);
			return x * Math.sqrt(-2 * Math.log(r) / r);

			// Remark: y * Math.sqrt(-2 * Math.log(r) / r) is an independent random gaussian
		}

		/**
		 * Returns a random real number from a Gaussian distribution with mean &mu; and standard deviation &sigma;.
		 *
		 * @param mu    the mean.
		 * @param sigma the standard deviation.
		 * @return a real number distributed according to the Gaussian distribution with mean {@code mu} and standard
		 * deviation {@code sigma}.
		 */
		public static double gaussian(double mu, double sigma) {
			return mu + sigma * gaussian();
		}

		/**
		 * Returns a random integer from a geometric distribution with success probability <em>p</em>. The integer
		 * represents the number of independent trials before the first success.
		 *
		 * @param p the parameter of the geometric distribution.
		 * @return a random integer from a geometric distribution with success probability {@code p}; or {@code
		 * Integer.MAX_VALUE} if {@code p} is (nearly) equal to {@code 1.0}.
		 * @throws IllegalArgumentException unless {@code p >= 0.0} and {@code p <= 1.0}.
		 */
		public static int geometric(double p) throws IllegalArgumentException {
			if (!(p >= 0)) {
				throw new IllegalArgumentException("probability p must be greater than 0: " + p);
			}
			if (!(p <= 1.0)) {
				throw new IllegalArgumentException("probability p must not be larger than 1: " + p);
			}
			// using algorithm given by Knuth
			return (int) Math.ceil(Math.log(uniform()) / Math.log(1.0 - p));
		}

		/**
		 * Returns a random integer from a Poisson distribution with mean &lambda;.
		 *
		 * @param lambda the mean of the Poisson distribution
		 * @return a random integer from a Poisson distribution with mean {@code lambda}
		 * @throws IllegalArgumentException unless {@code lambda > 0.0} and not infinite
		 */
		public static int poisson(double lambda) throws IllegalArgumentException {
			if (!(lambda > 0.0))
				throw new IllegalArgumentException("lambda must be positive: " + lambda);
			if (Double.isInfinite(lambda))
				throw new IllegalArgumentException("lambda must not be infinite: " + lambda);
			int k = 0;
			double p = 1.0;
			double expLambda = Math.exp(-lambda);
			k++;
			p *= uniform();
			while (p >= expLambda) {
				k++;
				p *= uniform();
			}
			return k - 1;
		}

		/**
		 * Returns a random real number from the standard Pareto distribution.
		 *
		 * @return a random real number from the standard Pareto distribution.
		 */
		public static double pareto() {
			return pareto(1.0);
		}

		/**
		 * Returns a random real number from a Pareto distribution with shape parameter &alpha;.
		 *
		 * @param alpha shape parameter
		 * @return a random real number from a Pareto distribution with shape parameter {@code alpha}.
		 * @throws IllegalArgumentException unless {@code alpha > 0.0}.
		 */
		public static double pareto(double alpha) throws IllegalArgumentException {
			if (!(alpha > 0.0))
				throw new IllegalArgumentException("alpha must be positive: " + alpha);
			return Math.pow(1 - uniform(), -1.0 / alpha) - 1.0;
		}

		/**
		 * Returns a random real number from the Cauchy distribution.
		 *
		 * @return a random real number from the Cauchy distribution.
		 */
		public static double cauchy() {
			return Math.tan(Math.PI * (uniform() - 0.5));
		}

		/**
		 * Returns a random integer from the specified discrete distribution.
		 *
		 * @param probabilities the probability of occurrence of each integer
		 * @return a random integer from a discrete distribution: {@code i} with probability {@code probabilities[i]}
		 * @throws IllegalArgumentException if {@code probabilities} is {@code null}, the sum of array entries is not
		 *                                  (very nearly) equal to {@code 1.0} or unless {@code probabilities[i] >= 0.0}
		 *                                  for each index {@code i}.
		 */
		public static int discrete(double[] probabilities) throws IllegalArgumentException {
			if (probabilities == null) throw new IllegalArgumentException("argument array must not be null");
			double EPSILON = 1.0E-14;
			double sum = 0.0;
			for (int i = 0; i < probabilities.length; i++) {
				if (!(probabilities[i] >= 0.0))
					throw new IllegalArgumentException("array entry " + i + " must be non-negative: " + probabilities[i]);
				sum += probabilities[i];
			}
			if (sum > 1.0 + EPSILON || sum < 1.0 - EPSILON)
				throw new IllegalArgumentException("sum of array entries does not approximately equal 1.0: " + sum);

			// The for loop may not return a value when both r is (nearly) 1.0 and when the
			// cumulative sum is less than 1.0 (as a result of floating-point round-off error)
			while (true) {
				double r = uniform();
				sum = 0.0;
				for (int i = 0; i < probabilities.length; i++) {
					sum = sum + probabilities[i];
					if (sum > r) return i;
				}
			}
		}

		/**
		 * Returns a random integer from the specified discrete distribution.
		 *
		 * @param frequencies the frequency of occurrence of each integer.
		 * @return a random integer from a discrete distribution: {@code i} with probability proportional to {@code
		 * frequencies[i]}.
		 * @throws IllegalArgumentException if {@code frequencies} is {@code null}, all array entries are {@code 0},
		 *                                  {@code frequencies[i]} is negative for any index {@code i} or the sum of
		 *                                  frequencies exceeds {@code Integer.MAX_VALUE} (2<sup>31</sup> - 1).
		 */
		public static int discrete(int[] frequencies) throws IllegalArgumentException {
			if (frequencies == null) throw new IllegalArgumentException("argument array must not be null");
			long sum = 0;
			for (int i = 0; i < frequencies.length; i++) {
				if (frequencies[i] < 0)
					throw new IllegalArgumentException("array entry " + i + " must be non-negative: " + frequencies[i]);
				sum += frequencies[i];
			}
			if (sum == 0)
				throw new IllegalArgumentException("at least one array entry must be positive");
			if (sum >= Integer.MAX_VALUE)
				throw new IllegalArgumentException("sum of frequencies overflows an int");
			// pick index i with probability proportional to frequency
			double r = uniform((int) sum);
			sum = 0;
			for (int i = 0; i < frequencies.length; i++) {
				sum += frequencies[i];
				if (sum > r) return i;
			}
			// can't reach here
			assert false;
			return -1;
		}

		/**
		 * Returns a random real number from an exponential distribution with rate &lambda;.
		 *
		 * @param lambda the rate of the exponential distribution.
		 * @return a random real number from an exponential distribution with rate {@code lambda}.
		 * @throws IllegalArgumentException unless {@code lambda > 0.0}.
		 */
		public static double exp(double lambda) throws IllegalArgumentException {
			if (!(lambda > 0.0))
				throw new IllegalArgumentException("lambda must be positive: " + lambda);
			return -Math.log(1 - uniform()) / lambda;
		}

		/**
		 * Rearranges the elements of the specified array in uniformly random order.
		 *
		 * @param a the array to shuffle.
		 * @throws IllegalArgumentException if {@code a} is {@code null}.
		 */
		public static void shuffle(Object[] a) throws IllegalArgumentException {
			validateNotNull(a);
			int n = a.length;
			for (int i = 0; i < n; i++) {
				int r = i + uniform(n - i);     // between i and n-1
				Object temp = a[i];
				a[i] = a[r];
				a[r] = temp;
			}
		}

		/**
		 * Rearranges the elements of the specified array in uniformly random order.
		 *
		 * @param a the array to shuffle.
		 * @throws IllegalArgumentException if {@code a} is {@code null}.
		 */
		public static void shuffle(double[] a) throws IllegalArgumentException {
			validateNotNull(a);
			int n = a.length;
			for (int i = 0; i < n; i++) {
				int r = i + uniform(n - i);     // between i and n-1
				double temp = a[i];
				a[i] = a[r];
				a[r] = temp;
			}
		}

		/**
		 * Rearranges the elements of the specified array in uniformly random order.
		 *
		 * @param a the array to shuffle.
		 * @throws IllegalArgumentException if {@code a} is {@code null}.
		 */
		public static void shuffle(int[] a) throws IllegalArgumentException {
			validateNotNull(a);
			int n = a.length;
			for (int i = 0; i < n; i++) {
				int r = i + uniform(n - i);     // between i and n-1
				int temp = a[i];
				a[i] = a[r];
				a[r] = temp;
			}
		}

		/**
		 * Rearranges the elements of the specified array in uniformly random order.
		 *
		 * @param a the array to shuffle.
		 * @throws IllegalArgumentException if {@code a} is {@code null}.
		 */
		public static void shuffle(char[] a) throws IllegalArgumentException {
			validateNotNull(a);
			int n = a.length;
			for (int i = 0; i < n; i++) {
				int r = i + uniform(n - i);     // between i and n-1
				char temp = a[i];
				a[i] = a[r];
				a[r] = temp;
			}
		}

		/**
		 * Rearranges the elements of the specified sub-array in uniformly random order.
		 *
		 * @param a    the array to shuffle.
		 * @param low  the left endpoint (inclusive).
		 * @param high the right endpoint (exclusive).
		 * @throws IllegalArgumentException if {@code a} is {@code null} or unless {@code (0 <= low) && (low < high) &&
		 *                                  (high <= a.length)}.
		 */
		public static void shuffle(Object[] a, int low, int high) throws IllegalArgumentException {
			validateNotNull(a);
			validateSubArrayIndices(low, high, a.length);

			for (int i = low; i < high; i++) {
				int r = i + uniform(high - i);     // between i and high-1
				Object temp = a[i];
				a[i] = a[r];
				a[r] = temp;
			}
		}

		/**
		 * Rearranges the elements of the specified sub-array in uniformly random order.
		 *
		 * @param a    the array to shuffle.
		 * @param low  the left endpoint (inclusive).
		 * @param high the right endpoint (exclusive).
		 * @throws IllegalArgumentException if {@code a} is {@code null} or unless {@code (0 <= low) && (low < high) &&
		 *                                  (high <= a.length)}.
		 */
		public static void shuffle(double[] a, int low, int high) throws IllegalArgumentException {
			validateNotNull(a);
			validateSubArrayIndices(low, high, a.length);

			for (int i = low; i < high; i++) {
				int r = i + uniform(high - i);     // between i and high-1
				double temp = a[i];
				a[i] = a[r];
				a[r] = temp;
			}
		}

		/**
		 * Rearranges the elements of the specified sub-array in uniformly random order.
		 *
		 * @param a  the array to shuffle.
		 * @param lo the left endpoint (inclusive).
		 * @param hi the right endpoint (exclusive).
		 * @throws IllegalArgumentException if {@code a} is {@code null} or unless {@code (0 <= lo) && (lo < hi) && (hi
		 *                                  <= a.length)}.
		 */
		public static void shuffle(int[] a, int lo, int hi) throws IllegalArgumentException {
			validateNotNull(a);
			validateSubArrayIndices(lo, hi, a.length);

			for (int i = lo; i < hi; i++) {
				int r = i + uniform(hi - i);     // between i and hi-1
				int temp = a[i];
				a[i] = a[r];
				a[r] = temp;
			}
		}

		/**
		 * Returns a uniformly random permutation of <em>n</em> elements.
		 *
		 * @param n number of elements
		 * @return an array of length {@code n} that is a uniformly random permutation of {@code 0}, {@code 1}, ...,
		 * {@code n-1}.
		 * @throws IllegalArgumentException if {@code n} is negative.
		 */
		public static int[] permutation(int n) throws IllegalArgumentException {
			if (n < 0) throw new IllegalArgumentException("n must be non-negative: " + n);
			int[] perm = new int[n];
			for (int i = 0; i < n; i++)
				perm[i] = i;
			shuffle(perm);
			return perm;
		}

		/**
		 * Returns a uniformly random permutation of <em>k</em> of <em>n</em> elements.
		 *
		 * @param n total number of elements
		 * @param k number of elements to select
		 * @return an array of length {@code k} that is a uniformly random permutation of {@code k} of the elements from
		 * {@code 0}, {@code 1}, ..., {@code n-1}
		 * @throws IllegalArgumentException if {@code n} is negative or unless {@code 0 <= k <= n}
		 */
		public static int[] permutation(int n, int k) throws IllegalArgumentException {
			assert n >= 0 : "n must be non-negative: " + n;
			assert k >= 0 && k <= n : "k must be between 0 and n: " + k;
			int[] perm = new int[k];
			for (int i = 0; i < k; i++) {
				int r = uniform(i + 1);
				perm[i] = perm[r];
				perm[r] = i;
			}
			for (int i = k; i < n; i++) {
				int r = uniform(i + 1);
				if (r < k) perm[r] = i;
			}
			return perm;
		}

		/**
		 * Throws an IllegalArgumentException if {@code x} is {@code null}.
		 *
		 * @param x the Object instance to verify is not null.
		 * @throws AssertionError if the object is not null.
		 */
		private static void validateNotNull(Object x) throws AssertionError {
			assert x != null : "Argument must not be null";
		}

		/**
		 * Throw an exception unless {@code 0 <= lo <= hi <= length}.
		 *
		 * @param lo     the left endpoint of the sub-array (inclusive).
		 * @param hi     the right endpoint of the sub-array (exclusive).
		 * @param length the length of the super-array.
		 * @throws AssertionError if the sub-array indices are out of bounds with regards to the given length.
		 */
		private static void validateSubArrayIndices(int lo, int hi, int length) throws AssertionError {
			assert lo >= 0 && hi <= length && lo <= hi : "Sub-array indices out of bounds: [" + lo + ", " + hi + ")";
		}

		/**
		 * Unit tests the methods in this class.
		 *
		 * @param args the command-line arguments
		 */
		public static void main(String[] args) {
			int n = 10;
			double[] probabilities = {0.5, 0.3, 0.1, 0.1};
			int[] frequencies = {5, 3, 1, 1};
			String[] a = "A B C D E F G".split(" ");

			StdOut.println("seed = " + StdRandom.getSeed());
			for (int i = 0; i < n; i++) {
				StdOut.printf("%2d ", uniform(100));
				StdOut.printf("%8.5f ", uniform(10.0, 99.0));
				StdOut.printf("%5b ", bernoulli(0.5));
				StdOut.printf("%7.5f ", gaussian(9.0, 0.2));
				StdOut.printf("%1d ", discrete(probabilities));
				StdOut.printf("%1d ", discrete(frequencies));
				StdOut.printf("%11d ", uniform(100000000000L));
				StdRandom.shuffle(a);
				for (String s : a)
					StdOut.print(s);
				StdOut.println();
			}
		}

	}

}
