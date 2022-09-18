/*
 * @lc app=leetcode id=2413 lang=java
 *
 * [2413] Smallest Even Multiple
 */

// @lc code=start
class Solution {

    //简单题，忽略
    public int smallestEvenMultiple(int n) {
        return lcm(2,n);
    }

    /**
     * 返回最大公约数
     * @param a
     * @param b
     * @return 最大公约数
     */
    public int gcd(int a,int b){
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * 返回最小公倍数
     * @param a
     * @param b
     * @return 最小公倍数
     */
    public int lcm(int a,int b){
        return (a * b) / gcd(a,b);
    }


}
// @lc code=end

