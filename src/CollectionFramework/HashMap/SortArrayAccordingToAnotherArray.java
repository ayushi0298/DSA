package CollectionFramework.HashMap;//https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/

import java.util.*;

public class SortArrayAccordingToAnotherArray {
    HashMap<Integer, Integer> storeCount = new HashMap<>();

    public void sortArray(int A1[], int A2[]) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A1.length; i++) {
            int count = storeCount.containsKey(A1[i]) ? storeCount.get(A1[i]) : 0;
            storeCount.put(A1[i], count + 1);
        }

        for (int i = 0; i < A2.length; i++) {
            int count = storeCount.get(A2[i]);
            for (int k = 0; k < count; k++) {
                result.add(A2[i]);
            }
            storeCount.remove(A2[i]);
        }
        Map<Integer, Integer> remainings = new TreeMap<>(storeCount);
        for (Map.Entry<Integer, Integer>
                entry : remainings.entrySet()) {
            int count = entry.getValue();
            for (int k = 0; k < count; k++) {
                result.add(entry.getKey());
            }
        }
        System.out.println(Arrays.toString(new ArrayList[]{result}));
//        System.out.println(Arrays.toString(result));
    }

    public static void main(String args[]) {
        SortArrayAccordingToAnotherArray st= new SortArrayAccordingToAnotherArray();
        int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int A2[] = {2, 1, 8, 3};
        st.sortArray(A1,A2);


    }
}
