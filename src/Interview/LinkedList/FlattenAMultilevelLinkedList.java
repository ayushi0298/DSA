package Interview.LinkedList;
//https://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/
public class FlattenAMultilevelLinkedList {
    Node head;

    static class Node {
        int data;
        Node next, child;

        public Node(int data, Node next, Node child) {
            this.data = data;
            this.child = child;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    ", child=" + child +
                    '}';
        }
    }

    public Node createList() {
        Node a = new Node(10, null, null);
        Node b = new Node(5, null, null);
        Node c = new Node(12, null, null);
        Node d = new Node(8, null, null);
        Node e = new Node(6, null, null);
        Node f = new Node(9, null, null);
        Node g = new Node(3, null, null);
        Node h = new Node(2, null, null);
        head = a;
        head.next = b;
        b.next = c;
        c.next = null;
        head.child = d;
        d.next = e;
        e.next = null;
        c.child = f;
        f.next = g;
        g.next = h;
        h.next = null;
        return head;

    }
    public Node flattenedLinkedList(Node head) {
        Node end = head, current=head;
        while (end.next != null) {
            end = end.next;
        }
        while (current!=end){
//            System.out.println(current.data + "head");
//            System.out.println(end.data + "end");
            if(current.child!=null){
                end.next = current.child;
                while(end.next!=null){
                    end = end.next;
//                    System.out.println(end.data + "end in loop");
                }

            }
            current = current.next;
        }
        return head;
    }
    public void printLinkedList(Node head){
        while(head!=null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String args[]) {
        FlattenAMultilevelLinkedList fd = new FlattenAMultilevelLinkedList();
        Node n = fd.createList();
        fd.flattenedLinkedList(n);


    }

}
