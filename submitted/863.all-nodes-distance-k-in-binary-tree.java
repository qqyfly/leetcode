import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

 /*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []
 

Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
  */


// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    //解法:首先DFS获得所有节点的父节点,放入map
    //然后从target节点开始往左孩子,右孩子以及父亲节点搜索.知道找到符合条件的,加入list.
    //主函数直接返回结果list即可

    // 57/57 cases passed (16 ms)
    // Your runtime beats 65.55 % of java submissions
    // Your memory usage beats 64.25 % of java submissions (42.9 MB)
    List<Integer> ans = new ArrayList<Integer>();
    Map<Integer, TreeNode> parents = new HashMap<Integer, TreeNode>();    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);
        findAns(target,null,0,k);
        return ans;
    }

    public void findParents(TreeNode node){
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }

        if (depth == k) {
            ans.add(node.val);
            return;
        }

        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }

        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }

        if (parents.get(node.val) != from) {
            findAns(parents.get(node.val), node, depth + 1, k);
        }
    }
}
// @lc code=end

