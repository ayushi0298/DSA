package CollectionFramework_LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-duplicate-subtrees/
public class DuplicateSubtrees {


    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode root;

    Map<String, TreeNode> map;

    public TreeNode createTree() {

        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);

        root = a;
        root.left = b;
        root.right = c;
        return root;

    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();

        helper(root);

        for (TreeNode node : map.values()) {
            if (node != null) {
                ans.add(node);
            }
        }

        return ans;
    }

    private String helper(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String path = root.val + "|" + helper(root.left) + "|" + helper(root.right);
        map.put(path, map.containsKey(path) ? root : null);

        return path;

    }

    public static void main(String args[]) {
        DuplicateSubtrees ds = new DuplicateSubtrees();
        root = ds.createTree();
        System.out.println(ds.findDuplicateSubtrees(root));


    }

}
