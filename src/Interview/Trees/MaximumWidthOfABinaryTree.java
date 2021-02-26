package Interview.Trees;

import CollectionFramework.Trees.ReverseLevelOrder;
//https://www.geeksforgeeks.org/microsoft-interview-experience-set-138-off-campus/
//https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfABinaryTree {
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
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(10);
        root = a;
        a.left = b;
        a.right = c;
        b.left = d;
        b.right=e;
        c.left=f;
        return root;
    }

    public int findMaximum(TreeNode root) {
        int maxWidth = 0;
        Queue<TreeNode> storeCurrentLevelNode = new LinkedList<>();
        storeCurrentLevelNode.add(root);
        while (!storeCurrentLevelNode.isEmpty()) {
            int sizeCurrent = storeCurrentLevelNode.size();
            maxWidth = Math.max(maxWidth, sizeCurrent);
            while (sizeCurrent > 0) {
                TreeNode temp = storeCurrentLevelNode.peek();
                storeCurrentLevelNode.remove();
                if (temp.left != null) {
                    storeCurrentLevelNode.add(temp.left);
                }
                if (temp.right != null) {
                    storeCurrentLevelNode.add(temp.right);
                }
                sizeCurrent--;
            }

        }
        return maxWidth;

    }


    public static void main(String args[]) {
        MaximumWidthOfABinaryTree mt = new MaximumWidthOfABinaryTree();
        root = mt.createTree();
        System.out.println(mt.findMaximum(root));

    }
}
