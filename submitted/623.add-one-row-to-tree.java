import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=623 lang=java
 *
 * [623] Add One Row to Tree
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


    //加了dummy之后,需要从dummy开始进queue
    // 109/109 cases passed (1 ms)
    // Your runtime beats 87.68 % of java submissions
    // Your memory usage beats 51.45 % of java submissions (45.5 MB)
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode dummy = new TreeNode(-1,root,null);
        
        Queue<TreeNode> q = new LinkedList<>();

        q.add(dummy);

        for(int i=0;i<depth-1;i++){
            int size=q.size();
            for(int j=0;j<size;j++){
                TreeNode t=q.poll();
                if(t.left!=null){q.add(t.left);}
                if(t.right!=null){q.add(t.right);}
            }
        }
        while(q.size()>0){
            TreeNode t=q.poll();
            TreeNode l=t.left;
            TreeNode r=t.right;
            t.left=new TreeNode(val);
            t.right=new TreeNode(val);
            t.left.left=l;
            t.right.right=r;
        }
        
        return dummy.left;
    }
}
// @lc code=end

