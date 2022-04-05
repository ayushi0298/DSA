package CollectionFramework_InterviewBit.Graphs;

import CollectionFramework_InterviewBit.Test;
import com.sun.source.tree.Tree;

//https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {


    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode root;

    public TreeNode createTree() {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);

        root = a;
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        return root;
    }

    public boolean checkSymmetry(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if ((node1 != null && node2 != null) && node1.val == node2.val) {
            return (checkSymmetry(node1.left, node2.right) && (checkSymmetry(node1.right, node2.left)));
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        return checkSymmetry(root, root);

    }

    public static void main(String args[]) {
        SymmetricTree st = new SymmetricTree();
        root = st.createTree();
        System.out.println(st.isSymmetric(root));
    }

}
