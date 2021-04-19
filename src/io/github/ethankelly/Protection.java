package io.github.ethankelly;

/**
 * The {@code Protection} enum stores values for each method of protection rating allocation in the model. These can
 * be:
 * <ul>
 *     <li> {@link #RANDOM} - Protection is assigned as a pseudo-randomly generated value.
 *     <li> {@link #MIXED} - Protection is assigned based partially on proximity to infection and partially on a pseudo-random baseline.
 *     <li> {@link #DETERMINISTIC} - Protection is assigned purely based on proximity to infection.
 * </ul>
 *
 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
 */
public enum Protection {
	/**
	 * Random protection allocation.
	 */
	RANDOM(0),
	/**
	 * Mixed protection allocation.
	 */
	MIXED(1),
	/**
	 * Deterministic (proximity-based) allocation.
	 */
	DETERMINISTIC(2);

	private final int value;

	/**
	 * Constructor used to associate a given value with the corresponding defence allocation method.
	 *
	 * @param value the value to associate to a protection allocation method.
	 */
	Protection(int value) {
		this.value = value;
	}

	/**
	 * @return the underlying value associated with the current protection allocation method.
	 */
	public int getValue() {
		return value;
	}

	public static Protection getProtection(int i) {
		return switch (i) {
			case 0 -> RANDOM;
			case 1 -> MIXED;
			case 2 -> DETERMINISTIC;
			default -> throw new IllegalStateException("Unexpected value: " + i);
		};
	}
}