package Population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class World {
    static private World instance;

    public synchronized static World getInstance(){
        if(instance == null){
            synchronized(World.class)
            {
                if(instance == null){
                    instance = new World();
                }
            }
        }
        return instance;
    }
    private ArrayList<Route> routeList;
    private ArrayList<City> cityList;
    private int numberOfCities;
    private int numberOfRoute;
    private int worldSizeX;
    private int worldSizeY;
    
    private World(){
//        System.out.println("Creating a world.....");
        

    }
    
    public void setWorld(int mapSizeX,int mapSizeY,int numberOfCities,int numberOfRoute){
//        System.out.println("Population.World size: " + mapSizeX + " X "+ mapSizeY );
//        System.out.println("Number of Cities: " + numberOfCities + ", Number of route "+ numberOfRoute );
        this.numberOfCities=numberOfCities;
        this.worldSizeX=mapSizeX;
        this.worldSizeY=mapSizeY;
        this.numberOfRoute=numberOfRoute;
        this.cityList=crateCityList();
        this.routeList=crateRouteList();
    }

    public int getWorldX(){
        return this.worldSizeX;
    }
    public int getWorldY(){
        return this.worldSizeY;
    }
    public int getNumberOfCities(){
        return this.numberOfCities;
    }
    public ArrayList<City> getCityList(){
        return this.cityList;
    }
    public ArrayList<Route> getRouteList(){
        return this.routeList;
    }


    public ArrayList<City> crateCityList(){
        ArrayList<City> cityList = new ArrayList();
        for (int i = 0; i < numberOfCities;i++)
        {
            int xPosition = ThreadLocalRandom.current().nextInt(0, worldSizeX);
            int yPosition = ThreadLocalRandom.current().nextInt(0, worldSizeY);
            cityList.add(i, new City(xPosition,yPosition,i));
//            System.out.println("Population.City ID: "+cityList.get(i).getcId()+",X position: "+cityList.get(i).getXPosition()+",Y position: "+cityList.get(i).getYPosition());
            }
        return cityList;
    }

    public ArrayList<Route> crateRouteList(){
        ArrayList<Route> routeList = new ArrayList();
        for(int i=0;i<numberOfRoute;i++){
            ArrayList<Integer> route = IntStream.range(0, numberOfCities).boxed().collect(Collectors.toCollection(ArrayList::new));
            Collections.shuffle(route);
            routeList.add(i, new Route(numberOfCities,cityList,route,i));
            }
        return routeList;
    } 
        

}
    
    

