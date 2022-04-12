package FinalTouch;

import java.util.ArrayList;
import java.util.HashMap;

// Done in 15 mins because solved it before
public class DiagonalTraversalTrees {
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

    public void diagonalDistance(TreeNode root, int distance, HashMap<Integer, ArrayList<Integer>> storeDistance) {
        ArrayList<Integer> current = storeDistance.get(distance);
        if (current == null) {
            current = new ArrayList<>();
            current.add(root.val);
        } else {
            current.add(root.val);
        }
        storeDistance.put(distance, current);
        if (root.left != null) {
            diagonalDistance(root.left, distance + 1, storeDistance);
        }
        if (root.right != null) {
            diagonalDistance(root.right, distance, storeDistance);
        }
    }

    public ArrayList<Integer> diagonalTraversal(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> storeDistance = new HashMap<>();
        diagonalDistance(root, 0, storeDistance);
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> x : storeDistance.values()) {
            for (int i = 0; i < x.size(); i++) {
                result.add(x.get(i));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        DiagonalTraversalTrees dt = new DiagonalTraversalTrees();
        root = dt.createTree();
        System.out.println(dt.diagonalTraversal(root));


    }
}
