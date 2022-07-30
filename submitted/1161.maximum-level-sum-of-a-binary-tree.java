import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

/*
 * @lc app=leetcode id=1161 lang=java
 *
 * [1161] Maximum Level Sum of a Binary Tree
 */

/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

 

Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
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


// 40/40 cases passed (13 ms)
// Your runtime beats 64.1 % of java submissions
// Your memory usage beats 36.33 % of java submissions (71.2 MB)
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //此处注意，数字会出现负数
        int maxSum = Integer.MIN_VALUE;
        int maxLev = 0;
        int lev = 1;
        while(!queue.isEmpty()){

            int size = queue.size();
            int sum = 0;
            for(int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left!= null) queue.offer(node.left);
                if (node.right!= null) queue.offer(node.right);
            }

            if (sum > maxSum){
                maxSum = sum;
                maxLev = lev; 
            }
            
            lev ++;
        }
        return maxLev;
    }
}
// @lc code=end

