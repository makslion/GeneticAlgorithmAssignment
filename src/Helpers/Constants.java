package Helpers;

import java.util.Random;

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




    public static boolean[] randomReproductionTemplate(int len) {
        Random random = new Random();

        boolean[] arr = new boolean[len];
        for(int i = 0; i < len; i++) {
            arr[i] = random.nextBoolean();
        }
        return arr;
    }


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
