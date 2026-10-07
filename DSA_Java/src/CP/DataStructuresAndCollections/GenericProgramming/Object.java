package CP.DataStructuresAndCollections.GenericProgramming;

public class Object<T> {

    private T val;

    public Object(){}

    public Object(T val){
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public Object<T> setVal(T val) {
        this.val = val;
        return this;
    }
}

