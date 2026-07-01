package BinaryTree.FAQ.BottomViewBT;

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

public class bottomViewBT {

    static class Pair {
        TreeNode node;
        int line;

        Pair(TreeNode node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    public List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int line = p.line;
            map.put(line, node.data);

            if (node.left != null) {
                q.offer(new Pair(node.left, line - 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, line + 1));
            }
        }
        for (int val : map.values()) {
            ans.add(val);
        }

        return ans;
    }

    public static void main(String[] args) {

        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        bottomViewBT solution = new bottomViewBT();

        // Get the Bottom View traversal
        List<Integer> bottomView = solution.bottomView(root);

        // Print the result
        System.out.println("Bottom View Traversal: ");
        for (int node : bottomView) {
            System.out.print(node + " ");
        }
    }
}
