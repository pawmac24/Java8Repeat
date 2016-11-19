package project01;

import java.util.ArrayList;
import java.util.Arrays;

public class IntSequenceDemo {

    public static void main(String[] args) {
        SquareSequence squares = new SquareSequence();
        double avg = average(squares, 100);
        System.out.println("1 avg equals = " + avg);

        IntSequence digits = new DigitSequence(1729);
        while (digits.hasNext()) System.out.print(digits.next() + " ");
        System.out.println();

        digits = new DigitSequence(1729);
        avg = average(digits, 100);
        System.out.println("2 avg equals = " + avg);

        IntSequence.xxx();
        SquareSequence squaresXYZ = new SquareSequence();
        System.out.println (squaresXYZ.yyy());

        String[] friends = { "Piotr", "Pawel", "Maria" };
        Arrays.sort(friends,
                (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(friends));
        ArrayList<String> enemies = new ArrayList<>(Arrays.asList("Malfoy", "Crabbe", "Goyle", null));
        enemies.removeIf(e -> e == null);
        System.out.println(enemies);
    }


    public static double average(IntSequence seq, int n) {
        int count = 0;
        double sum = 0;
        while (seq.hasNext() && count < n) {
            count++;
            sum += seq.next();
        }
        return count == 0 ? 0 : sum / count;
    }
}
