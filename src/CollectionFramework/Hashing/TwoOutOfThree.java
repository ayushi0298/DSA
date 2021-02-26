package CollectionFramework.Hashing;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.stream.Collectors;
//https://www.interviewbit.com/problems/two-out-of-three/
public class TwoOutOfThree {
    // public ArrayList<Integer> findCommon(ArrayList<Integer> a1, ArrayList<Integer> a2, ArrayList<Integer> a3)
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        HashMap<Integer, Integer> storeValues = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        List<Integer> newList1 = A.stream()
                .distinct()
                .collect(Collectors.toList());
        List<Integer> newList2 = B.stream()
                .distinct()
                .collect(Collectors.toList());
        List<Integer> newList3 = C.stream()
                .distinct()
                .collect(Collectors.toList());
        for (int i = 0; i < newList1.size(); i++) {
            if (storeValues.containsKey(newList1.get(i))) {
                int count = storeValues.get(newList1.get(i));
                storeValues.put(newList1.get(i), count + 1);
            } else {
                storeValues.put(newList1.get(i), 1);
            }
        }
        for (int i = 0; i < newList2.size(); i++) {
            if (storeValues.containsKey(newList2.get(i))) {
                int count = storeValues.get(newList2.get(i));
                storeValues.put(newList2.get(i), count + 1);
            } else {
                storeValues.put(newList2.get(i), 1);
            }
        }
        for (int i = 0; i < newList3.size(); i++) {
            if (storeValues.containsKey(newList3.get(i))) {
                int count = storeValues.get(newList3.get(i));
                storeValues.put(newList3.get(i), count + 1);
            } else {
                storeValues.put(newList3.get(i), 1);
            }
        }
        System.out.println(storeValues);
        for (Map.Entry x : storeValues.entrySet()) {
            int value= (int)x.getValue();
            int key = (int) x.getKey();
            if(value>=2){
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;
    }


    public static void main(String args[]) {
         TwoOutOfThree tt = new TwoOutOfThree();
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        ArrayList<Integer> a3 = new ArrayList<>();
        a1.add(1);
        a1.add(1);
        a1.add(2);
        a2.add(2);
        a2.add(3);
        a3.add(3);
        System.out.println(tt.solve(a1, a2, a3));

    }
}
