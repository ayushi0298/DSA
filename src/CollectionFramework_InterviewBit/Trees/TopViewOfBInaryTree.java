package CollectionFramework_InterviewBit.Trees;

import java.util.Map;
import java.util.TreeMap;

public class TopViewOfBInaryTree {
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
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        root = a;
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        return root;

    }

    public void findTopView(TreeNode root, int distance, int level) {
        if (root == null) {
            return;
        }
        if (!storeNodes.containsKey(distance)) {
            storeNodes.put(distance, new pair(root.val, level));
        }
        findTopView(root.left, distance - 1, level + 1);
        findTopView(root.right, distance + 1, level + 1);

    }

    public void topView(TreeNode root) {
        findTopView(root, 0, 0);
        for (Map.Entry<Integer, pair> entry :
                storeNodes.entrySet()) {
            System.out.print(entry.getValue().first + " ");
        }
    }


    public static void main(String args[]) {
        TopViewOfBInaryTree tb = new TopViewOfBInaryTree();
        root = tb.createTree();
        tb.topView(root);

    }

}
