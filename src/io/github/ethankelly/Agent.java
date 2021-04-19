package io.github.ethankelly;


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
 *
 * <p>
 *     Each agent's attributes are based on the initial state of the graph. In the model,
 *     we choose at random an initial vertex to be the 'setOutbreak' or source node. At time 0,
 *     only the source node is infected and all others are susceptible or protected, if
 *     there is no path between them and the source node for instance. An agent can
 *     transition to the protected state by having a protection rating of 1, which happens
 *     in different ways depending on context, such as via influence exerted or because the
 *     peril rating is also high and the baseline random protection was fairly high to begin with.
 *     At each time-step, we need to determine any changes to state, protection and peril.
 * </p>
 *
 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
 */
public class Agent {

	/**
	 * The vertex attribute of an agent indicates their location on the graph that the model uses. This, in turn, helps
	 * determine which other agents (vertices) they are connected to, which may indicate a possible route of infection.
	 */
	private final int vertex;

	/**
	 * Peril rating represents the danger they are currently in. The more infected vertices within a certain proximity,
	 * and the closer infected vertices are to the given agent, the higher the peril rating. Peril is zero if there is
	 * no path between the vertex and an infected agent and one if the agent is in immediate danger. We assign the peril
	 * rating of the agent based on the current graph state (as determined in the main model class) - specifically, the
	 * agent's proximity to infected vertices.
	 */
	private double peril;

	/**
	 * The protection rating of an agent is their intrinsic inclination towards avoidance of contraction in an epidemic
	 * scenario (e.g. related to how much contact they have daily, how much PPE they wear, etc.). Several methods update
	 * the method, whenever the peril has been updated (i.e. the state of the graph has changed in some way, peril may
	 * have changed and so protection also needs to be updated and set to its new value). We do not allow a protection
	 * of rating over 1, so this method prevents the value being set from being greater than that.
	 */
	private double protection;

	/**
	 * Each agent can be in one of a number of states, namely any of those in the State enum. These indicate which
	 * compartment of the SIR model the agent belongs to and each has an associated value to make computation simpler
	 * when updating the graph state and so on.
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
		return vertex;
	}

	/**
	 * @return the current peril rating of the agent.
	 */
	public double getPeril() {
		return peril;
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
		return protection;
	}

	/**
	 * @param protection the new protection to be assigned to the current agent.
	 */
	public void setProtection(double protection) {
		this.protection = protection > 1 ? 1 : protection;
	}

	/**
	 * @return the state to which the current agent belongs.
	 */
	public State getState() {
		return state;
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
		double peril = this.getPeril();
		double baseline = Math.random();
		double protection;

		switch (protectionType) {
			case RANDOM -> // Fully random protection rating
					protection = baseline;
			case MIXED -> { // Partially random, partially deterministic protection rating
				if (baseline * (1 / peril) > 1) protection = 1;
				else protection = (peril == 0) ? baseline : (baseline * (1 / peril));
			}
			case DETERMINISTIC -> { // Fully deterministic protection rating
				if (peril < 1) protection = peril;
				else protection = 0.999;
			}
			default -> throw new IllegalStateException("Unexpected value: " + protectionType);
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
	public double perilRating(int[] fires, Graph g) {
		double peril;

		int[] leastDistancePath = g.shortestPath(getVertex());
		double leastDist = leastDistancePath[fires[0]];
		//TODO make this work for more than one fire location - find closest fire, find shortest path to it

		if (leastDist == 0) peril = 1.0;
		else peril = leastDist == Integer.MAX_VALUE ? 0.0 : 1 / leastDist;

		setPeril(peril);
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
		State toSet = State.SUSCEPTIBLE;

		for (int fire : fires) {
			if (vertex == fire) {
				toSet = State.INFECTED;
				break;
			}
		}
		if (protection == 1.0 || peril == 0) {
			toSet = State.PROTECTED;
		}

		setState(toSet);
		return toSet;
	}
}
