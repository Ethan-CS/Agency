package io.github.ethankelly;


import io.github.ethankelly.graphs.Graph;
import io.github.ethankelly.params.Protection;
import io.github.ethankelly.params.State;

import java.util.Arrays;

/**
 * The {@code Agency} class represents agents and instantiates their attributes for use in compartmental graph models of
 * contagion. This class is significant since agency is the basis and purpose of the model we are developing. Each agent
 * has certain attributes that need to be determined initially and updated at each time-step in the model, which are:
 * <ul>
 *     <li> The vertex the agent is located at
 *     <li> The peril rating, based on the agent's proximity to infected vertices
 *     <li> The protection rating, which is partially random but increases with peril
 *     <li> The state of the vertex - whether it is susceptible to infection, infected, recovered or defended.
 * </ul>
 * Each agent's attributes are based on the initial state of the graph. In the model, we choose (either at random or
 * sequentially) a vertex to be the source node. At time 0, only the source node is infected and all others are
 * susceptible or protected, if there is no path between them and the source node for instance. An agent can transition
 * to the protected state by having a protection rating of 1, which happens in different ways depending on context, such
 * as via influence exerted or because the peril rating is also high and the baseline random protection was fairly high
 * to begin with. At each time-step, we need to determine any changes to state, protection and peril.
 *
 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
 */
public class Agent {

	/**
	 * Indicates the agent's location on the graph that the model uses.
	 */
	private final int vertex;

	/**
	 * Represents the danger the agent is currently in. The more infected vertices within a certain proximity, and the
	 * closer infected vertices are to the given agent, the higher the peril.
	 */
	private double peril;

	/**
	 * The agent's intrinsic inclination towards avoidance of contraction in an epidemic scenario.
	 */
	private double protection;

	/**
	 * Each agent can be in one of a number of states indicating which compartment of the model the agent belongs to.
	 */
	private State state;

	/**
	 * Class constructor.
	 *
	 * @param vertex     the vertex position (location) of the agent.
	 * @param peril      the initial peril rating of the agent (based on proximity to fire).
	 * @param protection the initial protection rating of the agent (partially random, increases with peril).
	 * @param state      the initial state of the agent.
	 */
	public Agent(int vertex, double peril, double protection, State state) {
		this.vertex = vertex;
		this.peril = peril;
		this.protection = protection;
		this.state = state;
	}

	/**
	 * @return the vertex location of the agent.
	 */
	public int getVertex() {
		return this.vertex;
	}

	/**
	 * @return the current peril rating of the agent.
	 */
	public double getPeril() {
		return this.peril;
	}

	/**
	 * @param peril the peril rating to be set to the current vertex.
	 */
	public void setPeril(double peril) {
		this.peril = peril;
	}

	/**
	 * @return the protection rating of the current agent.
	 */
	public double getProtection() {
		return this.protection;
	}

	/**
	 * @param protection the new protection to be assigned to the current agent.
	 */
	public void setProtection(double protection) {
		assert protection <= 1 && protection >= 0;
		this.protection = protection;
	}

	/**
	 * @return the state to which the current agent belongs.
	 */
	public State getState() {
		return this.state;
	}

	/**
	 * @param state the state into which we want to move the current agent.
	 */
	public void setState(State state) {
		this.state = state;
	}


	/**
	 * Returns a textual representation of the agent, detailing its vertex location, peril rating, protection rating and
	 * current state, used to print to standard output.
	 *
	 * @return a string representation of the agent.
	 */
	@Override
	public String toString() {
		return "Agent at vertex " + this.getVertex()
		       + ": peril " + String.format("%.2f", this.getPeril())
		       + ", protection " + String.format("%.2f", this.getProtection())
		       + " and state " + this.getState() + ".";
	}

	/**
	 * For a given agent, we need to update their protection rating frequently, which this model does by multiplying a
	 * baseline random number between 0 and 1 by the current peril rating, which means the protection rating increases
	 * with proximity to infected agents.
	 *
	 * @param protectionType the method of protection determination we use (fully random, fully deterministic or mixed)
	 * @return the updated protection rating attribute.
	 */
	public double protectionRating(Protection protectionType) {
		double peril = this.getPeril(); // How close infection is to the agent
		double protection;
		switch (protectionType) {
			case RANDOM -> protection = Math.random();
			case MIXED -> {
				double baseline = Math.random(); // Baseline random number
				if (baseline * (1 / peril) > 1) protection = 1;
				else protection = (peril == 0) ? baseline : (baseline * (1 / peril));
			}
			case DETERMINISTIC -> protection = 0.9 * peril;
			default -> throw new IllegalStateException("Unexpected protection type: " + protectionType);
		}
		this.setProtection(protection);
		return protection;
	}

	/**
	 * Given an agent, the current fires and the graph the model uses, we return a peril rating. This method can be used
	 * frequently to update the peril when the graph has been updated (new infections, recoveries and protections have
	 * taken place) and the peril rating itself is thus a true reflection of the danger level the agent is facing.
	 *
	 * @param fires agents that are currently infected by the contagion.
	 * @param g     the graph associated with the model.
	 * @return the updated peril rating, based on proximity to infection (0 - no danger, 1 - imminent danger).
	 */
	public double findPerilRating(int[] fires, Graph g) {
		double peril;

		int[] shortestPath = g.shortestPath(getVertex());
		double leastDist = shortestPath[fires[0]];
		for (int fire : fires) {
			if (shortestPath[fire] < leastDist && shortestPath[fire] != Integer.MAX_VALUE) {
				leastDist = shortestPath[fire];
			}
		}
		if (leastDist == 0) peril = 1.0;
		else peril = leastDist == Integer.MAX_VALUE ? 0.0 : (1 / leastDist);

		this.setPeril(peril);
		return peril;
	}

	/**
	 * Given an agent and the agents that are currently infected, we determine the state based on whether a path exists
	 * between the agent and an infected vertex. If no such path exists, we say the agent is protected. If one exists,
	 * they are susceptible. If the distance to an infected vertex is zero, then they are infected themselves. If they
	 * have been infected for a given number of turns, the agent becomes recovered for a further given number of turns.
	 *
	 * @param fires all currently infected (burning) vertices.
	 * @param model the current model.
	 * @return the updated state of the agent we have determined for the current model situation.
	 */
	public State findState(int[] fires, Model model) {
		int vertex = getVertex();
		double peril = model.getAgents().get(vertex).getPeril();
		double protection = model.getAgents().get(vertex).getProtection();
		State toSet = Arrays.stream(fires).anyMatch(fire -> vertex == fire) ? State.INFECTED : State.SUSCEPTIBLE;
		if (protection == 1.0 || peril == 0) toSet = State.PROTECTED;
		setState(toSet);
		return toSet;
	}
}
