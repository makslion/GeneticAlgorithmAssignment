package GeneticAlgorithmPackage.Components;

import Helpers.Utilities;
import Population.Route;

import java.util.ArrayList;

public abstract class Reproducer {

    public ArrayList<Route> doReproduction(ArrayList<Route> population) {

//        System.out.println(this.getClass().getSimpleName()+"\n\tbefore reproduction:");
//        for (Route route : population) {
//            System.out.print("Route id "+route.getrId()+" ");
//            for (Integer integer : route.getRoute())
//                System.out.print(integer);
//            System.out.print("\n");
//        }

        ArrayList<Route> newGeneration = new ArrayList<>();
        Route first = null;

        while (population.size() > 1) {

            int [] randomPair = Utilities.getRandomIntPair(0, population.size());
            Route firstParent = population.get(randomPair[0]);
            Route secondParent = population.get(randomPair[1]);

            //save the first "parent" to crossover with the last
            if(first == null)
                first = firstParent;


            population.remove(firstParent);
            newGeneration.addAll(doCrossover(firstParent,secondParent));
        }

        // the last crossover
        newGeneration.addAll(doCrossover(first, population.get(0)));

//        System.out.println(this.getClass().getSimpleName()+"\n\tafter reproduction: ");
//        for (Route route : newGeneration) {
//            System.out.print("Route id "+route.getrId()+" ");
//            for (Integer integer : route.getRoute())
//                System.out.print(integer);
//            System.out.print("\n");
//        }

        return newGeneration;
    }

    protected abstract ArrayList<Route> doCrossover(Route firstParent, Route secondParent);



}
