
public class Project {

    public static void main(String[] args) {


        int numberOfCities=50; 
        int worldSizeX=100;
        int worldSizeY=100;
        int numberOfRoute=200;
        
        World.getInstance().setWorld(worldSizeX, worldSizeY, numberOfCities,numberOfRoute);
        //System.out.print(World.getInstance().getCityList());
        //System.out.print(World.getInstance().getRouteList().get(20).getRoute().get(0));
        //System.out.print(World.getInstance().getRouteList().get(9).getRouteLength());
        

    }
    
   
    
}
