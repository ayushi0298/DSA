package FinalTouch;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreeToLinkedList {
    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode root;

    TreeNode createTree() {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        root = a;
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        return root;

    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;

            TreeNode current = root.right;
            while (current.right != null) {
                current = current.right;
            }
            current.right = temp;
        }
        flatten(root.right);
    }

    public static void main(String args[]) {
        FlattenBinaryTreeToLinkedList fb = new FlattenBinaryTreeToLinkedList();
        root = fb.createTree();
        fb.flatten(root);

    }

}
