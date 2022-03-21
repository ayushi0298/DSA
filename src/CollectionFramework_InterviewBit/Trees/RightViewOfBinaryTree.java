package CollectionFramework_InterviewBit.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://www.interviewbit.com/problems/right-view-of-binary-tree/

public class RightViewOfBinaryTree {

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
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        root = a;
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        return root;
    }


    // public ArrayList<Integer> printLevelOrder(TreeNode root)
    public ArrayList<Integer> solve(TreeNode root) {
        Queue<TreeNode> storeValues = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        storeValues.add(root);
        while (!storeValues.isEmpty()) {
            int size = storeValues.size();
            for (int i = 1; i <= size; i++) {
                TreeNode temp = storeValues.poll();
                if (i == size) {
                    result.add(temp.val);
                }
                if (temp.left != null) {
                    storeValues.add(temp.left);
                }
                if (temp.right != null) {
                    storeValues.add(temp.right);
                }
            }

        }
        return result;

    }

    public static void main(String args[]) {
        RightViewOfBinaryTree rt = new RightViewOfBinaryTree();
        root = rt.createTree();
        System.out.println(rt.solve(root));
    }


}
