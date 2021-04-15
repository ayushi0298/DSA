package CollectionFramework.Trees;

import Interview.Trees.LevelOrderTraversalOfATree;

import java.util.LinkedList;
import java.util.Queue;
//https://www.interviewbit.com/problems/maximum-level-sum/
public class MaximumLevelSum {

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
        root = a;
        a.left = b;
        a.right = c;
        return root;
    }

    public class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

    }

    public int solve(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int result = A.val;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(A);
        while (!q1.isEmpty()) {
            int nodeCount = q1.size();
            int sum = 0;
            while (nodeCount > 0) {
                TreeNode temp = q1.poll();
                sum = sum + temp.val;
                if (temp.left != null) {
                    q1.add(temp.left);
                }
                if (temp.right != null) {
                    q1.add(temp.right);
                }

                nodeCount--;
            }
            result = Math.max(sum, result);
        }
        return result;
    }

    public static void main(String args[]) {
        MaximumLevelSum ml = new MaximumLevelSum();
        root = ml.createTree();
        System.out.println(ml.solve(root));
    }

}
