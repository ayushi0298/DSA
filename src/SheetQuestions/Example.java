package SheetQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Example {
    public void kFrequent(int[] input, int k){

        int output[]= new int[k];
        HashMap<Integer, Integer> storesFrequency= new HashMap<>();
        for(int i=0; i< input.length;i++){
            storesFrequency.put(input[i],storesFrequency.getOrDefault(input[i],0)+1);

        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue= new PriorityQueue<>((x, y)->x.getValue().equals(y.getValue())?Integer.compare(x.getKey(),y.getKey()): Integer.compare(x.getValue(),y.getValue()));

        for(Map.Entry<Integer,Integer> entry:storesFrequency.entrySet()){
            queue.offer(entry);

        }
        for(int i=0;i<k;i++){
            output[i]= queue.poll().getKey();
        }
        for(int i=0;i<output.length;i++) {
            System.out.println(output[i] + " ");
        }
    }
    public static void main(String[] args) {
        Example e= new Example();
        int arr[]= {1,1,1,2,2,3};
        int k=2;
        e.kFrequent(arr,k);
    }
}

