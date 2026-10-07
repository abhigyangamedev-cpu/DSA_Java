package CP.DataStructuresAndCollections.GenericProgramming;

public class GenericContainer<T> implements ContainerInterface<T> {

    private T item;

    @Override
    public ContainerInterface<T> add(T item) {
        this.item = item;
        return this;
    }

    @Override
    public T get() {
        return item;
    }
}
