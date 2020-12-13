# Genetic Algorithms Assignment

### Usage: 
1. Download source code
2. in _Project.java_ uncomment desired _demo..._ method.
3. Run _Project.java_ 
4. Adjust _Utilities.Constants_ to change initial conditions. 
5. Enjoy

### Requirements:
- [x] Singleton Pattern
- [x] Factory Pattern
- [x] Strategy Pattern
- [x] Genetic Algorithm 

## Changelog:

### version 0.6
* Implementation of the Strategy pattern
* Comparator to compare the performance 


### version 0.5
* Implementation of the Abstract Factory
* Added Callback for the Genetic Algorithm 


### version 0.4
* Reorganized package structure 
* Implementation of Genetic Algorithm concept 
* Introduced _Helpers_ package to hold _Utilities_ and _Constants_ 
    * _Utilities_ hold static methods as this is the only option to keep them unique
    * _Constants_ should be treated as **settings** for the program
    
There are multiple commented lines of _println()_ statements: uncomment if you want to see data flow. 

_GeneticAlgorithmPackage_ holds GA related classes:
 * _GeneticAlgorithm.java_ - the class to be used in Factory pattern. 
 * Two samples of usage. There are 4 possible combinations so far.

_Population_ package holds population related classes.


### version 0.3
The program generates unidentical cities and routes in the world as well as calculate the length of each route. The class Population.World is a singleton.

### version 0.1
Initial commit.
