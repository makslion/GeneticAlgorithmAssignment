package GeneticAlgorithmPackage.Components;

import Population.Route;

import java.util.ArrayList;

public abstract class Selector {

    public abstract ArrayList<Route> doSelection(ArrayList<Route> population);

    protected ArrayList<Route> ensureEven(ArrayList<Route> population){
        //if odd just remove the last
        if (population.size()%2 == 1)
            population.remove(population.size()-1);
        return population;
    }
}
