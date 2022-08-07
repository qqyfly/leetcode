/*
 * @lc app=leetcode id=807 lang=java
 *
 * [807] Max Increase to Keep City Skyline
 */

// @lc code=start
class Solution {
    //类似接雨水
    // 横向取最大,纵向取最大,然后取两者最小值.
    // 汇总当前数值和该数值的差.
    
    // 133/133 cases passed (1 ms)
    // Your runtime beats 87.61 % of java submissions
    // Your memory usage beats 6 % of java submissions (45.1 MB)
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] h_max = new int[n];
        int[] v_max = new int[n];

        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                h_max[i] = Math.max(h_max[i],grid[i][j]);
                v_max[j] = Math.max(v_max[j],grid[i][j]);
            }
        }
        int ans = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                int max_height = Math.min(h_max[i],v_max[j]);
                if (max_height > grid[i][j]){
                    ans += (max_height - grid[i][j]);
                }
            }
        }
        return ans;

    }
}
// @lc code=end

