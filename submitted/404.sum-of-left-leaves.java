/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
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
class Solution {

    //做法左数+右树
    //100/100 cases passed (0 ms)
    // Your runtime beats 100 % of java submissions
    // Your memory usage beats 50.14 % of java submissions (41.9 MB)
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;        
        return dfs(root.left, true) + dfs(root.right, false);        
    }

    private int dfs(TreeNode node,boolean isLeft){
        if (node == null) return 0;
        
        if (node.left == null && node.right == null && isLeft){
            return node.val;
        }

        return dfs(node.left, true) + dfs(node.right,false);
        
    }
}
// @lc code=end

