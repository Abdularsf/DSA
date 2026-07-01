package BinaryTree.MediumProbelms.BalancedTree;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        data = val;
        left = right = null;
    }
}

public class balancedTree {
    public boolean isBalanced(TreeNode root) {
        return balancedTree(root) != -1;
    }

    private int balancedTree(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = balancedTree(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = balancedTree(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        // Creating an instance of the Solution class
        balancedTree solution = new balancedTree();

        // Checking if the tree is balanced
        if (solution.isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}
