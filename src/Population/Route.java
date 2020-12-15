package Population;


import GeneticAlgorithmPackage.GeneticAlgorithm;

import java.util.ArrayList;

/**
 * Route object.
 * Elements of the population for {@link GeneticAlgorithm}
 */
public class Route {
    private ArrayList<City> cityList;
    private ArrayList<Integer> route;
    private int numberOfCities;
    private double routeLength;
    private int rId;    

    public Route(int numberOfCities, ArrayList<City> cityList, ArrayList<Integer> route, int rId) {
        this.numberOfCities= numberOfCities; 
        this.cityList = cityList;
        this.route = route;
        this.rId = rId;
        this.routeLength=checkRouteLength();
    }

    public int getNumberOfCities() {
        return numberOfCities;
    }

    public ArrayList<Integer> getRoute() {
        return route;
    }
    
    public ArrayList<City> getCityList(){
        return cityList;
    }

    public double getRouteLength(){
        return routeLength;
    }
  
    public int getrId() {
        return rId;
    }


    /**
     * Cost function for the GA.
     * Calculates length of the route
     */
    double checkRouteLength(){
//        System.out.println("Population.Route: "+rId+", path:"+route);
        double totalDistance =0;
        for(int i=0;i<numberOfCities-1;i++){
        int x = cityList.get(route.get(i)).getXPosition();
        int y = cityList.get(route.get(i)).getYPosition();
        int xNext = cityList.get(route.get(i+1)).getXPosition();
        int yNext = cityList.get(route.get(i+1)).getYPosition();       
        double distance = Math.sqrt(Math.pow((x-xNext), 2)+ Math.pow((y-yNext), 2));
        totalDistance= totalDistance + distance;
//        System.out.println("distance of city "+i+" to city "+(i+1)+" is : "+distance);
        }
//        System.out.println("the total distance is："+ totalDistance);
        return totalDistance;
    }

    @Override
    public String toString() {
        String desc = "";
        for (int id: route)
            desc += id+" ";
        return desc;
    }
}
