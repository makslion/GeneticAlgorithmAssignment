package GeneticAlgorithmPackage.Components;

import Factory.AbstractFactory;
import GeneticAlgorithmPackage.GeneticAlgorithm;
import Population.Route;


public interface GeneticAlgorithmCallback {
    /**
     * Callback for the {@link GeneticAlgorithm}.
     * Used to get the best {@link Route} achieved during the evolution
     *
     * @param bestRoute the best route that algorithm has after evolution
     * @param factory instance of the factory used for object creation. Can be used to
     *                distinguish between different instances of Genetic Algorithms
     */
    void bestRouteCallback(Route bestRoute, AbstractFactory factory);

}
