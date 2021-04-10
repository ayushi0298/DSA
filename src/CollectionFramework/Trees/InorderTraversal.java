package CollectionFramework.Trees;

import java.util.ArrayList;
import java.util.Stack;
//https://www.interviewbit.com/problems/inorder-traversal/
public class InorderTraversal {
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
        root.right = b;
        b.left=c;
        return root;

    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode current = A;
        Stack<TreeNode> storeNodes = new Stack<>();
        while (current != null || storeNodes.size() > 0) {
            while (current != null) {
                storeNodes.push(current);
                current = current.left;
            }
            current = storeNodes.pop();
            result.add(current.val);
            current = current.right;

        }

        return result;
    }

    public static void main(String args[]) {
        InorderTraversal it = new InorderTraversal();
        root = it.createTree();
        System.out.println(it.inorderTraversal(root));


    }
}
