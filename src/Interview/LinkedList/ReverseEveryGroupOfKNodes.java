package Interview.LinkedList;

;

//https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
public class ReverseEveryGroupOfKNodes {
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
        Node b = new Node(4);
        Node c = new Node(5);
        Node d = new Node(6);
        head = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        return head;
    }

    public Node reverseLL(Node head, int k) {
        int count = 0;
        Node prev = null;
        Node next = null;
        Node current = head;
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null)
            head.next = reverseLL(current, k);
        return prev;
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String args[]) {
        ReverseEveryGroupOfKNodes rk = new ReverseEveryGroupOfKNodes();
        int k = 2;
        head = rk.createList();
        //rl.printList(head);
        //System.out.println(" ");
        //System.out.println("After: ");
        Node result = rk.reverseLL(head, k);
        rk.printList(result);

    }

}
