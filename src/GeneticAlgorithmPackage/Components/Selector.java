package GeneticAlgorithmPackage.Components;

import Population.Route;

import java.util.ArrayList;

public abstract class Selector {

    /**
     * Performs the selection over the population. Selection logic implemented in the subclasses
     *
     * @param population population to select fittest from.
     * @return half of the population - the fittest candidates
     */
    public abstract ArrayList<Route> doSelection(ArrayList<Route> population);

    /**
     * If the population has odd number of elements - remove the last.
     * Having even number important for the GA as it simplifies selection and reproduction
     * The last elements is removed only from the initial population hence it has no
     * influence of the performance
     *
     * @param population Initial population the check number of elements
     * @return population with even number of elements
     */
    protected ArrayList<Route> ensureEven(ArrayList<Route> population){
        //if odd just remove the last
        if (population.size()%2 == 1)
            population.remove(population.size()-1);
        return population;
    }
}
