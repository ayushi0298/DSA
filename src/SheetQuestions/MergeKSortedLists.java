package SheetQuestions;

import java.util.*;

public class MergeKSortedLists {
    static ListNode head1;
    static ListNode head2;

    static class ListNode {

        int data;
        ListNode next;
        ListNode(int d) {
            data = d;
        }
    }

    public ListNode createList1() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        head1 = a;
        a.next = b;
        b.next = c;
        c.next = null;
        return head1;

    }

    public ListNode createList2() {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(6);
        ListNode c = new ListNode(7);
        ListNode d = new ListNode(8);
        ListNode e = new ListNode(9);
        head2 = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        return head2;

    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.printf("%d ", node.data);
            node = node.next;
        }
    }

    public ListNode convert(ListNode[] a) {

        PriorityQueue<ListNode> pq;
        pq = new PriorityQueue<>(Comparator.comparingInt(x -> ((ListNode) x).data));
        pq.addAll(Arrays.asList(a).subList(0, a.length));
        ListNode head = null, last = null;
        while (!pq.isEmpty()) {
            ListNode min = pq
                    .poll();
            if (head == null) {
                head = last = min;

            } else {
                last.next = min;
                last = min;
            }
            if (min.next != null) {
                pq.add(min.next);
            }
        }

        return head;
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode[] y = new ListNode[a.size()];
        for (int i = 0; i < a.size(); i++) {
            y[i] = a.get(i);
        }
        ListNode result= convert(y);
        return result;

    }

    public static void main(String args[]) {
        MergeKSortedLists mt = new MergeKSortedLists();
        ArrayList<ListNode> input= new ArrayList<>();
        head1 = mt.createList1();
        head2 = mt.createList2();
        input.add(head1);
        input.add(head2);
        ListNode result = mt.mergeKLists(input);
        mt.printList(result);

    }
}
