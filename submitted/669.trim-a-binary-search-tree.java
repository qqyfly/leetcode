/*
 * @lc app=leetcode id=669 lang=java
 *
 * [669] Trim a Binary Search Tree
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
    // 78/78 cases passed (1 ms)
    // Your runtime beats 20.77 % of java submissions
    // Your memory usage beats 28.86 % of java submissions (45.8 MB)
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low) { // 跟节点比low小，左树直接跳过
            root = root.right;
            return trimBST(root,low,high);
        } else if (root.val > high) {// 跟节点比high大，右树直接跳过
            root = root.left;
            return trimBST(root,low,high);
        } else {//主逻辑
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
            return root;
        }
    }
}
// @lc code=end

