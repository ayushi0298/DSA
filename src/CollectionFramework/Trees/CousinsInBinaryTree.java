package CollectionFramework.Trees;

import Interview.Trees.LevelOrderTraversalOfATree;

import java.util.*;
//https://www.interviewbit.com/problems/cousins-in-binary-tree/
public class CousinsInBinaryTree {

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

    public class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

    }

    public HashMap<Integer, ArrayList<Integer>> updateHashMap(HashMap<Integer, ArrayList<Integer>> storeCousins, Pair current) {
        if (storeCousins.containsKey(current.level)) {
            ArrayList<Integer> currentIndex = storeCousins.get(current.level);
            currentIndex.add(current.node.val);
            storeCousins.put(current.level, currentIndex);
        } else {
            ArrayList<Integer> currentIndex = new ArrayList<>();
            currentIndex.add(current.node.val);
            storeCousins.put(current.level, currentIndex);
        }
        return storeCousins;
    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        int levelOfB=0;
        Queue<Pair> storePair = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> finalResult = new ArrayList<>();
        HashMap<Integer, Integer> storeRoot = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> storeCousins = new HashMap<>();
        storePair.add(new Pair(A, 0));
        storeRoot.put(A.val, -1);
        while (!storePair.isEmpty()) {
            Pair current = storePair.peek();
            storePair.remove();
            if (current.node.val == B) {
                levelOfB = current.level;
            }
            updateHashMap(storeCousins, current);
            if (current.node.left != null) {
                storeRoot.put(current.node.left.val, current.node.val);
                storePair.add(new Pair(current.node.left, current.level + 1));
            }
            if (current.node.right != null) {

                storeRoot.put(current.node.right.val, current.node.val);
                storePair.add(new Pair(current.node.right, current.level + 1));
            }
        }

        if (storeCousins.containsKey(levelOfB)) {
            //System.out.println(levelOfB);
            result = storeCousins.get(levelOfB);
            for (int i = 0; i < result.size(); i++) {
                if (storeRoot.get(result.get(i)) != storeRoot.get(B)) {
                    finalResult.add(result.get(i));
                }
            }
        }
        return finalResult;
    }

    public static void main(String args[]) {
        CousinsInBinaryTree cb = new CousinsInBinaryTree();
        int B = 2;
        root = cb.createTree();
        System.out.println(cb.solve(root, B));


    }
}
