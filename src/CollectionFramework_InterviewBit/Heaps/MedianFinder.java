package CollectionFramework_InterviewBit.Heaps;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> smaller, greater;

    public MedianFinder() {
        // max heap to store the smaller half elements
        smaller = new PriorityQueue<>
                ((a, b) -> b - a);

        // min-heap to store the greater half elements
        greater = new PriorityQueue<>();
    }

    public void addNum(int num) {
        smaller.add(num);
        greater.add(smaller.poll());
        if (greater.size() > smaller.size())
            smaller.add(greater.poll());

        System.out.println("Smaller : " + smaller);
        System.out.println("Greater : " + greater);

    }

    public double findMedian() {
        if (smaller.size() > greater.size())
            return smaller.peek();
        return (double) (smaller.peek() + greater.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());

    }
}