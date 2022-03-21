package CollectionFramework_InterviewBit.Trees;

import java.util.ArrayList;
import java.util.Stack;
//https://www.interviewbit.com/problems/preorder-traversal/
public class PreOrderTraversal {
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
        TreeNode c = new TreeNode(20);
        root = a;
        root.left = b;
        root.right = c;
        return root;

    }

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode current = A;
        Stack<TreeNode> storeNodes = new Stack<>();
        storeNodes.push(A);
        while (storeNodes.size() > 0) {
            TreeNode temp = storeNodes.pop();
            result.add(temp.val);

            if (temp.right != null) {
                storeNodes.push(temp.right);
            }
            if (temp.left != null) {
                storeNodes.push(temp.left);
            }

        }

        return result;
    }

    public static void main(String args[]) {
        PreOrderTraversal po = new PreOrderTraversal();
        root = po.createTree();
        System.out.println(po.preorderTraversal(root));


    }

}
