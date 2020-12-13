import Factory.FancyGAFactory;
import Factory.SimpleGAFactory;
import GeneticAlgorithmPackage.FancyGAsample;
import GeneticAlgorithmPackage.GeneticAlgorithm;
import GeneticAlgorithmPackage.SimpleGAsample;
import Helpers.Constants;
import Population.Route;
import Population.World;

import java.util.ArrayList;
import Comparator.Comparator;
import Comparator.ResultComparator;
import Comparator.TimeComparator;

public class Project {

    public static void main(String[] args) {

        // demoPopulation();

         //demoGA();

        comparatorDemo();
    }


    private static void demoPopulation(){

        World.getInstance().setWorld(Constants.WORLD_SIZE_X, Constants.WORLD_SIZE_Y, Constants.NUMBER_OF_CITIES,Constants.NUMBER_OF_ROUTES);
        System.out.print("City list:\n"+Population.World.getInstance().getCityList());
        System.out.print("Route list: \n"+Population.World.getInstance().getRouteList());
        System.out.print(Population.World.getInstance().getRouteList().get(0).getRoute().get(0));
        System.out.print(Population.World.getInstance().getRouteList().get(0).getRouteLength());

    }


    private static void comparatorDemo(){
        World.getInstance().setWorld(Constants.WORLD_SIZE_X, Constants.WORLD_SIZE_Y, Constants.NUMBER_OF_CITIES,Constants.NUMBER_OF_ROUTES);
        ArrayList<Route> initialPopulation = World.getInstance().getRouteList();

       // Comparator comparator = new Comparator(initialPopulation);
        //comparator.demoAlgorithms();
        Comparator timeComparator = new TimeComparator(initialPopulation);
        timeComparator.compare();
        
        Comparator resultComparator = new ResultComparator(initialPopulation);
        resultComparator.compare();
      
        
    }


    private static void demoGA(){

        World.getInstance().setWorld(Constants.WORLD_SIZE_X, Constants.WORLD_SIZE_Y, Constants.NUMBER_OF_CITIES,Constants.NUMBER_OF_ROUTES);
        ArrayList<Route> initialPopulation = World.getInstance().getRouteList();

        ArrayList<GeneticAlgorithm> simpleAlgorithms = new ArrayList<>();
        ArrayList<GeneticAlgorithm> fancyAlgorithms = new ArrayList<>();

        // prepare
        for (int i = 0; i < Constants.NUMBER_OF_GA_INSTANCES; i++){
            simpleAlgorithms.add(new GeneticAlgorithm(new SimpleGAFactory(),(ArrayList<Route>) initialPopulation.clone()));
            fancyAlgorithms.add(new GeneticAlgorithm(new FancyGAFactory(), (ArrayList<Route>) initialPopulation.clone()));
        }

        // start evolution
        for (GeneticAlgorithm ga : simpleAlgorithms)
            ga.start();
        for (GeneticAlgorithm ga : fancyAlgorithms)
            ga.start();

        // GAs are running in threads and it takes a bit. (especially because of sleep())
        // so the only way to call result from other class
        // is by this approach:
        int algorithmsYielded = 0;
        ArrayList<Route> simpleBestRoutes = new ArrayList<>();
        ArrayList<Route> fancyBestRoutes = new ArrayList<>();

        // wait until done!
        while (algorithmsYielded < simpleAlgorithms.size()){
            for (GeneticAlgorithm ga : simpleAlgorithms){
                Route placeHolder = ga.getTheBestRoute();

                if (placeHolder != null && !simpleBestRoutes.contains(placeHolder)){
                    algorithmsYielded += 1;
                    simpleBestRoutes.add(placeHolder);
//                    System.out.println(ga+" simple yielded "+algorithmsYielded);
                }
            }
        }

        System.out.println("\nResults from simple algorithms: ");
        for (Route route : simpleBestRoutes){
            System.out.println(route);
            System.out.println("length: "+route.getRouteLength());
        }

         // literally the same code, but for fancy GA (only name of GAsample changed - everything else the same!!)

        algorithmsYielded = 0;

        while (algorithmsYielded < fancyAlgorithms.size()){
            for (GeneticAlgorithm ga : fancyAlgorithms){
                Route placeHolder = ga.getTheBestRoute();

                if (placeHolder != null && !fancyBestRoutes.contains(placeHolder)){
                    algorithmsYielded += 1;

                    fancyBestRoutes.add(placeHolder);
//                    System.out.println(ga+" fancy yielded "+algorithmsYielded);
                }
            }
        }

        System.out.println("\nResults from fancy algorithms: ");
        for (Route route : fancyBestRoutes){
            System.out.println(route);
            System.out.println("length: "+route.getRouteLength());
        }



        // but this is not the "good" way
        // there are two options i can think about:
        //      attach an observer to the GeneticAlgorithm
        //      in finish() inside GeneticAlgorithm send the result where it needed
        // please, let me (Maksym) know if there is a need of implementation any of them
        // and I will do it ASAP
    }
    
   
    
}
