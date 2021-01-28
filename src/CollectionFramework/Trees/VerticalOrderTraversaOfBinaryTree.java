package CollectionFramework.Trees;

import java.util.*;
//https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/
public class VerticalOrderTraversaOfBinaryTree {
    static TreeNode root;
    TreeMap<Integer, ArrayList<Integer>> distanceAndNodes = new TreeMap<>();
    Queue<Pair> levelOrder = new LinkedList<>();

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode createTree() {

        TreeNode a = new TreeNode(6);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(9);
        root = a;
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        return root;
    }

    public class Pair {
        TreeNode node;
        int d;

        Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }

    }

    //preorder
    public void verticalTraversing(TreeNode root, int d) {
        ArrayList<Integer> current = distanceAndNodes.get(d) == null ? new ArrayList<>() : distanceAndNodes.get(d);
        current.add(root.val);
        distanceAndNodes.put(d, current);
        if (root.left != null) {
            verticalTraversing(root.left, d - 1);
        }
        if (root.right != null) {
            verticalTraversing(root.right, d + 1);
        }
    }


    //but actually we have to use level order
    public void printLevelUsingOneQueue(TreeNode root) {
        int d;
        Queue<Pair> q1 = new LinkedList<>();
        if (root != null) {
            q1.add(new Pair(root, 0));
        }
        while (true) {
            int nodeCount = q1.size();
            while (nodeCount > 0) {
                Pair currentNode = q1.peek();
                //System.out.print(temp.val + " ");
                q1.remove();
                d = currentNode.d;
                ArrayList<Integer> current = distanceAndNodes.get(d) == null ? new ArrayList<>() : distanceAndNodes.get(d);
                current.add(currentNode.node.val);
                distanceAndNodes.put(d, current);
                if (currentNode.node.left != null) {
                    q1.add(new Pair(currentNode.node.left, d - 1));
                }
                if (currentNode.node.right != null) {
                    q1.add(new Pair(currentNode.node.right, d + 1));
                }
                nodeCount--;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        printLevelUsingOneQueue(A);
        for (Map.Entry<Integer, ArrayList<Integer>> x : distanceAndNodes.entrySet()) {
            ArrayList<Integer> current = x.getValue();
            answer.add(current);
        }
        return answer;
    }
   /* public void printArrayList(TreeNode A){
        ArrayList<ArrayList<Integer>> answer =verticalOrderTraversal(A);
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < answer.get(i).size(); j++) {
                System.out.print(answer.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }*/

    public static void main(String args[]) {
        VerticalOrderTraversaOfBinaryTree vt = new VerticalOrderTraversaOfBinaryTree();
        root = vt.createTree();
       // vt.printArrayList(root);
        vt.verticalOrderTraversal(root);


    }


}
