package GeneticAlgorithmPackage.Components;

import Helpers.Constants;
import Helpers.Utilities;
import Population.Route;

import java.util.ArrayList;
import java.util.Arrays;

public class ReproducerUniform extends Reproducer{

    boolean [] reproductionTemplate;

    /**
     *  If the default template is not desired this method sets own template
     *
     * @param template boolean array of route length.
     *                 true - inherit from first parent
     *                 false - inherit from second parent.
     */
    public void setReproductionTemplate(boolean [] template){
        if (template.length == Constants.NUMBER_OF_CITIES)
            reproductionTemplate = template;
        else
            System.err.println("Wrong length. Must match number of cities!");
    }

    /**
     * Implementation of the {@link Reproducer#doCrossover(Route, Route)}
     */
    @Override
    protected ArrayList<Route> doCrossover(Route firstParent, Route secondParent) {
        // set default template if wasn't assigned already
        if (reproductionTemplate == null){
            reproductionTemplate = Constants.defaultReproductionTemplate(firstParent.getNumberOfCities());
//            System.out.println("Setting a new template: ");
//            for (Boolean b : reproductionTemplate)
//                if (b)
//                    System.out.print(1+" ");
//                else
//                    System.out.print(0+" ");
//            System.out.println("");
        }

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
            // if true, child 1 <- parent 1 and child 2 <- parent 2
            if (reproductionTemplate[i]){
                firstRoute.add(firstParent.getRoute().get(i));
                secondRoute.add(secondParent.getRoute().get(i));
            }
            // otherwise swap parents
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



        firstRoute = Utilities.removeDuplicates(firstRoute, firstParent.getCityList());
        secondRoute = Utilities.removeDuplicates(secondRoute, secondParent.getCityList());

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
