package CP.DataStructuresAndCollections.GenericProgramming;

enum Operations {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVISION;
    public <N extends Number> double calculate(N a, N b) {
        assert a != null : "First number cannot be null";
        assert b != null : "Second number cannot be null";
        double x = a.doubleValue();
        double y = b.doubleValue();
        switch (this) {
            case ADD:
                return x + y;

            case SUBTRACT:
                return x - y;

            case MULTIPLY:
                return x * y;

            case DIVISION:
                assert y != 0 : "Cannot divide by zero";
                return x / y;
        }
        return 0;
    }
}

public class GenericEnum {

    public static void main(String[] args) {

        System.out.println("Integer Operations:");

        System.out.println("Addition: " + Operations.ADD.calculate(10, 5));
        System.out.println("Subtraction: " + Operations.SUBTRACT.calculate(10, 5));
        System.out.println("Multiplication: " + Operations.MULTIPLY.calculate(10, 5));
        System.out.println("Division: " + Operations.DIVISION.calculate(10, 5));

        System.out.println("\nDouble Operations:");

        System.out.println("Addition: " + Operations.ADD.calculate(10.5, 5.5));
        System.out.println("Subtraction: " + Operations.SUBTRACT.calculate(10.5, 5.5));
        System.out.println("Multiplication: " + Operations.MULTIPLY.calculate(10.5, 5.5));
        System.out.println("Division: " + Operations.DIVISION.calculate(10.5, 5.5));

        System.out.println("\nFloat Operations:");

        System.out.println("Addition: " + Operations.ADD.calculate(10.5f, 5.5f));
        System.out.println("Multiplication: " + Operations.MULTIPLY.calculate(10.5f, 2.0f));
    }
}