package Factory;

import GeneticAlgorithmPackage.Components.ReproducerUniform;
import GeneticAlgorithmPackage.Components.SelectorTournament;
import GeneticAlgorithmPackage.GeneticAlgorithm;

public class FancyGAFactory extends AbstractFactory {	

	@Override
	public void createTheThing(GeneticAlgorithm geneticAlgorithm) {
		geneticAlgorithm.reproducer = new ReproducerUniform();
		geneticAlgorithm.selector = new SelectorTournament();
		
	}

}
