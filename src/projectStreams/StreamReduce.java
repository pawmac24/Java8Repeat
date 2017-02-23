package projectStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by PawelM on 2017-02-23.
 */
public class StreamReduce {

    public static void main(String[] args) {

        sumOperation();

        reduceOperation();
        reduceOperationWithoutOptional();
        reduceOperationWithoutOptionalShorten();
    }

    /**
     * Performs a reduction on the elements of this stream,
     * using an associative accumulation function,
     * and returns an Optional describing the reduced value,
     * if any.
     */
    private static void reduceOperation() {
        List<String> list = getLanguageList();

        Stream<String> wordStream = list.stream();
        Stream<Integer> lengthStream = wordStream.map(s -> s.length());
        //first
        Optional<Integer> sum = lengthStream.reduce((x, y) -> x + y);
        //second
        //Optional<Integer> sum = lengthStream.reduce(Integer::sum);
        sum.ifPresent(System.out::println);
    }

    /**
     * ... To avoid Optional you put special initial value for reduce (accumulation) function
     * (identity, accumulator)
     */
    private static void reduceOperationWithoutOptional() {
        List<String> list = getLanguageList();

        Stream<String> wordStream = list.stream();
        Stream<Integer> lengthStream = wordStream.map(s -> s.length());
        int sum = lengthStream.reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    /**
     * The shortest version (identity, reducer, and combiner)
     */
    private static void reduceOperationWithoutOptionalShorten() {
        List<String> list = getLanguageList();

        Stream<String> wordStream = list.stream();
        int sum = wordStream.reduce(0, (x, y) -> x + y.length(), (x, y) -> x + y);
        System.out.println(sum);
    }

    private static void sumOperation() {
        List<String> list = getLanguageList();

        Stream<String> wordStream = list.stream();

        int mySum = wordStream
                .map(s -> s.length())
                .mapToInt(Integer::new)
                .sum();

        System.out.println(mySum);
    }

    private static List<String> getLanguageList() {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("php");
        list.add("python");
        list.add("perl");
        list.add("c");
        list.add("lisp");
        list.add("c#");
        return list;
    }
}
