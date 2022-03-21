package CollectionFramework_InterviewBit.Trees;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/problems/path-to-given-node/
public class PathToGivenNode {

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode root;

    public TreeNode createTree1() {

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

    public boolean findPath(TreeNode root, int B, ArrayList<Integer> path) {
        if (root == null) {
            return false;
        }
        if (root.val == B) {
            path.add(root.val);
            return true;
        }
        boolean leftFound = findPath(root.left, B, path);
        boolean rightFound = findPath(root.right, B, path);
        if (leftFound == true || rightFound == true) {
            path.add(root.val);
            return true;
        }
        return false;
    }

    public ArrayList<Integer> solve(TreeNode root, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        findPath(root, B, result);
        Collections.reverse(result);
        return result;
    }

    public static void main(String args[]) {
        PathToGivenNode pg = new PathToGivenNode();
        root = pg.createTree1();
        int B = 5;
        System.out.println(pg.solve(root, B));

    }
}
