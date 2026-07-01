package BinaryTree.MediumProbelms.DiameterofTree;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class diameterOfTreeBrute {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        max = Math.max(max, leftHeight + rightHeight);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return max;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        // Creating a test tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        diameterOfTreeBrute sol = new diameterOfTreeBrute();
        System.out.println("Diameter of the binary tree is: " + sol.diameterOfBinaryTree(root));
    }
}
