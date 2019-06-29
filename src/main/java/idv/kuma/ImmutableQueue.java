package idv.kuma;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ImmutableQueue<T> implements Queue<T> {

    private final List<T> storage;

    public ImmutableQueue(){
        this.storage = new ArrayList<>();
    }


    private ImmutableQueue(List<T> storage) {
        this.storage = new ArrayList<>(storage);
    }


    @Override
    public Queue<T> deQueue() {

        if (storage.isEmpty()) throw new NoSuchElementException();

        return new ImmutableQueue<>(storage.subList(1, storage.size()));

    }

    @Override
    public Queue<T> enQueue(T t) {
        List<T> newList = new ArrayList<>(storage);
        newList.add(t);

        return new ImmutableQueue<>(newList);
    }


    @Override
    public T head() {
        if (storage.isEmpty()) throw new NoSuchElementException();
        return storage.get(0);
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }
}
