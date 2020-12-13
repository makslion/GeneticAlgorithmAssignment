package GeneticAlgorithmPackage;

import java.util.ArrayList;
import GeneticAlgorithmPackage.Components.ReproducerSinglePoint;
import GeneticAlgorithmPackage.Components.SelectorRank;
import Population.Route;

public class FancyGAFactory extends AbstractFactory {	

	@Override
	void createTheThing(GeneticAlgorithm geneticAlgorithm) {
		geneticAlgorithm.reproducer = new ReproducerSinglePoint();
		geneticAlgorithm.selector = new SelectorRank();
		
	}

}
