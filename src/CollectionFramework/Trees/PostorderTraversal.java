package CollectionFramework.Trees;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {
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

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> storeNodes = new Stack<>();
        while (A != null || !storeNodes.isEmpty()) {
            if (A != null) {
                storeNodes.add(A);
                A = A.left;
            } else {
                TreeNode temp = storeNodes.peek().right;
                if (temp == null) {
                    temp = storeNodes.pop();
                    result.add(temp.val);
                    while (!storeNodes.isEmpty() && temp == storeNodes.peek().right) {
                        temp = storeNodes.pop();
                        result.add(temp.val);
                    }
                } else {
                    A = temp;
                }
            }
        }
        return result;
    }


    public static void main(String args[]) {
        PostorderTraversal po = new PostorderTraversal();
        root = po.createTree();
        System.out.println(po.postorderTraversal(root));


    }

}
