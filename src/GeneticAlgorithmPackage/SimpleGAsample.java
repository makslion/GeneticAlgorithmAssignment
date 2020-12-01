package GeneticAlgorithmPackage;

import GeneticAlgorithmPackage.Components.ReproducerSinglePoint;
import GeneticAlgorithmPackage.Components.SelectorRank;
import Population.Route;
import java.util.ArrayList;

// just for testing purposes! Until we don't have factory
// in fact this is simulation of factory

public class SimpleGAsample extends GeneticAlgorithm {

    public SimpleGAsample(ArrayList<Route> population, int generationsToDo, int mutationRate) {
        super(population, generationsToDo, mutationRate);
        simulateFactory();
    }

    public SimpleGAsample(ArrayList<Route> population) {
        super(population);
        simulateFactory();
    }

    private void simulateFactory(){
        reproducer = new ReproducerSinglePoint();
        selector = new SelectorRank();
    }
}
