package CollectionFramework_InterviewBit.Trees;

//https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
public class KthSmallestElementInTree {
    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode root;
    int count = 0;

    public TreeNode createTree() {

        TreeNode a = new TreeNode(13);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        root = a;
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        return root;

    }

    public TreeNode findKthSmallest(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        TreeNode left = findKthSmallest(root.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return root;
        }
        return findKthSmallest(root.right, k);
    }


    public int kthsmallest(TreeNode root, int k) {
        TreeNode result = findKthSmallest(root, k);
        if (result != null) {
            return result.val;
        } else {
            return 0;
        }
    }


    public static void main(String args[]) {
        KthSmallestElementInTree kt = new KthSmallestElementInTree();
        root = kt.createTree();
        int k = 4;
        System.out.println(kt.kthsmallest(root, k));


    }
}
