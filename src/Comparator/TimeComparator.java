package Comparator;
import java.util.ArrayList;

import Factory.AbstractFactory;
import Factory.FancyGAFactory;
import Factory.SimpleGAFactory;
import GeneticAlgorithmPackage.GeneticAlgorithm;
import Population.Route;

public class TimeComparator extends Comparator {

	public TimeComparator(ArrayList<Route> initialPopulation) {
		super(initialPopulation);
	}

	private long simpleDuration = -1, fancyDuration = -1;
	private long simpleStartTime, fancyStartTime;

	@Override
	public void compare() {
		GeneticAlgorithm simpleGA = new GeneticAlgorithm(new SimpleGAFactory(), (ArrayList<Route>) initialPopulation.clone());
		simpleGA.setCallback(this);
		simpleStartTime = System.nanoTime();
		simpleGA.start();

		GeneticAlgorithm fancyGA = new GeneticAlgorithm(new FancyGAFactory(), (ArrayList<Route>) initialPopulation.clone());
		fancyGA.setCallback(this);
		fancyStartTime = System.nanoTime();
		fancyGA.start();
	}

	@Override
	public void bestRouteCallback(Route bestRoute, AbstractFactory factory) {

		if (factory instanceof SimpleGAFactory){
			long simpleEndTime = System.nanoTime();
			simpleDuration = simpleEndTime - simpleStartTime;
		}
		else if (factory instanceof FancyGAFactory){
			long fancyEndTime = System.nanoTime();
			fancyDuration = fancyEndTime - fancyStartTime;
		}

		if (simpleDuration != -1 && fancyDuration != -1)
			printResults();
	}


	@Override
	protected void printResults() {
		double simpleDurationSeconds = (double) simpleDuration / 1000000000;
		double fancyDurationSeconds = (double) fancyDuration / 1000000000;
		System.out.println("simpleGA execution time: "+ simpleDurationSeconds);
		System.out.println("fancyGA execution time: "+ fancyDurationSeconds);

		if(simpleDuration>fancyDuration) {
			System.out.println("simpleGA is slower than fancyGA");
		}
		else if(simpleDuration == fancyDuration){
			System.out.println("same");
			System.out.print(simpleDuration + fancyDuration);
		}
		else{
			System.out.println("simpleGA is faster than fancyGA");
		}
	}


}
