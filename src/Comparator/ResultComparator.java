package Comparator;
import java.util.ArrayList;

import Factory.FancyGAFactory;
import Factory.SimpleGAFactory;
import GeneticAlgorithmPackage.GeneticAlgorithm;
import Population.Route;

public class ResultComparator extends Comparator {

	public ResultComparator(ArrayList<Route> initialPopulation) {
		super(initialPopulation);
	}
	
	
	@Override
	public void compare() {
		
		double simpleLength = 0;
		GeneticAlgorithm simpleGA = new GeneticAlgorithm(new SimpleGAFactory(), (ArrayList<Route>) initialPopulation.clone());
		simpleGA.start();
		Route route;
		simpleLength = simpleGA.getTheBestRoute().getRouteLength();
		System.out.println("www");
		System.out.println("SimpleGA length"+simpleLength);

        
        double fancyLength;
        GeneticAlgorithm fancyGA = new GeneticAlgorithm(new FancyGAFactory(), (ArrayList<Route>) initialPopulation.clone());
        fancyGA.start();
        fancyLength = fancyGA.getTheBestRoute().getRouteLength();
        System.out.println("FancyGA length"+fancyLength);
        
        if(simpleLength>fancyLength) {
        	System.out.println("simpleGA length is longer");
    	}
    	else if(simpleLength==fancyLength){
    		System.out.println("same");
    	}
    	else if(simpleLength<fancyLength) {
    		System.out.println("simpleGA length is shorther");
    	}
		
        
        
        
        
	}
	
	
	

}
