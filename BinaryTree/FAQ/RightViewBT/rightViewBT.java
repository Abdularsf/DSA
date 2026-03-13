package BinaryTree.FAQ.RightViewBT;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize the node with a value
    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class rightViewBT {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        generatingRightView(root, 0, res);
        return res;
    }

    private void generatingRightView(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(root.data);
        }

        generatingRightView(root.right, level + 1, res);
        generatingRightView(root.left, level + 1, res);
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

        rightViewBT solution = new rightViewBT();

        // Get the Right View traversal
        List<Integer> rightView = solution.rightSideView(root);

        // Print the result for Right View
        System.out.print("Right View Traversal: ");
        for (int node : rightView) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
