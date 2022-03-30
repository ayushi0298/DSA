/*
package CollectionFramework_InterviewBit.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ZigZagLevelOrderTraversalBT {
    Map<Integer,ArrayList<Integer>> map = new HashMap<>();
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode root;
    int count = 0;

    public TreeNode createTree() {

        TreeNode a = new TreeNode(13);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        root = a;
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        return root;

    }
    public int height(TreeNode A) {
        if (A == null) return 0;
        return 1 + Math.max(height(A.left), height(A.right));
    }
    public ArrayList<ArrayList> zigzagLevelOrder(TreeNode A) {



    }

    public static void main(String args[]) {
    ZigZagLevelOrderTraversalBT z= new ZigZagLevelOrderTraversalBT();
    root= z.createTree();
    z.zigzagLevelOrder(root);
    }
}
*/
