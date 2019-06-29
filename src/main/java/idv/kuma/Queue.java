package idv.kuma;


public interface Queue<T> {

    //Removes the element at the beginning of the immutable queue,and returns the new queue.
    public Queue<T> deQueue();

    public Queue<T> enQueue(T t);

    public T head();

    public boolean isEmpty();
}