package CollectionFramework_InterviewBit.Trees;
//https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
public class SumRootToLeafNumbers {

    static TreeNode root;

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode createTree() {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        root = a;
        root.left = b;
        root.right = c;
        return root;
    }

    public int sum(TreeNode A, int val) {
        if (A == null) {
            return 0;
        }
        if (A.left == null && A.right == null) {
            return (val * 10 + A.val) % 1003;
        }
        int result = val * 10 + A.val;
        result = result % 1003;
        int finalCall = (sum(A.left, result) + sum(A.right, result));

        return finalCall % 1003;
    }

    public int sumNumbers(TreeNode A) {
        return sum(A, 0) % 1003;
    }

    public static void main(String args[]) {
        SumRootToLeafNumbers sr = new SumRootToLeafNumbers();
        root = sr.createTree();
        System.out.println(sr.sumNumbers(root));

    }
}
