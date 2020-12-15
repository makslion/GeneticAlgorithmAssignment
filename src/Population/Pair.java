package Population;

public class Pair<X, Y> {

    /**
     * The first element of this <code>Population.Pair</code>
     */
    private X x;

    /**
     * The second element of this <code>Population.Pair</code>
     */
    private Y y;

    /**
     * Constructs a new <code>Population.Pair</code> with the given values.
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

    public void setFirst(X x) {
        this.x = x;
    }

    public void setSecond(Y y) {
        this.y = y;
    }
}
