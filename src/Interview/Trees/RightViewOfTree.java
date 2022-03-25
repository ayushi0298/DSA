package Interview.Trees;

import com.sun.source.tree.Tree;
//https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfTree {
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

    private ArrayList<Integer> rightView(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        queue.add(node);
        result.add(node.val);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current.right != null) {
                result.add(current.right.val);
                queue.add(current.right);
            }
        }
        return result;
    }

    public static void main(String ars[]) {
        RightViewOfTree rt = new RightViewOfTree();
        root = rt.createTree();
        System.out.println(rt.rightView(root));
    }
}