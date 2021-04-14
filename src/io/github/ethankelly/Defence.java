package io.github.ethankelly;

/**
 * The {@code Defence} enum stores values for each method of protection rating allocation in the model. These can be:
 * <ul>
 *     <li> {@link #PROXIMITY} - Defence is calculated based on proximity to infection, breaking ties by highest degree vertex.
 *     <li> {@link #DEGREE} - Defence is calculated based on highest degree vertex in the graph, breaking ties by proximity to infection.
 *     <li> {@link #PROTECTION} - Defence is calculated based on the highest protection-rated vertex/vertices.
 * </ul>
 */
public enum Defence {
	/**
	 * Proximity-based defence strategy.
	 */
	PROXIMITY(0),
	/**
	 * Degree-based defence strategy.
	 */
	DEGREE(1),
	/**
	 * Highest protection-based defence strategy.
	 */
	PROTECTION(2);

	private final int value;

	/**
	 * Constructor, used to associate an inputted value with a particular strategy.
	 *
	 * @param value the value to associate with a strategy.
	 */
	Defence(int value) {
		this.value = value;
	}

	/**
	 * @return the value associated with the given defence strategy constant.
	 */
	public int getValue() {
		return value;
	}

	public static Defence getDefence(int i) {
		return switch (i) {
			case 0 -> PROXIMITY;
			case 1 -> DEGREE;
			case 2 -> PROTECTION;
			default -> throw new IllegalStateException("Unexpected value: " + i);
		};
	}
}