# Readable results of SIRP defence strategies on a random graph

## Generating Erdős–Rényi Graph:
Our graph generator class has generated an Erdős–Rényi graph with the following parameters:
 * Number of vertices: 20
 * Number of edges: 80
 * Probability: 80 / (20 * (20 - 1) / 2) = 0.42
 * Random generator seed: 1614037387517

The generated graph is represented using the following adjacency matrix:

0: 0 0 1 1 0 1 1 0 0 0 1 0 1 1 0 0 1 0 0 0 

1: 0 0 1 0 0 1 0 0 0 0 1 1 0 0 1 1 0 0 1 0 

2: 1 1 0 0 1 1 0 1 1 1 0 0 0 1 1 0 0 0 1 0 

3: 1 0 0 0 1 0 0 1 1 1 0 1 0 0 1 0 1 0 1 1 

4: 0 0 1 1 0 1 0 0 0 0 1 0 1 1 0 1 0 0 0 0 

5: 1 1 1 0 1 0 1 1 0 0 0 0 1 0 1 1 1 1 0 0 

6: 1 0 0 0 0 1 0 1 0 1 0 0 0 1 1 1 0 0 1 1 

7: 0 0 1 1 0 1 1 0 1 1 0 1 1 1 1 1 0 1 0 0 

8: 0 0 1 1 0 0 0 1 0 0 0 0 0 1 1 0 1 1 1 1 

9: 0 0 1 1 0 0 1 1 0 0 0 1 1 1 1 1 1 0 0 0 

10: 1 1 0 0 1 0 0 0 0 0 0 1 0 0 0 1 1 1 1 0 

11: 0 1 0 1 0 0 0 1 0 1 1 0 1 1 0 0 1 0 1 1 

12: 1 0 0 0 1 1 0 1 0 1 0 1 0 0 0 0 0 0 0 0 

13: 1 0 1 0 1 0 1 1 1 1 0 1 0 0 1 0 1 1 1 1 

14: 0 1 1 1 0 1 1 1 1 1 0 0 0 1 0 1 0 1 1 0 

15: 0 1 0 0 1 1 1 1 0 1 1 0 0 0 1 0 0 1 0 1 

16: 1 0 0 1 0 1 0 0 1 1 1 1 0 1 0 0 0 1 0 0 

17: 0 0 0 0 0 1 0 1 1 0 1 0 0 1 1 1 1 0 0 1 

18: 0 1 1 1 0 0 1 0 1 0 1 1 0 1 1 0 0 0 0 1 

19: 0 0 0 1 0 0 1 0 1 0 0 1 0 1 0 1 0 1 1 0 


## Model values
The values used in the model are:
 * Total defence quota each turn: 1.0
 * Probability with which the infection propagates: 1.0

## Outbreak: 0
* Agent at vertex 0: peril 1.00, protection 0.83 and state INFECTED.
* Agent at vertex 1: peril 0.50, protection 0.75 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 1.00, protection 0.14 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 1.00, protection 0.58 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 5: peril 1.00, protection 0.04 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 1.00, protection 0.11 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 0.50, protection 0.87 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 0.50, protection 0.13 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 10: peril 1.00, protection 0.68 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 0.50, protection 0.97 and state SUSCEPTIBLE.
* Agent at vertex 12: peril 1.00, protection 0.44 and state SUSCEPTIBLE.
* Agent at vertex 13: peril 1.00, protection 0.90 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 0.50, protection 0.15 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 16: peril 1.00, protection 0.02 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 18: peril 0.50, protection 0.07 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 0.50, protection 0.46 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [1, 2, 3, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 18, 19]
 * I: [0]
 * R: []
 * P: [4, 9, 15, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.9, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 2, 3, 5, 6, 7, 8, 10, 11, 12, 14, 16, 18, 19]
 * I: [0]
 * R: []
 * P: [4, 9, 13, 15, 17]

_Infecting:_ 2 3 5 6 10 12 16 

 * S: [1, 7, 8, 11, 14, 18, 19]
 * I: [0, 2, 3, 5, 6, 10, 12, 16]
 * R: []
 * P: [4, 9, 13, 15, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.13, 0.0, 0.0, 0.0, 0.02, 0.0, 0.0, 0.85, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 8, 11, 18, 19]
 * I: [0, 2, 3, 5, 6, 10, 12, 16]
 * R: []
 * P: [4, 7, 9, 13, 14, 15, 17]

_Infecting:_ 1 8 11 18 19 

 * S: []
 * I: [0, 1, 2, 3, 5, 6, 8, 10, 11, 12, 16, 18, 19]
 * R: []
 * P: [4, 7, 9, 13, 14, 15, 17]

__Nothing more to protect.__
Ending model with 7 protected and 13 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [1, 2, 3, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 18, 19]
 * I: [0]
 * R: []
 * P: [4, 9, 15, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.13, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.77, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 2, 3, 5, 6, 8, 10, 11, 12, 14, 16, 18, 19]
 * I: [0]
 * R: []
 * P: [4, 7, 9, 13, 15, 17]

_Infecting:_ 2 3 5 6 10 12 16 

 * S: [1, 8, 11, 14, 18, 19]
 * I: [0, 2, 3, 5, 6, 10, 12, 16]
 * R: []
 * P: [4, 7, 9, 13, 15, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.03, 0.0, 0.0, 0.08, 0.0, 0.0, 0.0, 0.89, 0.0]


 * S: [1, 8, 18, 19]
 * I: [0, 2, 3, 5, 6, 10, 12, 16]
 * R: []
 * P: [4, 7, 9, 11, 13, 14, 15, 17]

_Infecting:_ 1 8 18 19 

 * S: []
 * I: [0, 1, 2, 3, 5, 6, 8, 10, 12, 16, 18, 19]
 * R: []
 * P: [4, 7, 9, 11, 13, 14, 15, 17]

__Nothing more to protect.__
Ending model with 8 protected and 12 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [1, 2, 3, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 18, 19]
 * I: [0]
 * R: []
 * P: [4, 9, 15, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.25, 0.0, 0.18, 0.0, 0.0, 0.0, 0.13, 0.0, 0.0, 0.32, 0.03, 0.0, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [2, 3, 5, 6, 8, 12, 14, 16, 18, 19]
 * I: [0]
 * R: []
 * P: [1, 4, 7, 9, 10, 11, 13, 15, 17]

_Infecting:_ 2 3 5 6 12 16 

 * S: [8, 14, 18, 19]
 * I: [0, 2, 3, 5, 6, 12, 16]
 * R: []
 * P: [1, 4, 7, 9, 10, 11, 13, 15, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.46, 0.0, 0.0, 0.0, 0.0, 0.54]


 * S: [8, 14, 18]
 * I: [0, 2, 3, 5, 6, 12, 16]
 * R: []
 * P: [1, 4, 7, 9, 10, 11, 13, 15, 17, 19]

_Infecting:_ 8 14 18 

 * S: []
 * I: [0, 2, 3, 5, 6, 8, 12, 14, 16, 18]
 * R: []
 * P: [1, 4, 7, 9, 10, 11, 13, 15, 17, 19]

__Nothing more to protect.__
Ending model with 10 protected and 10 infected vertices in 4 turns.

## Outbreak: 1
* Agent at vertex 0: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 1: peril 1.00, protection 0.08 and state INFECTED.
* Agent at vertex 2: peril 1.00, protection 0.09 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 0.50, protection 0.12 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 0.50, protection 0.22 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 1.00, protection 0.50 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 7: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 8: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 9: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 10: peril 1.00, protection 0.63 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 1.00, protection 0.90 and state SUSCEPTIBLE.
* Agent at vertex 12: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 13: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 14: peril 1.00, protection 0.86 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 1.00, protection 0.78 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 17: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 18: peril 1.00, protection 0.37 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 0.50, protection 0.28 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [2, 3, 4, 5, 10, 11, 14, 15, 18, 19]
 * I: [1]
 * R: []
 * P: [0, 6, 7, 8, 9, 12, 13, 16, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.36, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.14, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [2, 3, 4, 10, 11, 15, 18, 19]
 * I: [1]
 * R: []
 * P: [0, 5, 6, 7, 8, 9, 12, 13, 14, 16, 17]

_Infecting:_ 2 10 11 15 18 

 * S: [3, 4, 19]
 * I: [1, 2, 10, 11, 15, 18]
 * R: []
 * P: [0, 5, 6, 7, 8, 9, 12, 13, 14, 16, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.88, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.12]


 * S: [4, 19]
 * I: [1, 2, 10, 11, 15, 18]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9, 12, 13, 14, 16, 17]

_Infecting:_ 4 19 

 * S: []
 * I: [1, 2, 4, 10, 11, 15, 18, 19]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9, 12, 13, 14, 16, 17]

__Nothing more to protect.__
Ending model with 12 protected and 8 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [2, 3, 4, 5, 10, 11, 14, 15, 18, 19]
 * I: [1]
 * R: []
 * P: [0, 6, 7, 8, 9, 12, 13, 16, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.36, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.14, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [2, 3, 4, 10, 11, 15, 18, 19]
 * I: [1]
 * R: []
 * P: [0, 5, 6, 7, 8, 9, 12, 13, 14, 16, 17]

_Infecting:_ 2 10 11 15 18 

 * S: [3, 4, 19]
 * I: [1, 2, 10, 11, 15, 18]
 * R: []
 * P: [0, 5, 6, 7, 8, 9, 12, 13, 14, 16, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.88, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.12]


 * S: [4, 19]
 * I: [1, 2, 10, 11, 15, 18]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9, 12, 13, 14, 16, 17]

_Infecting:_ 4 19 

 * S: []
 * I: [1, 2, 4, 10, 11, 15, 18, 19]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9, 12, 13, 14, 16, 17]

__Nothing more to protect.__
Ending model with 12 protected and 8 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [2, 3, 4, 5, 10, 11, 14, 15, 18, 19]
 * I: [1]
 * R: []
 * P: [0, 6, 7, 8, 9, 12, 13, 16, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.16, 0.0, 0.0, 0.0, 0.0, 0.37, 0.1, 0.0, 0.0, 0.14, 0.22, 0.0, 0.0, 0.0, 0.0]


 * S: [2, 3, 4, 5, 18, 19]
 * I: [1]
 * R: []
 * P: [0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17]

_Infecting:_ 2 5 18 

 * S: [3, 4, 19]
 * I: [1, 2, 5, 18]
 * R: []
 * P: [0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.28, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.72]


 * S: [3, 4]
 * I: [1, 2, 5, 18]
 * R: []
 * P: [0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19]

_Infecting:_ 3 4 

 * S: []
 * I: [1, 2, 3, 4, 5, 18]
 * R: []
 * P: [0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19]

__Nothing more to protect.__
Ending model with 14 protected and 6 infected vertices in 4 turns.

## Outbreak: 2
* Agent at vertex 0: peril 1.00, protection 0.21 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 1.00, protection 0.52 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 1.00, protection 0.76 and state INFECTED.
* Agent at vertex 3: peril 0.50, protection 0.93 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 1.00, protection 0.07 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 1.00, protection 0.41 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 0.50, protection 0.68 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.72 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 1.00, protection 0.63 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 1.00, protection 0.90 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 0.50, protection 0.56 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 12: peril 0.50, protection 0.89 and state SUSCEPTIBLE.
* Agent at vertex 13: peril 1.00, protection 0.53 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 1.00, protection 0.18 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 0.50, protection 0.82 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 17: peril 0.50, protection 0.14 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 1.00, protection 0.43 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 0.50, protection 1.00 and state PROTECTED.

#### Proximity to Infection Defence


 * S: [0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 17, 18]
 * I: [2]
 * R: []
 * P: [11, 16, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.28, 0.0, 0.0, 0.0, 0.0, 0.0, 0.47, 0.25, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 3, 4, 5, 6, 8, 9, 10, 12, 14, 15, 17, 18]
 * I: [2]
 * R: []
 * P: [7, 11, 13, 16, 19]

_Infecting:_ 0 1 4 5 8 9 14 18 

 * S: [3, 6, 10, 12, 15, 17]
 * I: [0, 1, 2, 4, 5, 8, 9, 14, 18]
 * R: []
 * P: [7, 11, 13, 16, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.07, 0.0, 0.0, 0.32, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.43, 0.0, 0.0]


 * S: [10, 12, 17]
 * I: [0, 1, 2, 4, 5, 8, 9, 14, 18]
 * R: []
 * P: [3, 6, 7, 11, 13, 15, 16, 19]

_Infecting:_ 10 12 17 

 * S: []
 * I: [0, 1, 2, 4, 5, 8, 9, 10, 12, 14, 17, 18]
 * R: []
 * P: [3, 6, 7, 11, 13, 15, 16, 19]

__Nothing more to protect.__
Ending model with 8 protected and 12 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 17, 18]
 * I: [2]
 * R: []
 * P: [11, 16, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.28, 0.0, 0.0, 0.0, 0.0, 0.0, 0.47, 0.25, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 3, 4, 5, 6, 8, 9, 10, 12, 14, 15, 17, 18]
 * I: [2]
 * R: []
 * P: [7, 11, 13, 16, 19]

_Infecting:_ 0 1 4 5 8 9 14 18 

 * S: [3, 6, 10, 12, 15, 17]
 * I: [0, 1, 2, 4, 5, 8, 9, 14, 18]
 * R: []
 * P: [7, 11, 13, 16, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.07, 0.0, 0.0, 0.32, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.43, 0.0, 0.0]


 * S: [10, 12, 17]
 * I: [0, 1, 2, 4, 5, 8, 9, 14, 18]
 * R: []
 * P: [3, 6, 7, 11, 13, 15, 16, 19]

_Infecting:_ 10 12 17 

 * S: []
 * I: [0, 1, 2, 4, 5, 8, 9, 10, 12, 14, 17, 18]
 * R: []
 * P: [3, 6, 7, 11, 13, 15, 16, 19]

__Nothing more to protect.__
Ending model with 8 protected and 12 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 17, 18]
 * I: [2]
 * R: []
 * P: [11, 16, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.07, 0.0, 0.0, 0.26, 0.28, 0.0, 0.1, 0.0, 0.0, 0.11, 0.0, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 4, 5, 6, 8, 10, 13, 14, 17, 18]
 * I: [2]
 * R: []
 * P: [3, 7, 9, 11, 12, 15, 16, 19]

_Infecting:_ 0 1 4 5 8 13 14 18 

 * S: [6, 10, 17]
 * I: [0, 1, 2, 4, 5, 8, 13, 14, 18]
 * R: []
 * P: [3, 7, 9, 11, 12, 15, 16, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.06, 0.0, 0.0, 0.0, 0.44, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0]


 * S: [17]
 * I: [0, 1, 2, 4, 5, 8, 13, 14, 18]
 * R: []
 * P: [3, 6, 7, 9, 10, 11, 12, 15, 16, 19]

_Infecting:_ 17 

 * S: []
 * I: [0, 1, 2, 4, 5, 8, 13, 14, 17, 18]
 * R: []
 * P: [3, 6, 7, 9, 10, 11, 12, 15, 16, 19]

__Nothing more to protect.__
Ending model with 10 protected and 10 infected vertices in 4 turns.

## Outbreak: 3
* Agent at vertex 0: peril 1.00, protection 0.38 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 0.50, protection 1.00 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 3: peril 1.00, protection 0.22 and state INFECTED.
* Agent at vertex 4: peril 1.00, protection 0.31 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 0.50, protection 0.64 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 0.50, protection 0.07 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.40 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 1.00, protection 0.46 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 1.00, protection 0.75 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 0.50, protection 0.18 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 1.00, protection 0.26 and state SUSCEPTIBLE.
* Agent at vertex 12: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 13: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 14: peril 1.00, protection 0.28 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 0.50, protection 0.02 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 1.00, protection 0.41 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 18: peril 1.00, protection 0.34 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 1.00, protection 0.67 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [0, 1, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 18, 19]
 * I: [3]
 * R: []
 * P: [2, 12, 13, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.6, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.4, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 4, 5, 6, 8, 9, 10, 11, 14, 15, 16, 18, 19]
 * I: [3]
 * R: []
 * P: [2, 7, 12, 13, 17]

_Infecting:_ 0 4 8 9 11 14 16 18 19 

 * S: [1, 5, 6, 10, 15]
 * I: [0, 3, 4, 8, 9, 11, 14, 16, 18, 19]
 * R: []
 * P: [2, 7, 12, 13, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.36, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.64, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 6, 10, 15]
 * I: [0, 3, 4, 8, 9, 11, 14, 16, 18, 19]
 * R: []
 * P: [2, 5, 7, 12, 13, 17]

_Infecting:_ 1 6 10 15 

 * S: []
 * I: [0, 1, 3, 4, 6, 8, 9, 10, 11, 14, 15, 16, 18, 19]
 * R: []
 * P: [2, 5, 7, 12, 13, 17]

__Nothing more to protect.__
Ending model with 6 protected and 14 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [0, 1, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 18, 19]
 * I: [3]
 * R: []
 * P: [2, 12, 13, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.6, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.4, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 4, 5, 6, 8, 9, 10, 11, 14, 15, 16, 18, 19]
 * I: [3]
 * R: []
 * P: [2, 7, 12, 13, 17]

_Infecting:_ 0 4 8 9 11 14 16 18 19 

 * S: [1, 5, 6, 10, 15]
 * I: [0, 3, 4, 8, 9, 11, 14, 16, 18, 19]
 * R: []
 * P: [2, 7, 12, 13, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.36, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.64, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 6, 10, 15]
 * I: [0, 3, 4, 8, 9, 11, 14, 16, 18, 19]
 * R: []
 * P: [2, 5, 7, 12, 13, 17]

_Infecting:_ 1 6 10 15 

 * S: []
 * I: [0, 1, 3, 4, 6, 8, 9, 10, 11, 14, 15, 16, 18, 19]
 * R: []
 * P: [2, 5, 7, 12, 13, 17]

__Nothing more to protect.__
Ending model with 6 protected and 14 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [0, 1, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 18, 19]
 * I: [3]
 * R: []
 * P: [2, 12, 13, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.36, 0.0, 0.0, 0.06, 0.25, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.33]


 * S: [0, 4, 6, 7, 8, 10, 11, 14, 15, 16, 18]
 * I: [3]
 * R: []
 * P: [1, 2, 5, 9, 12, 13, 17, 19]

_Infecting:_ 0 4 7 8 11 14 16 18 

 * S: [6, 10, 15]
 * I: [0, 3, 4, 7, 8, 11, 14, 16, 18]
 * R: []
 * P: [1, 2, 5, 9, 12, 13, 17, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.0, 0.0, 0.82, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [6, 15]
 * I: [0, 3, 4, 7, 8, 11, 14, 16, 18]
 * R: []
 * P: [1, 2, 5, 9, 10, 12, 13, 17, 19]

_Infecting:_ 6 15 

 * S: []
 * I: [0, 3, 4, 6, 7, 8, 11, 14, 15, 16, 18]
 * R: []
 * P: [1, 2, 5, 9, 10, 12, 13, 17, 19]

__Nothing more to protect.__
Ending model with 9 protected and 11 infected vertices in 4 turns.

## Outbreak: 4
* Agent at vertex 0: peril 0.50, protection 0.66 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 2: peril 1.00, protection 0.95 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 1.00, protection 0.59 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 1.00, protection 0.62 and state INFECTED.
* Agent at vertex 5: peril 1.00, protection 0.93 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 7: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 8: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 9: peril 0.50, protection 0.42 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 1.00, protection 0.19 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 12: peril 1.00, protection 0.43 and state SUSCEPTIBLE.
* Agent at vertex 13: peril 1.00, protection 0.16 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 0.50, protection 0.75 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 1.00, protection 0.47 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 0.50, protection 0.25 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 0.50, protection 0.98 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 0.50, protection 0.28 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 0.50, protection 1.00 and state PROTECTED.

#### Proximity to Infection Defence


 * S: [0, 2, 3, 5, 9, 10, 12, 13, 14, 15, 16, 17, 18]
 * I: [4]
 * R: []
 * P: [1, 6, 7, 8, 11, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.05, 0.03, 0.0, 0.07, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.84, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 3, 9, 10, 12, 14, 15, 16, 17, 18]
 * I: [4]
 * R: []
 * P: [1, 2, 5, 6, 7, 8, 11, 13, 19]

_Infecting:_ 3 10 12 15 

 * S: [0, 9, 14, 16, 17, 18]
 * I: [3, 4, 10, 12, 15]
 * R: []
 * P: [1, 2, 5, 6, 7, 8, 11, 13, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.58, 0.0, 0.0, 0.0, 0.0, 0.25, 0.0, 0.0, 0.0, 0.17, 0.0]


 * S: [0, 16, 17, 18]
 * I: [3, 4, 10, 12, 15]
 * R: []
 * P: [1, 2, 5, 6, 7, 8, 9, 11, 13, 14, 19]

_Infecting:_ 0 16 17 18 

 * S: []
 * I: [0, 3, 4, 10, 12, 15, 16, 17, 18]
 * R: []
 * P: [1, 2, 5, 6, 7, 8, 9, 11, 13, 14, 19]

__Nothing more to protect.__
Ending model with 11 protected and 9 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [0, 2, 3, 5, 9, 10, 12, 13, 14, 15, 16, 17, 18]
 * I: [4]
 * R: []
 * P: [1, 6, 7, 8, 11, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.84, 0.16, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 2, 3, 5, 9, 10, 12, 14, 15, 16, 17, 18]
 * I: [4]
 * R: []
 * P: [1, 6, 7, 8, 11, 13, 19]

_Infecting:_ 2 3 5 10 12 15 

 * S: [0, 9, 14, 16, 17, 18]
 * I: [2, 3, 4, 5, 10, 12, 15]
 * R: []
 * P: [1, 6, 7, 8, 11, 13, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.58, 0.0, 0.0, 0.0, 0.0, 0.1, 0.0, 0.0, 0.0, 0.32, 0.0]


 * S: [0, 16, 17, 18]
 * I: [2, 3, 4, 5, 10, 12, 15]
 * R: []
 * P: [1, 6, 7, 8, 9, 11, 13, 14, 19]

_Infecting:_ 0 16 17 18 

 * S: []
 * I: [0, 2, 3, 4, 5, 10, 12, 15, 16, 17, 18]
 * R: []
 * P: [1, 6, 7, 8, 9, 11, 13, 14, 19]

__Nothing more to protect.__
Ending model with 9 protected and 11 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [0, 2, 3, 5, 9, 10, 12, 13, 14, 15, 16, 17, 18]
 * I: [4]
 * R: []
 * P: [1, 6, 7, 8, 11, 19]
total defence: 1.0

_Strategy:_ [0.34, 0.0, 0.05, 0.26, 0.0, 0.07, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.25, 0.0, 0.0, 0.02, 0.0, 0.0]


 * S: [3, 9, 10, 12, 13, 15, 16, 18]
 * I: [4]
 * R: []
 * P: [0, 1, 2, 5, 6, 7, 8, 11, 14, 17, 19]

_Infecting:_ 3 10 12 13 15 

 * S: [9, 16, 18]
 * I: [3, 4, 10, 12, 13, 15]
 * R: []
 * P: [0, 1, 2, 5, 6, 7, 8, 11, 14, 17, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.58, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.42, 0.0]


 * S: [16, 18]
 * I: [3, 4, 10, 12, 13, 15]
 * R: []
 * P: [0, 1, 2, 5, 6, 7, 8, 9, 11, 14, 17, 19]

_Infecting:_ 16 18 

 * S: []
 * I: [3, 4, 10, 12, 13, 15, 16, 18]
 * R: []
 * P: [0, 1, 2, 5, 6, 7, 8, 9, 11, 14, 17, 19]

__Nothing more to protect.__
Ending model with 12 protected and 8 infected vertices in 4 turns.

## Outbreak: 5
* Agent at vertex 0: peril 1.00, protection 0.93 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 1.00, protection 0.12 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 1.00, protection 0.62 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 4: peril 1.00, protection 0.05 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 1.00, protection 0.33 and state INFECTED.
* Agent at vertex 6: peril 1.00, protection 0.82 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.06 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 0.50, protection 0.64 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 0.50, protection 0.69 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 0.50, protection 0.23 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 0.50, protection 0.38 and state SUSCEPTIBLE.
* Agent at vertex 12: peril 1.00, protection 0.54 and state SUSCEPTIBLE.
* Agent at vertex 13: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 14: peril 1.00, protection 0.98 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 1.00, protection 0.31 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 1.00, protection 0.12 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 1.00, protection 0.59 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 0.50, protection 0.33 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 0.50, protection 1.00 and state PROTECTED.

#### Proximity to Infection Defence


 * S: [0, 1, 2, 4, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18]
 * I: [5]
 * R: []
 * P: [3, 13, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.04, 0.0, 0.0, 0.0, 0.0, 0.94, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.02, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 2, 4, 6, 8, 9, 10, 11, 12, 15, 16, 17, 18]
 * I: [5]
 * R: []
 * P: [3, 7, 13, 14, 19]

_Infecting:_ 0 1 2 4 6 12 15 16 17 

 * S: [8, 9, 10, 11, 18]
 * I: [0, 1, 2, 4, 5, 6, 12, 15, 16, 17]
 * R: []
 * P: [3, 7, 13, 14, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.31, 0.0, 0.62, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.07, 0.0]


 * S: [8, 10, 18]
 * I: [0, 1, 2, 4, 5, 6, 12, 15, 16, 17]
 * R: []
 * P: [3, 7, 9, 11, 13, 14, 19]

_Infecting:_ 8 10 18 

 * S: []
 * I: [0, 1, 2, 4, 5, 6, 8, 10, 12, 15, 16, 17, 18]
 * R: []
 * P: [3, 7, 9, 11, 13, 14, 19]

__Nothing more to protect.__
Ending model with 7 protected and 13 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [0, 1, 2, 4, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18]
 * I: [5]
 * R: []
 * P: [3, 13, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.04, 0.0, 0.0, 0.0, 0.0, 0.94, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.02, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 2, 4, 6, 8, 9, 10, 11, 12, 15, 16, 17, 18]
 * I: [5]
 * R: []
 * P: [3, 7, 13, 14, 19]

_Infecting:_ 0 1 2 4 6 12 15 16 17 

 * S: [8, 9, 10, 11, 18]
 * I: [0, 1, 2, 4, 5, 6, 12, 15, 16, 17]
 * R: []
 * P: [3, 7, 13, 14, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.31, 0.0, 0.62, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.07, 0.0]


 * S: [8, 10, 18]
 * I: [0, 1, 2, 4, 5, 6, 12, 15, 16, 17]
 * R: []
 * P: [3, 7, 9, 11, 13, 14, 19]

_Infecting:_ 8 10 18 

 * S: []
 * I: [0, 1, 2, 4, 5, 6, 8, 10, 12, 15, 16, 17, 18]
 * R: []
 * P: [3, 7, 9, 11, 13, 14, 19]

__Nothing more to protect.__
Ending model with 7 protected and 13 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [0, 1, 2, 4, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18]
 * I: [5]
 * R: []
 * P: [3, 13, 19]
total defence: 1.0

_Strategy:_ [0.07, 0.0, 0.05, 0.0, 0.0, 0.0, 0.18, 0.0, 0.36, 0.31, 0.0, 0.0, 0.0, 0.0, 0.02, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 2, 4, 7, 10, 11, 12, 15, 16, 17, 18]
 * I: [5]
 * R: []
 * P: [0, 3, 6, 8, 9, 13, 14, 19]

_Infecting:_ 1 2 4 7 12 15 16 17 

 * S: [10, 11, 18]
 * I: [1, 2, 4, 5, 7, 12, 15, 16, 17]
 * R: []
 * P: [0, 3, 6, 8, 9, 13, 14, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.62, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.38, 0.0]


 * S: [10, 18]
 * I: [1, 2, 4, 5, 7, 12, 15, 16, 17]
 * R: []
 * P: [0, 3, 6, 8, 9, 11, 13, 14, 19]

_Infecting:_ 10 18 

 * S: []
 * I: [1, 2, 4, 5, 7, 10, 12, 15, 16, 17, 18]
 * R: []
 * P: [0, 3, 6, 8, 9, 11, 13, 14, 19]

__Nothing more to protect.__
Ending model with 9 protected and 11 infected vertices in 4 turns.

## Outbreak: 6
* Agent at vertex 0: peril 1.00, protection 0.20 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 0.50, protection 0.66 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 0.50, protection 0.08 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 5: peril 1.00, protection 0.23 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 1.00, protection 0.02 and state INFECTED.
* Agent at vertex 7: peril 1.00, protection 0.62 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 0.50, protection 0.55 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 1.00, protection 0.54 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 0.50, protection 0.27 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 12: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 13: peril 1.00, protection 0.82 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 1.00, protection 0.59 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 1.00, protection 0.77 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 17: peril 0.50, protection 0.92 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 1.00, protection 0.85 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 1.00, protection 0.82 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [0, 1, 2, 5, 7, 8, 9, 10, 13, 14, 15, 17, 18, 19]
 * I: [6]
 * R: []
 * P: [3, 4, 11, 12, 16]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.03, 0.0, 0.38, 0.0, 0.0, 0.0, 0.0, 0.0, 0.18, 0.41, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 2, 5, 8, 9, 10, 15, 17, 18, 19]
 * I: [6]
 * R: []
 * P: [3, 4, 7, 11, 12, 13, 14, 16]

_Infecting:_ 0 5 9 15 18 19 

 * S: [1, 2, 8, 10, 17]
 * I: [0, 5, 6, 9, 15, 18, 19]
 * R: []
 * P: [3, 4, 7, 11, 12, 13, 14, 16]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.92, 0.0, 0.0, 0.0, 0.0, 0.0, 0.08, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 8, 10, 17]
 * I: [0, 5, 6, 9, 15, 18, 19]
 * R: []
 * P: [2, 3, 4, 7, 11, 12, 13, 14, 16]

_Infecting:_ 1 8 10 17 

 * S: []
 * I: [0, 1, 5, 6, 8, 9, 10, 15, 17, 18, 19]
 * R: []
 * P: [2, 3, 4, 7, 11, 12, 13, 14, 16]

__Nothing more to protect.__
Ending model with 9 protected and 11 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [0, 1, 2, 5, 7, 8, 9, 10, 13, 14, 15, 17, 18, 19]
 * I: [6]
 * R: []
 * P: [3, 4, 11, 12, 16]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.03, 0.0, 0.38, 0.0, 0.0, 0.0, 0.0, 0.0, 0.18, 0.41, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 2, 5, 8, 9, 10, 15, 17, 18, 19]
 * I: [6]
 * R: []
 * P: [3, 4, 7, 11, 12, 13, 14, 16]

_Infecting:_ 0 5 9 15 18 19 

 * S: [1, 2, 8, 10, 17]
 * I: [0, 5, 6, 9, 15, 18, 19]
 * R: []
 * P: [3, 4, 7, 11, 12, 13, 14, 16]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.92, 0.0, 0.0, 0.0, 0.0, 0.0, 0.08, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 8, 10, 17]
 * I: [0, 5, 6, 9, 15, 18, 19]
 * R: []
 * P: [2, 3, 4, 7, 11, 12, 13, 14, 16]

_Infecting:_ 1 8 10 17 

 * S: []
 * I: [0, 1, 5, 6, 8, 9, 10, 15, 17, 18, 19]
 * R: []
 * P: [2, 3, 4, 7, 11, 12, 13, 14, 16]

__Nothing more to protect.__
Ending model with 9 protected and 11 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [0, 1, 2, 5, 7, 8, 9, 10, 13, 14, 15, 17, 18, 19]
 * I: [6]
 * R: []
 * P: [3, 4, 11, 12, 16]
total defence: 1.0

_Strategy:_ [0.0, 0.19, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.23, 0.0, 0.08, 0.15, 0.18]


 * S: [0, 1, 2, 5, 7, 8, 9, 10, 14]
 * I: [6]
 * R: []
 * P: [3, 4, 11, 12, 13, 15, 16, 17, 18, 19]

_Infecting:_ 0 5 7 9 14 

 * S: [1, 2, 8, 10]
 * I: [0, 5, 6, 7, 9, 14]
 * R: []
 * P: [3, 4, 11, 12, 13, 15, 16, 17, 18, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.14, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.45, 0.0, 0.41, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [2, 10]
 * I: [0, 5, 6, 7, 9, 14]
 * R: []
 * P: [1, 3, 4, 8, 11, 12, 13, 15, 16, 17, 18, 19]

_Infecting:_ 2 10 

 * S: []
 * I: [0, 2, 5, 6, 7, 9, 10, 14]
 * R: []
 * P: [1, 3, 4, 8, 11, 12, 13, 15, 16, 17, 18, 19]

__Nothing more to protect.__
Ending model with 12 protected and 8 infected vertices in 4 turns.

## Outbreak: 7
* Agent at vertex 0: peril 0.50, protection 0.50 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 2: peril 1.00, protection 0.14 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 1.00, protection 0.25 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 5: peril 1.00, protection 0.19 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 1.00, protection 0.41 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.80 and state INFECTED.
* Agent at vertex 8: peril 1.00, protection 0.94 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 1.00, protection 0.84 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 11: peril 1.00, protection 0.64 and state SUSCEPTIBLE.
* Agent at vertex 12: peril 1.00, protection 0.34 and state SUSCEPTIBLE.
* Agent at vertex 13: peril 1.00, protection 0.42 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 1.00, protection 0.17 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 1.00, protection 0.18 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 0.50, protection 0.71 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 1.00, protection 0.06 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 19: peril 0.50, protection 1.00 and state PROTECTED.

#### Proximity to Infection Defence


 * S: [0, 2, 3, 5, 6, 8, 9, 11, 12, 13, 14, 15, 16, 17]
 * I: [7]
 * R: []
 * P: [1, 4, 10, 18, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.58, 0.42, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 2, 3, 5, 6, 8, 9, 11, 12, 14, 15, 16, 17]
 * I: [7]
 * R: []
 * P: [1, 4, 10, 13, 18, 19]

_Infecting:_ 2 3 5 6 8 9 11 12 14 15 17 

 * S: [0, 16]
 * I: [2, 3, 5, 6, 7, 8, 9, 11, 12, 14, 15, 17]
 * R: []
 * P: [1, 4, 10, 13, 18, 19]
total defence: 1.0

_Strategy:_ [0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.29, 0.0, 0.0, 0.0]


 * S: []
 * I: [2, 3, 5, 6, 7, 8, 9, 11, 12, 14, 15, 17]
 * R: []
 * P: [0, 1, 4, 10, 13, 16, 18, 19]

__Nothing more to infect.__
Ending model with 8 protected and 12 infected vertices in 3 turns.

#### Greatest Degree Defence


 * S: [0, 2, 3, 5, 6, 8, 9, 11, 12, 13, 14, 15, 16, 17]
 * I: [7]
 * R: []
 * P: [1, 4, 10, 18, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.58, 0.42, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 2, 3, 5, 6, 8, 9, 11, 12, 14, 15, 16, 17]
 * I: [7]
 * R: []
 * P: [1, 4, 10, 13, 18, 19]

_Infecting:_ 2 3 5 6 8 9 11 12 14 15 17 

 * S: [0, 16]
 * I: [2, 3, 5, 6, 7, 8, 9, 11, 12, 14, 15, 17]
 * R: []
 * P: [1, 4, 10, 13, 18, 19]
total defence: 1.0

_Strategy:_ [0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.29, 0.0, 0.0, 0.0]


 * S: []
 * I: [2, 3, 5, 6, 7, 8, 9, 11, 12, 14, 15, 17]
 * R: []
 * P: [0, 1, 4, 10, 13, 16, 18, 19]

__Nothing more to infect.__
Ending model with 8 protected and 12 infected vertices in 3 turns.

#### Highest Protection Defence


 * S: [0, 2, 3, 5, 6, 8, 9, 11, 12, 13, 14, 15, 16, 17]
 * I: [7]
 * R: []
 * P: [1, 4, 10, 18, 19]
total defence: 1.0

_Strategy:_ [0.12, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.06, 0.16, 0.0, 0.36, 0.0, 0.0, 0.0, 0.0, 0.29, 0.0, 0.0, 0.0]


 * S: [0, 2, 3, 5, 6, 12, 13, 14, 15, 17]
 * I: [7]
 * R: []
 * P: [1, 4, 8, 9, 10, 11, 16, 18, 19]

_Infecting:_ 2 3 5 6 12 13 14 15 17 

 * S: [0]
 * I: [2, 3, 5, 6, 7, 12, 13, 14, 15, 17]
 * R: []
 * P: [1, 4, 8, 9, 10, 11, 16, 18, 19]
total defence: 1.0

_Strategy:_ [0.37, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [2, 3, 5, 6, 7, 12, 13, 14, 15, 17]
 * R: []
 * P: [0, 1, 4, 8, 9, 10, 11, 16, 18, 19]

__Nothing more to infect.__
Ending model with 10 protected and 10 infected vertices in 3 turns.

## Outbreak: 8
* Agent at vertex 0: peril 0.50, protection 0.77 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 0.50, protection 0.14 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 1.00, protection 0.73 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 1.00, protection 0.96 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 0.50, protection 0.47 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 0.50, protection 0.08 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 0.50, protection 0.45 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.42 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 1.00, protection 0.30 and state INFECTED.
* Agent at vertex 9: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 10: peril 0.50, protection 0.23 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 12: peril 0.50, protection 0.95 and state SUSCEPTIBLE.
* Agent at vertex 13: peril 1.00, protection 0.72 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 1.00, protection 0.76 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 16: peril 1.00, protection 0.33 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 1.00, protection 0.10 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 1.00, protection 0.77 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 1.00, protection 0.64 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [0, 1, 2, 3, 4, 5, 6, 7, 10, 12, 13, 14, 16, 17, 18, 19]
 * I: [8]
 * R: []
 * P: [9, 11, 15]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.58, 0.0, 0.0, 0.0, 0.0, 0.0, 0.28, 0.14, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 2, 3, 4, 5, 6, 10, 12, 14, 16, 17, 18, 19]
 * I: [8]
 * R: []
 * P: [7, 9, 11, 13, 15]

_Infecting:_ 2 3 14 16 17 18 19 

 * S: [0, 1, 4, 5, 6, 10, 12]
 * I: [2, 3, 8, 14, 16, 17, 18, 19]
 * R: []
 * P: [7, 9, 11, 13, 15]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.92, 0.08, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 4, 6, 10, 12]
 * I: [2, 3, 8, 14, 16, 17, 18, 19]
 * R: []
 * P: [5, 7, 9, 11, 13, 15]

_Infecting:_ 0 1 4 6 10 

 * S: [12]
 * I: [0, 1, 2, 3, 4, 6, 8, 10, 14, 16, 17, 18, 19]
 * R: []
 * P: [5, 7, 9, 11, 13, 15]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.05, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [0, 1, 2, 3, 4, 6, 8, 10, 14, 16, 17, 18, 19]
 * R: []
 * P: [5, 7, 9, 11, 12, 13, 15]

__Nothing more to infect.__
Ending model with 7 protected and 13 infected vertices in 5 turns.

#### Greatest Degree Defence


 * S: [0, 1, 2, 3, 4, 5, 6, 7, 10, 12, 13, 14, 16, 17, 18, 19]
 * I: [8]
 * R: []
 * P: [9, 11, 15]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.58, 0.0, 0.0, 0.0, 0.0, 0.0, 0.28, 0.14, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 2, 3, 4, 5, 6, 10, 12, 14, 16, 17, 18, 19]
 * I: [8]
 * R: []
 * P: [7, 9, 11, 13, 15]

_Infecting:_ 2 3 14 16 17 18 19 

 * S: [0, 1, 4, 5, 6, 10, 12]
 * I: [2, 3, 8, 14, 16, 17, 18, 19]
 * R: []
 * P: [7, 9, 11, 13, 15]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.92, 0.08, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 4, 6, 10, 12]
 * I: [2, 3, 8, 14, 16, 17, 18, 19]
 * R: []
 * P: [5, 7, 9, 11, 13, 15]

_Infecting:_ 0 1 4 6 10 

 * S: [12]
 * I: [0, 1, 2, 3, 4, 6, 8, 10, 14, 16, 17, 18, 19]
 * R: []
 * P: [5, 7, 9, 11, 13, 15]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.05, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [0, 1, 2, 3, 4, 6, 8, 10, 14, 16, 17, 18, 19]
 * R: []
 * P: [5, 7, 9, 11, 12, 13, 15]

__Nothing more to infect.__
Ending model with 7 protected and 13 infected vertices in 5 turns.

#### Highest Protection Defence


 * S: [0, 1, 2, 3, 4, 5, 6, 7, 10, 12, 13, 14, 16, 17, 18, 19]
 * I: [8]
 * R: []
 * P: [9, 11, 15]
total defence: 1.0

_Strategy:_ [0.23, 0.0, 0.2, 0.04, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.05, 0.0, 0.24, 0.0, 0.0, 0.0, 0.23, 0.0]


 * S: [1, 2, 4, 5, 6, 7, 10, 13, 16, 17, 19]
 * I: [8]
 * R: []
 * P: [0, 3, 9, 11, 12, 14, 15, 18]

_Infecting:_ 2 7 13 16 17 19 

 * S: [1, 4, 5, 6, 10]
 * I: [2, 7, 8, 13, 16, 17, 19]
 * R: []
 * P: [0, 3, 9, 11, 12, 14, 15, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.53, 0.0, 0.47, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 5, 6, 10]
 * I: [2, 7, 8, 13, 16, 17, 19]
 * R: []
 * P: [0, 3, 4, 9, 11, 12, 14, 15, 18]

_Infecting:_ 1 5 6 10 

 * S: []
 * I: [1, 2, 5, 6, 7, 8, 10, 13, 16, 17, 19]
 * R: []
 * P: [0, 3, 4, 9, 11, 12, 14, 15, 18]

__Nothing more to protect.__
Ending model with 9 protected and 11 infected vertices in 4 turns.

## Outbreak: 9
* Agent at vertex 0: peril 0.50, protection 0.86 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 0.50, protection 0.65 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 1.00, protection 0.67 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 1.00, protection 0.44 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 5: peril 0.50, protection 0.21 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 1.00, protection 0.23 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.40 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 9: peril 1.00, protection 0.77 and state INFECTED.
* Agent at vertex 10: peril 0.50, protection 0.43 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 1.00, protection 0.73 and state SUSCEPTIBLE.
* Agent at vertex 12: peril 1.00, protection 0.57 and state SUSCEPTIBLE.
* Agent at vertex 13: peril 1.00, protection 0.48 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 1.00, protection 0.89 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 1.00, protection 0.96 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 1.00, protection 0.45 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 18: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 19: peril 0.50, protection 0.37 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [0, 1, 2, 3, 5, 6, 7, 10, 11, 12, 13, 14, 15, 16, 19]
 * I: [9]
 * R: []
 * P: [4, 8, 17, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.48, 0.0, 0.0, 0.0, 0.0, 0.0, 0.52, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 2, 3, 5, 6, 7, 10, 11, 12, 14, 15, 16, 19]
 * I: [9]
 * R: []
 * P: [4, 8, 13, 17, 18]

_Infecting:_ 2 3 6 7 11 12 14 15 16 

 * S: [0, 1, 5, 10, 19]
 * I: [2, 3, 6, 7, 9, 11, 12, 14, 15, 16]
 * R: []
 * P: [4, 8, 13, 17, 18]
total defence: 1.0

_Strategy:_ [0.14, 0.0, 0.0, 0.0, 0.0, 0.79, 0.0, 0.0, 0.0, 0.0, 0.07, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 10, 19]
 * I: [2, 3, 6, 7, 9, 11, 12, 14, 15, 16]
 * R: []
 * P: [0, 4, 5, 8, 13, 17, 18]

_Infecting:_ 1 10 19 

 * S: []
 * I: [1, 2, 3, 6, 7, 9, 10, 11, 12, 14, 15, 16, 19]
 * R: []
 * P: [0, 4, 5, 8, 13, 17, 18]

__Nothing more to protect.__
Ending model with 7 protected and 13 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [0, 1, 2, 3, 5, 6, 7, 10, 11, 12, 13, 14, 15, 16, 19]
 * I: [9]
 * R: []
 * P: [4, 8, 17, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.48, 0.0, 0.0, 0.0, 0.0, 0.0, 0.52, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 2, 3, 5, 6, 7, 10, 11, 12, 14, 15, 16, 19]
 * I: [9]
 * R: []
 * P: [4, 8, 13, 17, 18]

_Infecting:_ 2 3 6 7 11 12 14 15 16 

 * S: [0, 1, 5, 10, 19]
 * I: [2, 3, 6, 7, 9, 11, 12, 14, 15, 16]
 * R: []
 * P: [4, 8, 13, 17, 18]
total defence: 1.0

_Strategy:_ [0.14, 0.0, 0.0, 0.0, 0.0, 0.79, 0.0, 0.0, 0.0, 0.0, 0.07, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 10, 19]
 * I: [2, 3, 6, 7, 9, 11, 12, 14, 15, 16]
 * R: []
 * P: [0, 4, 5, 8, 13, 17, 18]

_Infecting:_ 1 10 19 

 * S: []
 * I: [1, 2, 3, 6, 7, 9, 10, 11, 12, 14, 15, 16, 19]
 * R: []
 * P: [0, 4, 5, 8, 13, 17, 18]

__Nothing more to protect.__
Ending model with 7 protected and 13 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [0, 1, 2, 3, 5, 6, 7, 10, 11, 12, 13, 14, 15, 16, 19]
 * I: [9]
 * R: []
 * P: [4, 8, 17, 18]
total defence: 1.0

_Strategy:_ [0.14, 0.11, 0.33, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.27, 0.0, 0.0, 0.11, 0.04, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 3, 5, 6, 7, 10, 12, 13, 16, 19]
 * I: [9]
 * R: []
 * P: [0, 2, 4, 8, 11, 14, 15, 17, 18]

_Infecting:_ 3 6 7 12 13 16 

 * S: [1, 5, 10, 19]
 * I: [3, 6, 7, 9, 12, 13, 16]
 * R: []
 * P: [0, 2, 4, 8, 11, 14, 15, 17, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.24, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.57, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.19]


 * S: [5, 19]
 * I: [3, 6, 7, 9, 12, 13, 16]
 * R: []
 * P: [0, 1, 2, 4, 8, 10, 11, 14, 15, 17, 18]

_Infecting:_ 5 19 

 * S: []
 * I: [3, 5, 6, 7, 9, 12, 13, 16, 19]
 * R: []
 * P: [0, 1, 2, 4, 8, 10, 11, 14, 15, 17, 18]

__Nothing more to protect.__
Ending model with 11 protected and 9 infected vertices in 4 turns.

## Outbreak: 10
* Agent at vertex 0: peril 1.00, protection 0.63 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 1.00, protection 0.81 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 0.50, protection 0.25 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 0.50, protection 0.32 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 1.00, protection 0.52 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 6: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 7: peril 0.50, protection 0.74 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 0.50, protection 0.86 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 0.50, protection 1.00 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 1.00, protection 0.66 and state INFECTED.
* Agent at vertex 11: peril 1.00, protection 0.21 and state SUSCEPTIBLE.
* Agent at vertex 12: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 13: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 14: peril 0.50, protection 0.22 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 1.00, protection 0.13 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 1.00, protection 0.80 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 1.00, protection 0.03 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 1.00, protection 0.07 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 0.50, protection 1.00 and state PROTECTED.

#### Proximity to Infection Defence


 * S: [0, 1, 2, 3, 4, 7, 8, 9, 11, 14, 15, 16, 17, 18]
 * I: [10]
 * R: []
 * P: [5, 6, 12, 13, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.79, 0.0, 0.0, 0.0, 0.21, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 2, 3, 4, 7, 8, 9, 14, 15, 16, 17, 18]
 * I: [10]
 * R: []
 * P: [5, 6, 11, 12, 13, 19]

_Infecting:_ 0 1 4 15 16 17 18 

 * S: [2, 3, 7, 8, 9, 14]
 * I: [0, 1, 4, 10, 15, 16, 17, 18]
 * R: []
 * P: [5, 6, 11, 12, 13, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.26, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.74, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [2, 3, 8, 9, 14]
 * I: [0, 1, 4, 10, 15, 16, 17, 18]
 * R: []
 * P: [5, 6, 7, 11, 12, 13, 19]

_Infecting:_ 2 3 8 9 14 

 * S: []
 * I: [0, 1, 2, 3, 4, 8, 9, 10, 14, 15, 16, 17, 18]
 * R: []
 * P: [5, 6, 7, 11, 12, 13, 19]

__Nothing more to protect.__
Ending model with 7 protected and 13 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [0, 1, 2, 3, 4, 7, 8, 9, 11, 14, 15, 16, 17, 18]
 * I: [10]
 * R: []
 * P: [5, 6, 12, 13, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.26, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.74, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 2, 3, 4, 8, 9, 11, 14, 15, 16, 17, 18]
 * I: [10]
 * R: []
 * P: [5, 6, 7, 12, 13, 19]

_Infecting:_ 0 1 4 11 15 16 17 18 

 * S: [2, 3, 8, 9, 14]
 * I: [0, 1, 4, 10, 11, 15, 16, 17, 18]
 * R: []
 * P: [5, 6, 7, 12, 13, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.75, 0.22, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.03, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [3, 8, 9]
 * I: [0, 1, 4, 10, 11, 15, 16, 17, 18]
 * R: []
 * P: [2, 5, 6, 7, 12, 13, 14, 19]

_Infecting:_ 3 8 9 

 * S: []
 * I: [0, 1, 3, 4, 8, 9, 10, 11, 15, 16, 17, 18]
 * R: []
 * P: [2, 5, 6, 7, 12, 13, 14, 19]

__Nothing more to protect.__
Ending model with 8 protected and 12 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [0, 1, 2, 3, 4, 7, 8, 9, 11, 14, 15, 16, 17, 18]
 * I: [10]
 * R: []
 * P: [5, 6, 12, 13, 19]
total defence: 1.0

_Strategy:_ [0.21, 0.19, 0.0, 0.0, 0.0, 0.0, 0.0, 0.26, 0.14, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.2, 0.0, 0.0, 0.0]


 * S: [0, 2, 3, 4, 11, 14, 15, 17, 18]
 * I: [10]
 * R: []
 * P: [1, 5, 6, 7, 8, 9, 12, 13, 16, 19]

_Infecting:_ 0 4 11 15 17 18 

 * S: [2, 3, 14]
 * I: [0, 4, 10, 11, 15, 17, 18]
 * R: []
 * P: [1, 5, 6, 7, 8, 9, 12, 13, 16, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.32, 0.68, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [2, 14]
 * I: [0, 4, 10, 11, 15, 17, 18]
 * R: []
 * P: [1, 3, 5, 6, 7, 8, 9, 12, 13, 16, 19]

_Infecting:_ 2 14 

 * S: []
 * I: [0, 2, 4, 10, 11, 14, 15, 17, 18]
 * R: []
 * P: [1, 3, 5, 6, 7, 8, 9, 12, 13, 16, 19]

__Nothing more to protect.__
Ending model with 11 protected and 9 infected vertices in 4 turns.

## Outbreak: 11
* Agent at vertex 0: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 1: peril 1.00, protection 0.36 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 3: peril 1.00, protection 0.01 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 5: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 6: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 7: peril 1.00, protection 0.49 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 9: peril 1.00, protection 0.62 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 1.00, protection 0.80 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 1.00, protection 0.75 and state INFECTED.
* Agent at vertex 12: peril 1.00, protection 0.55 and state SUSCEPTIBLE.
* Agent at vertex 13: peril 1.00, protection 0.21 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 0.50, protection 0.05 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 16: peril 1.00, protection 0.90 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 18: peril 1.00, protection 0.95 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 1.00, protection 0.41 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [1, 3, 7, 9, 10, 12, 13, 14, 16, 18, 19]
 * I: [11]
 * R: []
 * P: [0, 2, 4, 5, 6, 8, 15, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.21, 0.0, 0.0, 0.0, 0.0, 0.0, 0.79, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 3, 7, 9, 10, 12, 14, 16, 18, 19]
 * I: [11]
 * R: []
 * P: [0, 2, 4, 5, 6, 8, 13, 15, 17]

_Infecting:_ 1 3 7 9 10 12 16 18 19 

 * S: [14]
 * I: [1, 3, 7, 9, 10, 11, 12, 16, 18, 19]
 * R: []
 * P: [0, 2, 4, 5, 6, 8, 13, 15, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.95, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [1, 3, 7, 9, 10, 11, 12, 16, 18, 19]
 * R: []
 * P: [0, 2, 4, 5, 6, 8, 13, 14, 15, 17]

__Nothing more to infect.__
Ending model with 10 protected and 10 infected vertices in 3 turns.

#### Greatest Degree Defence


 * S: [1, 3, 7, 9, 10, 12, 13, 14, 16, 18, 19]
 * I: [11]
 * R: []
 * P: [0, 2, 4, 5, 6, 8, 15, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.21, 0.0, 0.0, 0.0, 0.0, 0.0, 0.79, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 3, 7, 9, 10, 12, 14, 16, 18, 19]
 * I: [11]
 * R: []
 * P: [0, 2, 4, 5, 6, 8, 13, 15, 17]

_Infecting:_ 1 3 7 9 10 12 16 18 19 

 * S: [14]
 * I: [1, 3, 7, 9, 10, 11, 12, 16, 18, 19]
 * R: []
 * P: [0, 2, 4, 5, 6, 8, 13, 15, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.95, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [1, 3, 7, 9, 10, 11, 12, 16, 18, 19]
 * R: []
 * P: [0, 2, 4, 5, 6, 8, 13, 14, 15, 17]

__Nothing more to infect.__
Ending model with 10 protected and 10 infected vertices in 3 turns.

#### Highest Protection Defence


 * S: [1, 3, 7, 9, 10, 12, 13, 14, 16, 18, 19]
 * I: [11]
 * R: []
 * P: [0, 2, 4, 5, 6, 8, 15, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.38, 0.2, 0.0, 0.27, 0.0, 0.0, 0.0, 0.1, 0.0, 0.05, 0.0]


 * S: [1, 3, 7, 12, 13, 14, 19]
 * I: [11]
 * R: []
 * P: [0, 2, 4, 5, 6, 8, 9, 10, 15, 16, 17, 18]

_Infecting:_ 1 3 7 12 13 19 

 * S: [14]
 * I: [1, 3, 7, 11, 12, 13, 19]
 * R: []
 * P: [0, 2, 4, 5, 6, 8, 9, 10, 15, 16, 17, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.95, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [1, 3, 7, 11, 12, 13, 19]
 * R: []
 * P: [0, 2, 4, 5, 6, 8, 9, 10, 14, 15, 16, 17, 18]

__Nothing more to infect.__
Ending model with 13 protected and 7 infected vertices in 3 turns.

## Outbreak: 12
* Agent at vertex 0: peril 1.00, protection 0.30 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 2: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 3: peril 0.50, protection 0.06 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 1.00, protection 0.32 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 1.00, protection 0.97 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 7: peril 1.00, protection 0.31 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 9: peril 1.00, protection 0.43 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 11: peril 1.00, protection 0.38 and state SUSCEPTIBLE.
* Agent at vertex 12: peril 1.00, protection 0.98 and state INFECTED.
* Agent at vertex 13: peril 0.50, protection 0.22 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 15: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 16: peril 0.50, protection 0.21 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 0.50, protection 0.19 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 19: peril 0.50, protection 1.00 and state PROTECTED.

#### Proximity to Infection Defence


 * S: [0, 3, 4, 5, 7, 9, 11, 13, 16, 17]
 * I: [12]
 * R: []
 * P: [1, 2, 6, 8, 10, 14, 15, 18, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.03, 0.0, 0.69, 0.0, 0.27, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 3, 4, 9, 11, 13, 16, 17]
 * I: [12]
 * R: []
 * P: [1, 2, 5, 6, 7, 8, 10, 14, 15, 18, 19]

_Infecting:_ 0 4 9 11 

 * S: [3, 13, 16, 17]
 * I: [0, 4, 9, 11, 12]
 * R: []
 * P: [1, 2, 5, 6, 7, 8, 10, 14, 15, 18, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.22, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.78, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [3, 16, 17]
 * I: [0, 4, 9, 11, 12]
 * R: []
 * P: [1, 2, 5, 6, 7, 8, 10, 13, 14, 15, 18, 19]

_Infecting:_ 3 16 

 * S: [17]
 * I: [0, 3, 4, 9, 11, 12, 16]
 * R: []
 * P: [1, 2, 5, 6, 7, 8, 10, 13, 14, 15, 18, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.81, 0.0, 0.0]


 * S: []
 * I: [0, 3, 4, 9, 11, 12, 16]
 * R: []
 * P: [1, 2, 5, 6, 7, 8, 10, 13, 14, 15, 17, 18, 19]

__Nothing more to infect.__
Ending model with 13 protected and 7 infected vertices in 5 turns.

#### Greatest Degree Defence


 * S: [0, 3, 4, 5, 7, 9, 11, 13, 16, 17]
 * I: [12]
 * R: []
 * P: [1, 2, 6, 8, 10, 14, 15, 18, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.22, 0.0, 0.0, 0.0, 0.0, 0.0, 0.78, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 3, 4, 5, 7, 9, 11, 16, 17]
 * I: [12]
 * R: []
 * P: [1, 2, 6, 8, 10, 13, 14, 15, 18, 19]

_Infecting:_ 0 4 5 7 9 11 

 * S: [3, 16, 17]
 * I: [0, 4, 5, 7, 9, 11, 12]
 * R: []
 * P: [1, 2, 6, 8, 10, 13, 14, 15, 18, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.94, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.06, 0.0, 0.0, 0.0]


 * S: [16, 17]
 * I: [0, 4, 5, 7, 9, 11, 12]
 * R: []
 * P: [1, 2, 3, 6, 8, 10, 13, 14, 15, 18, 19]

_Infecting:_ 16 17 

 * S: []
 * I: [0, 4, 5, 7, 9, 11, 12, 16, 17]
 * R: []
 * P: [1, 2, 3, 6, 8, 10, 13, 14, 15, 18, 19]

__Nothing more to protect.__
Ending model with 11 protected and 9 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [0, 3, 4, 5, 7, 9, 11, 13, 16, 17]
 * I: [12]
 * R: []
 * P: [1, 2, 6, 8, 10, 14, 15, 18, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.03, 0.0, 0.0, 0.0, 0.57, 0.0, 0.39, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 3, 4, 7, 11, 13, 16, 17]
 * I: [12]
 * R: []
 * P: [1, 2, 5, 6, 8, 9, 10, 14, 15, 18, 19]

_Infecting:_ 0 4 7 11 

 * S: [3, 13, 16, 17]
 * I: [0, 4, 7, 11, 12]
 * R: []
 * P: [1, 2, 5, 6, 8, 9, 10, 14, 15, 18, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.78, 0.0, 0.0, 0.22, 0.0, 0.0, 0.0]


 * S: [3, 16, 17]
 * I: [0, 4, 7, 11, 12]
 * R: []
 * P: [1, 2, 5, 6, 8, 9, 10, 13, 14, 15, 18, 19]

_Infecting:_ 3 16 17 

 * S: []
 * I: [0, 3, 4, 7, 11, 12, 16, 17]
 * R: []
 * P: [1, 2, 5, 6, 8, 9, 10, 13, 14, 15, 18, 19]

__Nothing more to protect.__
Ending model with 12 protected and 8 infected vertices in 4 turns.

## Outbreak: 13
* Agent at vertex 0: peril 1.00, protection 0.81 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 2: peril 1.00, protection 0.21 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 4: peril 1.00, protection 0.92 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 6: peril 1.00, protection 0.67 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.82 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 1.00, protection 0.06 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 1.00, protection 0.56 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 11: peril 1.00, protection 0.24 and state SUSCEPTIBLE.
* Agent at vertex 12: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 13: peril 1.00, protection 0.94 and state INFECTED.
* Agent at vertex 14: peril 1.00, protection 0.67 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 0.50, protection 0.55 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 1.00, protection 0.43 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 1.00, protection 0.42 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 1.00, protection 0.49 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 1.00, protection 0.83 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [0, 2, 4, 6, 7, 8, 9, 11, 14, 15, 16, 17, 18, 19]
 * I: [13]
 * R: []
 * P: [1, 3, 5, 10, 12]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.48, 0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.33, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 2, 4, 6, 8, 9, 11, 15, 16, 17, 18, 19]
 * I: [13]
 * R: []
 * P: [1, 3, 5, 7, 10, 12, 14]

_Infecting:_ 0 2 4 6 8 9 11 16 17 18 19 

 * S: [15]
 * I: [0, 2, 4, 6, 8, 9, 11, 13, 16, 17, 18, 19]
 * R: []
 * P: [1, 3, 5, 7, 10, 12, 14]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.45, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [0, 2, 4, 6, 8, 9, 11, 13, 16, 17, 18, 19]
 * R: []
 * P: [1, 3, 5, 7, 10, 12, 14, 15]

__Nothing more to infect.__
Ending model with 8 protected and 12 infected vertices in 3 turns.

#### Greatest Degree Defence


 * S: [0, 2, 4, 6, 7, 8, 9, 11, 14, 15, 16, 17, 18, 19]
 * I: [13]
 * R: []
 * P: [1, 3, 5, 10, 12]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.48, 0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.33, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 2, 4, 6, 8, 9, 11, 15, 16, 17, 18, 19]
 * I: [13]
 * R: []
 * P: [1, 3, 5, 7, 10, 12, 14]

_Infecting:_ 0 2 4 6 8 9 11 16 17 18 19 

 * S: [15]
 * I: [0, 2, 4, 6, 8, 9, 11, 13, 16, 17, 18, 19]
 * R: []
 * P: [1, 3, 5, 7, 10, 12, 14]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.45, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [0, 2, 4, 6, 8, 9, 11, 13, 16, 17, 18, 19]
 * R: []
 * P: [1, 3, 5, 7, 10, 12, 14, 15]

__Nothing more to infect.__
Ending model with 8 protected and 12 infected vertices in 3 turns.

#### Highest Protection Defence


 * S: [0, 2, 4, 6, 7, 8, 9, 11, 14, 15, 16, 17, 18, 19]
 * I: [13]
 * R: []
 * P: [1, 3, 5, 10, 12]
total defence: 1.0

_Strategy:_ [0.19, 0.0, 0.0, 0.0, 0.08, 0.0, 0.04, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.33, 0.0, 0.0, 0.0, 0.0, 0.17]


 * S: [2, 6, 8, 9, 11, 15, 16, 17, 18]
 * I: [13]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 10, 12, 14, 19]

_Infecting:_ 2 6 8 9 11 16 17 18 

 * S: [15]
 * I: [2, 6, 8, 9, 11, 13, 16, 17, 18]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 10, 12, 14, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.45, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [2, 6, 8, 9, 11, 13, 16, 17, 18]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 10, 12, 14, 15, 19]

__Nothing more to infect.__
Ending model with 11 protected and 9 infected vertices in 3 turns.

## Outbreak: 14
* Agent at vertex 0: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 1: peril 1.00, protection 0.97 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 1.00, protection 0.27 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 1.00, protection 0.82 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 5: peril 1.00, protection 0.18 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 1.00, protection 0.06 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.62 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 1.00, protection 0.52 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 1.00, protection 0.41 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 0.50, protection 0.32 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 12: peril 0.50, protection 0.40 and state SUSCEPTIBLE.
* Agent at vertex 13: peril 1.00, protection 0.18 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 1.00, protection 0.56 and state INFECTED.
* Agent at vertex 15: peril 1.00, protection 0.18 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 0.50, protection 0.86 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 1.00, protection 0.81 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 1.00, protection 0.90 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 0.50, protection 0.64 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [1, 2, 3, 5, 6, 7, 8, 9, 10, 12, 13, 15, 16, 17, 18, 19]
 * I: [14]
 * R: []
 * P: [0, 4, 11]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.82, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 2, 3, 5, 6, 7, 8, 9, 10, 12, 15, 16, 17, 18, 19]
 * I: [14]
 * R: []
 * P: [0, 4, 11, 13]

_Infecting:_ 1 2 3 5 6 7 8 9 15 17 18 

 * S: [10, 12, 16, 19]
 * I: [1, 2, 3, 5, 6, 7, 8, 9, 14, 15, 17, 18]
 * R: []
 * P: [0, 4, 11, 13]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.68, 0.0, 0.0, 0.0, 0.0, 0.0, 0.14, 0.0, 0.0, 0.18]


 * S: [12, 19]
 * I: [1, 2, 3, 5, 6, 7, 8, 9, 14, 15, 17, 18]
 * R: []
 * P: [0, 4, 10, 11, 13, 16]

_Infecting:_ 12 19 

 * S: []
 * I: [1, 2, 3, 5, 6, 7, 8, 9, 12, 14, 15, 17, 18, 19]
 * R: []
 * P: [0, 4, 10, 11, 13, 16]

__Nothing more to protect.__
Ending model with 6 protected and 14 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [1, 2, 3, 5, 6, 7, 8, 9, 10, 12, 13, 15, 16, 17, 18, 19]
 * I: [14]
 * R: []
 * P: [0, 4, 11]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.82, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 2, 3, 5, 6, 7, 8, 9, 10, 12, 15, 16, 17, 18, 19]
 * I: [14]
 * R: []
 * P: [0, 4, 11, 13]

_Infecting:_ 1 2 3 5 6 7 8 9 15 17 18 

 * S: [10, 12, 16, 19]
 * I: [1, 2, 3, 5, 6, 7, 8, 9, 14, 15, 17, 18]
 * R: []
 * P: [0, 4, 11, 13]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.68, 0.0, 0.0, 0.0, 0.0, 0.0, 0.14, 0.0, 0.0, 0.18]


 * S: [12, 19]
 * I: [1, 2, 3, 5, 6, 7, 8, 9, 14, 15, 17, 18]
 * R: []
 * P: [0, 4, 10, 11, 13, 16]

_Infecting:_ 12 19 

 * S: []
 * I: [1, 2, 3, 5, 6, 7, 8, 9, 12, 14, 15, 17, 18, 19]
 * R: []
 * P: [0, 4, 10, 11, 13, 16]

__Nothing more to protect.__
Ending model with 6 protected and 14 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [1, 2, 3, 5, 6, 7, 8, 9, 10, 12, 13, 15, 16, 17, 18, 19]
 * I: [14]
 * R: []
 * P: [0, 4, 11]
total defence: 1.0

_Strategy:_ [0.0, 0.03, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.14, 0.19, 0.1, 0.36]


 * S: [2, 5, 6, 7, 8, 9, 10, 12, 13, 15, 19]
 * I: [14]
 * R: []
 * P: [0, 1, 3, 4, 11, 16, 17, 18]

_Infecting:_ 2 5 6 7 8 9 13 15 

 * S: [10, 12, 19]
 * I: [2, 5, 6, 7, 8, 9, 13, 14, 15]
 * R: []
 * P: [0, 1, 3, 4, 11, 16, 17, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.39, 0.0, 0.6, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.01]


 * S: [10]
 * I: [2, 5, 6, 7, 8, 9, 13, 14, 15]
 * R: []
 * P: [0, 1, 3, 4, 11, 12, 16, 17, 18, 19]

_Infecting:_ 10 

 * S: []
 * I: [2, 5, 6, 7, 8, 9, 10, 13, 14, 15]
 * R: []
 * P: [0, 1, 3, 4, 11, 12, 16, 17, 18, 19]

__Nothing more to protect.__
Ending model with 10 protected and 10 infected vertices in 4 turns.

## Outbreak: 15
* Agent at vertex 0: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 1: peril 1.00, protection 0.77 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 3: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 4: peril 1.00, protection 0.12 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 1.00, protection 0.00 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 1.00, protection 0.78 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.59 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 9: peril 1.00, protection 0.12 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 1.00, protection 0.22 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 12: peril 0.50, protection 0.63 and state SUSCEPTIBLE.
* Agent at vertex 13: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 14: peril 1.00, protection 0.99 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 1.00, protection 0.07 and state INFECTED.
* Agent at vertex 16: peril 0.50, protection 0.77 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 1.00, protection 0.51 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 19: peril 1.00, protection 0.61 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [1, 4, 5, 6, 7, 9, 10, 12, 14, 16, 17, 19]
 * I: [15]
 * R: []
 * P: [0, 2, 3, 8, 11, 13, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.58, 0.0, 0.41, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.01, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 4, 5, 6, 9, 10, 12, 16, 17, 19]
 * I: [15]
 * R: []
 * P: [0, 2, 3, 7, 8, 11, 13, 14, 18]

_Infecting:_ 1 4 5 6 9 10 17 19 

 * S: [12, 16]
 * I: [1, 4, 5, 6, 9, 10, 15, 17, 19]
 * R: []
 * P: [0, 2, 3, 7, 8, 11, 13, 14, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.37, 0.0, 0.0, 0.0, 0.23, 0.0, 0.0, 0.0]


 * S: []
 * I: [1, 4, 5, 6, 9, 10, 15, 17, 19]
 * R: []
 * P: [0, 2, 3, 7, 8, 11, 12, 13, 14, 16, 18]

__Nothing more to infect.__
Ending model with 11 protected and 9 infected vertices in 3 turns.

#### Greatest Degree Defence


 * S: [1, 4, 5, 6, 7, 9, 10, 12, 14, 16, 17, 19]
 * I: [15]
 * R: []
 * P: [0, 2, 3, 8, 11, 13, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.58, 0.0, 0.41, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.01, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [1, 4, 5, 6, 9, 10, 12, 16, 17, 19]
 * I: [15]
 * R: []
 * P: [0, 2, 3, 7, 8, 11, 13, 14, 18]

_Infecting:_ 1 4 5 6 9 10 17 19 

 * S: [12, 16]
 * I: [1, 4, 5, 6, 9, 10, 15, 17, 19]
 * R: []
 * P: [0, 2, 3, 7, 8, 11, 13, 14, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.37, 0.0, 0.0, 0.0, 0.23, 0.0, 0.0, 0.0]


 * S: []
 * I: [1, 4, 5, 6, 9, 10, 15, 17, 19]
 * R: []
 * P: [0, 2, 3, 7, 8, 11, 12, 13, 14, 16, 18]

__Nothing more to infect.__
Ending model with 11 protected and 9 infected vertices in 3 turns.

#### Highest Protection Defence


 * S: [1, 4, 5, 6, 7, 9, 10, 12, 14, 16, 17, 19]
 * I: [15]
 * R: []
 * P: [0, 2, 3, 8, 11, 13, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.23, 0.0, 0.0, 0.0, 0.0, 0.22, 0.0, 0.0, 0.0, 0.0, 0.0, 0.3, 0.0, 0.01, 0.0, 0.23, 0.0, 0.0, 0.0]


 * S: [4, 5, 7, 9, 10, 12, 17, 19]
 * I: [15]
 * R: []
 * P: [0, 1, 2, 3, 6, 8, 11, 13, 14, 16, 18]

_Infecting:_ 4 5 7 9 10 17 19 

 * S: [12]
 * I: [4, 5, 7, 9, 10, 15, 17, 19]
 * R: []
 * P: [0, 1, 2, 3, 6, 8, 11, 13, 14, 16, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.06, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [4, 5, 7, 9, 10, 15, 17, 19]
 * R: []
 * P: [0, 1, 2, 3, 6, 8, 11, 12, 13, 14, 16, 18]

__Nothing more to infect.__
Ending model with 12 protected and 8 infected vertices in 3 turns.

## Outbreak: 16
* Agent at vertex 0: peril 1.00, protection 0.63 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 2: peril 0.50, protection 0.77 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 1.00, protection 0.19 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 0.50, protection 0.34 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 1.00, protection 0.32 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 0.50, protection 0.17 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 8: peril 1.00, protection 0.48 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 1.00, protection 0.02 and state SUSCEPTIBLE.
* Agent at vertex 10: peril 1.00, protection 0.17 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 1.00, protection 0.66 and state SUSCEPTIBLE.
* Agent at vertex 12: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 13: peril 1.00, protection 0.56 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 15: peril 0.50, protection 0.25 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 1.00, protection 0.22 and state INFECTED.
* Agent at vertex 17: peril 1.00, protection 0.93 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 0.50, protection 0.88 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 0.50, protection 0.24 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [0, 2, 3, 4, 5, 6, 8, 9, 10, 11, 13, 15, 17, 18, 19]
 * I: [16]
 * R: []
 * P: [1, 7, 12, 14]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.56, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.44, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 2, 3, 4, 5, 6, 8, 9, 10, 11, 15, 17, 18, 19]
 * I: [16]
 * R: []
 * P: [1, 7, 12, 13, 14]

_Infecting:_ 0 3 5 8 9 10 11 17 

 * S: [2, 4, 6, 15, 18, 19]
 * I: [0, 3, 5, 8, 9, 10, 11, 16, 17]
 * R: []
 * P: [1, 7, 12, 13, 14]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.23, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.75, 0.0, 0.0, 0.02, 0.0]


 * S: [4, 6, 18, 19]
 * I: [0, 3, 5, 8, 9, 10, 11, 16, 17]
 * R: []
 * P: [1, 2, 7, 12, 13, 14, 15]

_Infecting:_ 4 6 18 19 

 * S: []
 * I: [0, 3, 4, 5, 6, 8, 9, 10, 11, 16, 17, 18, 19]
 * R: []
 * P: [1, 2, 7, 12, 13, 14, 15]

__Nothing more to protect.__
Ending model with 7 protected and 13 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [0, 2, 3, 4, 5, 6, 8, 9, 10, 11, 13, 15, 17, 18, 19]
 * I: [16]
 * R: []
 * P: [1, 7, 12, 14]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.56, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.44, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 2, 3, 4, 5, 6, 8, 9, 10, 11, 15, 17, 18, 19]
 * I: [16]
 * R: []
 * P: [1, 7, 12, 13, 14]

_Infecting:_ 0 3 5 8 9 10 11 17 

 * S: [2, 4, 6, 15, 18, 19]
 * I: [0, 3, 5, 8, 9, 10, 11, 16, 17]
 * R: []
 * P: [1, 7, 12, 13, 14]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.23, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.75, 0.0, 0.0, 0.02, 0.0]


 * S: [4, 6, 18, 19]
 * I: [0, 3, 5, 8, 9, 10, 11, 16, 17]
 * R: []
 * P: [1, 2, 7, 12, 13, 14, 15]

_Infecting:_ 4 6 18 19 

 * S: []
 * I: [0, 3, 4, 5, 6, 8, 9, 10, 11, 16, 17, 18, 19]
 * R: []
 * P: [1, 2, 7, 12, 13, 14, 15]

__Nothing more to protect.__
Ending model with 7 protected and 13 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [0, 2, 3, 4, 5, 6, 8, 9, 10, 11, 13, 15, 17, 18, 19]
 * I: [16]
 * R: []
 * P: [1, 7, 12, 14]
total defence: 1.0

_Strategy:_ [0.24, 0.0, 0.23, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.34, 0.0, 0.0, 0.0, 0.0, 0.0, 0.07, 0.12, 0.0]


 * S: [0, 3, 4, 5, 6, 8, 9, 10, 13, 15, 19]
 * I: [16]
 * R: []
 * P: [1, 2, 7, 11, 12, 14, 17, 18]

_Infecting:_ 0 3 5 8 9 10 13 

 * S: [4, 6, 15, 19]
 * I: [0, 3, 5, 8, 9, 10, 13, 16]
 * R: []
 * P: [1, 2, 7, 11, 12, 14, 17, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.66, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.34, 0.0, 0.0, 0.0, 0.0]


 * S: [6, 15, 19]
 * I: [0, 3, 5, 8, 9, 10, 13, 16]
 * R: []
 * P: [1, 2, 4, 7, 11, 12, 14, 17, 18]

_Infecting:_ 6 15 19 

 * S: []
 * I: [0, 3, 5, 6, 8, 9, 10, 13, 15, 16, 19]
 * R: []
 * P: [1, 2, 4, 7, 11, 12, 14, 17, 18]

__Nothing more to protect.__
Ending model with 9 protected and 11 infected vertices in 4 turns.

## Outbreak: 17
* Agent at vertex 0: peril 0.50, protection 0.07 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 2: peril 0.50, protection 0.63 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 0.50, protection 0.31 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 5: peril 1.00, protection 0.21 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 0.50, protection 0.71 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.37 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 1.00, protection 0.50 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 10: peril 1.00, protection 0.49 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 12: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 13: peril 1.00, protection 0.41 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 1.00, protection 0.28 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 1.00, protection 0.63 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 1.00, protection 0.12 and state SUSCEPTIBLE.
* Agent at vertex 17: peril 1.00, protection 0.46 and state INFECTED.
* Agent at vertex 18: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 19: peril 1.00, protection 0.97 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [0, 2, 3, 5, 6, 7, 8, 10, 13, 14, 15, 16, 19]
 * I: [17]
 * R: []
 * P: [1, 4, 9, 11, 12, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.41, 0.0, 0.0, 0.0, 0.0, 0.0, 0.59, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 2, 3, 5, 6, 7, 8, 10, 14, 15, 16, 19]
 * I: [17]
 * R: []
 * P: [1, 4, 9, 11, 12, 13, 18]

_Infecting:_ 5 7 8 10 14 15 16 19 

 * S: [0, 2, 3, 6]
 * I: [5, 7, 8, 10, 14, 15, 16, 17, 19]
 * R: []
 * P: [1, 4, 9, 11, 12, 13, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.37, 0.63, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 3, 6]
 * I: [5, 7, 8, 10, 14, 15, 16, 17, 19]
 * R: []
 * P: [1, 2, 4, 9, 11, 12, 13, 18]

_Infecting:_ 0 3 6 

 * S: []
 * I: [0, 3, 5, 6, 7, 8, 10, 14, 15, 16, 17, 19]
 * R: []
 * P: [1, 2, 4, 9, 11, 12, 13, 18]

__Nothing more to protect.__
Ending model with 8 protected and 12 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [0, 2, 3, 5, 6, 7, 8, 10, 13, 14, 15, 16, 19]
 * I: [17]
 * R: []
 * P: [1, 4, 9, 11, 12, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.41, 0.0, 0.0, 0.0, 0.0, 0.0, 0.59, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 2, 3, 5, 6, 7, 8, 10, 14, 15, 16, 19]
 * I: [17]
 * R: []
 * P: [1, 4, 9, 11, 12, 13, 18]

_Infecting:_ 5 7 8 10 14 15 16 19 

 * S: [0, 2, 3, 6]
 * I: [5, 7, 8, 10, 14, 15, 16, 17, 19]
 * R: []
 * P: [1, 4, 9, 11, 12, 13, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.37, 0.63, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 3, 6]
 * I: [5, 7, 8, 10, 14, 15, 16, 17, 19]
 * R: []
 * P: [1, 2, 4, 9, 11, 12, 13, 18]

_Infecting:_ 0 3 6 

 * S: []
 * I: [0, 3, 5, 6, 7, 8, 10, 14, 15, 16, 17, 19]
 * R: []
 * P: [1, 2, 4, 9, 11, 12, 13, 18]

__Nothing more to protect.__
Ending model with 8 protected and 12 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [0, 2, 3, 5, 6, 7, 8, 10, 13, 14, 15, 16, 19]
 * I: [17]
 * R: []
 * P: [1, 4, 9, 11, 12, 18]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.37, 0.0, 0.0, 0.0, 0.29, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.31, 0.0, 0.0, 0.0, 0.03]


 * S: [0, 3, 5, 7, 8, 10, 13, 14, 15, 16]
 * I: [17]
 * R: []
 * P: [1, 2, 4, 6, 9, 11, 12, 18, 19]

_Infecting:_ 5 7 8 10 13 14 15 16 

 * S: [0, 3]
 * I: [5, 7, 8, 10, 13, 14, 15, 16, 17]
 * R: []
 * P: [1, 2, 4, 6, 9, 11, 12, 18, 19]
total defence: 1.0

_Strategy:_ [0.31, 0.0, 0.0, 0.69, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0]
 * I: [5, 7, 8, 10, 13, 14, 15, 16, 17]
 * R: []
 * P: [1, 2, 3, 4, 6, 9, 11, 12, 18, 19]

_Infecting:_ 0 

 * S: []
 * I: [0, 5, 7, 8, 10, 13, 14, 15, 16, 17]
 * R: []
 * P: [1, 2, 3, 4, 6, 9, 11, 12, 18, 19]

__Nothing more to protect.__
Ending model with 10 protected and 10 infected vertices in 4 turns.

## Outbreak: 18
* Agent at vertex 0: peril 0.50, protection 0.81 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 1.00, protection 0.03 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 1.00, protection 0.34 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 1.00, protection 0.39 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 0.50, protection 0.35 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 0.50, protection 0.66 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 1.00, protection 0.08 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 0.50, protection 0.69 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 1.00, protection 0.65 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 10: peril 1.00, protection 0.09 and state SUSCEPTIBLE.
* Agent at vertex 11: peril 1.00, protection 0.83 and state SUSCEPTIBLE.
* Agent at vertex 12: peril 0.50, protection 0.59 and state SUSCEPTIBLE.
* Agent at vertex 13: peril 1.00, protection 0.79 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 1.00, protection 0.13 and state SUSCEPTIBLE.
* Agent at vertex 15: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 16: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 17: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 18: peril 1.00, protection 0.30 and state INFECTED.
* Agent at vertex 19: peril 1.00, protection 0.83 and state SUSCEPTIBLE.

#### Proximity to Infection Defence


 * S: [0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 19]
 * I: [18]
 * R: []
 * P: [9, 15, 16, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.21, 0.79, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 14, 19]
 * I: [18]
 * R: []
 * P: [9, 13, 15, 16, 17]

_Infecting:_ 1 2 3 6 8 10 11 14 19 

 * S: [0, 4, 5, 7, 12]
 * I: [1, 2, 3, 6, 8, 10, 11, 14, 18, 19]
 * R: []
 * P: [9, 13, 15, 16, 17]
total defence: 1.0

_Strategy:_ [0.19, 0.0, 0.0, 0.0, 0.15, 0.34, 0.0, 0.31, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [4, 12]
 * I: [1, 2, 3, 6, 8, 10, 11, 14, 18, 19]
 * R: []
 * P: [0, 5, 7, 9, 13, 15, 16, 17]

_Infecting:_ 4 12 

 * S: []
 * I: [1, 2, 3, 4, 6, 8, 10, 11, 12, 14, 18, 19]
 * R: []
 * P: [0, 5, 7, 9, 13, 15, 16, 17]

__Nothing more to protect.__
Ending model with 8 protected and 12 infected vertices in 4 turns.

#### Greatest Degree Defence


 * S: [0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 19]
 * I: [18]
 * R: []
 * P: [9, 15, 16, 17]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.21, 0.79, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 14, 19]
 * I: [18]
 * R: []
 * P: [9, 13, 15, 16, 17]

_Infecting:_ 1 2 3 6 8 10 11 14 19 

 * S: [0, 4, 5, 7, 12]
 * I: [1, 2, 3, 6, 8, 10, 11, 14, 18, 19]
 * R: []
 * P: [9, 13, 15, 16, 17]
total defence: 1.0

_Strategy:_ [0.19, 0.0, 0.0, 0.0, 0.15, 0.34, 0.0, 0.31, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [4, 12]
 * I: [1, 2, 3, 6, 8, 10, 11, 14, 18, 19]
 * R: []
 * P: [0, 5, 7, 9, 13, 15, 16, 17]

_Infecting:_ 4 12 

 * S: []
 * I: [1, 2, 3, 4, 6, 8, 10, 11, 12, 14, 18, 19]
 * R: []
 * P: [0, 5, 7, 9, 13, 15, 16, 17]

__Nothing more to protect.__
Ending model with 8 protected and 12 infected vertices in 4 turns.

#### Highest Protection Defence


 * S: [0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 19]
 * I: [18]
 * R: []
 * P: [9, 15, 16, 17]
total defence: 1.0

_Strategy:_ [0.19, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.26, 0.0, 0.0, 0.0, 0.17, 0.0, 0.21, 0.0, 0.0, 0.0, 0.0, 0.0, 0.17]


 * S: [1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 14]
 * I: [18]
 * R: []
 * P: [0, 9, 11, 13, 15, 16, 17, 19]

_Infecting:_ 1 2 3 6 8 10 14 

 * S: [4, 5, 7, 12]
 * I: [1, 2, 3, 6, 8, 10, 14, 18]
 * R: []
 * P: [0, 9, 11, 13, 15, 16, 17, 19]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.2, 0.34, 0.0, 0.05, 0.0, 0.0, 0.0, 0.0, 0.41, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [4]
 * I: [1, 2, 3, 6, 8, 10, 14, 18]
 * R: []
 * P: [0, 5, 7, 9, 11, 12, 13, 15, 16, 17, 19]

_Infecting:_ 4 

 * S: []
 * I: [1, 2, 3, 4, 6, 8, 10, 14, 18]
 * R: []
 * P: [0, 5, 7, 9, 11, 12, 13, 15, 16, 17, 19]

__Nothing more to protect.__
Ending model with 11 protected and 9 infected vertices in 4 turns.

## Outbreak: 19
* Agent at vertex 0: peril 0.50, protection 0.07 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 2: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 3: peril 1.00, protection 0.78 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 5: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 6: peril 1.00, protection 0.07 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 8: peril 1.00, protection 0.71 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 10: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 11: peril 1.00, protection 0.93 and state SUSCEPTIBLE.
* Agent at vertex 12: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 13: peril 1.00, protection 0.06 and state SUSCEPTIBLE.
* Agent at vertex 14: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 15: peril 1.00, protection 0.18 and state SUSCEPTIBLE.
* Agent at vertex 16: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 17: peril 1.00, protection 0.29 and state SUSCEPTIBLE.
* Agent at vertex 18: peril 1.00, protection 0.08 and state SUSCEPTIBLE.
* Agent at vertex 19: peril 1.00, protection 0.94 and state INFECTED.

#### Proximity to Infection Defence


 * S: [0, 3, 6, 8, 11, 13, 15, 17, 18]
 * I: [19]
 * R: []
 * P: [1, 2, 4, 5, 7, 9, 10, 12, 14, 16]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.06, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.94, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 3, 6, 8, 11, 15, 17, 18]
 * I: [19]
 * R: []
 * P: [1, 2, 4, 5, 7, 9, 10, 12, 13, 14, 16]

_Infecting:_ 3 6 8 11 15 17 18 

 * S: [0]
 * I: [3, 6, 8, 11, 15, 17, 18, 19]
 * R: []
 * P: [1, 2, 4, 5, 7, 9, 10, 12, 13, 14, 16]
total defence: 1.0

_Strategy:_ [0.93, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [3, 6, 8, 11, 15, 17, 18, 19]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 9, 10, 12, 13, 14, 16]

__Nothing more to infect.__
Ending model with 12 protected and 8 infected vertices in 3 turns.

#### Greatest Degree Defence


 * S: [0, 3, 6, 8, 11, 13, 15, 17, 18]
 * I: [19]
 * R: []
 * P: [1, 2, 4, 5, 7, 9, 10, 12, 14, 16]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.06, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.94, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: [0, 3, 6, 8, 11, 15, 17, 18]
 * I: [19]
 * R: []
 * P: [1, 2, 4, 5, 7, 9, 10, 12, 13, 14, 16]

_Infecting:_ 3 6 8 11 15 17 18 

 * S: [0]
 * I: [3, 6, 8, 11, 15, 17, 18, 19]
 * R: []
 * P: [1, 2, 4, 5, 7, 9, 10, 12, 13, 14, 16]
total defence: 1.0

_Strategy:_ [0.93, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [3, 6, 8, 11, 15, 17, 18, 19]
 * R: []
 * P: [0, 1, 2, 4, 5, 7, 9, 10, 12, 13, 14, 16]

__Nothing more to infect.__
Ending model with 12 protected and 8 infected vertices in 3 turns.

#### Highest Protection Defence


 * S: [0, 3, 6, 8, 11, 13, 15, 17, 18]
 * I: [19]
 * R: []
 * P: [1, 2, 4, 5, 7, 9, 10, 12, 14, 16]
total defence: 1.0

_Strategy:_ [0.0, 0.0, 0.0, 0.22, 0.0, 0.0, 0.0, 0.0, 0.29, 0.0, 0.0, 0.07, 0.0, 0.0, 0.0, 0.0, 0.0, 0.42, 0.0, 0.0]


 * S: [0, 6, 13, 15, 17, 18]
 * I: [19]
 * R: []
 * P: [1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 14, 16]

_Infecting:_ 6 13 15 17 18 

 * S: [0]
 * I: [6, 13, 15, 17, 18, 19]
 * R: []
 * P: [1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 14, 16]
total defence: 1.0

_Strategy:_ [0.93, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]


 * S: []
 * I: [6, 13, 15, 17, 18, 19]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 14, 16]

__Nothing more to infect.__
Ending model with 14 protected and 6 infected vertices in 3 turns.
