import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTemplate {
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public void pqq(ArrayList<Integer> input) {
        //default integer priority queue
        //PriorityQueue<Integer> queue = new PriorityQueue<>();

        //reverse integer priority queue
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < input.size(); i++) {
            queue.add(input.get(i));
        }
        System.out.println(queue.peek());
    }

    public static class Pair implements Comparable<Pair> {
        int value1;
        int value2;

        public Pair(int value1, int value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public int compareTo(Pair o) {
            // min
            return Integer.compare(value2, o.value2);
            // max
//             return Integer.compare(o.value2,value2);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "value1=" + value1 +
                    ", value2=" + value2 +
                    '}';
        }
    }

    public static void main(String args[]) {
        PriorityQueueTemplate x = new PriorityQueueTemplate();
        pq.add(new Pair(1, 2));
        pq.add(new Pair(2, 1));
        System.out.println(pq.peek());
        ArrayList<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(9);
        a.add(90);
        x.pqq(a);


    }

}
