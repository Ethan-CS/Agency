# Readable results of SIRP defence strategies on a random graph
## Generating Eulerian Path Graph:

Graph generator has generated the specified graph with the following parameters:

 * Type of graph: Eulerian Path
 * Number of vertices: 20
 * Number of edges: 20
 * Probability: 20 / (20 * (20 - 1) / 2) = 0.11
 * Random generator seed: 1615508033045

The graph is represented using the following adjacency matrix:

0: 0 0 1 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 

1: 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 

2: 1 0 0 0 1 0 1 0 0 0 0 0 0 1 0 0 0 0 1 0 

3: 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 

4: 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 

5: 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 

6: 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 

7: 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 

8: 1 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 0 

9: 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 1 0 0 0 

10: 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 

11: 0 0 0 0 0 0 1 0 0 1 1 0 0 0 0 0 0 0 0 0 

12: 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 

13: 0 0 1 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 

14: 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 1 0 0 0 

15: 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 

16: 0 0 0 0 0 0 0 0 0 1 0 0 0 0 1 0 0 0 1 0 

17: 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 

18: 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 

19: 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 


## Model values
The values used in the model are:
 * Total defence quota each turn: 1.0
 * Probability with which the infection propagates: 1.0
## Outbreak: 0
* Agent at vertex 0: peril 1.00, protection 0.47 and state INFECTED.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 1.00, protection 0.00 and state SUSCEPTIBLE.* Agent at vertex 3: peril 0.25, protection 0.62 and state SUSCEPTIBLE.* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.50, protection 0.23 and state SUSCEPTIBLE.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 1.00, protection 0.22 and state SUSCEPTIBLE.* Agent at vertex 9: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 10: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.33, protection 0.82 and state SUSCEPTIBLE.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 14: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 17: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [2, 3, 6, 8, 11]
 * I: [0]
 * R: []
 * P: [1, 4, 5, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3, 6, 8, 11]
 * I: [0]
 * R: []
 * P: [1, 2, 4, 5, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Infecting:_ 8 

 * S: [3, 6, 11]
 * I: [0, 8]
 * R: []
 * P: [1, 2, 4, 5, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.05, 0.0, 0.0, 0.77, 0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3]
 * I: [0, 8]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [3]
 * I: [0, 8]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.33, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [0, 8]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 18 protected and 2 infected vertices in 5 turns.


#### Greatest Degree Defence

 * S: [2, 3, 6, 8, 11]
 * I: [0]
 * R: []
 * P: [1, 4, 5, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3, 6, 8, 11]
 * I: [0]
 * R: []
 * P: [1, 2, 4, 5, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Infecting:_ 8 

 * S: [3, 6, 11]
 * I: [0, 8]
 * R: []
 * P: [1, 2, 4, 5, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.05, 0.0, 0.0, 0.77, 0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3]
 * I: [0, 8]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [3]
 * I: [0, 8]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.33, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [0, 8]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 18 protected and 2 infected vertices in 5 turns.


#### Highest Protection Defence

 * S: [2, 3, 6, 8, 11]
 * I: [0]
 * R: []
 * P: [1, 4, 5, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.38, 0.0, 0.0, 0.44, 0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [2, 6, 8]
 * I: [0]
 * R: []
 * P: [1, 3, 4, 5, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Infecting:_ 2 8 

 * S: [6]
 * I: [0, 2, 8]
 * R: []
 * P: [1, 3, 4, 5, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.33, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [0, 2, 8]
 * R: []
 * P: [1, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 17 protected and 3 infected vertices in 3 turns.


## Outbreak: 1
* Agent at vertex 0: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 1: peril 1.00, protection 0.55 and state INFECTED.* Agent at vertex 2: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 3: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 9: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 10: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 14: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 17: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: []
 * I: [1]
 * R: []
 * P: [0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


#### Greatest Degree Defence

 * S: []
 * I: [1]
 * R: []
 * P: [0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


#### Highest Protection Defence

 * S: []
 * I: [1]
 * R: []
 * P: [0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


## Outbreak: 2
* Agent at vertex 0: peril 1.00, protection 0.90 and state SUSCEPTIBLE.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 1.00, protection 0.25 and state INFECTED.* Agent at vertex 3: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 1.00, protection 0.31 and state SUSCEPTIBLE.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 1.00, protection 0.55 and state SUSCEPTIBLE.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.50, protection 0.84 and state SUSCEPTIBLE.* Agent at vertex 9: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 10: peril 0.33, protection 0.00 and state SUSCEPTIBLE.* Agent at vertex 11: peril 0.50, protection 0.79 and state SUSCEPTIBLE.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 1.00, protection 0.27 and state SUSCEPTIBLE.* Agent at vertex 14: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 17: peril 0.50, protection 0.97 and state SUSCEPTIBLE.* Agent at vertex 18: peril 1.00, protection 0.16 and state SUSCEPTIBLE.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [0, 4, 6, 8, 10, 11, 13, 17, 18]
 * I: [2]
 * R: []
 * P: [1, 3, 5, 7, 9, 12, 14, 15, 16, 19]
_Strategy:_ [0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.06, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.84, 0.0]

 * S: [4, 6, 8, 10, 11, 13, 17]
 * I: [2]
 * R: []
 * P: [0, 1, 3, 5, 7, 9, 12, 14, 15, 16, 18, 19]
_Infecting:_ 4 6 13 

 * S: [8, 10, 11, 17]
 * I: [2, 4, 6, 13]
 * R: []
 * P: [0, 1, 3, 5, 7, 9, 12, 14, 15, 16, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.16, 0.0, 0.6, 0.21, 0.0, 0.0, 0.0, 0.0, 0.0, 0.03, 0.0, 0.0]

 * S: [10]
 * I: [2, 4, 6, 13]
 * R: []
 * P: [0, 1, 3, 5, 7, 8, 9, 11, 12, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [10]
 * I: [2, 4, 6, 13]
 * R: []
 * P: [0, 1, 3, 5, 7, 8, 9, 11, 12, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.39, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [2, 4, 6, 13]
 * R: []
 * P: [0, 1, 3, 5, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 16 protected and 4 infected vertices in 5 turns.


#### Greatest Degree Defence

 * S: [0, 4, 6, 8, 10, 11, 13, 17, 18]
 * I: [2]
 * R: []
 * P: [1, 3, 5, 7, 9, 12, 14, 15, 16, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.16, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.84, 0.0]

 * S: [0, 4, 6, 10, 11, 13, 17]
 * I: [2]
 * R: []
 * P: [1, 3, 5, 7, 8, 9, 12, 14, 15, 16, 18, 19]
_Infecting:_ 0 4 6 13 

 * S: [10, 11, 17]
 * I: [0, 2, 4, 6, 13]
 * R: []
 * P: [1, 3, 5, 7, 8, 9, 12, 14, 15, 16, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.76, 0.2, 0.0, 0.0, 0.0, 0.0, 0.0, 0.03, 0.0, 0.0]

 * S: [10]
 * I: [0, 2, 4, 6, 13]
 * R: []
 * P: [1, 3, 5, 7, 8, 9, 11, 12, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [10]
 * I: [0, 2, 4, 6, 13]
 * R: []
 * P: [1, 3, 5, 7, 8, 9, 11, 12, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.23, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [0, 2, 4, 6, 13]
 * R: []
 * P: [1, 3, 5, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 15 protected and 5 infected vertices in 5 turns.


#### Highest Protection Defence

 * S: [0, 4, 6, 8, 10, 11, 13, 17, 18]
 * I: [2]
 * R: []
 * P: [1, 3, 5, 7, 9, 12, 14, 15, 16, 19]
_Strategy:_ [0.1, 0.0, 0.0, 0.0, 0.04, 0.0, 0.45, 0.0, 0.16, 0.0, 0.0, 0.21, 0.0, 0.0, 0.0, 0.0, 0.0, 0.03, 0.0, 0.0]

 * S: [4, 10, 13, 18]
 * I: [2]
 * R: []
 * P: [0, 1, 3, 5, 6, 7, 8, 9, 11, 12, 14, 15, 16, 17, 19]
_Infecting:_ 4 13 18 

 * S: [10]
 * I: [2, 4, 13, 18]
 * R: []
 * P: [0, 1, 3, 5, 6, 7, 8, 9, 11, 12, 14, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [2, 4, 13, 18]
 * R: []
 * P: [0, 1, 3, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 19]
__Nothing more to infect.__
Ending model with 16 protected and 4 infected vertices in 3 turns.


## Outbreak: 3
* Agent at vertex 0: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.33, protection 0.45 and state SUSCEPTIBLE.* Agent at vertex 3: peril 1.00, protection 0.35 and state INFECTED.* Agent at vertex 4: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.20, protection 0.80 and state SUSCEPTIBLE.* Agent at vertex 9: peril 0.25, protection 0.89 and state SUSCEPTIBLE.* Agent at vertex 10: peril 0.17, protection 0.07 and state SUSCEPTIBLE.* Agent at vertex 11: peril 0.20, protection 1.00 and state PROTECTED.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.25, protection 0.64 and state SUSCEPTIBLE.* Agent at vertex 14: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 17: peril 1.00, protection 0.86 and state SUSCEPTIBLE.* Agent at vertex 18: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [2, 8, 9, 10, 13, 17]
 * I: [3]
 * R: []
 * P: [0, 1, 4, 5, 6, 7, 11, 12, 14, 15, 16, 18, 19]
_Strategy:_ [0.0, 0.0, 0.55, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.11, 0.0, 0.0, 0.0, 0.19, 0.0, 0.0, 0.0, 0.14, 0.0, 0.0]

 * S: [8, 10, 13]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 9, 11, 12, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [8, 10, 13]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 9, 11, 12, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.2, 0.0, 0.63, 0.0, 0.0, 0.17, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [10]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [10]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.3, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 5 turns.


#### Greatest Degree Defence

 * S: [2, 8, 9, 10, 13, 17]
 * I: [3]
 * R: []
 * P: [0, 1, 4, 5, 6, 7, 11, 12, 14, 15, 16, 18, 19]
_Strategy:_ [0.0, 0.0, 0.55, 0.0, 0.0, 0.0, 0.0, 0.0, 0.2, 0.11, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.14, 0.0, 0.0]

 * S: [9, 10, 13]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 11, 12, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [9, 10, 13]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 11, 12, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.01, 0.63, 0.0, 0.0, 0.36, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [10]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [10]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.3, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 5 turns.


#### Highest Protection Defence

 * S: [2, 8, 9, 10, 13, 17]
 * I: [3]
 * R: []
 * P: [0, 1, 4, 5, 6, 7, 11, 12, 14, 15, 16, 18, 19]
_Strategy:_ [0.0, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.2, 0.11, 0.0, 0.0, 0.0, 0.36, 0.0, 0.0, 0.0, 0.14, 0.0, 0.0]

 * S: [2, 10]
 * I: [3]
 * R: []
 * P: [0, 1, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [2, 10]
 * I: [3]
 * R: []
 * P: [0, 1, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.37, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.63, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [10]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [10]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.3, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 5 turns.


## Outbreak: 4
* Agent at vertex 0: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 1.00, protection 0.84 and state SUSCEPTIBLE.* Agent at vertex 3: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 1.00, protection 0.54 and state INFECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.33, protection 0.16 and state SUSCEPTIBLE.* Agent at vertex 9: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 10: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.33, protection 0.83 and state SUSCEPTIBLE.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.50, protection 0.54 and state SUSCEPTIBLE.* Agent at vertex 14: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 17: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.50, protection 0.06 and state SUSCEPTIBLE.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [2, 8, 11, 13, 18]
 * I: [4]
 * R: []
 * P: [0, 1, 3, 5, 6, 7, 9, 10, 12, 14, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.16, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.84, 0.0]

 * S: [8, 11, 13, 18]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 9, 10, 12, 14, 15, 16, 17, 19]
_Nothing infected._
 * S: [8, 11, 13, 18]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 9, 10, 12, 14, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.44, 0.0, 0.0, 0.0, 0.0, 0.46, 0.0, 0.0, 0.0, 0.0, 0.1, 0.0]

 * S: [8, 11]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [8, 11]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.41, 0.0, 0.0, 0.17, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 5 turns.


#### Greatest Degree Defence

 * S: [2, 8, 11, 13, 18]
 * I: [4]
 * R: []
 * P: [0, 1, 3, 5, 6, 7, 9, 10, 12, 14, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.16, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.84, 0.0]

 * S: [8, 11, 13, 18]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 9, 10, 12, 14, 15, 16, 17, 19]
_Nothing infected._
 * S: [8, 11, 13, 18]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 9, 10, 12, 14, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.84, 0.0, 0.0, 0.05, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.0]

 * S: [11, 13]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [11, 13]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.12, 0.0, 0.46, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 5 turns.


#### Highest Protection Defence

 * S: [2, 8, 11, 13, 18]
 * I: [4]
 * R: []
 * P: [0, 1, 3, 5, 6, 7, 9, 10, 12, 14, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.16, 0.0, 0.0, 0.0, 0.0, 0.0, 0.21, 0.0, 0.0, 0.17, 0.0, 0.46, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [8, 18]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19]
_Nothing infected._
 * S: [8, 18]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.64, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.36, 0.0]

 * S: [18]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19]
_Nothing infected._
 * S: [18]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.58, 0.0]

 * S: []
 * I: [4]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 5 turns.


## Outbreak: 5
* Agent at vertex 0: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 3: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 1.00, protection 0.78 and state INFECTED.* Agent at vertex 6: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 9: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 10: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 14: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 17: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: []
 * I: [5]
 * R: []
 * P: [0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


#### Greatest Degree Defence

 * S: []
 * I: [5]
 * R: []
 * P: [0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


#### Highest Protection Defence

 * S: []
 * I: [5]
 * R: []
 * P: [0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


## Outbreak: 6
* Agent at vertex 0: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 1.00, protection 0.86 and state SUSCEPTIBLE.* Agent at vertex 3: peril 0.25, protection 0.30 and state SUSCEPTIBLE.* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 1.00, protection 0.93 and state INFECTED.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.33, protection 0.52 and state SUSCEPTIBLE.* Agent at vertex 9: peril 0.50, protection 0.76 and state SUSCEPTIBLE.* Agent at vertex 10: peril 0.50, protection 0.15 and state SUSCEPTIBLE.* Agent at vertex 11: peril 1.00, protection 0.45 and state SUSCEPTIBLE.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.50, protection 0.62 and state SUSCEPTIBLE.* Agent at vertex 14: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.33, protection 0.51 and state SUSCEPTIBLE.* Agent at vertex 17: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.50, protection 0.16 and state SUSCEPTIBLE.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [2, 3, 8, 9, 10, 11, 13, 16, 18]
 * I: [6]
 * R: []
 * P: [0, 1, 4, 5, 7, 12, 14, 15, 17, 19]
_Strategy:_ [0.0, 0.0, 0.14, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.55, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.31, 0.0]

 * S: [3, 8, 9, 10, 13, 16, 18]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 11, 12, 14, 15, 17, 19]
_Nothing infected._
 * S: [3, 8, 9, 10, 13, 16, 18]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 11, 12, 14, 15, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.24, 0.0, 0.0, 0.0, 0.23, 0.0, 0.0, 0.0, 0.0, 0.54, 0.0]

 * S: [3, 8, 10, 13, 16]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 9, 11, 12, 14, 15, 17, 18, 19]
_Nothing infected._
 * S: [3, 8, 10, 13, 16]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 9, 11, 12, 14, 15, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.85, 0.0, 0.0, 0.15, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3, 8, 16]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19]
_Nothing infected._
 * S: [3, 8, 16]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.03, 0.0, 0.0, 0.0, 0.0, 0.48, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.49, 0.0, 0.0, 0.0]

 * S: [3]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [3]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.68, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [6]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 9 turns.


#### Greatest Degree Defence

 * S: [2, 3, 8, 9, 10, 11, 13, 16, 18]
 * I: [6]
 * R: []
 * P: [0, 1, 4, 5, 7, 12, 14, 15, 17, 19]
_Strategy:_ [0.0, 0.0, 0.14, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.55, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.31, 0.0]

 * S: [3, 8, 9, 10, 13, 16, 18]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 11, 12, 14, 15, 17, 19]
_Nothing infected._
 * S: [3, 8, 9, 10, 13, 16, 18]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 11, 12, 14, 15, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.46, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.54, 0.0]

 * S: [3, 8, 9, 10, 13, 16]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 11, 12, 14, 15, 17, 18, 19]
_Nothing infected._
 * S: [3, 8, 9, 10, 13, 16]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 11, 12, 14, 15, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.02, 0.24, 0.0, 0.0, 0.0, 0.25, 0.0, 0.0, 0.49, 0.0, 0.0, 0.0]

 * S: [3, 10, 13]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 8, 9, 11, 12, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [3, 10, 13]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 8, 9, 11, 12, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.03, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.85, 0.0, 0.0, 0.12, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [3]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.68, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [6]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 9 turns.


#### Highest Protection Defence

 * S: [2, 3, 8, 9, 10, 11, 13, 16, 18]
 * I: [6]
 * R: []
 * P: [0, 1, 4, 5, 7, 12, 14, 15, 17, 19]
_Strategy:_ [0.0, 0.0, 0.14, 0.0, 0.0, 0.0, 0.0, 0.0, 0.25, 0.24, 0.0, 0.0, 0.0, 0.38, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3, 8, 10, 11, 16, 18]
 * I: [6]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 9, 12, 13, 14, 15, 17, 19]
_Infecting:_ 11 

 * S: [3, 8, 10, 16, 18]
 * I: [6, 11]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 9, 12, 13, 14, 15, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.27, 0.0, 0.0, 0.0, 0.0, 0.24, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.49, 0.0, 0.0, 0.0]

 * S: [3, 10, 18]
 * I: [6, 11]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 8, 9, 12, 13, 14, 15, 16, 17, 19]
_Infecting:_ 10 

 * S: [3, 18]
 * I: [6, 10, 11]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 8, 9, 12, 13, 14, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.43, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.57, 0.0]

 * S: [18]
 * I: [6, 10, 11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 8, 9, 12, 13, 14, 15, 16, 17, 19]
_Nothing infected._
 * S: [18]
 * I: [6, 10, 11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 8, 9, 12, 13, 14, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.27, 0.0]

 * S: []
 * I: [6, 10, 11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 8, 9, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 17 protected and 3 infected vertices in 7 turns.


## Outbreak: 7
* Agent at vertex 0: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 3: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 7: peril 1.00, protection 0.99 and state INFECTED.* Agent at vertex 8: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 9: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 10: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 14: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 17: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: []
 * I: [7]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


#### Greatest Degree Defence

 * S: []
 * I: [7]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


#### Highest Protection Defence

 * S: []
 * I: [7]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


## Outbreak: 8
* Agent at vertex 0: peril 1.00, protection 0.54 and state SUSCEPTIBLE.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 3: peril 0.20, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 0.33, protection 0.75 and state SUSCEPTIBLE.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.33, protection 0.59 and state SUSCEPTIBLE.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 1.00, protection 0.34 and state INFECTED.* Agent at vertex 9: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 10: peril 0.20, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 1.00, protection 0.96 and state SUSCEPTIBLE.* Agent at vertex 14: peril 1.00, protection 0.04 and state SUSCEPTIBLE.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.50, protection 0.49 and state SUSCEPTIBLE.* Agent at vertex 17: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [0, 4, 6, 13, 14, 16]
 * I: [8]
 * R: []
 * P: [1, 2, 3, 5, 7, 9, 10, 11, 12, 15, 17, 18, 19]
_Strategy:_ [0.46, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.04, 0.51, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [4, 6, 14, 16]
 * I: [8]
 * R: []
 * P: [0, 1, 2, 3, 5, 7, 9, 10, 11, 12, 13, 15, 17, 18, 19]
_Infecting:_ 14 

 * S: [4, 6, 16]
 * I: [8, 14]
 * R: []
 * P: [0, 1, 2, 3, 5, 7, 9, 10, 11, 12, 13, 15, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.08, 0.0, 0.41, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.51, 0.0, 0.0, 0.0]

 * S: [4]
 * I: [8, 14]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [4]
 * I: [8, 14]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [8, 14]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 18 protected and 2 infected vertices in 5 turns.


#### Greatest Degree Defence

 * S: [0, 4, 6, 13, 14, 16]
 * I: [8]
 * R: []
 * P: [1, 2, 3, 5, 7, 9, 10, 11, 12, 15, 17, 18, 19]
_Strategy:_ [0.46, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.03, 0.0, 0.0, 0.51, 0.0, 0.0, 0.0]

 * S: [4, 6, 13, 14]
 * I: [8]
 * R: []
 * P: [0, 1, 2, 3, 5, 7, 9, 10, 11, 12, 15, 16, 17, 18, 19]
_Infecting:_ 13 14 

 * S: [4, 6]
 * I: [8, 13, 14]
 * R: []
 * P: [0, 1, 2, 3, 5, 7, 9, 10, 11, 12, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.25, 0.0, 0.41, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [8, 13, 14]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 17 protected and 3 infected vertices in 3 turns.


#### Highest Protection Defence

 * S: [0, 4, 6, 13, 14, 16]
 * I: [8]
 * R: []
 * P: [1, 2, 3, 5, 7, 9, 10, 11, 12, 15, 17, 18, 19]
_Strategy:_ [0.3, 0.0, 0.0, 0.0, 0.25, 0.0, 0.41, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.04, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [0, 14, 16]
 * I: [8]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 15, 17, 18, 19]
_Infecting:_ 0 14 

 * S: [16]
 * I: [0, 8, 14]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 15, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.51, 0.0, 0.0, 0.0]

 * S: []
 * I: [0, 8, 14]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 17 protected and 3 infected vertices in 3 turns.


## Outbreak: 9
* Agent at vertex 0: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.33, protection 0.19 and state SUSCEPTIBLE.* Agent at vertex 3: peril 0.25, protection 0.68 and state SUSCEPTIBLE.* Agent at vertex 4: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.50, protection 0.12 and state SUSCEPTIBLE.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 9: peril 1.00, protection 0.08 and state INFECTED.* Agent at vertex 10: peril 0.50, protection 0.53 and state SUSCEPTIBLE.* Agent at vertex 11: peril 1.00, protection 0.54 and state SUSCEPTIBLE.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.25, protection 0.58 and state SUSCEPTIBLE.* Agent at vertex 14: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 1.00, protection 0.47 and state SUSCEPTIBLE.* Agent at vertex 17: peril 0.33, protection 0.04 and state SUSCEPTIBLE.* Agent at vertex 18: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [2, 3, 6, 10, 11, 13, 16, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 4, 5, 7, 8, 12, 14, 15, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.01, 0.0, 0.0, 0.0, 0.0, 0.46, 0.0, 0.0, 0.0, 0.0, 0.53, 0.0, 0.0, 0.0]

 * S: [2, 3, 6, 10, 13, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 4, 5, 7, 8, 11, 12, 14, 15, 16, 18, 19]
_Nothing infected._
 * S: [2, 3, 6, 10, 13, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 4, 5, 7, 8, 11, 12, 14, 15, 16, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.87, 0.0, 0.0, 0.0, 0.13, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [2, 3, 10, 13, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 4, 5, 6, 7, 8, 11, 12, 14, 15, 16, 18, 19]
_Nothing infected._
 * S: [2, 3, 10, 13, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 4, 5, 6, 7, 8, 11, 12, 14, 15, 16, 18, 19]
_Strategy:_ [0.0, 0.0, 0.66, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.34, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [2, 3, 13, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 16, 18, 19]
_Nothing infected._
 * S: [2, 3, 13, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 16, 18, 19]
_Strategy:_ [0.0, 0.0, 0.15, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.85, 0.0, 0.0]

 * S: [3, 13, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 16, 18, 19]
_Nothing infected._
 * S: [3, 13, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 16, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.32, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.42, 0.0, 0.0, 0.0, 0.11, 0.0, 0.0]

 * S: []
 * I: [9]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 9 turns.


#### Greatest Degree Defence

 * S: [2, 3, 6, 10, 11, 13, 16, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 4, 5, 7, 8, 12, 14, 15, 18, 19]
_Strategy:_ [0.0, 0.0, 0.81, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.19, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3, 6, 10, 11, 13, 16, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 8, 12, 14, 15, 18, 19]
_Infecting:_ 11 16 

 * S: [3, 6, 10, 13, 17]
 * I: [9, 11, 16]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 8, 12, 14, 15, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.88, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.12, 0.0, 0.0]

 * S: [3, 10, 13, 17]
 * I: [9, 11, 16]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 12, 14, 15, 18, 19]
_Infecting:_ 10 

 * S: [3, 13, 17]
 * I: [9, 10, 11, 16]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 12, 14, 15, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.17, 0.0, 0.0, 0.0, 0.83, 0.0, 0.0]

 * S: [3, 13]
 * I: [9, 10, 11, 16]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 12, 14, 15, 17, 18, 19]
_Nothing infected._
 * S: [3, 13]
 * I: [9, 10, 11, 16]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 12, 14, 15, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.32, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.26, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [9, 10, 11, 16]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 12, 13, 14, 15, 17, 18, 19]
__Nothing more to infect.__
Ending model with 16 protected and 4 infected vertices in 7 turns.


#### Highest Protection Defence

 * S: [2, 3, 6, 10, 11, 13, 16, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 4, 5, 7, 8, 12, 14, 15, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.32, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.25, 0.0, 0.42, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [2, 6, 10, 11, 16, 17]
 * I: [9]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 8, 12, 13, 14, 15, 18, 19]
_Infecting:_ 11 16 

 * S: [2, 6, 10, 17]
 * I: [9, 11, 16]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 8, 12, 13, 14, 15, 18, 19]
_Strategy:_ [0.0, 0.0, 0.53, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.47, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [2, 6, 17]
 * I: [9, 11, 16]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 8, 10, 12, 13, 14, 15, 18, 19]
_Infecting:_ 6 

 * S: [2, 17]
 * I: [6, 9, 11, 16]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 8, 10, 12, 13, 14, 15, 18, 19]
_Strategy:_ [0.0, 0.0, 0.28, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.72, 0.0, 0.0]

 * S: [17]
 * I: [6, 9, 11, 16]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 8, 10, 12, 13, 14, 15, 18, 19]
_Nothing infected._
 * S: [17]
 * I: [6, 9, 11, 16]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 8, 10, 12, 13, 14, 15, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.24, 0.0, 0.0]

 * S: []
 * I: [6, 9, 11, 16]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 8, 10, 12, 13, 14, 15, 17, 18, 19]
__Nothing more to infect.__
Ending model with 16 protected and 4 infected vertices in 7 turns.


## Outbreak: 10
* Agent at vertex 0: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.33, protection 0.13 and state SUSCEPTIBLE.* Agent at vertex 3: peril 0.17, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.50, protection 0.28 and state SUSCEPTIBLE.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.20, protection 0.16 and state SUSCEPTIBLE.* Agent at vertex 9: peril 0.50, protection 0.22 and state SUSCEPTIBLE.* Agent at vertex 10: peril 1.00, protection 0.55 and state INFECTED.* Agent at vertex 11: peril 1.00, protection 0.49 and state SUSCEPTIBLE.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 14: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 17: peril 0.20, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [2, 6, 8, 9, 11]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.49, 0.0, 0.0, 0.0, 0.0, 0.51, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [2, 6, 8, 9]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [2, 6, 8, 9]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.22, 0.0, 0.0, 0.78, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [2, 8, 9]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 6, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [2, 8, 9]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 6, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.87, 0.0, 0.0, 0.0, 0.0, 0.0, 0.12, 0.01, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [8]
 * I: [10]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [8]
 * I: [10]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.72, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [10]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 7 turns.


#### Greatest Degree Defence

 * S: [2, 6, 8, 9, 11]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.87, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.13, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [6, 8, 9, 11]
 * I: [10]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 12, 13, 14, 15, 16, 17, 18, 19]
_Infecting:_ 11 

 * S: [6, 8, 9]
 * I: [10, 11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.16, 0.0, 0.84, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [6, 9]
 * I: [10, 11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 8, 12, 13, 14, 15, 16, 17, 18, 19]
_Infecting:_ 6 9 

 * S: []
 * I: [6, 9, 10, 11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 8, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 16 protected and 4 infected vertices in 4 turns.


#### Highest Protection Defence

 * S: [2, 6, 8, 9, 11]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.49, 0.0, 0.0, 0.0, 0.0, 0.51, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [2, 6, 8, 9]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [2, 6, 8, 9]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.22, 0.0, 0.0, 0.78, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [2, 8, 9]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 6, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [2, 8, 9]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 6, 7, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.15, 0.0, 0.0, 0.0, 0.0, 0.0, 0.84, 0.01, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [2]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [2]
 * I: [10]
 * R: []
 * P: [0, 1, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.72, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [10]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 7 turns.


## Outbreak: 11
* Agent at vertex 0: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.50, protection 0.69 and state SUSCEPTIBLE.* Agent at vertex 3: peril 0.20, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 0.33, protection 0.30 and state SUSCEPTIBLE.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 1.00, protection 0.96 and state SUSCEPTIBLE.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.25, protection 0.14 and state SUSCEPTIBLE.* Agent at vertex 9: peril 1.00, protection 0.41 and state SUSCEPTIBLE.* Agent at vertex 10: peril 1.00, protection 0.82 and state SUSCEPTIBLE.* Agent at vertex 11: peril 1.00, protection 0.20 and state INFECTED.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 14: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 17: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [2, 4, 6, 8, 9, 10]
 * I: [11]
 * R: []
 * P: [0, 1, 3, 5, 7, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.19, 0.0, 0.0, 0.0, 0.04, 0.0, 0.0, 0.59, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [2, 4, 8]
 * I: [11]
 * R: []
 * P: [0, 1, 3, 5, 6, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [2, 4, 8]
 * I: [11]
 * R: []
 * P: [0, 1, 3, 5, 6, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.13, 0.0, 0.7, 0.0, 0.0, 0.0, 0.17, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [8]
 * I: [11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [8]
 * I: [11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.69, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 5 turns.


#### Greatest Degree Defence

 * S: [2, 4, 6, 8, 9, 10]
 * I: [11]
 * R: []
 * P: [0, 1, 3, 5, 7, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.31, 0.0, 0.0, 0.0, 0.0, 0.0, 0.69, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [4, 6, 8, 9, 10]
 * I: [11]
 * R: []
 * P: [0, 1, 2, 3, 5, 7, 12, 13, 14, 15, 16, 17, 18, 19]
_Infecting:_ 6 9 10 

 * S: [4, 8]
 * I: [6, 9, 10, 11]
 * R: []
 * P: [0, 1, 2, 3, 5, 7, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.7, 0.0, 0.0, 0.0, 0.17, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [6, 9, 10, 11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 8, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 16 protected and 4 infected vertices in 3 turns.


#### Highest Protection Defence

 * S: [2, 4, 6, 8, 9, 10]
 * I: [11]
 * R: []
 * P: [0, 1, 3, 5, 7, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.31, 0.0, 0.0, 0.0, 0.04, 0.0, 0.0, 0.46, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [4, 8, 9]
 * I: [11]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Infecting:_ 9 

 * S: [4, 8]
 * I: [9, 11]
 * R: []
 * P: [0, 1, 2, 3, 5, 6, 7, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.7, 0.0, 0.0, 0.0, 0.3, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [8]
 * I: [9, 11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [8]
 * I: [9, 11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 10, 12, 13, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.56, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [9, 11]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 18 protected and 2 infected vertices in 5 turns.


## Outbreak: 12
* Agent at vertex 0: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 3: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 9: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 10: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 12: peril 1.00, protection 0.56 and state INFECTED.* Agent at vertex 13: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 14: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 17: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: []
 * I: [12]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


#### Greatest Degree Defence

 * S: []
 * I: [12]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


#### Highest Protection Defence

 * S: []
 * I: [12]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


## Outbreak: 13
* Agent at vertex 0: peril 0.50, protection 0.01 and state SUSCEPTIBLE.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 1.00, protection 0.06 and state SUSCEPTIBLE.* Agent at vertex 3: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 1.00, protection 0.53 and state SUSCEPTIBLE.* Agent at vertex 9: peril 0.25, protection 0.62 and state SUSCEPTIBLE.* Agent at vertex 10: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 1.00, protection 0.53 and state INFECTED.* Agent at vertex 14: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.33, protection 0.13 and state SUSCEPTIBLE.* Agent at vertex 17: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [0, 2, 8, 9, 16]
 * I: [13]
 * R: []
 * P: [1, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.94, 0.0, 0.0, 0.0, 0.0, 0.0, 0.06, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [0, 8, 9, 16]
 * I: [13]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 17, 18, 19]
_Infecting:_ 8 

 * S: [0, 9, 16]
 * I: [8, 13]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 17, 18, 19]
_Strategy:_ [0.99, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.01, 0.0, 0.0, 0.0]

 * S: [9, 16]
 * I: [8, 13]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 17, 18, 19]
_Nothing infected._
 * S: [9, 16]
 * I: [8, 13]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.14, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.86, 0.0, 0.0, 0.0]

 * S: [9]
 * I: [8, 13]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [9]
 * I: [8, 13]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.24, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [8, 13]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 18 protected and 2 infected vertices in 7 turns.


#### Greatest Degree Defence

 * S: [0, 2, 8, 9, 16]
 * I: [13]
 * R: []
 * P: [1, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.94, 0.0, 0.0, 0.0, 0.0, 0.0, 0.06, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [0, 8, 9, 16]
 * I: [13]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 17, 18, 19]
_Infecting:_ 8 

 * S: [0, 9, 16]
 * I: [8, 13]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 17, 18, 19]
_Strategy:_ [0.13, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.87, 0.0, 0.0, 0.0]

 * S: [0, 9]
 * I: [8, 13]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 16, 17, 18, 19]
_Infecting:_ 0 

 * S: [9]
 * I: [0, 8, 13]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.38, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [0, 8, 13]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 17 protected and 3 infected vertices in 5 turns.


#### Highest Protection Defence

 * S: [0, 2, 8, 9, 16]
 * I: [13]
 * R: []
 * P: [1, 3, 4, 5, 6, 7, 10, 11, 12, 14, 15, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.47, 0.38, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.15, 0.0, 0.0, 0.0]

 * S: [0, 2, 16]
 * I: [13]
 * R: []
 * P: [1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 17, 18, 19]
_Infecting:_ 2 

 * S: [0, 16]
 * I: [2, 13]
 * R: []
 * P: [1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 17, 18, 19]
_Strategy:_ [0.28, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.72, 0.0, 0.0, 0.0]

 * S: [0]
 * I: [2, 13]
 * R: []
 * P: [1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19]
_Infecting:_ 0 

 * S: []
 * I: [0, 2, 13]
 * R: []
 * P: [1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 17 protected and 3 infected vertices in 4 turns.


## Outbreak: 14
* Agent at vertex 0: peril 0.50, protection 0.76 and state SUSCEPTIBLE.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 3: peril 0.25, protection 0.29 and state SUSCEPTIBLE.* Agent at vertex 4: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 1.00, protection 0.98 and state SUSCEPTIBLE.* Agent at vertex 9: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 10: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.50, protection 0.36 and state SUSCEPTIBLE.* Agent at vertex 14: peril 1.00, protection 0.37 and state INFECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 1.00, protection 0.42 and state SUSCEPTIBLE.* Agent at vertex 17: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.50, protection 0.13 and state SUSCEPTIBLE.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [0, 3, 8, 13, 16, 18]
 * I: [14]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 15, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.02, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.58, 0.0, 0.4, 0.0]

 * S: [0, 3, 13, 18]
 * I: [14]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 19]
_Nothing infected._
 * S: [0, 3, 13, 18]
 * I: [14]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 19]
_Strategy:_ [0.24, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.29, 0.0, 0.0, 0.0, 0.0, 0.47, 0.0]

 * S: [3, 13]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [3, 13]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.66, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.34, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [3]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.05, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [14]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 7 turns.


#### Greatest Degree Defence

 * S: [0, 3, 8, 13, 16, 18]
 * I: [14]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 15, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.02, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.58, 0.0, 0.4, 0.0]

 * S: [0, 3, 13, 18]
 * I: [14]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 19]
_Nothing infected._
 * S: [0, 3, 13, 18]
 * I: [14]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 19]
_Strategy:_ [0.24, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.29, 0.0, 0.0, 0.0, 0.0, 0.47, 0.0]

 * S: [3, 13]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [3, 13]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.66, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.34, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19]
_Nothing infected._
 * S: [3]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.05, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [14]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 7 turns.


#### Highest Protection Defence

 * S: [0, 3, 8, 13, 16, 18]
 * I: [14]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 15, 17, 19]
_Strategy:_ [0.24, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.02, 0.0, 0.0, 0.0, 0.0, 0.16, 0.0, 0.0, 0.58, 0.0, 0.0, 0.0]

 * S: [3, 13, 18]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 19]
_Nothing infected._
 * S: [3, 13, 18]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.52, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.48, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3, 18]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 19]
_Nothing infected._
 * S: [3, 18]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.82, 0.0]

 * S: [18]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 19]
_Nothing infected._
 * S: [18]
 * I: [14]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.05, 0.0]

 * S: []
 * I: [14]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 7 turns.


## Outbreak: 15
* Agent at vertex 0: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 3: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 9: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 10: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 14: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 1.00, protection 0.24 and state INFECTED.* Agent at vertex 16: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 17: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: []
 * I: [15]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


#### Greatest Degree Defence

 * S: []
 * I: [15]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


#### Highest Protection Defence

 * S: []
 * I: [15]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


## Outbreak: 16
* Agent at vertex 0: peril 0.33, protection 0.42 and state SUSCEPTIBLE.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.50, protection 0.76 and state SUSCEPTIBLE.* Agent at vertex 3: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.33, protection 0.74 and state SUSCEPTIBLE.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 9: peril 1.00, protection 0.05 and state SUSCEPTIBLE.* Agent at vertex 10: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.50, protection 0.67 and state SUSCEPTIBLE.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 14: peril 1.00, protection 0.11 and state SUSCEPTIBLE.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 1.00, protection 0.29 and state INFECTED.* Agent at vertex 17: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 1.00, protection 0.78 and state SUSCEPTIBLE.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [0, 2, 6, 9, 11, 14, 18]
 * I: [16]
 * R: []
 * P: [1, 3, 4, 5, 7, 8, 10, 12, 13, 15, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.78, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.22, 0.0]

 * S: [0, 2, 6, 9, 11, 14]
 * I: [16]
 * R: []
 * P: [1, 3, 4, 5, 7, 8, 10, 12, 13, 15, 17, 18, 19]
_Infecting:_ 9 14 

 * S: [0, 2, 6, 11]
 * I: [9, 14, 16]
 * R: []
 * P: [1, 3, 4, 5, 7, 8, 10, 12, 13, 15, 17, 18, 19]
_Strategy:_ [0.43, 0.0, 0.24, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.33, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [0, 6]
 * I: [9, 14, 16]
 * R: []
 * P: [1, 2, 3, 4, 5, 7, 8, 10, 11, 12, 13, 15, 17, 18, 19]
_Nothing infected._
 * S: [0, 6]
 * I: [9, 14, 16]
 * R: []
 * P: [1, 2, 3, 4, 5, 7, 8, 10, 11, 12, 13, 15, 17, 18, 19]
_Strategy:_ [0.15, 0.0, 0.0, 0.0, 0.0, 0.0, 0.26, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [9, 14, 16]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 15, 17, 18, 19]
__Nothing more to infect.__
Ending model with 17 protected and 3 infected vertices in 5 turns.


#### Greatest Degree Defence

 * S: [0, 2, 6, 9, 11, 14, 18]
 * I: [16]
 * R: []
 * P: [1, 3, 4, 5, 7, 8, 10, 12, 13, 15, 17, 19]
_Strategy:_ [0.0, 0.0, 0.24, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.21, 0.0, 0.33, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.22, 0.0]

 * S: [0, 6, 9, 14]
 * I: [16]
 * R: []
 * P: [1, 2, 3, 4, 5, 7, 8, 10, 11, 12, 13, 15, 17, 18, 19]
_Infecting:_ 9 14 

 * S: [0, 6]
 * I: [9, 14, 16]
 * R: []
 * P: [1, 2, 3, 4, 5, 7, 8, 10, 11, 12, 13, 15, 17, 18, 19]
_Strategy:_ [0.58, 0.0, 0.0, 0.0, 0.0, 0.0, 0.26, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [9, 14, 16]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 15, 17, 18, 19]
__Nothing more to infect.__
Ending model with 17 protected and 3 infected vertices in 3 turns.


#### Highest Protection Defence

 * S: [0, 2, 6, 9, 11, 14, 18]
 * I: [16]
 * R: []
 * P: [1, 3, 4, 5, 7, 8, 10, 12, 13, 15, 17, 19]
_Strategy:_ [0.0, 0.0, 0.24, 0.0, 0.0, 0.0, 0.26, 0.0, 0.0, 0.0, 0.0, 0.28, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.22, 0.0]

 * S: [0, 9, 11, 14]
 * I: [16]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 13, 15, 17, 18, 19]
_Infecting:_ 9 14 

 * S: [0, 11]
 * I: [9, 14, 16]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 13, 15, 17, 18, 19]
_Strategy:_ [0.58, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.05, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [9, 14, 16]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 15, 17, 18, 19]
__Nothing more to infect.__
Ending model with 17 protected and 3 infected vertices in 3 turns.


## Outbreak: 17
* Agent at vertex 0: peril 0.33, protection 0.60 and state SUSCEPTIBLE.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 3: peril 1.00, protection 0.91 and state SUSCEPTIBLE.* Agent at vertex 4: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 9: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 10: peril 0.20, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.33, protection 0.56 and state SUSCEPTIBLE.* Agent at vertex 14: peril 0.33, protection 0.77 and state SUSCEPTIBLE.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.50, protection 0.80 and state SUSCEPTIBLE.* Agent at vertex 17: peril 1.00, protection 0.62 and state INFECTED.* Agent at vertex 18: peril 1.00, protection 0.25 and state SUSCEPTIBLE.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [0, 3, 13, 14, 16, 18]
 * I: [17]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.09, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.16, 0.0, 0.75, 0.0]

 * S: [0, 13, 14, 16]
 * I: [17]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 18, 19]
_Nothing infected._
 * S: [0, 13, 14, 16]
 * I: [17]
 * R: []
 * P: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 18, 19]
_Strategy:_ [0.4, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.44, 0.11, 0.0, 0.05, 0.0, 0.0, 0.0]

 * S: [14]
 * I: [17]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 18, 19]
_Nothing infected._
 * S: [14]
 * I: [17]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.12, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [17]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19]
__Nothing more to infect.__
Ending model with 19 protected and 1 infected vertices in 5 turns.


#### Greatest Degree Defence

 * S: [0, 3, 13, 14, 16, 18]
 * I: [17]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 19]
_Strategy:_ [0.04, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.2, 0.0, 0.75, 0.0]

 * S: [0, 3, 13, 14]
 * I: [17]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 18, 19]
_Infecting:_ 3 

 * S: [0, 13, 14]
 * I: [3, 17]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 18, 19]
_Strategy:_ [0.36, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.44, 0.2, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [14]
 * I: [3, 17]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 18, 19]
_Nothing infected._
 * S: [14]
 * I: [3, 17]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 18, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.03, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [3, 17]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19]
__Nothing more to infect.__
Ending model with 18 protected and 2 infected vertices in 5 turns.


#### Highest Protection Defence

 * S: [0, 3, 13, 14, 16, 18]
 * I: [17]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 19]
_Strategy:_ [0.4, 0.0, 0.0, 0.09, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.07, 0.23, 0.0, 0.2, 0.0, 0.0, 0.0]

 * S: [13, 18]
 * I: [17]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 19]
_Infecting:_ 18 

 * S: [13]
 * I: [17, 18]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.37, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [17, 18]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 19]
__Nothing more to infect.__
Ending model with 18 protected and 2 infected vertices in 3 turns.


## Outbreak: 18
* Agent at vertex 0: peril 0.50, protection 0.00 and state SUSCEPTIBLE.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 1.00, protection 0.14 and state SUSCEPTIBLE.* Agent at vertex 3: peril 0.50, protection 0.99 and state SUSCEPTIBLE.* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 9: peril 0.50, protection 0.03 and state SUSCEPTIBLE.* Agent at vertex 10: peril 0.25, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.33, protection 1.00 and state PROTECTED.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.50, protection 0.24 and state SUSCEPTIBLE.* Agent at vertex 14: peril 0.50, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 1.00, protection 0.19 and state SUSCEPTIBLE.* Agent at vertex 17: peril 1.00, protection 0.45 and state SUSCEPTIBLE.* Agent at vertex 18: peril 1.00, protection 0.51 and state INFECTED.* Agent at vertex 19: peril 0.00, protection 1.00 and state PROTECTED.
#### Proximity to Infection Defence

 * S: [0, 2, 3, 9, 13, 16, 17]
 * I: [18]
 * R: []
 * P: [1, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 19]
_Strategy:_ [0.0, 0.0, 0.86, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.14, 0.0, 0.0, 0.0]

 * S: [0, 3, 9, 13, 16, 17]
 * I: [18]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 19]
_Infecting:_ 16 17 

 * S: [0, 3, 9, 13]
 * I: [16, 17, 18]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 19]
_Strategy:_ [1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3, 9, 13]
 * I: [16, 17, 18]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 19]
_Infecting:_ 3 9 

 * S: [13]
 * I: [3, 9, 16, 17, 18]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.76, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [3, 9, 16, 17, 18]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 19]
__Nothing more to infect.__
Ending model with 15 protected and 5 infected vertices in 5 turns.


#### Greatest Degree Defence

 * S: [0, 2, 3, 9, 13, 16, 17]
 * I: [18]
 * R: []
 * P: [1, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 19]
_Strategy:_ [0.0, 0.0, 0.86, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.14, 0.0, 0.0, 0.0]

 * S: [0, 3, 9, 13, 16, 17]
 * I: [18]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 19]
_Infecting:_ 16 17 

 * S: [0, 3, 9, 13]
 * I: [16, 17, 18]
 * R: []
 * P: [1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 19]
_Strategy:_ [1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [3, 9, 13]
 * I: [16, 17, 18]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 19]
_Infecting:_ 3 9 

 * S: [13]
 * I: [3, 9, 16, 17, 18]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.76, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: []
 * I: [3, 9, 16, 17, 18]
 * R: []
 * P: [0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 19]
__Nothing more to infect.__
Ending model with 15 protected and 5 infected vertices in 5 turns.


#### Highest Protection Defence

 * S: [0, 2, 3, 9, 13, 16, 17]
 * I: [18]
 * R: []
 * P: [1, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.01, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.43, 0.0, 0.0, 0.0, 0.55, 0.0, 0.0]

 * S: [0, 2, 9, 13, 16]
 * I: [18]
 * R: []
 * P: [1, 3, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 17, 19]
_Infecting:_ 2 16 

 * S: [0, 9, 13]
 * I: [2, 16, 18]
 * R: []
 * P: [1, 3, 4, 5, 6, 7, 8, 10, 11, 12, 14, 15, 17, 19]
_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.67, 0.0, 0.0, 0.0, 0.33, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

 * S: [0, 9]
 * I: [2, 16, 18]
 * R: []
 * P: [1, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 17, 19]
_Infecting:_ 0 9 

 * S: []
 * I: [0, 2, 9, 16, 18]
 * R: []
 * P: [1, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 17, 19]
__Nothing more to protect.__
Ending model with 15 protected and 5 infected vertices in 4 turns.


## Outbreak: 19
* Agent at vertex 0: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 1: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 2: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 3: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 4: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 5: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 6: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 7: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 8: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 9: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 10: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 11: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 12: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 13: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 14: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 15: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 16: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 17: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 18: peril 0.00, protection 1.00 and state PROTECTED.* Agent at vertex 19: peril 1.00, protection 0.89 and state INFECTED.
#### Proximity to Infection Defence

 * S: []
 * I: [19]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


#### Greatest Degree Defence

 * S: []
 * I: [19]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


#### Highest Protection Defence

 * S: []
 * I: [19]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18]
__Nothing more to protect.__
Ending model with 19 protected and 1 infected vertices in 0 turns.


