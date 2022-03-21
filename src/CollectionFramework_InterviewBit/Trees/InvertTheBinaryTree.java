package CollectionFramework_InterviewBit.Trees;
//https://www.interviewbit.com/problems/invert-the-binary-tree/
public class InvertTheBinaryTree {
    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode root;
    public TreeNode createTree() {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        root = a;
        root.right = b;
        b.left=c;
        return root;

    }
    public TreeNode invertTree(TreeNode A){
        if(A==null){
            return A;
        }
        TreeNode left= invertTree(A.left);
        TreeNode right= invertTree(A.right);

        A.left=right;
        A.right=left;
        return A;

    }

    public static void main(String args[]){
        InvertTheBinaryTree it= new InvertTheBinaryTree();
        root= it.createTree();
        it.invertTree(root);
    }

}
