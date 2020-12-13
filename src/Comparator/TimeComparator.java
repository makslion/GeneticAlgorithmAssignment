package Comparator;
import java.util.ArrayList;

import GeneticAlgorithmPackage.GeneticAlgorithm;
import Population.Route;

public class TimeComparator extends Comparator {

	public TimeComparator(ArrayList<Route> initialPopulation) {
		super(initialPopulation);
	}
	
	@Override
	public void compare() {
		ArrayList<GeneticAlgorithm> simpleAlgorithms = new ArrayList<>();
        long startTime1 = System.nanoTime();
        for (GeneticAlgorithm ga : simpleAlgorithms)
            ga.start();
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1);
        System.out.println("simpleGA excution time: "+ duration1);
        
        ArrayList<GeneticAlgorithm> fancyAlgorithms = new ArrayList<>();
        long startTime2 = System.nanoTime();
        for (GeneticAlgorithm ga : fancyAlgorithms)
            ga.start();
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("fancyGA excution time: "+ duration2);
        
        if(duration1>duration2) {
        	System.out.println("simpleGA is slower than fancyGA");
    	}
    	else if(duration1 == duration2){
    		System.out.println("same");
    		System.out.print(duration1 + duration2);
    	}
    	else if(duration1<duration2) {
    		System.out.println("simpleGA is faster than fancyGA");
    	}
		
		
	}
	

}
