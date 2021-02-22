package io.github.ethankelly;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * The {@code Model} class contains all methods involved in storing and updating the state of play. For instance, a
 * method for getting the currently burning vertices (based on a given probability of propagation) and for updating the
 * state of the graph. The model starts with only the source node as infected, any vertices that do not have a path to
 * the source node as protected and any others as susceptible. As the model progresses, if any vertices have been
 * influenced to the level required to deem them immune to the disease (perhaps by a vaccine), then they move to the
 * protected state. Further, any transmissions that occur based on the probability of transmission and the protection
 * rating of the agents the contagion is currently adjacent to have their states updated accordingly. Then, another
 * defence turn is played and so on, until no more moves can be made. This class contains methods that check for this
 * instance after every turn and thereby end the simulation. The methods here are passed probabilities which dictate
 * infection dynamics, depending on the particular context we want to consider.
 *
 * @author <a href="mailto:e.kelly.1@research.gla.ac.uk">Ethan Kelly</a>
 */
public class Model {
    public static final int PROXIMITY = 0;
    public static final int DEGREE = 1;
    public static final int PROTECTION = 2;
    private final int numVertices;
    private Graph graph;
    private List<Agent> agents;

    /**
     * Class constructor.
     *
     * @param numVertices the number of vertices in the graph the model is based on.
     * @param graph       the graph we use in the model we are creating.
     */
    public Model(int numVertices, Graph graph) {
        this.numVertices = numVertices;
        this.graph = graph;
        // This ensures only one instance is created, which we then update,
        // rather than creating multiple instances and so on.
        this.agents = assignAgents(numVertices);
    }

    /**
     * Used to test methods involved in running the agency-based SIRP model.
     *
     * @param args the command-line arguments.
     */
    @SuppressWarnings({"unused"})
    public static void main(String[] args) throws FileNotFoundException {
        // Numbers of vertices and edges for testing on random graphs
        int numVertices = 10;
        int numEdges = 18;
        // Split vertices into two partitions for bipartite graphs
        int numVertices1 = numVertices / 2;
        int numVertices2 = numVertices - numVertices1;
        // Probability for Erdős–Rényi graphs
        double p = (double) numEdges / (numVertices * (numVertices - 1) / 2.0);

        // Total defence (improvement in protection ratings) that can be deployed each turn
        double totalDefence = 0.5;
        // Probability with which the infection transmits
        double probInfection = 1.0;

        Graph g = GraphGenerator.erdosRenyi(numVertices, p);

        File dir = new File("out/" + String.valueOf(numVertices) + "_vertices/");
        dir.mkdir();
        File readableFile = new File(dir + "/" + GraphGenerator.getSeed() + "Readable.md");
        PrintWriter readable = new PrintWriter(readableFile);
        File dataFile = new File(dir + "/" + GraphGenerator.getSeed() + "Data.csv");
        PrintWriter data = new PrintWriter(dataFile);
        StdOut.setOut(readable);

        StdOut.println("# Readable results of SIRP defence strategies on a random graph\n");

        // New graph for use in the model
        StdOut.println("## Generating Erdős–Rényi Graph:");
        StdOut.println("* Number of vertices: " + numVertices
                + "\n * Number of edges: " + numEdges
                + "\n * Probability: " + numEdges + " / " + "(" + numVertices + " * (" + numVertices + " - 1) / 2) = " + p
                + "\n * Random generator seed: " + GraphGenerator.getSeed());
        StdOut.println();

        StdOut.setOut(data);
        StdOut.println(Graph.makeCommaSeparated(g) + "" + GraphGenerator.getSeed());

        StdOut.setOut(readable);

        // Initialise the model
        Model m = new Model(numVertices, g);
        Model n = new Model(numVertices, g);
        Model o = new Model(numVertices, g);
        StdOut.println(m.getGraph());

        // Cycle through all vertices to test the model using each vertex as a source
        for (int i = 0; i < m.getNumVertices(); i++) {
            StdOut.setOut(readable);
            StdOut.println("\n## Outbreak: " + i);
            // Initialise a list of agents given the starting state of the graph
            for (int j = 0; j < m.getNumVertices(); j++) {
                m.getAgents().set(j, new Agent(j, 0, 0, State.SUSCEPTIBLE));
                m.getAgents().get(j).setPeril(m.perilRating(m.getAgents().get(j), new int[]{i}, m.getGraph()));
                m.getAgents().get(j).setProtection(m.protectionRating(m.getAgents().get(j)));
                m.getAgents().get(j).setState(m.findState(m.getAgents().get(j), new int[]{i}));

                // Set the n and o agents to the same peril and protection ratings as m agents
                // so that we can directly compare the results we obtain when running the models.
                n.getAgents().set(j, new Agent(j, 0, 0, State.SUSCEPTIBLE));
                n.getAgents().get(j).setPeril(m.getAgents().get(j).getPeril());
                n.getAgents().get(j).setProtection(m.getAgents().get(j).getProtection());
                n.getAgents().get(j).setState(n.findState(n.getAgents().get(j), new int[]{i}));

                o.getAgents().set(j, new Agent(j, 0, 0, State.SUSCEPTIBLE));
                o.getAgents().get(j).setPeril(m.getAgents().get(j).getPeril());
                o.getAgents().get(j).setProtection(m.getAgents().get(j).getProtection());
                o.getAgents().get(j).setState(o.findState(o.getAgents().get(j), new int[]{i}));
            }
            // Print the agents we initialised, run the model until
            // either nothing can be infected or nothing can be protected.
            m.printAgents();
            String mResult = m.runReadableTest(totalDefence, probInfection, PROXIMITY);
            String nResult = n.runReadableTest(totalDefence, probInfection, DEGREE);
            String oResult = o.runReadableTest(totalDefence, probInfection, PROTECTION);

            // Print the results to a more machine-readable file.
            StdOut.setOut(data);
            StdOut.println("\nOUTBREAK " + i + "\nSTRATEGY, END TURN, PROTECTED, INFECTED");
            StdOut.println(mResult);
            StdOut.println(nResult);
            StdOut.println(oResult);
        }
        StdOut.close();
    }

    /**
     * Given an agent, the current fires and the graph the model uses, we return a peril rating. This method can be used
     * frequently to update the peril when the graph has been updated (new infections, recoveries and protections have
     * taken place) and the peril rating itself is thus a true reflection of the danger level the agent is facing.
     *
     * @param agent the agent we want to calculate danger relative to.
     * @param fires agents that are currently infected by the contagion.
     * @param g     the graph associated with the model.
     * @return the updated peril rating, based on proximity to infection (0 - no danger, 1 - imminent danger).
     */
    public double perilRating(Agent agent, int[] fires, Graph g) {
        double peril;

        int[] leastDistancePath = g.shortestPath(agent.getVertex());
        double leastDist = leastDistancePath[fires[0]];
        //TODO make this work for more than one fire location - find closest fire, find shortest path to it

        if (leastDist == 0) peril = 1.0;
        else peril = leastDist == Integer.MAX_VALUE ? 0.0 : 1 / leastDist;

        agent.setPeril(peril);
        return peril;
    }

    /**
     * For a given agent, we need to update their protection rating frequently, which this model does by multiplying a
     * baseline random number between 0 and 1 by the current peril rating, which means the protection rating increases
     * with proximity to infected agents.
     *
     * @param agent the agent to determine a protection rating for.
     * @return the updated protection rating attribute.
     */
    public double protectionRating(Agent agent) {
        double peril = agent.getPeril();
        double baseline = Math.random();
        if (baseline * (1 / peril) > 1) {
            return 1;
        } else {
            return peril == 0 ? baseline : baseline * (1 / peril);
        }
    }

    /**
     * Given an agent and the agents that are currently infected, we determine the state based on whether a path exists
     * between the agent and an infected vertex. If no such path exists, we say the agent is protected. If one exists,
     * they are susceptible. If the distance to an infected vertex is zero, then they are infected themselves. If they
     * have been infected for a given number of turns, the agent becomes recovered for a further given number of turns.
     *
     * @param agent the agent to determine the state of.
     * @param fires all currently infected (burning) vertices.
     * @return the updated state of the agent we have determined for the current model situation.
     */
    public State findState(Agent agent, int[] fires) {
        int vertex = agent.getVertex();
        double peril = this.getAgents().get(vertex).getPeril();
        double protection = this.getAgents().get(vertex).getProtection();
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

        agent.setState(toSet);
        return toSet;
    }

    /**
     * We have several (heuristic) defence approaches to the stochastic model that this class instantiates. We choose
     * one of the defence strategies currently available:
     * <ul>
     *      <li> Defend based on proximity to fire, breaking ties by choosing the highest degree vertex;
     *      <li> Defend based on highest degree vertices, breaking ties with greatest proximity to fire; and
     *      <li> Defend the agents with the highest protection ratings.
     * </ul>
     * <p>
     * In the proximity approach, we find the vertex closest to fire (if there is more than one candidate, we break ties
     * by greatest degree) and begin by defending that. We recurse until the total allocated defence is spent. Each
     * agent has their protection ratings accordingly. When a vertex has a protection rating of 1.0, it moves to the
     * protected state and cannot contract the infection.
     * <p>
     * In the degree based approach, we find the agent which inhabits the highest degree vertex in the graph
     * underpinning the model (breaking ties this time by proximity to fire) and increase its protection as much as
     * possible. If there is remaining defence quota after this, we recurse until this allocation is spent. We again
     * set protection ratings to reflect the strategy to implement and where appropriate re-assign states.
     * <p>
     * In the highest protection defence strategy, we find the vertex (or vertices) with highest protection, that is the
     * vertex (vertices) that would be cheapest to increase their protection rating to 1.0 and move to the protected
     * state of the model. Then, for as long as there is remaining defence allowance, the strategy reallocates the
     * remaining quota to the next highest protection rated vertex.
     *
     * @param totalDefence the total defence quota that we can implement per turn.
     * @param whichDefence a value corresponding to the defence strategy to use.
     * @return the strategy to deploy based on the defence we have chosen.
     */
    public double[] runDefence(double totalDefence, int whichDefence) {
        // Find the susceptible agents (the only agents we are interested in defending).
        List<Agent> susceptibleAgents = this.getSusceptible();
        double[] strategy = new double[this.getNumVertices()];
        List<Agent> toDefend = switch (whichDefence) {
            case PROXIMITY -> findHighestPeril();
            case DEGREE -> findHighestDegree();
            case PROTECTION -> findHighestProtection();
            default -> throw new IllegalStateException("Unexpected value: " + whichDefence);
        };

        // Split the defence quota evenly among the total vertices we have determined should be defended.
        double eachDefence = totalDefence / toDefend.size();
        for (int i = 0; i < this.getNumVertices(); i++) {
            if (toDefend.contains(agents.get(i))) {
                if (agents.get(i).getProtection() + eachDefence > 1) {
                    // If increasing protection by the calculated amount will take protection over 1, take the defence
                    // up to 1.0 and then redistribute the remaining defence quota amongst the other agents to protect.
                    strategy[i] = 1 - agents.get(i).getProtection();
                    eachDefence = (totalDefence - strategy[i]) / toDefend.size();
                    agents.get(i).setState(State.PROTECTED);
                    // Remove any fully defended agents from the susceptible list
                    susceptibleAgents.remove(agents.get(i));
                } else strategy[i] += eachDefence;

                double sum = 0;
                for (double v : strategy) sum += v;
                // If we still have defence to use, find the next most appropriate agent(s) and defend them
                while (sum < totalDefence && !susceptibleAgents.isEmpty()) {
                    List<Agent> nextToDefend = switch (whichDefence) {
                        case PROXIMITY -> findHighestPeril();
                        case DEGREE -> findHighestDegree();
                        case PROTECTION -> findHighestProtection();
                        default -> throw new IllegalStateException("Unexpected value: " + whichDefence);
                    };
                    toDefend.addAll(nextToDefend);
                    totalDefence = 1 - sum;
                    eachDefence = totalDefence / nextToDefend.size();
                    for (Agent nextDefence : nextToDefend) {
                        if (nextDefence.getProtection() + eachDefence >= 1) {
                            // Again, if increasing protection by the calculated amount will take protection over 1,
                            // take the defence up to 1.0 and then redistribute remaining quota.
                            strategy[nextDefence.getVertex()] = 1 - nextDefence.getProtection();
                            eachDefence =
                                    (totalDefence - strategy[nextDefence.getVertex()]) / (nextToDefend.size() - 1);
                            agents.get(nextDefence.getVertex()).setState(State.PROTECTED);
                            // Remove any fully defended agents from the susceptible list
                            susceptibleAgents.remove(nextDefence);
                        } else strategy[nextDefence.getVertex()] += eachDefence;
                    }
                    // Recalculate the sum of the strategy elements to see if we've played entire defence quota
                    sum = 0;
                    for (double v : strategy) sum += v;
                }
            }
        }

        // Get the currently infected vertices, so we can re-calculate peril and assign states.
        int[] fires = new int[this.getNumVertices()];
        List<Agent> onFire = this.getInfected();
        int k = 0;
        for (Agent infected : onFire) {
            fires[k++] = infected.getVertex();
        }
        fires = Arrays.copyOf(fires, k);

        for (int j = 0; j < this.getNumVertices(); j++) {
            agents.get(j).setProtection(agents.get(j).getProtection() + strategy[j]);
            agents.get(j).setState(this.findState(agents.get(j), fires));
        }

        return strategy;
    }

    private List<Agent> findHighestDegree() {
        List<Agent> susceptibleAgents =
                this.getAgents().stream().filter(
                        agent -> agent.getState() == State.SUSCEPTIBLE).collect(Collectors.toList());

        List<Agent> highestDegrees = new ArrayList<>();

        int highestDegree = 0;
        for (Agent agent : susceptibleAgents) {
            int thisDegree = Graph.findDegree(this.graph, agent.getVertex());
            if (thisDegree > highestDegree) {
                highestDegree = thisDegree;
            }
        }
        for (Agent agent : susceptibleAgents) {
            int thisDegree = Graph.findDegree(this.graph, agent.getVertex());
            if (thisDegree == highestDegree) {
                highestDegrees.add(agent);
            }
        }

        // Tie-breaker: if we have more than one vertex with highest degree in the graph,
        // Choose the agent with greatest peril rating and defend that one.
        if (highestDegrees.size() > 1) {
            double greatestPeril = 0.0;
            for (Agent agent : highestDegrees) {
                if (agent.getPeril() > greatestPeril) greatestPeril = agent.getPeril();
            }
            for (Agent agent : highestDegrees) {
                if (agent.getPeril() == greatestPeril) {
                    // There may be more than one suitable candidate - select the
                    // lexicographically first vertex to defend relative agent.
                    highestDegrees.clear();
                    highestDegrees.add(agent);
                    break;
                }
            }
        }
        return highestDegrees;
    }

    /**
     * In order to determine a reasonable defence, we need to find the agent at highest peril currently. There may be
     * more than one at this same peril value (e.g. 1.0 is quite a common peril, when an agent is directly adjacent to
     * an infected agent), so we find all agents with the highest peril and choose which one to return as the agent to
     * defend by determining which of the choices has the highest degree. If there is more than one such candidate, we
     * select the lexicographically first agent.
     *
     * @return the agent or agents with highest peril from the given list of susceptible agents.
     */
    private List<Agent> findHighestPeril() {
        List<Agent> susceptibleAgents =
                this.getAgents().stream().filter(
                        agent -> agent.getState() == State.SUSCEPTIBLE).collect(Collectors.toList());
        List<Agent> toDefend = new ArrayList<>();
        // Find the agent or agents with highest peril rating(s) in order to increase their protection.
        double highestPeril = 0.0;
        for (Agent agent : susceptibleAgents) {
            if (agent.getPeril() > highestPeril) {
                highestPeril = agent.getPeril();
            }
        }
        for (Agent agent : susceptibleAgents) {
            if (agent.getPeril() == highestPeril) {
                toDefend.add(agent);
            }
        }

        // Tie-breaker: if we have more than one vertex with highest peril rating in the model,
        // Choose the agent at vertex with greatest degree and defend that one.
        if (toDefend.size() > 1) {
            int highestDegree = 0;
            for (Agent agent : toDefend) {
                int thisDegree = Graph.findDegree(this.graph, agent.getVertex());
                if (thisDegree > highestDegree) highestDegree = thisDegree;
            }
            for (Agent agent : toDefend) {
                int thisDegree = Graph.findDegree(this.graph, agent.getVertex());
                if (thisDegree == highestDegree) {
                    // There may be more than one suitable candidate - select the
                    // lexicographically first vertex to defend relative agent.
                    toDefend.clear();
                    toDefend.add(agent);
                    break;
                }
            }
        }
        return toDefend;
    }

    /**
     * Some defence strategies may be deployed to the highest protection-rated vertex, moving downwards until we no
     * longer have protection to deploy.
     *
     * @return the agent or agents with highest protection rating from the currently susceptible agents.
     */
    private List<Agent> findHighestProtection() {
        List<Agent> susceptibleAgents =
                this.getAgents().stream().filter(
                        agent -> agent.getState() == State.SUSCEPTIBLE).collect(Collectors.toList());

        List<Agent> highestProtection = new ArrayList<>();
        // Cycle through all agents, reassign highest protection value everytime we find a greater protection rating
        double highProtection = 0.0;
        for (Agent agent : susceptibleAgents) {
            if (agent.getProtection() > highProtection) {
                highProtection = agent.getProtection();
            }
        }
        // Add any agent/agents with the highest protection rating to the list to return
        for (Agent agent : susceptibleAgents) {
            if (agent.getProtection() == highProtection) {
                highestProtection.add(agent);
            }
        }
        return highestProtection;
    }

    /**
     * Given a rate (probability) of infection, we determine which susceptible vertices contract the infection from any
     * infected neighbours.
     *
     * @param probabilityOfInfection the probability with which the infection spreads.
     * @return the vertices that the method determines should be burned.
     */
    public List<Agent> findNextBurning(double probabilityOfInfection) {
        // Find the currently infected (burning) vertices
        List<Agent> infectedAgents = this.getInfected();
        // Find the susceptible agents (the only agents we could infect).
        List<Agent> susceptibleAgents = this.getSusceptible();

        List<Agent> toInfect = new ArrayList<>();
        for (Agent susceptibleAgent : susceptibleAgents) {
            for (Agent infectedAgent : infectedAgents) {
                if (getGraph().isEdge(susceptibleAgent.getVertex(), infectedAgent.getVertex())) {
                    if (willInfect(probabilityOfInfection, susceptibleAgent.getProtection())) {
                        toInfect.add(susceptibleAgent);
                    }
                }
            }
        }
        toInfect.forEach(agent -> agent.setState(State.INFECTED));
        return toInfect.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Given a probability of infection and the defence rating of the susceptible vertex that that may become infected,
     * determines whether it will be infected.
     *
     * @param probInfection the probability with which the infection propagates.
     * @param defence       the protection rating of the susceptible agent in peril.
     * @return whether the agent becomes infected or not.
     */
    public boolean willInfect(double probInfection, double defence) {
        return (2 - probInfection - (1 - defence) < 1);
    }

    /**
     * Being a graph (or network) model, we associate each model with a graph object (using the graph class). The graph
     * a given model utilises is saved and stored as an attribute of the model, hence the use of getters and setters to
     * access it.
     *
     * @return the graph on which the model is based.
     */
    public Graph getGraph() {
        return graph;
    }

    /**
     * Setter used to set a graph to the model attribute - that is, to store a graph object that we instantiate as a
     * permanent attribute to the model we are working on.
     *
     * @param graph the graph to associate as an attribute to the current model.
     */
    @SuppressWarnings("unused")
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    /**
     * We maintain a list of agents, one per vertex, that form the basis of the model. Each agent has the usual
     * attributes of an agent object: a vertex (where it lives), a peril rating, a protection rating and a state
     * (susceptible, infected, recovered or protected).
     *
     * @return the current list of agents.
     */
    public List<Agent> getAgents() {
        return this.agents;
    }

    /**
     * We set the list of agents by creating a new agent for each vertex and setting peril and protection initially to
     * zero and state to susceptible. We then go on to assign the actual ratings and states to each agent once we
     * initialise the graph and decide on a vertex location for the outbreak to begin at. This method is called only
     * once, at the start of the method when we do not have an instance of the field yet.
     *
     * @param numVertices the number of vertices in the graph model.
     * @return the list of agents we have created.
     */
    private List<Agent> assignAgents(int numVertices) {
        List<Agent> agents = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            agents.add(new Agent(i, 0.0, 0.0, State.SUSCEPTIBLE));
        }
        this.agents = agents;
        return agents;
    }

    private void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    /**
     * An important piece of information in the model is the number of vertices in the graph. This informs how many
     * agents we need to generate to inhabit each vertex and the range of values we can select from to begin the
     * outbreak.
     *
     * @return the assigned number of vertices in the graph model.
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * Several methods benefit from having access to a List of only the susceptible vertices, such as determining the
     * next defence strategy or which vertices contract the infection in the next time step. This method returns a List
     * of all currently susceptible vertices.
     *
     * @return all agents currently in the susceptible state, as a list of agents.
     */
    public List<Agent> getSusceptible() {
        List<Agent> agents = this.getAgents();
        List<Agent> susceptibleAgents = new ArrayList<>();

        for (Agent agent : agents) {
            if (agent.getState() == State.SUSCEPTIBLE)
                susceptibleAgents.add(agent);
        }
        return susceptibleAgents;
    }

    /**
     * In order to monitor and analyse the progression of the model, we need to be able to view which vertices are in
     * each state - this method returns the agents currently infected by the contagion.
     *
     * @return the currently infected agents, as a list of agents.
     */
    public List<Agent> getInfected() {
        List<Agent> agents = this.getAgents();
        List<Agent> infectedAgents = new ArrayList<>();

        for (Agent agent : agents) {
            if (agent.getState() == State.INFECTED)
                infectedAgents.add(agent);
        }
        return infectedAgents;
    }

    /**
     * In order to monitor and analyse the progression of the model, we need to be able to view which vertices are in
     * each state - this method returns the agents that are currently recovered from the contagion, allowing us to
     * attribute to them some (potentially zero) increase in protection due to some level of immunity, where
     * appropriate.
     *
     * @return the currently recovered agents, as a list of agents.
     */
    public List<Agent> getRecovered() {
        List<Agent> agents = this.getAgents();
        List<Agent> recoveredAgents = new ArrayList<>();

        for (Agent agent : agents) {
            if (agent.getState() == State.RECOVERED)
                recoveredAgents.add(agent);
        }
        return recoveredAgents;
    }

    /**
     * In order to monitor and analyse the progression of the model, we need to be able to view which vertices are in
     * each state - this method returns the currently protected vertices. These are agents who either have a protection
     * rating of 1.0 (and can thereby not contract the infection) or have no path on the graph to any currently infected
     * vertex.
     *
     * @return the currently protected vertices, as a list of agents.
     */
    public List<Agent> getProtected() {
        List<Agent> agents = this.getAgents();
        List<Agent> protectedAgents = new ArrayList<>();

        for (Agent agent : agents) {
            if (agent.getState() == State.PROTECTED)
                protectedAgents.add(agent);
        }
        return protectedAgents;
    }

    /**
     * Cycles through the agents list field and prints them to the standard output. Used for testing purposes.
     */
    private void printAgents() {
        List<Agent> agents = this.getAgents();
        agents.stream().map(agent -> "* " + agent).forEach(StdOut::println);
    }

    /**
     * Prints arrays to the standard output that contain the vertices of the currently susceptible, infected, recovered
     * and protected vertices in order to verify that the model is working as expected.
     */
    private void printSIRP() {
        StdOut.println();
        // Get the vertex locations of currently susceptible agents.
        int[] susceptible = new int[this.getSusceptible().size()];
        Arrays.setAll(susceptible, i -> this.getSusceptible().get(i).getVertex());
        // Get the vertex locations of currently infected agents.
        int[] infected = new int[this.getInfected().size()];
        Arrays.setAll(infected, i -> this.getInfected().get(i).getVertex());
        // Get the vertex locations of currently recovered agents.
        int[] recovered = new int[this.getRecovered().size()];
        Arrays.setAll(recovered, i -> this.getRecovered().get(i).getVertex());
        // Get the vertex locations of currently protected agents.
        int[] defended = new int[this.getProtected().size()];
        Arrays.setAll(defended, i -> this.getProtected().get(i).getVertex());

        // Print each array, as found above, to the standard output
        // to monitor progression of the model.
        StdOut.println(" * S: " + Arrays.toString(susceptible)
                + "\n * I: " + Arrays.toString(infected)
                + "\n * R: " + Arrays.toString(recovered)
                + "\n * P: " + Arrays.toString(defended));
    }

    /**
     * Runs a test model, with a particular graph and outbreak, so that we can test and monitor the behaviours of each
     * method and verify that the model runs as expected by printing to a file in a human-readable way.
     *
     * @param totalDefence           the total amount of protection improvement that can be distributed to susceptible
     *                               vertices each defensive turn.
     * @param probabilityOfInfection the probability with which the infection propagates.
     * @param whichDefence           the choice of defence strategy.
     */
    private String runReadableTest(double totalDefence, double probabilityOfInfection, int whichDefence) {
        StringBuilder s = new StringBuilder();
        switch (whichDefence) {
            case PROXIMITY -> {
                StdOut.println("\n#### Proximity to Infection Defence\n");
                s.append("PROXIMITY, ");
            }
            case DEGREE -> {
                StdOut.println("\n#### Greatest Degree Defence\n");
                s.append("DEGREE, ");
            }
            case PROTECTION -> {
                StdOut.println("\n#### Cheapest Protection Increase Defence\n");
                s.append("PROTECTION, ");
            }
        }
        this.printSIRP();
        int turn = 0;
        while (true) {
            if (!this.getSusceptible().isEmpty()) {
                // Print the strategy we performed. Each increase is to
                // 2 dp when printed, but maintains full length in usage.
                double[] strategy = this.runDefence(totalDefence, whichDefence);
                double[] strategyToPrint = new double[strategy.length];
                DecimalFormat df = new DecimalFormat("0.00");
                int i = 0;
                for (double d : strategy) strategyToPrint[i++] = Double.parseDouble(df.format(d));
                StdOut.println("\n_Strategy:_ " + Arrays.toString(strategyToPrint) + "\n");
                this.printSIRP();
                turn++;
            } else {
                StdOut.print("\n__Nothing more to protect.__\nEnding model with "
                        + this.getProtected().size() + " protected and "
                        + this.getInfected().size() + " infected vertices in "
                        + turn);
                StdOut.print(turn == 1 ? " turn.\n" : " turns.\n");
                break;
            }
            if (!this.getSusceptible().isEmpty()) {
                List<Agent> toInfect = this.findNextBurning(probabilityOfInfection);
                if (!toInfect.isEmpty()) {
                    StdOut.print("\n_Infecting:_ ");
                    for (Agent agent : toInfect) {
                        StdOut.print(agent.getVertex() + " ");
                    }
                    StdOut.println();
                } else {
                    StdOut.println("\n_Nothing infected._");
                }
                this.printSIRP();
                turn++;
            } else {
                StdOut.print("\n__Nothing more to infect.__\nEnding model with "
                        + this.getProtected().size() + " protected and "
                        + this.getInfected().size() + " infected vertices in "
                        + turn);
                StdOut.print(turn == 1 ? " turn.\n" : " turns.\n");
                break;
            }
        }
        s.append(turn).append(", ").append(this.getProtected().size()).append(", ").append(this.getInfected().size());
        return String.valueOf(s);
    }

}
