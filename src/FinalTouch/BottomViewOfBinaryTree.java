package FinalTouch;

import java.util.Map;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {
    TreeMap<Integer, pair> storeNodes = new TreeMap<>();

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class pair {
        int first, second;

        pair(int i, int j) {
            first = i;
            second = j;
        }
    }

    static TreeNode root;

    public TreeNode createTree() {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        /*TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(25);*/
        TreeNode h = new TreeNode(7);
        TreeNode i = new TreeNode(8);
        root = a;
        root.left = b;
        root.right = c;
        c.left = d;
        c.right = e;
        d.left = h;
        d.right = i;
        return root;

    }

    public void findBottomView(TreeNode root, int distance, int level) {
        if (root == null) {
            return;
        }
        if (!storeNodes.containsKey(distance)) {
            storeNodes.put(distance, new pair(root.val, level));
        } else {
            storeNodes.put(distance, new pair(root.val, level));
        }
        findBottomView(root.left, distance - 1, level + 1);
        findBottomView(root.right, distance + 1, level + 1);

    }

    public void bottomView(TreeNode root) {
        int sum=0;
        findBottomView(root, 0, 0);
        for (Map.Entry<Integer, pair> entry :
                storeNodes.entrySet()) {
            System.out.print(entry.getValue().first + " ");
            sum=sum+entry.getValue().first;

        }
        System.out.println("Sum: " + sum);
    }


    public static void main(String args[]) {
        BottomViewOfBinaryTree tb = new BottomViewOfBinaryTree();
        root = tb.createTree();
        tb.bottomView(root);

    }


}
