package io.github.ethankelly;

import io.github.ethankelly.params.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AgentTest {

	@Test
	void testClone() {
		Agent a = new Agent(1, 0.5, 0.5, State.SUSCEPTIBLE);
		Agent b = (Agent) a.clone();

		Assertions.assertEquals(a, b);

		b.setState(State.INFECTED);
		Assertions.assertNotEquals(a, b);
	}
}