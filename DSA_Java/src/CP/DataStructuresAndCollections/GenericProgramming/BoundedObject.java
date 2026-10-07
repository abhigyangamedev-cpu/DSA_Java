package CP.DataStructuresAndCollections.GenericProgramming;

// Example 1
public class BoundedObject<N extends Number> {
    private N val;

    public BoundedObject(){}

    public BoundedObject(N val){
        this.val = val;
    }

    public N getVal() {
        return val;
    }

    public BoundedObject<N> setVal(N val) {
        this.val = val;
        return this;
    }

    public static void main(String[] args){

        // Bounded Object Example 1

        // BoundedObject<String> BObj1 = new BoundedObject<>("Hello");
        // Error :- Not in Bound Error

        BoundedObject<Float> BObj2 = new BoundedObject<>(5.0f);
        System.out.println(BObj2.getVal());

    }
}


