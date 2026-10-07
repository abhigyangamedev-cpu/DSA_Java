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
}


