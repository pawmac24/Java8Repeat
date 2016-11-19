package project06;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * Created by PawelM on 2016-11-19.
 */
public class Java8Tester06 {

    public static void main(String args[]) {
        stringOperations();
        squareOperations();
        statisticsOperations();
        randomOperations();
        parallelOperations();
    }

    private static void parallelOperations() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        System.out.println("List: " + strings);

        //parallel processing
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("Parallel Empty Strings: " + count);
    }

    private static void randomOperations() {
        //print ten random numbers
        System.out.println("Random numbers: ");
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt());
        }
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    private static void statisticsOperations() {
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        System.out.println("Number List: " + integers);

        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }

    private static void squareOperations() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        System.out.println("Number list: " + numbers);
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);
    }

    private static void stringOperations() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        System.out.println("List: " + strings);

        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("Empty Strings: " + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("Strings of length 3: " + count);

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);

        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);
    }


}

