package projectStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by PawelM on 2017-02-23.
 */
public class StreamExample {

    public static void main(String[] args) {

        //a stream is just a sequence of items
        createStreamFromList();
        createStreamFromArray();

        usingMap();
        usingFilter();

        operationSum();
        operationReduce();

    }

    /**
     * Reduce
     */
    private static void operationReduce() {
        String[] myArray = { "this", "is", "a", "sentence" };
        String result = Arrays.stream(myArray)
                .reduce("", (a,b) -> a + b);
        System.out.println("operationReduce = " + result);
    }

    /**
     *  Java 8 includes several reduction methods, such as sum, average and count,
     *  which allow to perform arithmetic operations on Stream objects and get numbers as results.
     */
    private static void operationSum() {

        int myArray[] = { 1, 5, 8 };
        int sum = Arrays.stream(myArray).sum();
        System.out.println("operationSum = " + sum);
    }

    /**
     * The filter() method expects a lambda expression as its argument.
     * However, the lambda expression passed to it must always return a boolean value,
     * which determines whether or not the processed element should belong to the resulting Stream object.
     */
    private static void usingFilter() {
        String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};
        String[] strings = Arrays.stream(myArray)
                .filter(s -> s.length() > 4)
                .toArray(String[]::new);
        System.out.println("usingFilter = " + Arrays.toString(strings));
    }

    /**
     * Map() - It takes a lambda expression as its only argument,
     * and uses it to change every individual element in the stream.
     * Its return value is a new Stream object containing the changed elements.
     */
    private static void usingMap() {
        String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};
        Stream<String> myStream = Arrays.stream(myArray);

        Stream<String> myNewStream = myStream.map(s -> s.toUpperCase());
        String[] myNewArray = myNewStream.toArray(String[]::new);
        System.out.println("usingMap = " + Arrays.toString(myNewArray));
    }

    private static void createStreamFromArray() {
        // Create an array
        Integer[] myArray = {1, 5, 8};

        // Convert it into a Stream
        Stream<Integer> myStream = Arrays.stream(myArray);
        myStream.forEach(System.out::println);
    }

    private static void createStreamFromList() {
        // Create an ArrayList
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(1);
        myList.add(5);
        myList.add(8);

        // Convert it into a Stream
        Stream<Integer> myStream = myList.stream();
        myStream.forEach(System.out::println);
    }
}
