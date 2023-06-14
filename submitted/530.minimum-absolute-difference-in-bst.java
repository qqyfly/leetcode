/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
 */

// @lc code=start
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

 /**
189/189 cases passed (1 ms)
Your runtime beats 59.21 % of java submissions
Your memory usage beats 36.27 % of java submissions (43.3 MB)
  */
class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private Integer prevVal = null;

    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorderTraversal(node.left);
        
        if (prevVal != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prevVal));
        }
        
        prevVal = node.val;
        
        inorderTraversal(node.right);
    }
}
// @lc code=end

