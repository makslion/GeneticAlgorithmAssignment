package Helpers;

import GeneticAlgorithmPackage.Components.ReproducerUniform;
import Population.Route;

import java.util.Random;


/**
 * Constants and settings for the whole program
 */
public class Constants {
    // world parameters
    public static int NUMBER_OF_CITIES = 50;
    public static int WORLD_SIZE_X = 300;
    public static int WORLD_SIZE_Y = 300;
    public static int NUMBER_OF_ROUTES = 20; //NOT LESS THEN 4

    // genetic algorithms parameters
    public static int DEFAULT_GENERATIONS = 1000;
    public static int DEFAULT_MUTATION_RATE = 2; // percents!!
    public static int NUMBER_OF_GA_INSTANCES = 5;



    /**
     * Obtain a random template for {@link ReproducerUniform}
     *
     * @param len length of the template
     * @return boolean array (pseudo random values) of the desired length
     */
    public static boolean[] randomReproductionTemplate(int len) {
        Random random = new Random();

        boolean[] arr = new boolean[len];
        for(int i = 0; i < len; i++) {
            arr[i] = random.nextBoolean();
        }
        return arr;
    }


    /**
     * Obtain a default reproduction template for {@link ReproducerUniform#doCrossover(Route, Route)}
     *
     * @param len length of the template
     * @return boolean array (based on the default template) of the desired length
     */
    public static boolean[] defaultReproductionTemplate(int len){
        boolean [] template = {true, false};
        boolean [] templateResized = new boolean[len];

        int loop = 0;
        for (int i = 0; i < len; i++){
            if (loop == template.length)
                loop = 0;
            templateResized[i] = template[loop];
            loop++;
        }

        return templateResized;
    }
}
