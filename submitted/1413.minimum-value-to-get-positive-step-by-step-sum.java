/*
 * @lc app=leetcode id=1413 lang=java
 *
 * [1413] Minimum Value to Get Positive Step by Step Sum
 */

// @lc code=start
class Solution {
    public int minStartValue(int[] nums) {
        //简单题,忽略
        // 55/55 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 72.13 % of java submissions (41.3 MB)
        int n = nums.length;        
        int min = nums[0];
        
        for(int i = 1;i < n;i++){
            nums[i] +=  nums[i-1];
            min = Math.min(min,nums[i]);            
        }

        if (min > 0) return 1;
        else return - min + 1;
    }
}
// @lc code=end

