package CollectionFramework_InterviewBit.LinkedLists;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
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
        ListNode c = new ListNode(9);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(8);
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.data < list2.data) {
            list1.next = mergeTwoLists(list1.next, list2);
            System.out.println(list1.next.data);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            System.out.println(list2.next.data);
            return list2;
        }
    }

    public static void main(String args[]) {
        MergeTwoSortedLists mt = new MergeTwoSortedLists();
        head1 = mt.createList1();
        head2 = mt.createList2();
        ListNode result = mt.mergeTwoLists(head1, head2);
        mt.printList(result);

    }
}
