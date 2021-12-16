/*
Kevin Martinsen
cSCI 1116 - Algorithms and Data Structures
12/15/2021

Exercise 24_5 - GenericQueue using inheritance
 */
import java.util.Collection;
import java.util.LinkedList;

public class GenericQueue<E> extends LinkedList<E> {
    GenericQueue() {} // empty queue
    GenericQueue(Collection<? extends E> c) {
        super(c); // add it all into the LinkedList's constructor
    }

    public void enqueue(E elem) {
        addLast(elem);
    }

    public E dequeue() {
        return removeFirst();
    }
}
