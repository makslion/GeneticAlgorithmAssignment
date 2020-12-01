package GeneticAlgorithmPackage.Components;

import Helpers.Utilities;
import Population.Route;

import java.util.ArrayList;

public class SelectorTournament extends Selector{

    @Override
    public ArrayList<Route> doSelection(ArrayList<Route> population) {

//        System.out.println("\n\nTournament selector. \nBefore selection:");
//        for (Route route : population)
//            System.out.println(route.getrId()+" "+route.getRouteLength());


        // selection process!
        //if odd just remove the last
        population = ensureEven(population);

        ArrayList<Route> survivors = new ArrayList<>();

        // tournament finishes when all candidates had "fight"
        while (population.size() != 0){

            int [] pairIndexes = Utilities.getRandomIntPair(0, population.size());

            // randomly select two candidates
            Route first = population.get(pairIndexes[0]);
            Route second = population.get(pairIndexes[1]);

            // "fight" - add the fittest to survivors
            if (first.getRouteLength() < second.getRouteLength())
                survivors.add(first);
            else
                survivors.add(second);

            // remove two candidates from original population
            population.remove(first);
            population.remove(second);
        }

//        System.out.println("after selection: \n\t");
//        for (Route route : survivors)
//            System.out.println(route.getrId() + " " + route.getRouteLength());

        return survivors;
    }
}
