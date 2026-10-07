package CP.DataStructuresAndCollections.GenericProgramming;

public class GenericConstructor {

    // Default Constructor
    public <T> GenericConstructor() {
        System.out.println("Default Constructor");
    }

    // One-Parameter Generic Constructor
    public <T> GenericConstructor(T value) {
        System.out.println("Value: " + value);
    }

    // Two-Parameter Generic Constructor
    public <T, U> GenericConstructor(T first, U second) {
        System.out.println("First: " + first);
        System.out.println("Second: " + second);
    }
}
