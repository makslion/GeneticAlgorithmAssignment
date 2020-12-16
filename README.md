# Genetic Algorithm
Assignment for the CS613 — Advanced Concepts in Object-Oriented Programming.
At National University of Ireland, Maynooth.

### Authors:
* Zuoyun Jin. 
   * Student ID: 19252512
   * Student email: zuoyun.jin.2020@mumail.ie
* Zixuan Zhang. 
    * Student ID: 
    * Student email: zixuan.a.zhang.2019@mumail.ie
* Maksym Vavilov. 
    * Student ID: 19252513
    * Student email: maksym.vavilov.2020@mumail.ie
  


### Usage: 
1. Download source code
2. Run _Project.java_ 
3. Adjust _Utilities.Constants_ to change initial conditions. 
4. Enjoy

There is way to run only the world demo or GA demo. To do so, uncomment demoPopulation() 
or demoGA() in the _Project.main()_ 

### Requirements:
- [x] Singleton Pattern
- [x] Factory Pattern
- [x] Strategy Pattern
- [x] Genetic Algorithm 

### Features: 
* Strategy pattern - refer to the Comparator package
* Abstract Factory - refer to the Factory package
* Genetic Algorithm - refer to the GeneticAlgorithmPackage package
    * Single point and Uniform reproducers.
    Refer to the ReproducerSinglePoint and ReproducerUniform 
    at the GeneticAlgorithmPackage.Components package respectively.
    * Rank and Tournament selectors. 
    Refer to the SelectorRank and SelectorTournament
    at the GeneticAlgorithmPackage.Components package respectively.
* Callback interface for the Genetic Algorithm. Used to provide
the best Route to the Comparator. Refer to the GeneticAlgorithmPackage.Components.
* Singleton pattern. Refer to the Population.World class. 
* Parameterised class and Generics. Refer to the Population.Pair class.
* Threading. Refer to the GeneticAlgorithmPackage.GeneticAlgorithm
 

## Changelog:

### version 1.0
* Refactored and cleaned up code
* Javadocs added

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
