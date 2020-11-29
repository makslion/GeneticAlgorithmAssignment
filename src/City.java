public class City {
    private int cId;
    private Pair pair;

    City(int xPosition,int yPosition,int cId){
        pair= new Pair<Integer,Integer>(xPosition, yPosition);
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


    public void setcId(int cId) {
        this.cId = cId;
    }
                                 
}

class Pair<X, Y> {

 /**
     * The first element of this <code>Pair</code>
     */
    private X x;

    /**
     * The second element of this <code>Pair</code>
     */
    private Y y;

    /**
     * Constructs a new <code>Pair</code> with the given values.
     * 
     * @param first  the first element
     * @param second the second element
     */
    public Pair(X first, Y second) {

        this.x = first;
        this.y = second;
    }
    public X first() {
        return x;
    }
    public Y second() {
        return y;
    }

}
