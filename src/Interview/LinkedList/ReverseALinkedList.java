package Interview.LinkedList;

public class ReverseALinkedList {
    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    public Node createList() {
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        head = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        return head;

    }

    public Node reverseLL(Node head) {

        Node prev = null;
        Node next;
        Node current = head;
        while (current != null ) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        head = prev;
        return head;
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }
    public static void main(String args[]) {
        ReverseALinkedList rl = new ReverseALinkedList();
        head = rl.createList();
        //rl.printList(head);
        //System.out.println(" ");
        //System.out.println("After: ");
        Node result = rl.reverseLL(head);
        rl.printList(result);

    }
}
