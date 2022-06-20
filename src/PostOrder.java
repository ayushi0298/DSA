/*
import Interview.Trees.Leaves;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PostOrder {

          1
                  2 3

  TC: O(n)
    public void postOrder(TreeNode A) {


        if (root == null) {

            return;
        }
        postOrder(root.left);
        postOrder(root.right);

        System.out.println(root.value + " ->");
    }
   TC: O(n)
    public void preOrder(TreeNode A) {

        if (root == null) {

            return;
        }
        System.out.println(root.value + " ->");
        preOrder(root.left);
        preOrder(root.right);

    }
  TC: O(n)
    public void preOrderIterative(TreeNode A) {
        if (A == null) {
            return;

        }
        Stack<TreeNode> storeNodes = new Stack<TreeNode>();
        storeNodes.push(A);
        while (!storeNodes.isEmpty()) {
            TreeNode node = storeNodes.peek();
            System.out.println(node.value + " ");
            storeNodes.pop();
            if (node.right != null) {
                storeNodes.push(node.right);
            }
            if (node.left != null) {
                storeNodes.push(node.left);
            }
        }

    }
   TC: O(n)
        SC: O(1)
    public void inOrder(TreeNode A) {

        if (root == null) {

            return;
        }
        inOrder(root.left);
        System.out.println(root.value + " ->");
        inOrder(root.right);

    }
  O(n): TC
    SC: O(n)

    public void levelOrder(TreeNode A) {
        if (A == null) {
            return;
        }
        Queue<TreeNode> storeNodes = new LinkedList<Leaves.TreeNode>();
        storeNodes.add(A);
        while (!storeNodes.isEmpty()) {
            TreeNode temp = storeNodes.poll();
            System.out.println(temp.value" ");
            if (temp.left != null) {
                storeNodes.add(temp.left);
            }
            if (temp.right != null) {
                storeNodes.add(temp.right);
            }

        }


    }

}
}

*/
