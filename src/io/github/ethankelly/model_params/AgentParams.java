package io.github.ethankelly.model_params;

/**
 * Contains enums listing various parameters an Agent object can take - a defence strategy and a state.
 */
public class AgentParams {

	/**
	 * The {@code Defence} enum stores values for each method of protection rating allocation in the model. These can
	 * be:
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

		public static Defence getDefence(int i) {
			return switch (i) {
				case 0 -> PROXIMITY;
				case 1 -> DEGREE;
				case 2 -> PROTECTION;
				default -> throw new IllegalStateException("Unexpected value: " + i);
			};
		}

		/**
		 * @return the value associated with the given defence strategy constant.
		 */
		public int getValue() {
			return value;
		}
	}

	/**
	 * The {@code State} class represents the states that an agent can be in from the SIRP model. These states are:
	 * <ul>
	 *     <li> {@link #SUSCEPTIBLE} - the agent may contract the disease (i.e. with non-zero probability).
	 *     <li> {@link #INFECTED} - has been exposed and successfully infected by the contagion.
	 *     <li> {@link #RECOVERED} - previously had the disease, has since recovered and is no longer infectious.
	 *     <li> {@link #PROTECTED} - an agent in this state cannot become infected.
	 * </ul>
	 *
	 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
	 */
	public enum State {
		/**
		 * Susceptible state
		 */
		SUSCEPTIBLE(0),
		/**
		 * Infected state
		 */
		INFECTED(1),
		/**
		 * Recovered state
		 */
		RECOVERED(2),
		/**
		 * Protected (defended) state
		 */
		PROTECTED(3);

		private final int value;

		/**
		 * Class constructor, used to associate the inputted value with a given state.
		 */
		State(int value) {
			this.value = value;
		}

		/**
		 * Each state has a value associated to it, for ease of computation and storage of the graph state at each time
		 * step. The value method returns the value associated to the state that it is called on.
		 *
		 * @return the value of the state.
		 */
		public int value() {
			return this.value;
		}
	}
}
