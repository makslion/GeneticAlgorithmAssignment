package GeneticAlgorithmPackage.Components;

import Helpers.Utilities;
import Population.Pair;
import Population.Route;

import java.util.ArrayList;


public abstract class Reproducer {

    /**
     * Preforming reproduction over given population.
     *
     * @param population Array list of{@link Route}.
     *                   The population of "parents" to exchange genes.
     *                   Half of the current generation
     * @return ArrayList of {@link Route}. NextGeneration Result of the reproduction. Twice as big as parents
     */
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

            Pair<Integer, Integer> pair = Utilities.getRandomIntPair(0, population.size());
            Route firstParent = population.get(pair.first());
            Route secondParent = population.get(pair.second());

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

    /**
     * The crossover part of the reproduction. Logic is implemented in subclasses.
     *
     * @param firstParent first parent {@link Route} for crossover
     * @param secondParent second parrent {@link Route} for crossover
     * @return Array list of {@link Route} with two children from parents.
     */
    protected abstract ArrayList<Route> doCrossover(Route firstParent, Route secondParent);



}
