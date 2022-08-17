import java.util.PriorityQueue;

public class Demo1 {
    public int findMinCost(int[] input) {
        int totalCost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            pq.add(input[i]);
        }
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            pq.add(sum);
            totalCost += sum;
        }
        return totalCost;
    }

    public static void main(String args[]) {
        Demo1 d= new Demo1();
        int[] input= new int[]{5,17,100,11};
        System.out.println(d.findMinCost(input));
    }
}
