package project01;

/**
 * Created by PawelM on 2016-11-17.
 */
public class SquareSequence implements IntSequence {

    private int i;

    //@Override
    public boolean hasNext() {
        return true;
    }

    //@Override
    public int next() {
        i++;
        return i * i;
    }

}
