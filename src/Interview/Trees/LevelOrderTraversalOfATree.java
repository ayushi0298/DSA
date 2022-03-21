package Interview.Trees;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/level-order-tree-traversal/
public class LevelOrderTraversalOfATree {
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
        b.left = d;
        b.right = e;
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

    //using Pair class it was written by me
    public void printLevelOrder(TreeNode root) {

        Queue<Pair> storeValues = new LinkedList<>();
        storeValues.add(new Pair(root, 1));
        while (!storeValues.isEmpty()) {
            Pair temp = storeValues.peek();
            storeValues.remove();
            System.out.println(temp.node.val + " " + temp.level);
            if (temp.node.left != null) {
                storeValues.add(new Pair(temp.node.left, temp.level + 1));
            }
            if (temp.node.right != null) {
                storeValues.add(new Pair(temp.node.right, temp.level + 1));
            }

        }

    }

    public static void main(String args[]) {

        LevelOrderTraversalOfATree lo = new LevelOrderTraversalOfATree();
        root = lo.createTree();
        lo.printLevelOrder(root);
        //lo.printLevelOrder(root);

    }

}

