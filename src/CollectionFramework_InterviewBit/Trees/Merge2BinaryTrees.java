package CollectionFramework_InterviewBit.Trees;

//https://www.interviewbit.com/problems/merge-two-binary-tree/
public class Merge2BinaryTrees {
    static TreeNode root1;
    static TreeNode root2;


    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode createTree1() {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        root1 = a;
        root1.left = b;
        root1.right = c;
        return root1;

    }

    public TreeNode createTree12() {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(4);
        root2 = a;
        root2.left = b;
        return root2;

    }

    // public TreeNode mergeTrees(TreeNode A, TreeNode B)
    public TreeNode solve(TreeNode A, TreeNode B) {
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }
        A.val = A.val + B.val;
        A.left = solve(A.left, B.left);
        A.right = solve(A.right, B.right);
        return A;

    }

    public void printTree(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            printTree(node.left);
            printTree(node.right);
        }

    }


    public static void main(String args[]) {
        Merge2BinaryTrees mb = new Merge2BinaryTrees();
        root1 = mb.createTree1();
        root2 = mb.createTree12();
        TreeNode x = mb.solve(root1, root2);
        mb.printTree(x);

    }
}
