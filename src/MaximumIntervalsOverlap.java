import java.util.ArrayList;
import java.util.Arrays;

public class MaximumIntervalsOverlap {
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
            if(value1 == o.value1){
                return Integer.compare(o.value2, value2);
            }
            return Integer.compare(value1, o.value1);
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
    int maxGuests = 0, max=0;
    public int findMaxTime(int x[], int y[], int size) {

//        Arrays.sort(x);
//        Arrays.sort(y);
        Pair result[] = new Pair[size];

        for (int i = 0, c = 0; i < x.length; i++) {
            result[c++] = new Pair(x[i], 1);
            result[c++] = new Pair(y[i], -1);
        }

//        for (int i = 0; i < x.length; i++) {
//            result[i] = new Pair(x[i], 1);
//        }
//        for (int i = x.length; i < (x.length + y.length); i++) {
//            result[i] = new Pair(y[i-x.length], -1);
//        }
        //System.out.println(Arrays.toString(result));
        Arrays.sort(result);
        //System.out.println(Arrays.toString(result));

        for (int i = 0; i < result.length; i++) {
            if (result[i].value2 == 1) {
                maxGuests = maxGuests + 1;

            } else {
                maxGuests = maxGuests - 1;
            }
            //System.out.println(result[i].value1 +" " + maxGuests);
            if(max<maxGuests){
                max = maxGuests;
            }
        }

        return max;
    }

    public static void main(String args[]) {
        MaximumIntervalsOverlap mp = new MaximumIntervalsOverlap();
        int x[] = new int[]{1, 2, 10, 5, 5};
        int y[] = new int[]{4, 5, 12, 9, 12};
        int size = x.length + y.length;
        System.out.println(mp.findMaxTime(x, y, size));
    }

}
