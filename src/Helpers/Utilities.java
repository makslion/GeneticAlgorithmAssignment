package Helpers;

import Population.City;
import Population.Route;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Utilities {

    //lower bound inclusive, upper bound exclusive
    public static int[] getRandomIntPair(int lowerBound, int upperBound){
        Random random = new Random();
        int [] pairIndexes = {0,0};
        // generate two pseudo random indexes of routes in population
        // ensure we have unique indexes
        while (pairIndexes[0] == pairIndexes[1])
            pairIndexes = random.ints(lowerBound , upperBound).limit(2).toArray();

        return pairIndexes;
    }

    // remove duplicated cities
    public static ArrayList<Integer> filterDuplicates(ArrayList<Integer> route, ArrayList<City> cities){

        ArrayList<Integer> duplicateIndex = new ArrayList<>();
        ArrayList<Integer> duplicateID = new ArrayList<>();
        ArrayList<Integer> blacklist = new ArrayList<>();

        // fid duplicates
        for (int i = 0; i < route.size()-1; i ++){
            int currentIndex = route.get(i);
            for (int j = i+1; j < route.size(); j++){
                if (currentIndex == route.get(j) && !blacklist.contains(j)){
//                    System.out.println("\nfound duplicate: "+currentIndex+" at index "+j+" on element "+route.get(j));
//                    System.out.println("i "+i+" ,j "+j);
                    duplicateIndex.add(j);
                    duplicateID.add(currentIndex);
                    blacklist.add(j);
                }
            }
        }

        // if there were duplicates
        if (!duplicateID.isEmpty()) {
            ArrayList<City> missingCities = new ArrayList<>();

            // find missing cities in the route
            for (City city : cities) {
                if (!route.contains(city.getcId())) {
//                    System.out.println("Found missing city with id: " + city.getcId());
                    missingCities.add(city);
                }
            }

//            System.out.println("");
//            System.out.println("route:");
//            for (Integer integer : route)
//                System.out.print(integer+" ");
//            System.out.println("");
//            System.out.println("missing cities: ");
//            for (City city : missingCities)
//                System.out.print(city.getcId()+" ");
//            System.out.println("");
//            System.out.println("duplicate IDs:");
//            for (Integer integer: duplicateID)
//                System.out.print(integer+" ");
//            System.out.println("");
//            System.out.println("blacklist:");
//            for (Integer integer : blacklist)
//                System.out.print(integer+" ");
//            System.out.println();

            // replace duplicates with missing cities
            for (Integer blacklistElement : blacklist){
                // double check
                if (duplicateID.contains(route.get(blacklistElement))) {
                    route.set(blacklistElement, missingCities.get(0).getcId());
                    missingCities.remove(0);
                }
            }

//            System.out.println("route after removal duplicates:");
//            for (Integer integer : route)
//                System.out.print(integer+" ");
//            System.out.println("");
        }


        return route;

    }

}
