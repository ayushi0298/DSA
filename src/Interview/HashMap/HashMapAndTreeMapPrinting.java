package Interview.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapAndTreeMapPrinting {

    public void hashMap() {
        HashMap<Integer, Integer> a1 = new HashMap<>();
        a1.put(100, 2);
        a1.put(20, 2);
        a1.put(5, 2);
        a1.put(9, 2);
        a1.put(3, 2);
        for (Map.Entry x : a1.entrySet()) {
            int key = (int) x.getKey();
            System.out.print(key + " ");
        }
        System.out.println( " ");

    }

    public void treeMap() {
        TreeMap<Integer, Integer> a2 = new TreeMap<>();
        a2.put(100, 2);
        a2.put(20, 2);
        a2.put(5, 2);
        a2.put(9, 2);
        a2.put(3, 2);
        for (Map.Entry x : a2.entrySet()) {
            int key = (int) x.getKey();
            System.out.print(key + " ");
        }

    }

    public static void main(String args[]) {
        HashMapAndTreeMapPrinting hp = new HashMapAndTreeMapPrinting();
        hp.hashMap();
        hp.treeMap();
    }
}

