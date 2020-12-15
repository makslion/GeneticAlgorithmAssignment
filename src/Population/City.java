package Population;

/**
 * City object. Building block for the {@link Route}
 */
public class City {
    private int cId;
    private Pair<Integer, Integer> pair;

    City(int xPosition,int yPosition,int cId){
        pair= new Pair<>(xPosition, yPosition);
        this.cId=cId;
    }

    public int getXPosition()
    {
        return (int) pair.first();
    }
    public int getYPosition()
    {
        return (int) pair.second();
    }

    public int getcId() {
        return cId;
    }
                                 
}

