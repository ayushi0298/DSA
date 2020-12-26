import java.util.PriorityQueue;

public class PriorityQueueTemplate {
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

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
        pq.add(new Pair(1, 1));
        System.out.println(pq.peek());


    }

}
