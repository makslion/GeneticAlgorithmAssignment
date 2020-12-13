package GeneticAlgorithmPackage.Components;

import Factory.AbstractFactory;
import Population.Route;

import java.util.ArrayList;

public interface GeneticAlgorithmCallback {
    void bestRouteCallback(Route bestRoute, AbstractFactory factory);

    void populationCallback(ArrayList<Route> population);

	void compare();
}
