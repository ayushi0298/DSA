package CollectionFramework.Hashing;

import java.util.ArrayList;
import java.util.HashSet;

//https://www.interviewbit.com/problems/first-repeating-element/
public class FirstRepeatingElement {
    //public int findFirst(ArrayList<Integer> input)

    public int solve(ArrayList<Integer> input) {
        int firstOccurence = -1;
        HashSet firstRepeating = new HashSet();

        for (int i = input.size() - 1; i >= 0; i--) {
            if (firstRepeating.contains(input.get(i))) {
                firstOccurence = i;
            }
            firstRepeating.add(input.get(i));
        }
        if (firstOccurence != -1) {
            return input.get(firstOccurence);
        }
        return -1;
    }


    public static void main(String args[]) {
        FirstRepeatingElement fr = new FirstRepeatingElement();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(10);
        input.add(5);
        input.add(3);
        input.add(4);
        input.add(3);
        input.add(5);
        input.add(6);
        System.out.println(fr.solve(input));

    }
}
