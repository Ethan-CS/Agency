package io.github.ethankelly;

import io.github.ethankelly.graphs.Graph;
import io.github.ethankelly.graphs.GraphGenerator;
import io.github.ethankelly.params.Protection;
import io.github.ethankelly.params.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ModelTest {
	Graph testGraph = GraphGenerator.complete(4); // Underlying graph to associate with the model
	Model m; // Model object used to test

	@BeforeEach
	void setUp() {
		testGraph.appendVertices(1); // Append a vertex, so we have an automatically protected agent
		m = new Model(testGraph); // Initialise the model object
		m.initialiseModel(2, Protection.DETERMINISTIC); // Initialise the agents based on initial outbreak at 2
	}

	@Test
	void getSusceptible() {
		// Here, we are expecting agents at 0, 1 and 3 to be susceptible.
		// Agent at 2 is infected and agent at 4 is protected
		List<Agent> susceptible = new ArrayList<>();
		susceptible.add(new Agent(0, 1, 0.9, State.SUSCEPTIBLE));
		susceptible.add(new Agent(1, 1, 0.9, State.SUSCEPTIBLE));
		susceptible.add(new Agent(3, 1, 0.9, State.SUSCEPTIBLE));

		Assertions.assertEquals(m.getSusceptible(), susceptible);
	}

	@Test
	void getInfected() {
		List<Agent> infected = Collections.singletonList(new Agent(2, 1, 0.9, State.INFECTED));
		Assertions.assertEquals(m.getInfected(), infected);
	}

	@Test
	void getRecovered() {
		// We aren't expecting any recoveries as the code does not include this mechanism as of yet
		List<Agent> recovered = Collections.emptyList();
		Assertions.assertEquals(m.getRecovered(), recovered);
	}

	@Test
	void getProtected() {
		// Only agent we expect to be protected here is the one inhabiting the appended vertex with no edges attached.
		// We expect peril to be zero since there's no infection pathway between this agent and an infected agent,
		// We also expect protection to be 1 since being in the Protected state means your protection must be 1.
		List<Agent> protect = Collections.singletonList(new Agent(4, 0, 1, State.PROTECTED));
		Assertions.assertEquals(m.getProtected(), protect);
	}

}