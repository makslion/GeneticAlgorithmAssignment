package GeneticAlgorithmPackage;

import GeneticAlgorithmPackage.Components.ReproducerSinglePoint;
import GeneticAlgorithmPackage.Components.SelectorRank;
import Population.Route;
import java.util.ArrayList;

// just for testing purposes! Until we don't have factory
// in fact this is simulation of factory

public class SimpleGAsample extends GeneticAlgorithm {

    public SimpleGAsample(AbstractFactory factory, ArrayList<Route> population, int generationsToDo, int mutationRate) {
        super(factory, population, generationsToDo, mutationRate);
        simulateFactory();
    }

    public SimpleGAsample(AbstractFactory factory, ArrayList<Route> population) {
        super(factory, population);
        simulateFactory();
    }

    private void simulateFactory(){
        reproducer = new ReproducerSinglePoint();
        selector = new SelectorRank();
    }
}
