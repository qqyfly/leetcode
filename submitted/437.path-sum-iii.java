/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 */
/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

Example 1:


Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000
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

// 128/128 cases passed (18 ms)
// Your runtime beats 49.03 % of java submissions
// Your memory usage beats 55.5 % of java submissions (44.1 MB)
class Solution {
    //双重DFS,DONE // 测试用例里有越界，因此dfs2 要换成long型
    int ans = 0;
    int target = 0;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;

        dfs1(root);        
        return ans;
    }

    void dfs1(TreeNode root) {
        if (root == null) return;
        dfs2(root, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    void dfs2(TreeNode root, long val) {
        if (val == target) ans++;
 
        if (root.left != null) dfs2(root.left, val + root.left.val);
        if (root.right != null) dfs2(root.right, val + root.right.val);
    }
}
// @lc code=end

