
package CollectionFramework_InterviewBit.Trees;

import java.util.*;

public class ZigZagLevelOrderTraversalBT {
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
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        root = a;
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        return root;
    }

    public int[][] zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<TreeNode> alternate1 = new Stack<>();
        Stack<TreeNode> alternate2 = new Stack<>();
        alternate1.push(A);

        while (!alternate1.isEmpty() || !alternate2.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            if (!alternate1.isEmpty()) result.add(list);
            while (!alternate1.isEmpty()) {
                TreeNode node = alternate1.pop();
                list.add(node.val);

                if (node.left != null) {
                    alternate2.push(node.left);
                }
                if (node.right != null) {
                    alternate2.push(node.right);
                }
            }

            list = new ArrayList<>();
            if (!alternate2.isEmpty()) result.add(list);
            while (!alternate2.isEmpty()) {
                TreeNode node = alternate2.pop();
                list.add(node.val);

                if (node.right != null){
                    alternate1.push(node.right);
                }
                if (node.left != null) {
                    alternate1.push(node.left);
                }
            }
        }
        //to convert arraylist of arraylist in 2 d array
        int[][] arr = result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);


        return arr;
    }

    public static void main(String args[]) {
        ZigZagLevelOrderTraversalBT z = new ZigZagLevelOrderTraversalBT();
        root = z.createTree();
        System.out.println(Arrays.toString(z.zigzagLevelOrder(root)));
    }
}

