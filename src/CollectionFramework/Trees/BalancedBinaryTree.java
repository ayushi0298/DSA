package CollectionFramework.Trees;
//https://www.interviewbit.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode root;
    boolean flag;

    public TreeNode createTree() {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
       /* root = a;
        a.left = b;
        b.left = c;*/
        root = a;
        a.left = b;
        b.left = c;
        return root;
    }

    //using global variable
    public int isBalanced(TreeNode root) {
        //System.out.println(flag);
        findHeight(root);
        if (flag == true) {
            return 0;
        }
        return 1;
    }

    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        if (leftHeight - rightHeight > 1) {
            flag = true;
            return 0;
        }
        //return leftHeight + rightHeight+1;
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static void main(String args[]) {
        BalancedBinaryTree bt = new BalancedBinaryTree();
        root = bt.createTree();
        System.out.println(bt.isBalanced(root));
    }

}
