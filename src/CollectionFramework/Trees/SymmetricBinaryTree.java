package CollectionFramework.Trees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

//https://www.interviewbit.com/problems/symmetric-binary-tree/
public class SymmetricBinaryTree {
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
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        root = a;
        root.left = b;
        root.right = c;
        return root;

    }

    public boolean checkSymmetry(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null && node1.val == node2.val) {
            return (checkSymmetry(node1.left, node2.right) && checkSymmetry(node1.right, node2.left));
        }
        return false;

    }

    public int isSymmetric(TreeNode A) {
        return checkSymmetry(A, A) ? 1 : 0;

    }

    public static void main(String args[]) {
        SymmetricBinaryTree sb = new SymmetricBinaryTree();
        root = sb.createTree();
        System.out.println(sb.isSymmetric(root));
    }
}
