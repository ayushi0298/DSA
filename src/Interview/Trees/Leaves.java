package Interview.Trees;


//https://www.geeksforgeeks.org/print-leaf-nodes-left-right-binary-tree/
public class Leaves {
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

    private void dfs(TreeNode node) {
        if (root == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.println(node.val);
        }
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
    }

    public static void main(String ars[]) {
        Leaves l = new Leaves();
        root = l.createTree();
        l.dfs(root);
    }
}
