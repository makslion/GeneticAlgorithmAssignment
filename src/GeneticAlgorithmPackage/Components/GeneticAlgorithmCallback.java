package GeneticAlgorithmPackage.Components;

import Population.Route;

import java.util.ArrayList;

public interface GeneticAlgorithmCallback {
    void bestRouteCallback(Route bestRoute);

    void populationCallback(ArrayList<Route> population);
}
