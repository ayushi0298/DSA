package CollectionFramework_InterviewBit.Heaps;

import java.util.ArrayList;
import java.util.Collections;

public class  HeapImplementation {

    ArrayList<Integer> input = new ArrayList<>();

    public static void swap(int first, int second) {
        int temp = first;
        first = second;
        second = temp;
    }   

    public static void sort(ArrayList<Integer> input) {
        int n = input.size();
        for (int i = n / 2; i >= 0; i--) {
            heapifyTopDown(input, i);

        }
    }

    public static void heapifyTopDown(ArrayList<Integer> input, int i) {
        int n = input.size();
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && input.get(left) > input.get(largest)) {
            largest = left;

        }

        if (right < n && input.get(right) > input.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            System.out.println("Before: " + input.toString());
            Collections.swap(input, i, largest);
            System.out.println("After: " + input.toString());
            heapifyTopDown(input, largest);

        }
    }

    public static void heapifyBottomUp(ArrayList<Integer> input, int n) {
        int parent = (n - 1) / 2;
        if (input.get(parent) > 0) {
            if (input.get(n) > input.get(parent)) {
                Collections.swap(input, n, parent);
                heapifyBottomUp(input, parent);
            }
        }
    }

    public static void insertNode(ArrayList<Integer> input, int insertElement) {
        input.add(insertElement);
        heapifyBottomUp(input, input.size() - 1);
        System.out.println("Added successfully: " + insertElement);
    }

    public static void deleteNode(ArrayList<Integer> input) {
        int lastIndex = input.size() - 1;
        int lastElement = input.get(lastIndex);
        int deleteElement = input.get(0);
        input.set(0, lastElement);
        input.remove(lastIndex);
        heapifyTopDown(input, 0);
        System.out.println("Deleted successfully: " + deleteElement);
    }

    public static void retriveNode(ArrayList<Integer> input) {
        int returnElement = input.get(0);
        System.out.println("Element found: " + returnElement);
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(25);
        input.add(26);
        input.add(7);
        sort(input);
        System.out.println(input.toString());
        insertNode(input, 40);
        System.out.println(input.toString());
        deleteNode(input);
        System.out.println(input.toString());
        retriveNode(input);
        System.out.println(input.toString());


    }

}
