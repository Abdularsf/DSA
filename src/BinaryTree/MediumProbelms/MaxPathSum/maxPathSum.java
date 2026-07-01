package BinaryTree.MediumProbelms.MaxPathSum;

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

public class maxPathSum {

    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        findMaxPathSum(root, maxSum);
        return maxSum[0];
    }

    private int findMaxPathSum(TreeNode node, int[] maxSum) {
        if (node == null)
            return 0;
        int leftSum = Math.max(0, findMaxPathSum(node.left, maxSum));
        int rightSum = Math.max(0, findMaxPathSum(node.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + node.data);
        return node.data + Math.max(leftSum, rightSum);
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
        maxPathSum solution = new maxPathSum();

        // Finding and printing the maximum path sum
        int maxPathSum = solution.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }
}
