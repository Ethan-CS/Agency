package io.github.ethankelly.graphs;

import org.apache.commons.lang.SerializationUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GraphTest {

	@Test
	void testClone() {
		Graph g = GraphGenerator.simple(10, 30);
		Graph h = g.clone();
		Assertions.assertEquals(g, h);
		h.appendVertices(1);
		Assertions.assertNotEquals(g, h);
	}

	@Test
	public void testCommonsClone() {
		Graph g = GraphGenerator.simple(10, 30);
		Graph h = (Graph) SerializationUtils.clone(g);
		Assertions.assertEquals(g, h);

	}
}