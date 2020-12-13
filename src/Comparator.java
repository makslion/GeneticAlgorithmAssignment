import Factory.FancyGAFactory;
import Factory.SimpleGAFactory;
import GeneticAlgorithmPackage.Components.GeneticAlgorithmCallback;
import GeneticAlgorithmPackage.GeneticAlgorithm;
import Population.Route;

import java.util.ArrayList;

public class Comparator implements GeneticAlgorithmCallback {

    private ArrayList<Route> initialPopulation;

    public Comparator(ArrayList<Route> initialPopulation) {
        this.initialPopulation = initialPopulation;
    }


    public void demoAlgorithms(){
        GeneticAlgorithm simpleGA = new GeneticAlgorithm(new SimpleGAFactory(), (ArrayList<Route>) initialPopulation.clone());
        simpleGA.setCallback(this);
        simpleGA.start();

        GeneticAlgorithm fancyGA = new GeneticAlgorithm(new FancyGAFactory(), (ArrayList<Route>) initialPopulation.clone());
        fancyGA.setCallback(this);
        fancyGA.start();
    }

    @Override
    public void bestRouteCallback(Route bestRoute) {
        System.out.println(bestRoute);
        System.out.println("length: "+bestRoute.getRouteLength());
    }

    @Override
    public void populationCallback(ArrayList<Route> population) {
        // access to the whole population from the GA
    }


}
