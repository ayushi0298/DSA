package CollectionFramework_InterviewBit.Trees;

import java.util.HashMap;

public class LeavesOfBTAndNewLeaves {
    HashMap<TreeNode, Integer> storesNodes = new HashMap<>();

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

    public void findleaves(TreeNode root) {
        if (root == null) {
            return;
        }
        if (storesNodes.containsKey(root.left) && storesNodes.containsKey(root.right)) {
            int k1 = storesNodes.get(root.left);
            int k2 = storesNodes.get(root.right);
            if (k1 == 0 && k2 == 0) {
                storesNodes.put(root, 0);
                System.out.println(root.val);
            }

        }
        if (root.left == null && root.right == null) {
            storesNodes.put(root, 1);
            System.out.println(root.val);
        }
        if (root.left != null) {
            findleaves(root.left);
        }
        if (root.right != null) {
            findleaves(root.right);
        }
    }

    public static void main(String args[]) {
        LeavesOfBTAndNewLeaves lv = new LeavesOfBTAndNewLeaves();
        root = lv.createTree();
        lv.findleaves(root);

    }

}
