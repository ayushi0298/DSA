package CollectionFramework.Trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://www.interviewbit.com/problems/2sum-binary-tree/
public class TwoSumBinaryTree {


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

        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        root = a;
        root.left = b;
        root.right = c;
        return root;

    }

    public int t2Sum(TreeNode A, int B) {
        Queue<TreeNode> storeCurrent = new LinkedList<>();
        Set<Integer> storeSumPossible = new HashSet<>();
        storeCurrent.add(A);
        while (!storeCurrent.isEmpty()) {
            TreeNode temp = storeCurrent.poll();
            if (storeSumPossible.contains(B - temp.val)) {
                return 1;
            } else {
                storeSumPossible.add(temp.val);
            }
            if (temp.left != null) {
                storeCurrent.add(temp.left);
            }
            if (temp.right != null) {
                storeCurrent.add(temp.right);
            }

        }
        return 0;
    }

    public static void main(String args[]) {
        TwoSumBinaryTree ts = new TwoSumBinaryTree();
        root = ts.createTree();
        int B = 19;
        System.out.println(ts.t2Sum(root, B));


    }
}
