package CollectionFramework_InterviewBit.Trees;

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
