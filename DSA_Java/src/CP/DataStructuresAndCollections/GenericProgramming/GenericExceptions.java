package CP.DataStructuresAndCollections.GenericProgramming;

public class GenericExceptions {
    static class MyException extends Exception {
        public <T> MyException(T value) {
            super("Exception related to value: " + value + " of type: " + value.getClass().getName());
        }
    }
    public static void main(String[] args) {
        // Integer example
        try {
            throw new MyException(123);
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        // String example
        try {
            throw new MyException("Hello");
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        // Double example
        try {
            throw new MyException(12.5);
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}