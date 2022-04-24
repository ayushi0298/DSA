package CollectionFramework_InterviewBit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

//https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
public class IntersectionOfSortedArrays {
    public ArrayList<Integer> intersect(List<Integer> A, List<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                i++;
            } else if ((A.get(i)).equals(B.get(j))) {
                ans.add(B.get(j));
                i++;
                j++;
            } else {

                j++;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        IntersectionOfSortedArrays it = new IntersectionOfSortedArrays();
        ArrayList<Integer> A1 = new ArrayList<>();
        A1.add(1);
        A1.add(2);
        ArrayList<Integer> A2 = new ArrayList<>();
        A2.add(1);
        A2.add(2);
        A2.add(3);
        System.out.println(it.intersect(A1, A2));

    }
}
//SC: O(n)
//TC:O(n)