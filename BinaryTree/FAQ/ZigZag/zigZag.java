package BinaryTree.FAQ.ZigZag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class zigZag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag = true;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> row = new ArrayList<>(Collections.nCopies(size, 0));
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int ind = flag ? i : size - 1 - i;
                row.set(ind, node.data);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            flag = !flag;
            ans.add(row);
        }
        return ans;
    }

    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        zigZag solution = new zigZag();

        // Get the zigzag level order traversal
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        // Print the result
        printResult(result);
    }
}
