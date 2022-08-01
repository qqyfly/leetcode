import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
 */
/*
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).
 

Constraints:

The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100

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
    
    //BFS,用了2个queue,一个用于BFS,一个用于记录pos，pos数值是上一次压进来的
    // 113/113 cases passed (3 ms)
    // Your runtime beats 57.31 % of java submissions
    // Your memory usage beats 38.27 % of java submissions (43.8 MB)
    public int widthOfBinaryTree(TreeNode root) {
        // 如果结点为空，则宽度为0
        if(root == null) {
            return 0;
        }

        // 记录最大宽度
        int width = 0;

        // 队列1，放入TreeNode结点
        Queue<TreeNode> queue1 = new LinkedList<>();

        // 队列2，放入结点的位置索引
        Queue<Integer> queue2 = new LinkedList<>();

        // 放入root结点
        queue1.offer(root);

        // 放入root结点的位置索引
        queue2.offer(1);
        while(!queue1.isEmpty()) {
            // 当前层的结点数量
            int size = queue1.size();
            // 记录当前层的最大宽度
            int tmpWidth = 0;
            // 用于判断是否为当前层的第一个结点
            boolean flag = false;
            int left = -1, right = -1;
            while(size-- > 0) {
                TreeNode node = queue1.poll();

                int pos = queue2.poll();

                // 遇到第一个结点
                if(!flag) {
                    flag = true;
                    left = pos;
                }
                right = pos;
                // 不停更新当前层的最大宽度
                tmpWidth = Math.max(tmpWidth, right-left+1);
                if(node.left != null) {
                    queue1.offer(node.left);
                    queue2.offer(pos*2);
                }

                if(node.right != null) {
                    queue1.offer(node.right);
                    queue2.offer(pos*2+1);
                }
            }
            width = Math.max(width, tmpWidth);
        }
        return width;
    }
}
// @lc code=end

