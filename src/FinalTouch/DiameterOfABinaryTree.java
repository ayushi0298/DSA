package FinalTouch;
//https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
public class DiameterOfABinaryTree {
    static TreeNode root;
    static int maxDiameter;

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

    public int findDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubtreeDepth = findDiameter(root.left);
        int rightSubtreeDepth = findDiameter(root.right);
        //System.out.println("Node: " + root.val + " leftSubtree: " + leftSubtreeDepth + " rightSubTree: " + rightSubtreeDepth);
        maxDiameter = Math.max(maxDiameter, leftSubtreeDepth + rightSubtreeDepth);
        return Math.max(leftSubtreeDepth, rightSubtreeDepth) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        findDiameter(root);
        return maxDiameter;
    }

    public static void main(String args[]) {
        DiameterOfABinaryTree db = new DiameterOfABinaryTree();
        root = db.createTree();
        System.out.println(db.diameterOfBinaryTree(root));
        System.out.println(maxDiameter);

    }
}

