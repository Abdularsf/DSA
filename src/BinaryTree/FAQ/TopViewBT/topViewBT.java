package BinaryTree.FAQ.TopViewBT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class topViewBT {
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public List<Integer> topView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            int line = pair.getValue();
            if (!mpp.containsKey(line)) {
                mpp.put(line, node.data);
            }
            if (node.left != null) {
                q.add(new Pair<>(node.left, line - 1));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }
        for (Integer value : mpp.values()) {
            ans.add(value);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        topViewBT solution = new topViewBT();
        List result = solution.topView(root);

        System.out.println("Top View: " + result);
    }
}
