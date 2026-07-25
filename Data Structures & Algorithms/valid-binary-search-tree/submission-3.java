/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class BinaryCheck {
    int leftMax = Integer.MIN_VALUE;
    int rightMin = Integer.MAX_VALUE;
    boolean isValid = false;

    BinaryCheck(int left, int right, boolean valid) {
        leftMax = left;
        rightMin = right;
        isValid = valid;
    }

    BinaryCheck(boolean valid) {
        isValid = valid;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        BinaryCheck check = helper(root);
        return check.isValid;
    }

    public BinaryCheck helper(TreeNode node) {
        if (node == null) {
            return new BinaryCheck(true);
        }
        if (node.left == null && node.right == null) {
            return new BinaryCheck(node.val, node.val, true);
        }

        BinaryCheck leftCheck = helper(node.left);
        if (node.left != null && (!leftCheck.isValid || leftCheck.leftMax >= node.val)) {
            return new BinaryCheck(false);
        }

        BinaryCheck rightCheck = helper(node.right);
        if (node.right != null && (!rightCheck.isValid || rightCheck.rightMin <= node.val)) {
            return new BinaryCheck(false);
        }
        
        int max = Math.max(leftCheck.leftMax, rightCheck.leftMax);
        max = Math.max(max, node.val);
        
        int min = Math.min(rightCheck.rightMin, leftCheck.rightMin);
        min = Math.min(min, node.val);

        return new BinaryCheck(max, min, true);
    }
}
