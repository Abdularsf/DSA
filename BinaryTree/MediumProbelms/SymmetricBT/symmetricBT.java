package BinaryTree.MediumProbelms.SymmetricBT;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class symmetricBT {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetry(root.left, root.right);
    }

    private boolean symmetry(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null || rightTree == null) {
            return leftTree == rightTree;
        }
        if (leftTree.data != rightTree.data) {
            return false;
        }
        return symmetry(leftTree.left, rightTree.right) && symmetry(leftTree.right, rightTree.left);
    }

    public static void main(String[] args) {
        symmetricBT solution = new symmetricBT();

        // Create a sample tree: 1, 2, 2, 3, 4, 4, 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // Test the symmetric tree
        System.out.println(solution.isSymmetric(root)); // Output: true
    }
}
