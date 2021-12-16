/*
Kevin Martinsen
cSCI 1116 - Algorithms and Data Structures
12/15/2021

Exercise 24_5 - GenericQueue using inheritance
 */
public class TestGenericQueue {
    public static void main(String[] args) {
        GenericQueue<Object> testQueue = new GenericQueue<Object>();
        testQueue.enqueue("Test");
        testQueue.enqueue(5);
        testQueue.enqueue("More");

        System.out.println(testQueue.dequeue());
        System.out.println(testQueue.dequeue());
        System.out.println(testQueue.dequeue());
    }
}
