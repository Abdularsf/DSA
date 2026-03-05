package BinaryTree.Preorder;

import java.util.ArrayList;
import java.util.List;

// import javax.swing.tree.TreeNode;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize a node with a value
    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class preOrderRecursive {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        helper(root.left, list);
        helper(root.right, list);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create an instance of the Solution class
        preOrderRecursive solution = new preOrderRecursive();
        // Getting preorder traversal
        List<Integer> result = solution.preorder(root);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
