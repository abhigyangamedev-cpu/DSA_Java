package CP.DataStructuresAndCollections.GenericProgramming;

public class GenericMethods {

    public static <T> void printElement(T element) {
        System.out.println(element);
    }

    public static <T> void printElements(T[] elements) {
        for (T element : elements) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {

        printElement(10);
        printElement("Hello");
        printElement(10.5f);

        System.out.println();

        Integer[] numbers = {10, 20, 30, 40};
        String[] names = {"Abhi", "Rahul", "Aman"};

        printElements(numbers);

        System.out.println();

        printElements(names);
    }
}
