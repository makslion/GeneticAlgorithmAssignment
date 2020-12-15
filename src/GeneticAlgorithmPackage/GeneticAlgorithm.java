package GeneticAlgorithmPackage;

import Factory.AbstractFactory;
import GeneticAlgorithmPackage.Components.GeneticAlgorithmCallback;
import Helpers.Constants;
import GeneticAlgorithmPackage.Components.Reproducer;
import GeneticAlgorithmPackage.Components.Selector;
import Population.Route;

import java.util.ArrayList;
import java.util.Random;

/**
 * Genetic algorithm implementation.
 * Extends thread to allow multiple parallel algorithms
 * with no impact on the performance
 */
public class GeneticAlgorithm extends Thread{

    // factory comes here
    private AbstractFactory factory;

    // components
    public Selector selector;
    public Reproducer reproducer;
    private ArrayList<Route> population;
    private Route theBestRoute;
    private GeneticAlgorithmCallback callback;

    //parameters
    private int generationsToDo = Constants.DEFAULT_GENERATIONS;
    private int mutationRate = Constants.DEFAULT_MUTATION_RATE;

    private Thread thread;


    /**
     * Constructor to override default parameters
     *
     * @param factory Instance of the factory used for the creation of instance of GA
     * @param population initial population to evolve on
     * @param generationsToDo number of generations for algorithm before it stops
     * @param mutationRate rate of the mutation for each city in each route in every generation.
     *                     Integer value represents percents (0-100)
     */
    public GeneticAlgorithm(AbstractFactory factory, ArrayList<Route> population, int generationsToDo, int mutationRate) {
        this.factory = factory;
        createAlgorithm();
        this.population = population;
        this.generationsToDo = generationsToDo;
        this.mutationRate = mutationRate;
    }

    /**
     * Constructor to use default parameters from {@link Constants}
     *
     * @param factory Instance of the factory used for the creation of instance of GA
     * @param population initial population to evolve on
     */
    public GeneticAlgorithm(AbstractFactory factory, ArrayList<Route> population) {
        this.factory = factory;
        createAlgorithm();
        this.population = population;
    }

    /**
     * Use {@link AbstractFactory} instance to create this object
     */
    private void createAlgorithm(){
        factory.createTheThing(this);
    }


    @Override
    public void start() {
        if (thread == null) {
            thread = new Thread (this);
            try {
                // GA heavily dependent on the random
                // here used pseudo-random
                // sleep to de-sync from the "random seed"
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
            thread.start();
        }
    }

    /**
     * Evolution process. Loop through number of generations
     * and once done - finalize
     */
    @Override
    public void run() {
        if(population == null){
            System.err.println("You haven't initialized Genetic Algorithm.\tUse the constructor with valid parameters");
        }
        else {
            // genetic algorithm for generationsToDo generations
            for (int i = 0; i < generationsToDo; i++){
//                System.out.println("generation "+i+" population size "+population.size()+" length of routes "+population.get(0).getRoute().size());
                //select the fittest
                population = selector.doSelection(population);

                //do crossover
                population = reproducer.doReproduction(population);

                //mutate
                population = doMutation(population);
            }

            // after reaching the desired number of generations
            finish();
        }
    }


    /**
     * Mutation phase of the genetic algorithm.
     * Implemented here as the is only one way to mutate.
     * Hence, no need to burden a factory and create more classes
     *
     * @param population current generation in the genetic algorithm
     * @return population with mutated cities.
     */
    private ArrayList<Route> doMutation(ArrayList<Route> population){
//        System.out.println("doing mutation over: ");
//        for (Route route : population)
//            System.out.println(route);
//        System.out.println("With chance of "+Constants.DEFAULT_MUTATION_RATE+"%");

        Random random = new Random();

        for (Route route : population){
//            System.out.println("playing with \n"+route);
            for (int i = 0; i < route.getRoute().size(); i++){
                if (random.nextInt(100) <= Constants.DEFAULT_MUTATION_RATE){
//                    System.out.println("mutating at index "+i);
                    // there is a chance to mutate to the same city id!
                    route.getRoute().set(i, random.nextInt(Constants.NUMBER_OF_CITIES));
                }
            }
//            System.out.println("mutated route: \n"+route);
        }


        return population;
    }



    /**
     * Called internally after evolution is done
     * Sores the best route and invokes {@link GeneticAlgorithmCallback} object
     * if it was set by {@link #setCallback(GeneticAlgorithmCallback)}
     */
    private void finish(){
//        System.out.println(this+" done with generations. Saving the besst result");
        Route candidate = null;

        for (Route route : population){
//            System.out.println("checking the route with length "+route.getRouteLength());
            if (candidate == null)
                candidate = route;
            else if (candidate.getRouteLength() > route.getRouteLength()) {
                candidate = route;
//                System.out.println("new candidate!");
            }
        }
//        System.out.println("saving route with length "+candidate.getRouteLength()+" as the best");
        theBestRoute = candidate;

        // check for a callback
        if (callback != null)
            callback.bestRouteCallback(theBestRoute, factory);
    }


    /**
     * Used for demonstration only.
     * Must not be used in the application - refer instead to the {@link GeneticAlgorithmCallback} interface
     *
     * @return the best route if evolution is done. Null if evolution is in proress
     */
    public Route getTheBestRoute(){
        return theBestRoute != null? theBestRoute : null;
    }


    public void setCallback(GeneticAlgorithmCallback callback) {
        this.callback = callback;
    }
}
