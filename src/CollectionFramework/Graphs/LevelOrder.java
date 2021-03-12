package CollectionFramework.Graphs;

import Interview.Trees.MaximumWidthOfABinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
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

        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(10);
        root = a;
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        b.left = f;

        return root;
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> levelList = new LinkedList<>();
        levelList.add(A);
        while (!levelList.isEmpty()) {
            int size = levelList.size();
            ArrayList<Integer> current = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode temp = levelList.remove();
                current.add(temp.val);
                if (temp.left != null) {
                    levelList.add(temp.left);
                }
                if (temp.right != null) {
                    levelList.add(temp.right);
                }

            }
            result.add(current);
        }

        return result;
    }

    public static void main(String args[]) {
        LevelOrder lo = new LevelOrder();
        root = lo.createTree();
        System.out.println(lo.levelOrder(root));

    }

}
