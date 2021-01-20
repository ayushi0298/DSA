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
        int k=4;
        input.add(1);
        input.add(1);
        input.add(3);
        input.add(9);
        input.add(50);
        input.add(10);
        System.out.println(kl.findKLargest(input,k));
    }
}
