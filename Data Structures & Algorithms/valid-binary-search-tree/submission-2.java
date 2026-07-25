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

        BinaryCheck leftCheck = helper(node.left);
        if (!leftCheck.isValid || leftCheck.leftMax >= node.val) {
            return new BinaryCheck(false);
        }

        BinaryCheck rightCheck = helper(node.right);
        if (!rightCheck.isValid || rightCheck.rightMin <= node.val) {
            return new BinaryCheck(false);
        }
        
        int max = Math.max(leftCheck.leftMax, node.val);
        max = Math.max(max, rightCheck.leftMax);
        
        int min = Math.min(rightCheck.rightMin, node.val);
        min = Math.min(min, leftCheck.rightMin);

        return new BinaryCheck(max, min, true);
    }
}
