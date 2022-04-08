package CollectionFramework_LeetCode;

//https://leetcode.com/problems/path-sum/
public class PathSum {

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
        return root;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        boolean foundPath = false;
        int sum = targetSum - root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            foundPath = true;
            return foundPath;
        }
        if (root.left != null) {
            foundPath = foundPath || hasPathSum(root.left, sum);
        }
        if (root.right != null) {
            foundPath = foundPath || hasPathSum(root.right, sum);
        }
        return foundPath;


    }

    public static void main(String args[]) {
        PathSum ps = new PathSum();
        root = ps.createTree();
        int target = 8;
        System.out.println(ps.hasPathSum(root, target));
    }

}
