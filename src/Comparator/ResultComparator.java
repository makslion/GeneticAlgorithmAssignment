package Comparator;
import java.util.ArrayList;

import Factory.AbstractFactory;
import Factory.FancyGAFactory;
import Factory.SimpleGAFactory;
import GeneticAlgorithmPackage.GeneticAlgorithm;
import Population.Route;

public class ResultComparator extends Comparator {

	public ResultComparator(ArrayList<Route> initialPopulation) {
		super(initialPopulation);
	}


	private double simpleLength = -1, fancyLength = -1;

	@Override
	public void compare() {

		GeneticAlgorithm simpleGA = new GeneticAlgorithm(new SimpleGAFactory(), (ArrayList<Route>) initialPopulation.clone());
		simpleGA.setCallback(this);
		simpleGA.start();

        GeneticAlgorithm fancyGA = new GeneticAlgorithm(new FancyGAFactory(), (ArrayList<Route>) initialPopulation.clone());
        fancyGA.setCallback(this);
        fancyGA.start();
	}


	@Override
	public void bestRouteCallback(Route bestRoute, AbstractFactory factory) {
		if (factory instanceof SimpleGAFactory)
			simpleLength = bestRoute.getRouteLength();
		else if (factory instanceof  FancyGAFactory)
			fancyLength = bestRoute.getRouteLength();

		if (simpleLength != -1 && fancyLength != -1)
			printResults();
	}


	@Override
	protected void printResults(){
		System.out.println("SimpleGA length: "+simpleLength);
		System.out.println("FancyGA length: "+fancyLength);

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
