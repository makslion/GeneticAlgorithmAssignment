package GeneticAlgorithmPackage;

import Factory.AbstractFactory;
import GeneticAlgorithmPackage.Components.ReproducerUniform;
import GeneticAlgorithmPackage.Components.SelectorTournament;
import Population.Route;
import java.util.ArrayList;

// just for testing purposes! Until we don't have factory
// in fact this is simulation of factory

public class FancyGAsample extends GeneticAlgorithm {

    public FancyGAsample(AbstractFactory factory, ArrayList<Route> population, int generationsToDo, int mutationRate) {
        super(factory, population, generationsToDo, mutationRate);
        simulateFactory();
    }

    public FancyGAsample(AbstractFactory factory, ArrayList<Route> population) {
        super(factory, population);
        simulateFactory();
    }

    private void simulateFactory(){
        reproducer = new ReproducerUniform();
        selector = new SelectorTournament();
    }
}
