/*
 * @lc app=leetcode id=458 lang=java
 *
 * [458] Poor Pigs
 */

// @lc code=start
class Solution {

    //解法:
    // 计算可用的trialTime次数
    //假设b个桶,做了trialTime次
    // (trialTime + 1) ^ numPigs < b

    // 17/17 cases passed (0 ms)
    // Your runtime beats 100 % of java submissions
    // Your memory usage beats 48.8 % of java submissions (41 MB)
    public int poorPigs1(int buckets, int minutesToDie, int minutesToTest) {
        int numPigs = 0;
        int trialTime = minutesToTest / minutesToDie;
        while (Math.pow(trialTime + 1, numPigs) < buckets) {
            numPigs++;
        }
        return numPigs;
    }

    // 17/17 cases passed (0 ms)
    // Your runtime beats 100 % of java submissions
    // Your memory usage beats 90.4 % of java submissions (39.2 MB)
    
    //此方法是从上面这个方法推导下来的
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int k = minutesToTest / minutesToDie;
        return (int) Math.ceil(Math.log(buckets) / Math.log(k + 1));
    }    
}
// @lc code=end

