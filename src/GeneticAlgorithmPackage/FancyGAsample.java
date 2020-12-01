package GeneticAlgorithmPackage;

import GeneticAlgorithmPackage.Components.ReproducerUniform;
import GeneticAlgorithmPackage.Components.SelectorTournament;
import Population.Route;
import java.util.ArrayList;

// just for testing purposes! Until we don't have factory
// in fact this is simulation of factory

public class FancyGAsample extends GeneticAlgorithm {

    public FancyGAsample(ArrayList<Route> population, int generationsToDo, int mutationRate) {
        super(population, generationsToDo, mutationRate);
        simulateFactory();
    }

    public FancyGAsample(ArrayList<Route> population) {
        super(population);
        simulateFactory();
    }

    private void simulateFactory(){
        reproducer = new ReproducerUniform();
        selector = new SelectorTournament();
    }
}
