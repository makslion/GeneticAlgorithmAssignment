package Comparator;

import Factory.AbstractFactory;
import GeneticAlgorithmPackage.Components.GeneticAlgorithmCallback;
import Population.Route;

import java.util.ArrayList;


public abstract class Comparator implements GeneticAlgorithmCallback {

    protected ArrayList<Route> initialPopulation;

    /**
     * Constructor for Comparators
     *
     * @param initialPopulation population for Genetic Algorithms to evolve.
     */
    public Comparator(ArrayList<Route> initialPopulation) {
        this.initialPopulation = initialPopulation;
    }


    @Override
    public abstract void bestRouteCallback(Route bestRoute, AbstractFactory factory);

    /**
     * Initialization of Genetic algorithms and start of the evolution.
     */
	public abstract void compare();

	/**
     * Print out results of Genetic Algorithms and print the best algorithm name
     * Depends on the comparison criteria
     */
    protected abstract void printResults();

}
