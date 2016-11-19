package project01;

/**
 * Created by PawelM on 2016-11-17.
 */
public class DigitSequence implements IntSequence {

    private int number;
    public DigitSequence(int n) {
        number = n;
    }

    public boolean hasNext() {
        return number != 0;
    }

    public int next() {
        System.out.println("-1->" + number);
        int result = number % 10;
        System.out.println("-2->" + result);
        number /= 10;
        System.out.println("-3->" + number);
        return result;
    }

    public int rest() {
        return number;
    }

    @Override
    public String yyy(){
        return "Dyyy";
    }
}
