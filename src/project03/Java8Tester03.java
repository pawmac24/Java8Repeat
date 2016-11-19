package project03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PawelM on 2016-11-19.
 */
public class Java8Tester03 {
    public static void main(String args[]){
        Java8Tester03 tester = new Java8Tester03();

        //with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        //with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        //without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        SecondMathOperation secondAddition = (int a, int b) -> a + b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));
        System.out.println("12 + 7 = " + tester.secondOperate(12, 7, secondAddition));

        //with parenthesis
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //without parenthesis
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        SecondGreetingService greetService3 = (message1, message2) ->
                System.out.println("Hello " + message1 + "-" +message2);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");
        greetService3.sayTwoMessage("ttt", "uuu");

        secondExample();
    }



    interface MathOperation {
        int operation(int a, int b);
    }

    interface SecondMathOperation{
        int secondOperation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    interface SecondGreetingService {
        void sayTwoMessage(String message1, String message2);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    private int secondOperate(int a, int b, SecondMathOperation mathOperation){
        return mathOperation.secondOperation(a, b);
    }

    private static void secondExample() {
        List names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(System.out::println);
    }
}