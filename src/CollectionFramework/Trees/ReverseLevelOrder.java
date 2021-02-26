package CollectionFramework.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://www.interviewbit.com/problems/reverse-level-order/
public class ReverseLevelOrder {
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
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(5);
        root = a;
        a.left = b;
        a.right = c;
        c.left = d;
        return root;
    }

    public ArrayList<Integer> solve(TreeNode root) {
        Queue<TreeNode> storeCurrent = new LinkedList<>();
        //ArrayList<Integer> storeReverseOrder = new ArrayList<>();
        Stack<Integer> storeReverseOrder = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        storeCurrent.add(root);
        while (!storeCurrent.isEmpty()) {
            TreeNode temp = storeCurrent.peek();
            storeReverseOrder.push(temp.val);
            storeCurrent.remove();
            if (temp.right != null) {
                storeCurrent.add(temp.right);
            }
            if (temp.left != null) {
                storeCurrent.add(temp.left);
            }

        }
        System.out.println(storeReverseOrder);
        while (!storeReverseOrder.isEmpty()) {
            int temp = storeReverseOrder.peek();
            result.add(temp);
            storeReverseOrder.pop();

        }
        return result;
    }


    public static void main(String args[]) {
        ReverseLevelOrder rt = new ReverseLevelOrder();
        root = rt.createTree();
        System.out.println(rt.solve(root));

    }
}
