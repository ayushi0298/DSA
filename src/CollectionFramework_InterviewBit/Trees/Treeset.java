package CollectionFramework_InterviewBit.Trees;

import java.util.Set;
import java.util.TreeSet;

public class Treeset {
    public static void main(String[] args)
    {

        Set<Integer> ts1 = new TreeSet<>();

        // Elements are added using add() method
        ts1.add(1);
        ts1.add(2);
        ts1.add(3);
        ts1.remove(1);
        int i= ((TreeSet<Integer>) ts1).first();



        System.out.println(ts1);
        System.out.println(i);
    }

}
