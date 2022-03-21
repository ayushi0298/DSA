package CollectionFramework_InterviewBit.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://www.geeksforgeeks.org/print-cousins-of-a-given-node-in-binary-tree-single-traversal/
public class CousinsInABinaryTreeUsingSingleTraversal {
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
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);

        root = a;
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        c.left = g;
        d.left = h;
        f.right = i;
        return root;

    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> storesNodes = new LinkedList<>();
        boolean found = false;
        TreeNode current;
        int size = 0;
        storesNodes.add(A);
        if (A.val == B) {
            return result;
        }
        while (!storesNodes.isEmpty() && found == false) {
            size = storesNodes.size();
            while (size > 0) {
                current = storesNodes.peek();
                storesNodes.remove();
                if ((current.left != null && current.left.val == B) || (current.right != null && current.right.val == B)) {
                    found = true;
                } else {
                    if (current.left != null) {
                        storesNodes.add(current.left);
                    }
                    if (current.right != null) {
                        storesNodes.add(current.right);
                    }
                }
                size--;
            }
        }
        //System.out.println(found);

        if (found == true) {
            size = storesNodes.size();
            if (size == 0) {
                return result;
            }
            for (int i = 0; i < size; i++) {
                current = storesNodes.peek();
                storesNodes.remove();
                result.add(current.val);
            }
        }
        //System.out.println(result);
        return result;

    }


    public static void main(String args[]) {
        CousinsInABinaryTreeUsingSingleTraversal cs = new CousinsInABinaryTreeUsingSingleTraversal();
        root = cs.createTree();
        int B = 8;
        System.out.println(cs.solve(root, B));

    }
}
