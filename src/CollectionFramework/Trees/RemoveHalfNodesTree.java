package CollectionFramework.Trees;

//https://www.interviewbit.com/problems/remove-half-nodes/
public class RemoveHalfNodesTree {
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

    public void printTree(TreeNode node) {
        if (node != null) {
            printTree(node.left);
            printTree(node.right);
            System.out.println(node.val);
        }
    }

    public TreeNode solve(TreeNode A) {
       if(A== null){
           return null;
       }
        A.left = solve(A.left);
        A.right = solve(A.right);

        if (A.left == null && A.right == null) {
            return A;
        }
        if (A.left == null) {
            TreeNode newRoot = A.right;
            return newRoot;
        }
        if (A.right == null) {
            TreeNode newRoot = A.left;
            return newRoot;
        }
        return A;

    }
    public static void main(String args[]) {
        RemoveHalfNodesTree rf = new RemoveHalfNodesTree();
        root = rf.createTree();
        //rf.printTree(root);
        TreeNode result= rf.solve(root);
        rf.printTree(result);
        //rf.printTree(root);

    }
}
