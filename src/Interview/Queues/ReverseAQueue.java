package Interview.Queues;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/reversing-queue-using-recursion/
//without using extra space
public class ReverseAQueue {
    static Queue<Integer> storeElements;
    int count = 0;
    int k = 3;
    int size;

    public Queue<Integer> reverseKGroupQueue() {
        if (storeElements.isEmpty()) {
            return storeElements;
        }
        if (size != 0 && count < k) {
            int poppedElement = storeElements.peek();
            count = count + 1;
            size--;
            storeElements.remove();
            storeElements = reverseKGroupQueue();
            storeElements.add(poppedElement);
        }
        return storeElements;
    }

    public Queue<Integer> callReverseQueue() {

        while (size != 0) {
            if (size != 0 && count == k) {
                count = 0;
                reverseKGroupQueue();
            }
            reverseKGroupQueue();
        }
        return storeElements;
    }


    public Queue<Integer> reverseAQueue(Queue<Integer> storeElements) {

        if (storeElements.isEmpty()) {
            return storeElements;
        }
        int poppedElement = storeElements.peek();
        storeElements.remove();
        storeElements = reverseAQueue(storeElements);
        storeElements.add(poppedElement);
        // System.out.println(storeElements);

        return storeElements;
    }

    public void printQueue(Queue<Integer> storeElements) {
        for (Integer i : storeElements) {
            System.out.print(i.toString() + " ");
        }
    }

    //1 2 3 4
    public static void main(String args[]) {
        ReverseAQueue rq = new ReverseAQueue();
        storeElements = new LinkedList<>();
        storeElements.add(1);
        storeElements.add(2);
        storeElements.add(3);
        storeElements.add(4);
        storeElements.add(5);
        storeElements.add(6);
//        storeElements.add(4);
        rq.size = storeElements.size();
        rq.printQueue(storeElements);
        System.out.println();
        storeElements = rq.callReverseQueue();
        //storeElements = rq.reverseKGroupQueue(storeElements, k, size);
        rq.printQueue(storeElements);


    }
}
