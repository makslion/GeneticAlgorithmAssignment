package Factory;

import GeneticAlgorithmPackage.Components.ReproducerSinglePoint;
import GeneticAlgorithmPackage.Components.SelectorRank;
import GeneticAlgorithmPackage.GeneticAlgorithm;


public class SimpleGAFactory extends AbstractFactory {
	
		@Override
		public void createTheThing(GeneticAlgorithm geneticAlgorithm) {
			geneticAlgorithm.reproducer = new ReproducerSinglePoint();
			geneticAlgorithm.selector = new SelectorRank();
			
		}
}
