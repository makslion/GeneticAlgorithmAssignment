package GeneticAlgorithmPackage.Components;

import Helpers.Utilities;
import Population.Route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ReproducerSinglePoint extends Reproducer{



    protected ArrayList<Route> doCrossover(Route firstParent, Route secondParent){
        // generate pseudo random int to specify the point for crossover
        int randomInt = new Random().nextInt(firstParent.getRoute().size());
//        int middlePoint = firstParent.getRoute().size()/2;

//        System.out.print("\ndoing crossover between\n");
//        System.out.print("Route id "+firstParent.getrId()+" ");
//        for (Integer integer : firstParent.getRoute())
//            System.out.print(integer);
//        System.out.print("\n");
//        System.out.print("Route id "+secondParent.getrId()+" ");
//        for (Integer integer : secondParent.getRoute())
//            System.out.print(integer);
//        System.out.print("\n");


        // things to build a new route
        Route fistChild, secondChild;
        ArrayList<Integer> firstRoute = new ArrayList<>();
        ArrayList<Integer> secondRoute = new ArrayList<>();

        // going over the route
        for(int i = 0; i < firstParent.getRoute().size(); i++){
            // until we reach a random just copy
            if (i < randomInt){
                firstRoute.add(firstParent.getRoute().get(i));
                secondRoute.add(secondParent.getRoute().get(i));
            }
            // after we reach random value, switch parents
            else {
                firstRoute.add(secondParent.getRoute().get(i));
                secondRoute.add(firstParent.getRoute().get(i));

            }
        }

//        System.out.print("\nafter crossover \n");
//        for (Integer integer : firstRoute)
//            System.out.print(integer);
//        System.out.print("\n");
//        for (Integer integer : secondRoute)
//            System.out.print(integer);
//        System.out.print("\n");



        firstRoute = Utilities.filterDuplicates(firstRoute, firstParent.getCityList());
        secondRoute = Utilities.filterDuplicates(secondRoute, secondParent.getCityList());

        //generate new roads.
        fistChild = new Route(firstParent.getNumberOfCities(), firstParent.getCityList(), firstRoute, firstParent.getrId());
                //+(2*firstParent.getRoute().size()));
        secondChild = new Route(secondParent.getNumberOfCities(), secondParent.getCityList(), secondRoute, secondParent.getrId());
                //+(2*secondParent.getRoute().size()));

//        System.out.print("after duplicate removal \n");
//        for (Integer integer : firstRoute)
//            System.out.print(integer);
//        System.out.print("\n");
//        for (Integer integer : secondRoute)
//            System.out.print(integer);
//        System.out.print("\n");

        return new ArrayList<Route>(Arrays.asList(fistChild,secondChild));
    }
}
