# Agency-based contagion modelling

This repo contains code for an agency-centred network model of infectious disease (or similar contagion). There are a
number of variable parameters in this project, which can be varied automatically for otherwise identical models, and the
results of each change can be compared in the output.

## Graph

The graph is the first step in creating a model in this project. The model uses vertices (noes) to represent individuals
between whom the disease can spread provided there is an edge between two vertices. There is a `GraphGenerator` class in
the model that can be used to (pseudo-randomly) generate graphs of the following types:

* Simple,
* Erdős–Rényi,
* Complete,
* Bipartite,
* Complete bipartite,
* Erdős–Rényi bipartite,
* Path,
* Binary tree
* Cycle,
* Eulerian path,
* Eulerian cycle,
* Wheel,
* Star,
* Regular,
* Tree.

A graph object stores (as an attribute) the random seed used to generate the values which, in turn, generated the random
graph. Each graph object also has an associated number of vertices, number of edges and adjacency matrix stored as
attributes.

## Agents

Each agent in the model is the occupant of a vertex of the graph associated with the model. The vertex location of each
agent object is stored as an attribute of the agent. The other attributes of each agent are the peril and protection
ratings and the state they occupy. Peril is a measure of proximity to the closest infection (in the future, I aim to
make this 'proximity to _all_ infections') and represents the danger the given agent is currently in, as a number
between 0 (no danger) and 1 (immediate danger). The protection rating is one of the most important factors in this
agency-centred formulation - it represents how much a given agent is protected from contraction. In the context of
infectious disease, this could be related to how many people they usually see, and the steps they take to maintain hand
hygiene, mask wearing practices and so on. In this project, initial protection can be determined in one of three ways:

* Randomly - each agent is assigned a (pseudo-)random number representing their degree of protection from the contagion.
* Deterministically - the protection rating is simply the peril rating, representing the case of agents increasing their
  personal protective measures the closer infection is to them.
* Mixed - protection is allocated based partially on a baseline (pseudo-)random number and then increased based on
  proximity to the closest infection, to add some more realistic variation to the deterministic approach.

The state an agent is in can change throughout the model: at the moment, the states in use are:

* Susceptible - the agent may contract the contagion.
* Infected - the agent is currently infected with the contagion.
* Protected - the agent is currently unable to contract the disease because, for instance, their protection rating has
  been increased to 1 or there is no path of infection between them and an infected agent in the graph.

In the future, I will make use of:

* Recovered - the agent has been infected by the contagion, has recovered and therefore cannot contract again for some
  set period of time (possibly indefinitely).

## Modelling

When the model is run, some parameters are set - the number of vertices for the graph, the number of edges and/or a
probability for random graph generation if required, and the number of graphs to generate if we wish to run a
multi-graph test. Then, we can run identical models for each protection allocation method, which in turn run identical
models for each defence strategy, which involves setting each vertex in the graph as the outbreak of the contagion in
turn, implementing the relevant defence strategy, determining infections (with a variable probability of infection) and
repeating until either nothing can be infected or nothing can be defended. The results of each model are outputted as a
CSV file for machine-readable data and (if the graphs are small enough) a markdown human-readable file to understand
more granular information about how the model ran (i.e. including the defence implementation in each defensive round,
and the infections that subsequently occurred). Then, a CSV reader class has been written to analyse the data files and
determine the winning strategy for each model. If we are running multi-graph experiments, we then read back in this
winning strategy data and keep track for each type of protection allocation how many times on the given graph each
defence strategy won. By 'win', we mean the following: the winning strategy (or strategies) for a given model (which is
the full run from initial outbreak to nothing more can be infected or defended on a particular graph with a specific
protection allocation) is the strategy (or strategies) which resulted in the fewest infected agents and the most
protected agents in the shortest time (the smallest end-turn, where a turn is either a defence strategy implementation
or infection attempt). 