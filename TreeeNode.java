class public TreeeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SymmetricBinaryTree {
    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean isSymmetric = isSymmetric(root);
        System.out.println("Is the tree symmetric? " + isSymmetric);  // Output: true
    }

    public static boolean isSymmetric(TreeNode root) {
        // An empty tree is symmetric
        if (root == null) {
            return true;
        }
        // Compare the left and right subtrees
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        // If both nodes are null, they are symmetric
        if (left == null && right == null) {
            return true;
        }
        // If one of the nodes is null, they are not symmetric
        if (left == null || right == null) {
            return false;
        }
        // Check if the current nodes are equal and recurse for their children
        return (left.val == right.val) 
                && isMirror(left.left, right.right) 
                && isMirror(left.right, right.left);
    }
}
