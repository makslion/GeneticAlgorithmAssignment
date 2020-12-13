package GeneticAlgorithmPackage.Components;


import Population.Route;

import java.util.ArrayList;
import java.util.Comparator;

public class SelectorRank extends Selector{

    @Override
    public ArrayList<Route> doSelection(ArrayList<Route> population) {

//        System.out.println("\n\nRank selector. \nBefore selection:");
//        for (Route route : population)
//            System.out.println(route.getrId()+" "+route.getRouteLength());


        // selection process!
        // order based on distance
        population.sort(Comparator.comparingDouble(Route::getRouteLength));
        //if odd just remove the last
        population = ensureEven(population);


        ArrayList<Route> survivors = new ArrayList<>();

        // select top half
        for (int i = 0; i < population.size() / 2; i++)
            survivors.add(population.get(i));


//            System.out.println("after selection: \n\t");
//            for (Route route : survivors)
//                System.out.println(route.getrId() + " " + route.getRouteLength());

        return survivors;

    }
}
