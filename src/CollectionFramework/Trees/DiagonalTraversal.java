package CollectionFramework.Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//https://www.interviewbit.com/problems/diagonal-traversal/
public class DiagonalTraversal {
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
        root = a;
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        return root;

    }

    public void diagonalDistance(TreeNode root, int distance, HashMap<Integer, ArrayList<Integer>> storesDiagonalNodes) {

        if (root == null) {
            return;
        }
        ArrayList<Integer> currentValuesAtD = storesDiagonalNodes.get(distance);
        if (currentValuesAtD == null) {
            currentValuesAtD = new ArrayList<>();
            currentValuesAtD.add(root.val);
        } else {
            currentValuesAtD.add(root.val);
        }
        storesDiagonalNodes.put(distance, currentValuesAtD);

        if (root.left != null) {
            diagonalDistance(root.left, distance + 1, storesDiagonalNodes);
        }
        if (root.right != null) {
            diagonalDistance(root.right, distance, storesDiagonalNodes);
        }
    }

    public ArrayList<Integer> solve(TreeNode A) {
        HashMap<Integer, ArrayList<Integer>> storesDiagonalNodes = new HashMap<>();
        diagonalDistance(root, 0, storesDiagonalNodes);
        ArrayList<Integer> result = new ArrayList<>();
        System.out.println(storesDiagonalNodes);
        for (ArrayList<Integer> x : storesDiagonalNodes.values()) {
            for (int i = 0; i < x.size(); i++) {
                result.add(x.get(i));
            }
        }
        return result;
    }

    public static void main(String args[]) {
        DiagonalTraversal dt = new DiagonalTraversal();
        root = dt.createTree();
        System.out.println(dt.solve(root));
    }

}
