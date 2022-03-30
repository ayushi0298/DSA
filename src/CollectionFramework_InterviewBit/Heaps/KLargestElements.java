package CollectionFramework_InterviewBit.Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
//https://www.interviewbit.com/problems/k-largest-elements/
public class KLargestElements {
    public ArrayList<Integer> findKLargest(ArrayList<Integer> input, int k){
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < input.size(); i++) {
            queue.add(input.get(i));
        }
        System.out.println("reverse: " + queue);
        //System.out.println(queue);
        for (int i = 0; i <k; i++){
            int currentPeek = queue.peek();
            result.add(currentPeek);
            queue.remove();
        }
       return result;
    }

    public static void main(String args[]){
        KLargestElements kl =new KLargestElements();
        ArrayList<Integer> input = new ArrayList<>();
        int k=10;
        input.add(1);
        input.add(1);
        input.add(3);
        input.add(9);
        input.add(50);
        input.add(10);
        input.add(98);
        input.add(32);
        input.add(88);
        input.add(12);
        input.add(54);
        input.add(65);
        System.out.println(kl.findKLargest(input,k));
    }
}
