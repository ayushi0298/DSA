package CollectionFramework_LeetCode;

import java.util.ArrayList;
import java.util.List;

//https://www.lintcode.com/problem/650/

public class FindLeavesOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode root;
    List<List<Integer>> res = new ArrayList<>();

    public TreeNode createTree() {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        root = a;
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        return root;
    }

    public int returnLeaves(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int depth = Math.max(returnLeaves(root.left), returnLeaves(root.right)) + 1;
        if (depth >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        return depth;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        returnLeaves(root);
        return res;

    }

    public static void main(String args[]) {
        FindLeavesOfBinaryTree fl = new FindLeavesOfBinaryTree();
        root = fl.createTree();
        System.out.println(fl.findLeaves(root));
    }
}
