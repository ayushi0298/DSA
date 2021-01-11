package Interview.Trees;

import java.util.Stack;
//https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
public class LevelOrderTraversalInSpriralForm {
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
        TreeNode g = new TreeNode(7);
        root = a;
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        return root;
    }

    public void spiralForm(TreeNode root) {
        if(root==null){
            return ;
        }
        Stack<TreeNode> alternate1= new Stack<>();
        Stack<TreeNode> alternate2 = new Stack<>();

        alternate1.push(root);
        while (!alternate1.empty() || !alternate2.empty()){
            while (!alternate1.empty()){
                TreeNode temp = alternate1.peek();
                alternate1.pop();
                System.out.print(temp.val + " ");
                if(temp.right!=null){
                    alternate2.push(temp.right);
                }
                if(temp.left!=null){
                    alternate2.push(temp.left);
                }
            }
            while (!alternate2.empty()){
                TreeNode temp = alternate2.peek();
                alternate2.pop();
                System.out.print(temp.val + " ");
                if(temp.left!=null){
                    alternate1.push(temp.left);
                }
                if(temp.right!=null) {
                    alternate1.push(temp.right);
                }
            }
        }

    }

    public static void main(String args[]) {
        LevelOrderTraversalInSpriralForm lt = new LevelOrderTraversalInSpriralForm();
        root = lt.createTree();
        lt.spiralForm(root);

    }
}
