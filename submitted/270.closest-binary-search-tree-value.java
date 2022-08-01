/*

Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.

 

Example 1:


Input: root = [4,2,5,1,3], target = 3.714286
Output: 4
Example 2:

Input: root = [1], target = 4.428571
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109

*/



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

    //题解：普通遍历树

    // 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    // 内存消耗：41.5 MB, 在所有 Java 提交中击败了28.89%的用户
    // 通过测试用例：63 / 63
    
    double min = Double.MAX_VALUE;
    int minNode;

    public int closestValue(TreeNode root, double target) {        
        if (min > Math.abs(target-root.val)){
            min = Math.abs(target-root.val);
            minNode = root.val;
        }
        
        if (root.val >= target){ //只可能在根节点和左边寻找        
            if (root.left != null)
                closestValue(root.left,target);
        }else{//root.val < target  只可能在根节点和右边寻找
            if (root.right != null)
                closestValue(root.right,target);
        }

        return minNode;

    }
}