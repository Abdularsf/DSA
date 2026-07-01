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

public class diameterOfTreeOptimal {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];

    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null)
            return 0;
        int leftH = height(node.left, diameter);
        int rightH = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }

    public static void main(String[] args) {
        // Creating a test tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        diameterOfTreeOptimal sol = new diameterOfTreeOptimal();
        System.out.println("Diameter of the binary tree is: " + sol.diameterOfBinaryTree(root));
    }
}
