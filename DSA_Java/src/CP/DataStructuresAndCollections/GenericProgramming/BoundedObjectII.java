package CP.DataStructuresAndCollections.GenericProgramming;

public class BoundedObjectII {
    // Example 2
    interface Printable {
        void print();
    }

    static class PrintableNumber<T extends Number> extends Number implements Printable {

        private final T value;

        PrintableNumber(T value) {
            this.value = value;
        }

        @Override
        public void print() {
            System.out.println("Printing " + value);
        }

        @Override
        public int intValue() {
            return value.intValue();
        }

        @Override
        public long longValue() {
            return value.longValue();
        }

        @Override
        public float floatValue() {
            return value.floatValue();
        }

        @Override
        public double doubleValue() {
            return value.doubleValue();
        }
    }

    static class NumberContainer<T extends PrintableNumber & Printable> {

        private T value;

        public NumberContainer(T value) {
            this.value = value;
        }

        public NumberContainer<T> display() {
            value.print();
            return this;
        }

        public T getValue() {
            return value;
        }

        public NumberContainer<T> setValue(T value) {
            this.value = value;
            return this;
        }
    }

    public static void main(String[] args){
        // Bounded Object Example 2 using Interface

        PrintableNumber myNumber = new PrintableNumber(12);
        NumberContainer<PrintableNumber> num = new NumberContainer<>(myNumber);
        num.display();

        PrintableNumber myNumber2 = new PrintableNumber(12.67);
        NumberContainer<PrintableNumber> num2 = new NumberContainer<>(myNumber2);
        num2.display();
    }
}
