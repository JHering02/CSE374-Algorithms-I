/**
 * James Hering
 * Algorithms I
 * 18 November 2023
 * 
 * A program which implements a recursive method that checks if a binary tree is balanced.
 */
public class Solution extends TreeNode {

    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        if (root.left.val > root.right.val || root.right.val > root.left.val)
            return isBalanced(root.left) == isBalanced(root.right);
        return false;
    }
}

