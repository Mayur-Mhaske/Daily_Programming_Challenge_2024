class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Treenodes {
    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean isValid = isValidBST(root);
        System.out.println("Is the tree a valid BST? " + isValid);  // Output: true
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBSTHelper(TreeNode node, long min, long max) {
        // Base case: if the node is null, it's a valid subtree
        if (node == null) {
            return true;
        }

        // Check if the current node's value is within the valid range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively check the left and right subtrees with updated ranges
        return isValidBSTHelper(node.left, min, node.val) && 
               isValidBSTHelper(node.right, node.val, max);
    }
}
