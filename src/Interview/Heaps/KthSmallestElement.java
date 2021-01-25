package Interview.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
//https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
public class KthSmallestElement {
    public int findSmallest(int k, ArrayList<Integer> input) {
        int count=0, result=0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < input.size(); i++) {
            queue.add(input.get(i));
        }
        for (int i = 0; i < k; i++) {
            int current=  queue.peek();
            count++;
            queue.remove();
            if(count==k){
                 result= current;
            }
        }
        return result ;
    }
    public static void main(String  args[]){
        KthSmallestElement kt = new KthSmallestElement();
        ArrayList<Integer> input = new ArrayList<>();
        int k=3;
        input.add(7);
        input.add(4);
        input.add(2);
        input.add(10);
        input.add(8);
        input.add(11);
        System.out.println(kt.findSmallest(k,input));



    }
}
