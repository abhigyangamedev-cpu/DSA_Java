package CP.DataStructuresAndCollections.GenericProgramming;

import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

public class WildcardsInGeneric {

    // Unbounded Wildcard
    public void printArrayList(ArrayList<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    // Upper Bound
    // Accepts List<Integer>, List<Double>, List<Float>, etc.
    public static double sum(List<? extends Number> numbers) {
        double sum = 0;

        for (Number o : numbers) {
            sum += o.doubleValue();
        }

        return sum;
    }

    // Lower Bound
    // Accepts List<Integer>, List<Number>, List<Object>, etc.
    public static void printNumbers(List<? super Integer> numbers) {
        for (Object o : numbers) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {

        WildcardsInGeneric obj = new WildcardsInGeneric();

        // 1. Unbounded Wildcard <?>

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        ArrayList<String> names = new ArrayList<>();
        names.add("Abhigyan");
        names.add("Rahul");
        names.add("Amit");

        System.out.println("=== Unbounded Wildcard ===");

        obj.printArrayList(numbers);

        System.out.println();

        obj.printArrayList(names);

        // 2. Upper Bound <? extends Number>

        System.out.println("\n=== Upper Bound ===");

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(20);
        integers.add(30);

        ArrayList<Double> decimals = new ArrayList<>();
        decimals.add(10.5);
        decimals.add(20.5);
        decimals.add(30.5);

        System.out.println("Integer Sum: " + sum(integers));
        System.out.println("Double Sum: " + sum(decimals));

        // 3. Lower Bound <? super Integer>

        System.out.println("\n=== Lower Bound ===");

        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(20);
        integerList.add(30);

        ArrayList<Number> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(20.5);
        numberList.add(30);

        ArrayList<Object> objectList = new ArrayList<>();
        objectList.add(10);
        objectList.add("Hello");
        objectList.add(30.5);

        System.out.println("Integer List:");
        printNumbers(integerList);

        System.out.println("\nNumber List:");
        printNumbers(numberList);

        System.out.println("\nObject List:");
        printNumbers(objectList);
    }
}