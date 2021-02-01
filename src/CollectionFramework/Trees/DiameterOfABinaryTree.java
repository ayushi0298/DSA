package CollectionFramework.Trees;

//https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
public class DiameterOfABinaryTree {
    static TreeNode root;
    static int maxDiameter = 0;

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

    public int findDiameter(TreeNode root, int distance) {
        int leftPath, rightPath;
        if (root == null) {
            return 0;
        }

        leftPath = findDiameter(root.left, distance + 1);
        rightPath = findDiameter(root.right, distance + 1);

        distance = leftPath + rightPath + 1;

        if (distance > maxDiameter) {
            maxDiameter = distance;
        }
        return maxDiameter;

    }

    public int findDiameter(TreeNode root) {
        int leftPath, rightPath;
        if (root == null) {
            return 0;
        }
        leftPath = findDiameter(root.left);
        rightPath = findDiameter(root.right);

        int curDiameter = leftPath + rightPath + 1;
        if (curDiameter > maxDiameter) {
            maxDiameter = curDiameter;
        }
        return Math.max(leftPath, rightPath) + 1;
    }

    public static void main(String args[]) {
        DiameterOfABinaryTree db = new DiameterOfABinaryTree();
        root = db.createTree();
//      System.out.println(db.findDiameter(root, 0));
        System.out.println(db.findDiameter(root));
        //db.findDiameter(root);
        System.out.println(maxDiameter);

    }
}

