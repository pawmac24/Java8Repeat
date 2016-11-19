package project02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by PawelM on 2016-11-19.
 */
public class Java8Tester02 {

    public static void main(String[] args) {
        List<String> names1 = new ArrayList<String>();
        names1.add("Pawel ");
        names1.add("Robert ");
        names1.add("Andrzej ");
        names1.add("Tomek ");
        names1.add("Marek ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Pawel ");
        names2.add("Robert ");
        names2.add("Andrzej ");
        names2.add("Tomek ");
        names2.add("Marek ");

        Java8Tester02 tester = new Java8Tester02();
        System.out.println("Sort using Java 7 syntax: ");

        tester.sortUsingJava7(names1);
        System.out.println(names1);
        System.out.println("Sort using Java 8 syntax: ");

        tester.sortUsingJava8(names2);
        System.out.println(names2);
    }

    //sort using java 7
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    //sort using java 8
    private void sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }

}
