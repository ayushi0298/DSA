package CollectionFramework_InterviewBit.Trees;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/print-cousins-of-a-given-node-in-binary-tree-single-traversal/
public class Check2NodesAreCousins {
    static TreeNode root;

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode createTree() {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);

        root = a;
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        return root;

    }

    public class Pair {
        TreeNode data;
        TreeNode parent;

        Pair(TreeNode data, TreeNode parent) {
            this.data = data;
            this.parent = parent;
        }

    }

    public boolean check2Nodes(TreeNode root, int A, int B) {
        Queue<Pair> storeParent = new LinkedList<>();
        TreeNode storeParentA = null;
        TreeNode storeParentB = null;
        Pair current = null;
        int size = 0;
        int bothFound = 0;
        storeParent.add(new Pair(root, root));
        while (!storeParent.isEmpty()) {
            size = storeParent.size();
            while (size > 0) {
                current = storeParent.peek();
                storeParent.remove();
                if (current.data.left != null) {
                    storeParent.add(new Pair(current.data.left, current.data));
                }
                if (current.data.right != null) {
                    storeParent.add(new Pair(current.data.right, current.data));
                }
                if (current.data != null && current.data.val == A) {
                    //System.out.println(current.parent.val);
                    storeParentA = current.parent;
                }
                if (current.data != null && current.data.val == B) {
                    storeParentB = current.parent;
                }
                size--;
            }
        }
        if (current.data.val == A && current.data.val == B) {
            bothFound = 1;
        }
        //System.out.println(storeParentA.val + " " + storeParentB.val);
        if (bothFound == 1) {
            if (storeParentA != storeParentB) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Check2NodesAreCousins ct = new Check2NodesAreCousins();
        root = ct.createTree();
        int A = 3, B = 6;
        System.out.println(ct.check2Nodes(root, A, B));


    }
}
