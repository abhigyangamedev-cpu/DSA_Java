package CP.DataStructuresAndCollections.GenericProgramming;

/*
Naming Conventions
T = Type
E = Elements
K = keys
V = Value
N = Number
*/

public class Main {
    public static void main(String[] args){

        // Object Example
        Object<Integer> Obj1 = new Object<>();

        Obj1.setVal(1);
        System.out.println(Obj1.getVal());

        Object<Integer> Obj2 = new Object<>(2);

        System.out.println(Obj2.getVal());

        Obj2.setVal(4);
        System.out.println(Obj2.getVal());

        // Pair Example
        Pair<String,Integer> p1 = new Pair<>("id",2506666);

        System.out.println(p1.getKey());
        System.out.println(p1.getValue());

        p1.setKey("roll number");
        System.out.println(p1.getKey());
        System.out.println(p1.getValue());

        // Bounded Object Example 1

        // BoundedObject<String> BObj1 = new BoundedObject<>("Hello");
        // Error :- Not in Bound Error

        BoundedObject<Float> BObj2 = new BoundedObject<>(5.0f);
        System.out.println(BObj2.getVal());

        // Bounded Object Example 2 using Interface

        BoundedObjectII.PrintableNumber myNumber = new BoundedObjectII.PrintableNumber(12);
        BoundedObjectII.NumberContainer<BoundedObjectII.PrintableNumber> num = new BoundedObjectII.NumberContainer<>(myNumber);
        num.display();
    }
}
