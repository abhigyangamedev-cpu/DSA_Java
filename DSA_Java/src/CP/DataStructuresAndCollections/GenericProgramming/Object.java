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

    public static void main(String[] args){
        // Object Example
        Object<Integer> Obj1 = new Object<>();

        Obj1.setVal(1);
        System.out.println(Obj1.getVal());

        Object<String> Obj2 = new Object<>("H");

        System.out.println(Obj2.getVal());

        Obj2.setVal("X");
        System.out.println(Obj2.getVal());
    }
}

