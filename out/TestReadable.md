# Readable results of SIRP defence strategies on a random graph

## Generating Erdős–Rényi Graph:
* Number of vertices: 10
 * Number of edges: 18
 * Probability: 0.4
 * Random generator seed: 1614011974097

0: 0 0 0 0 1 0 0 0 0 0 

1: 0 0 1 0 1 0 0 1 1 0 

2: 0 1 0 0 0 0 0 0 0 0 

3: 0 0 0 0 0 1 0 0 0 0 

4: 1 1 0 0 0 1 0 0 0 0 

5: 0 0 0 1 1 0 0 0 1 1 

6: 0 0 0 0 0 0 0 1 1 1 

7: 0 1 0 0 0 0 1 0 1 1 

8: 0 1 0 0 0 1 1 1 0 1 

9: 0 0 0 0 0 1 1 1 1 0 



## Outbreak: 0
Agents all same: false
* Agent at vertex 0: peril 1.00, protection 0.50 and state INFECTED.
* Agent at vertex 1: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 2: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 3: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 4: peril 1.00, protection 0.47 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 0.50, protection 0.07 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 0.25, protection 1.00 and state PROTECTED.
* Agent at vertex 7: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 8: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 9: peril 0.33, protection 1.00 and state PROTECTED.

#### PROXIMITY TO INFECTION DEFENCE STRATEGY


 * S: [4, 5]
 * I: [0]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [4, 5]
 * I: [0]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]


_Infecting:_ 4 

 * S: [5]
 * I: [0, 4]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0]



 * S: [5]
 * I: [0, 4]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]


_Infecting:_ 5 

 * S: []
 * I: [0, 4, 5]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]

__Nothing more to protect.__
Ending model with 7 protected and 3 infected vertices in 4 turns.
Agents all same: false

#### GREATEST DEGREE DEFENCE STRATEGY


 * S: [4, 5]
 * I: [0]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0]



 * S: [4, 5]
 * I: [0]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]


_Infecting:_ 4 

 * S: [5]
 * I: [0, 4]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.43, 0.0, 0.0, 0.0, 0.0]



 * S: []
 * I: [0, 4]
 * R: []
 * P: [1, 2, 3, 5, 6, 7, 8, 9]

__Nothing more to infect.__
Ending model with 8 protected and 2 infected vertices in 3 turns.
Agents all same: false

#### CHEAPEST INCREASE DEFENCE STRATEGY


 * S: [4, 5]
 * I: [0]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [4, 5]
 * I: [0]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]


_Infecting:_ 4 

 * S: [5]
 * I: [0, 4]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0]



 * S: [5]
 * I: [0, 4]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]


_Infecting:_ 5 

 * S: []
 * I: [0, 4, 5]
 * R: []
 * P: [1, 2, 3, 6, 7, 8, 9]

__Nothing more to protect.__
Ending model with 7 protected and 3 infected vertices in 4 turns.

## Outbreak: 1
Agents all same: false
* Agent at vertex 0: peril 0.50, protection 0.55 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 1.00, protection 0.81 and state INFECTED.
* Agent at vertex 2: peril 1.00, protection 0.20 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 4: peril 1.00, protection 0.49 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 6: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 7: peril 1.00, protection 0.21 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 1.00, protection 0.50 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 0.50, protection 0.89 and state SUSCEPTIBLE.

#### PROXIMITY TO INFECTION DEFENCE STRATEGY


 * S: [0, 2, 4, 7, 8, 9]
 * I: [1]
 * R: []
 * P: [3, 5, 6]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0]



 * S: [0, 2, 4, 7, 8, 9]
 * I: [1]
 * R: []
 * P: [3, 5, 6]


_Infecting:_ 2 4 7 8 

 * S: [0, 9]
 * I: [1, 2, 4, 7, 8]
 * R: []
 * P: [3, 5, 6]


_Strategy:_ [0.45, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.11]



 * S: []
 * I: [1, 2, 4, 7, 8]
 * R: []
 * P: [0, 3, 5, 6, 9]

__Nothing more to infect.__
Ending model with 5 protected and 5 infected vertices in 3 turns.
Agents all same: false

#### GREATEST DEGREE DEFENCE STRATEGY


 * S: [0, 2, 4, 7, 8, 9]
 * I: [1]
 * R: []
 * P: [3, 5, 6]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0]



 * S: [0, 2, 4, 7, 8, 9]
 * I: [1]
 * R: []
 * P: [3, 5, 6]


_Infecting:_ 2 4 7 8 

 * S: [0, 9]
 * I: [1, 2, 4, 7, 8]
 * R: []
 * P: [3, 5, 6]


_Strategy:_ [0.45, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.11]



 * S: []
 * I: [1, 2, 4, 7, 8]
 * R: []
 * P: [0, 3, 5, 6, 9]

__Nothing more to infect.__
Ending model with 5 protected and 5 infected vertices in 3 turns.
Agents all same: false

#### CHEAPEST INCREASE DEFENCE STRATEGY


 * S: [0, 2, 4, 7, 8, 9]
 * I: [1]
 * R: []
 * P: [3, 5, 6]


_Strategy:_ [0.45, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.44, 0.11]



 * S: [2, 4, 7, 8]
 * I: [1]
 * R: []
 * P: [0, 3, 5, 6, 9]


_Infecting:_ 2 4 7 8 

 * S: []
 * I: [1, 2, 4, 7, 8]
 * R: []
 * P: [0, 3, 5, 6, 9]

__Nothing more to protect.__
Ending model with 5 protected and 5 infected vertices in 2 turns.

## Outbreak: 2
Agents all same: false
* Agent at vertex 0: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 1: peril 1.00, protection 0.50 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 1.00, protection 0.37 and state INFECTED.
* Agent at vertex 3: peril 0.25, protection 1.00 and state PROTECTED.
* Agent at vertex 4: peril 0.50, protection 0.28 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 6: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 7: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 8: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 9: peril 0.33, protection 1.00 and state PROTECTED.

#### PROXIMITY TO INFECTION DEFENCE STRATEGY


 * S: [1, 4]
 * I: [2]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]


_Strategy:_ [0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [1, 4]
 * I: [2]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]


_Infecting:_ 1 

 * S: [4]
 * I: [1, 2]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [4]
 * I: [1, 2]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]


_Infecting:_ 4 

 * S: []
 * I: [1, 2, 4]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]

__Nothing more to protect.__
Ending model with 7 protected and 3 infected vertices in 4 turns.
Agents all same: false

#### GREATEST DEGREE DEFENCE STRATEGY


 * S: [1, 4]
 * I: [2]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]


_Strategy:_ [0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [1, 4]
 * I: [2]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]


_Infecting:_ 1 

 * S: [4]
 * I: [1, 2]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [4]
 * I: [1, 2]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]


_Infecting:_ 4 

 * S: []
 * I: [1, 2, 4]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]

__Nothing more to protect.__
Ending model with 7 protected and 3 infected vertices in 4 turns.
Agents all same: false

#### CHEAPEST INCREASE DEFENCE STRATEGY


 * S: [1, 4]
 * I: [2]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]


_Strategy:_ [0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [1, 4]
 * I: [2]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]


_Infecting:_ 1 

 * S: [4]
 * I: [1, 2]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [4]
 * I: [1, 2]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]


_Infecting:_ 4 

 * S: []
 * I: [1, 2, 4]
 * R: []
 * P: [0, 3, 5, 6, 7, 8, 9]

__Nothing more to protect.__
Ending model with 7 protected and 3 infected vertices in 4 turns.

## Outbreak: 3
Agents all same: false
* Agent at vertex 0: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 1: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 2: peril 0.25, protection 1.00 and state PROTECTED.
* Agent at vertex 3: peril 1.00, protection 0.43 and state INFECTED.
* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 5: peril 1.00, protection 0.33 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 7: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 8: peril 0.50, protection 0.10 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 0.50, protection 1.00 and state PROTECTED.

#### PROXIMITY TO INFECTION DEFENCE STRATEGY


 * S: [5, 8]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0]



 * S: [5, 8]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]


_Infecting:_ 5 

 * S: [8]
 * I: [3, 5]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0]



 * S: [8]
 * I: [3, 5]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]


_Infecting:_ 8 

 * S: []
 * I: [3, 5, 8]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]

__Nothing more to protect.__
Ending model with 7 protected and 3 infected vertices in 4 turns.
Agents all same: false

#### GREATEST DEGREE DEFENCE STRATEGY


 * S: [5, 8]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0]



 * S: [5, 8]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]


_Infecting:_ 5 

 * S: [8]
 * I: [3, 5]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.4, 0.0]



 * S: []
 * I: [3, 5]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 8, 9]

__Nothing more to infect.__
Ending model with 8 protected and 2 infected vertices in 3 turns.
Agents all same: false

#### CHEAPEST INCREASE DEFENCE STRATEGY


 * S: [5, 8]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0]



 * S: [5, 8]
 * I: [3]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]


_Infecting:_ 5 

 * S: [8]
 * I: [3, 5]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0]



 * S: [8]
 * I: [3, 5]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]


_Infecting:_ 8 

 * S: []
 * I: [3, 5, 8]
 * R: []
 * P: [0, 1, 2, 4, 6, 7, 9]

__Nothing more to protect.__
Ending model with 7 protected and 3 infected vertices in 4 turns.

## Outbreak: 4
Agents all same: false
* Agent at vertex 0: peril 1.00, protection 0.62 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 1.00, protection 0.04 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 3: peril 0.50, protection 0.70 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 1.00, protection 0.62 and state INFECTED.
* Agent at vertex 5: peril 1.00, protection 0.85 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 0.33, protection 0.63 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 0.50, protection 0.51 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 0.50, protection 0.03 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 0.50, protection 1.00 and state PROTECTED.

#### PROXIMITY TO INFECTION DEFENCE STRATEGY


 * S: [0, 1, 3, 5, 6, 7, 8]
 * I: [4]
 * R: []
 * P: [2, 9]


_Strategy:_ [0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [0, 1, 3, 5, 6, 7, 8]
 * I: [4]
 * R: []
 * P: [2, 9]


_Infecting:_ 0 1 5 

 * S: [3, 6, 7, 8]
 * I: [0, 1, 4, 5]
 * R: []
 * P: [2, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0]



 * S: [3, 6, 7, 8]
 * I: [0, 1, 4, 5]
 * R: []
 * P: [2, 9]


_Infecting:_ 3 7 8 

 * S: [6]
 * I: [0, 1, 3, 4, 5, 7, 8]
 * R: []
 * P: [2, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.37, 0.0, 0.0, 0.0]



 * S: []
 * I: [0, 1, 3, 4, 5, 7, 8]
 * R: []
 * P: [2, 6, 9]

__Nothing more to infect.__
Ending model with 3 protected and 7 infected vertices in 5 turns.
Agents all same: false

#### GREATEST DEGREE DEFENCE STRATEGY


 * S: [0, 1, 3, 5, 6, 7, 8]
 * I: [4]
 * R: []
 * P: [2, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0]



 * S: [0, 1, 3, 5, 6, 7, 8]
 * I: [4]
 * R: []
 * P: [2, 9]


_Infecting:_ 0 1 5 

 * S: [3, 6, 7, 8]
 * I: [0, 1, 4, 5]
 * R: []
 * P: [2, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.49, 0.47, 0.0]



 * S: [3, 6]
 * I: [0, 1, 4, 5]
 * R: []
 * P: [2, 7, 8, 9]


_Infecting:_ 3 

 * S: [6]
 * I: [0, 1, 3, 4, 5]
 * R: []
 * P: [2, 7, 8, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.37, 0.0, 0.0, 0.0]



 * S: []
 * I: [0, 1, 3, 4, 5]
 * R: []
 * P: [2, 6, 7, 8, 9]

__Nothing more to infect.__
Ending model with 5 protected and 5 infected vertices in 5 turns.
Agents all same: false

#### CHEAPEST INCREASE DEFENCE STRATEGY


 * S: [0, 1, 3, 5, 6, 7, 8]
 * I: [4]
 * R: []
 * P: [2, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.3, 0.0, 0.15, 0.37, 0.0, 0.0, 0.0]



 * S: [0, 1, 7, 8]
 * I: [4]
 * R: []
 * P: [2, 3, 5, 6, 9]


_Infecting:_ 0 1 

 * S: [7, 8]
 * I: [0, 1, 4]
 * R: []
 * P: [2, 3, 5, 6, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.49, 1.02, 0.0]



 * S: []
 * I: [0, 1, 4]
 * R: []
 * P: [2, 3, 5, 6, 7, 8, 9]

__Nothing more to infect.__
Ending model with 7 protected and 3 infected vertices in 3 turns.

## Outbreak: 5
Agents all same: false
* Agent at vertex 0: peril 0.50, protection 0.13 and state SUSCEPTIBLE.
* Agent at vertex 1: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 2: peril 0.33, protection 0.12 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 1.00, protection 0.54 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 1.00, protection 0.91 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 1.00, protection 0.51 and state INFECTED.
* Agent at vertex 6: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 7: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 8: peril 1.00, protection 0.69 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 1.00, protection 0.92 and state SUSCEPTIBLE.

#### PROXIMITY TO INFECTION DEFENCE STRATEGY


 * S: [0, 2, 3, 4, 8, 9]
 * I: [5]
 * R: []
 * P: [1, 6, 7]


_Strategy:_ [0.0, 0.0, 0.0, 0.46, 0.09, 0.0, 0.0, 0.0, 0.31, 0.08]



 * S: [0, 2]
 * I: [5]
 * R: []
 * P: [1, 3, 4, 6, 7, 8, 9]


_Nothing infected._

 * S: [0, 2]
 * I: [5]
 * R: []
 * P: [1, 3, 4, 6, 7, 8, 9]


_Strategy:_ [0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [0, 2]
 * I: [5]
 * R: []
 * P: [1, 3, 4, 6, 7, 8, 9]


_Nothing infected._

 * S: [0, 2]
 * I: [5]
 * R: []
 * P: [1, 3, 4, 6, 7, 8, 9]


_Strategy:_ [0.37, 0.0, 1.27, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: []
 * I: [5]
 * R: []
 * P: [0, 1, 2, 3, 4, 6, 7, 8, 9]

__Nothing more to infect.__
Ending model with 9 protected and 1 infected vertices in 5 turns.
Agents all same: false

#### GREATEST DEGREE DEFENCE STRATEGY


 * S: [0, 2, 3, 4, 8, 9]
 * I: [5]
 * R: []
 * P: [1, 6, 7]


_Strategy:_ [0.0, 0.0, 0.0, 0.46, 0.09, 0.0, 0.0, 0.0, 0.31, 0.08]



 * S: [0, 2]
 * I: [5]
 * R: []
 * P: [1, 3, 4, 6, 7, 8, 9]


_Nothing infected._

 * S: [0, 2]
 * I: [5]
 * R: []
 * P: [1, 3, 4, 6, 7, 8, 9]


_Strategy:_ [0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [0, 2]
 * I: [5]
 * R: []
 * P: [1, 3, 4, 6, 7, 8, 9]


_Nothing infected._

 * S: [0, 2]
 * I: [5]
 * R: []
 * P: [1, 3, 4, 6, 7, 8, 9]


_Strategy:_ [0.37, 0.0, 1.27, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: []
 * I: [5]
 * R: []
 * P: [0, 1, 2, 3, 4, 6, 7, 8, 9]

__Nothing more to infect.__
Ending model with 9 protected and 1 infected vertices in 5 turns.
Agents all same: false

#### CHEAPEST INCREASE DEFENCE STRATEGY


 * S: [0, 2, 3, 4, 8, 9]
 * I: [5]
 * R: []
 * P: [1, 6, 7]


_Strategy:_ [0.0, 0.0, 0.0, 0.46, 0.09, 0.0, 0.0, 0.0, 0.31, 0.08]



 * S: [0, 2]
 * I: [5]
 * R: []
 * P: [1, 3, 4, 6, 7, 8, 9]


_Nothing infected._

 * S: [0, 2]
 * I: [5]
 * R: []
 * P: [1, 3, 4, 6, 7, 8, 9]


_Strategy:_ [0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [0, 2]
 * I: [5]
 * R: []
 * P: [1, 3, 4, 6, 7, 8, 9]


_Nothing infected._

 * S: [0, 2]
 * I: [5]
 * R: []
 * P: [1, 3, 4, 6, 7, 8, 9]


_Strategy:_ [0.37, 0.0, 1.27, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: []
 * I: [5]
 * R: []
 * P: [0, 1, 2, 3, 4, 6, 7, 8, 9]

__Nothing more to infect.__
Ending model with 9 protected and 1 infected vertices in 5 turns.

## Outbreak: 6
Agents all same: false
* Agent at vertex 0: peril 0.25, protection 1.00 and state PROTECTED.
* Agent at vertex 1: peril 0.50, protection 0.80 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 0.33, protection 0.41 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 4: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 5: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 6: peril 1.00, protection 0.18 and state INFECTED.
* Agent at vertex 7: peril 1.00, protection 0.44 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 1.00, protection 0.33 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 1.00, protection 0.66 and state SUSCEPTIBLE.

#### PROXIMITY TO INFECTION DEFENCE STRATEGY


 * S: [1, 2, 7, 8, 9]
 * I: [6]
 * R: []
 * P: [0, 3, 4, 5]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0]



 * S: [1, 2, 7, 8, 9]
 * I: [6]
 * R: []
 * P: [0, 3, 4, 5]


_Infecting:_ 7 8 9 

 * S: [1, 2]
 * I: [6, 7, 8, 9]
 * R: []
 * P: [0, 3, 4, 5]


_Strategy:_ [0.0, 0.2, 0.59, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: []
 * I: [6, 7, 8, 9]
 * R: []
 * P: [0, 1, 2, 3, 4, 5]

__Nothing more to infect.__
Ending model with 6 protected and 4 infected vertices in 3 turns.
Agents all same: false

#### GREATEST DEGREE DEFENCE STRATEGY


 * S: [1, 2, 7, 8, 9]
 * I: [6]
 * R: []
 * P: [0, 3, 4, 5]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0]



 * S: [1, 2, 7, 8, 9]
 * I: [6]
 * R: []
 * P: [0, 3, 4, 5]


_Infecting:_ 7 8 9 

 * S: [1, 2]
 * I: [6, 7, 8, 9]
 * R: []
 * P: [0, 3, 4, 5]


_Strategy:_ [0.0, 0.2, 0.59, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: []
 * I: [6, 7, 8, 9]
 * R: []
 * P: [0, 1, 2, 3, 4, 5]

__Nothing more to infect.__
Ending model with 6 protected and 4 infected vertices in 3 turns.
Agents all same: false

#### CHEAPEST INCREASE DEFENCE STRATEGY


 * S: [1, 2, 7, 8, 9]
 * I: [6]
 * R: []
 * P: [0, 3, 4, 5]


_Strategy:_ [0.0, 0.2, 0.0, 0.0, 0.0, 0.0, 0.0, 0.92, 0.0, 0.34]



 * S: [2, 8]
 * I: [6]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 9]


_Infecting:_ 8 

 * S: [2]
 * I: [6, 8]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 9]


_Strategy:_ [0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [2]
 * I: [6, 8]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 9]


_Nothing infected._

 * S: [2]
 * I: [6, 8]
 * R: []
 * P: [0, 1, 3, 4, 5, 7, 9]


_Strategy:_ [0.0, 0.0, 0.09, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: []
 * I: [6, 8]
 * R: []
 * P: [0, 1, 2, 3, 4, 5, 7, 9]

__Nothing more to infect.__
Ending model with 8 protected and 2 infected vertices in 5 turns.

## Outbreak: 7
Agents all same: false
* Agent at vertex 0: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 1: peril 1.00, protection 0.51 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 0.50, protection 0.58 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 5: peril 0.50, protection 0.33 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 1.00, protection 0.84 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.67 and state INFECTED.
* Agent at vertex 8: peril 1.00, protection 0.54 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 1.00, protection 0.99 and state SUSCEPTIBLE.

#### PROXIMITY TO INFECTION DEFENCE STRATEGY


 * S: [1, 2, 5, 6, 8, 9]
 * I: [7]
 * R: []
 * P: [0, 3, 4]


_Strategy:_ [0.0, 0.49, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.46, 0.0]



 * S: [2, 5, 6, 9]
 * I: [7]
 * R: []
 * P: [0, 1, 3, 4, 8]


_Infecting:_ 6 9 

 * S: [2, 5]
 * I: [6, 7, 9]
 * R: []
 * P: [0, 1, 3, 4, 8]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0]



 * S: [2, 5]
 * I: [6, 7, 9]
 * R: []
 * P: [0, 1, 3, 4, 8]


_Infecting:_ 5 

 * S: [2]
 * I: [5, 6, 7, 9]
 * R: []
 * P: [0, 1, 3, 4, 8]


_Strategy:_ [0.0, 0.0, 0.42, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: []
 * I: [5, 6, 7, 9]
 * R: []
 * P: [0, 1, 2, 3, 4, 8]

__Nothing more to infect.__
Ending model with 6 protected and 4 infected vertices in 5 turns.
Agents all same: false

#### GREATEST DEGREE DEFENCE STRATEGY


 * S: [1, 2, 5, 6, 8, 9]
 * I: [7]
 * R: []
 * P: [0, 3, 4]


_Strategy:_ [0.0, 0.49, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.46, 0.0]



 * S: [2, 5, 6, 9]
 * I: [7]
 * R: []
 * P: [0, 1, 3, 4, 8]


_Infecting:_ 6 9 

 * S: [2, 5]
 * I: [6, 7, 9]
 * R: []
 * P: [0, 1, 3, 4, 8]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0]



 * S: [2, 5]
 * I: [6, 7, 9]
 * R: []
 * P: [0, 1, 3, 4, 8]


_Infecting:_ 5 

 * S: [2]
 * I: [5, 6, 7, 9]
 * R: []
 * P: [0, 1, 3, 4, 8]


_Strategy:_ [0.0, 0.0, 0.42, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: []
 * I: [5, 6, 7, 9]
 * R: []
 * P: [0, 1, 2, 3, 4, 8]

__Nothing more to infect.__
Ending model with 6 protected and 4 infected vertices in 5 turns.
Agents all same: false

#### CHEAPEST INCREASE DEFENCE STRATEGY


 * S: [1, 2, 5, 6, 8, 9]
 * I: [7]
 * R: []
 * P: [0, 3, 4]


_Strategy:_ [0.0, 0.0, 0.42, 0.0, 0.0, 0.0, 0.16, 0.0, 0.42, 0.01]



 * S: [1, 5, 8]
 * I: [7]
 * R: []
 * P: [0, 2, 3, 4, 6, 9]


_Infecting:_ 1 8 

 * S: [5]
 * I: [1, 7, 8]
 * R: []
 * P: [0, 2, 3, 4, 6, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0]



 * S: [5]
 * I: [1, 7, 8]
 * R: []
 * P: [0, 2, 3, 4, 6, 9]


_Infecting:_ 5 

 * S: []
 * I: [1, 5, 7, 8]
 * R: []
 * P: [0, 2, 3, 4, 6, 9]

__Nothing more to protect.__
Ending model with 6 protected and 4 infected vertices in 4 turns.

## Outbreak: 8
Agents all same: false
* Agent at vertex 0: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 1: peril 1.00, protection 0.15 and state SUSCEPTIBLE.
* Agent at vertex 2: peril 0.50, protection 0.18 and state SUSCEPTIBLE.
* Agent at vertex 3: peril 0.50, protection 0.23 and state SUSCEPTIBLE.
* Agent at vertex 4: peril 0.50, protection 0.82 and state SUSCEPTIBLE.
* Agent at vertex 5: peril 1.00, protection 0.28 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 1.00, protection 0.78 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.84 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 1.00, protection 0.05 and state INFECTED.
* Agent at vertex 9: peril 1.00, protection 0.59 and state SUSCEPTIBLE.

#### PROXIMITY TO INFECTION DEFENCE STRATEGY


 * S: [1, 2, 3, 4, 5, 6, 7, 9]
 * I: [8]
 * R: []
 * P: [0]


_Strategy:_ [0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [1, 2, 3, 4, 5, 6, 7, 9]
 * I: [8]
 * R: []
 * P: [0]


_Infecting:_ 1 5 6 7 9 

 * S: [2, 3, 4]
 * I: [1, 5, 6, 7, 8, 9]
 * R: []
 * P: [0]


_Strategy:_ [0.0, 0.0, 0.82, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [3]
 * I: [1, 5, 6, 7, 8, 9]
 * R: []
 * P: [0, 2, 4]


_Infecting:_ 3 

 * S: []
 * I: [1, 3, 5, 6, 7, 8, 9]
 * R: []
 * P: [0, 2, 4]

__Nothing more to protect.__
Ending model with 3 protected and 7 infected vertices in 4 turns.
Agents all same: false

#### GREATEST DEGREE DEFENCE STRATEGY


 * S: [1, 2, 3, 4, 5, 6, 7, 9]
 * I: [8]
 * R: []
 * P: [0]


_Strategy:_ [0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [1, 2, 3, 4, 5, 6, 7, 9]
 * I: [8]
 * R: []
 * P: [0]


_Infecting:_ 1 5 6 7 9 

 * S: [2, 3, 4]
 * I: [1, 5, 6, 7, 8, 9]
 * R: []
 * P: [0]


_Strategy:_ [0.0, 0.0, 0.82, 0.0, 0.18, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [3]
 * I: [1, 5, 6, 7, 8, 9]
 * R: []
 * P: [0, 2, 4]


_Infecting:_ 3 

 * S: []
 * I: [1, 3, 5, 6, 7, 8, 9]
 * R: []
 * P: [0, 2, 4]

__Nothing more to protect.__
Ending model with 3 protected and 7 infected vertices in 4 turns.
Agents all same: false

#### CHEAPEST INCREASE DEFENCE STRATEGY


 * S: [1, 2, 3, 4, 5, 6, 7, 9]
 * I: [8]
 * R: []
 * P: [0]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.22, 0.16, 0.0, 0.41]



 * S: [1, 2, 3, 5]
 * I: [8]
 * R: []
 * P: [0, 4, 6, 7, 9]


_Infecting:_ 1 5 

 * S: [2, 3]
 * I: [1, 5, 8]
 * R: []
 * P: [0, 4, 6, 7, 9]


_Strategy:_ [0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]



 * S: [2, 3]
 * I: [1, 5, 8]
 * R: []
 * P: [0, 4, 6, 7, 9]


_Infecting:_ 2 3 

 * S: []
 * I: [1, 2, 3, 5, 8]
 * R: []
 * P: [0, 4, 6, 7, 9]

__Nothing more to protect.__
Ending model with 5 protected and 5 infected vertices in 4 turns.

## Outbreak: 9
Agents all same: false
* Agent at vertex 0: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 1: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 2: peril 0.33, protection 1.00 and state PROTECTED.
* Agent at vertex 3: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 4: peril 0.50, protection 1.00 and state PROTECTED.
* Agent at vertex 5: peril 1.00, protection 0.14 and state SUSCEPTIBLE.
* Agent at vertex 6: peril 1.00, protection 0.51 and state SUSCEPTIBLE.
* Agent at vertex 7: peril 1.00, protection 0.47 and state SUSCEPTIBLE.
* Agent at vertex 8: peril 1.00, protection 0.41 and state SUSCEPTIBLE.
* Agent at vertex 9: peril 1.00, protection 0.21 and state INFECTED.

#### PROXIMITY TO INFECTION DEFENCE STRATEGY


 * S: [5, 6, 7, 8]
 * I: [9]
 * R: []
 * P: [0, 1, 2, 3, 4]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0]



 * S: [5, 6, 7, 8]
 * I: [9]
 * R: []
 * P: [0, 1, 2, 3, 4]


_Infecting:_ 5 6 7 8 

 * S: []
 * I: [5, 6, 7, 8, 9]
 * R: []
 * P: [0, 1, 2, 3, 4]

__Nothing more to protect.__
Ending model with 5 protected and 5 infected vertices in 2 turns.
Agents all same: false

#### GREATEST DEGREE DEFENCE STRATEGY


 * S: [5, 6, 7, 8]
 * I: [9]
 * R: []
 * P: [0, 1, 2, 3, 4]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0]



 * S: [5, 6, 7, 8]
 * I: [9]
 * R: []
 * P: [0, 1, 2, 3, 4]


_Infecting:_ 5 6 7 8 

 * S: []
 * I: [5, 6, 7, 8, 9]
 * R: []
 * P: [0, 1, 2, 3, 4]

__Nothing more to protect.__
Ending model with 5 protected and 5 infected vertices in 2 turns.
Agents all same: false

#### CHEAPEST INCREASE DEFENCE STRATEGY


 * S: [5, 6, 7, 8]
 * I: [9]
 * R: []
 * P: [0, 1, 2, 3, 4]


_Strategy:_ [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.49, 1.01, 0.0, 0.0]



 * S: [5, 8]
 * I: [9]
 * R: []
 * P: [0, 1, 2, 3, 4, 6, 7]


_Infecting:_ 5 8 

 * S: []
 * I: [5, 8, 9]
 * R: []
 * P: [0, 1, 2, 3, 4, 6, 7]

__Nothing more to protect.__
Ending model with 7 protected and 3 infected vertices in 2 turns.
