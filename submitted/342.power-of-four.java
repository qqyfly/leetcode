/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */
/*
Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 

Constraints:

-231 <= n <= 231 - 1
 

Follow up: Could you solve it without loops/recursion?
 */


// @lc code=start

class Solution {
    // 1061/1061 cases passed (3 ms)
    // Your runtime beats 11.24 % of java submissions
    // Your memory usage beats 7.26 % of java submissions (42.3 MB)
    public boolean isPowerOfFour1(int n) {
        if (n == 1) return true;
        if (n == 0) return false;
        if (n < 0) return false;

        while(n > 1){
            int remain = n % 4;
            if (remain != 0) return false;
            n = n / 4;
        }
        return true;
    }

    // 1061/1061 cases passed (1 ms)
    // Your runtime beats 100 % of java submissions
    // Your memory usage beats 40.14 % of java submissions (41.4 MB)
    public boolean isPowerOfFour(int n) {        
        return n > 0 && (n & (n - 1)) == 0 && (n & 0b10101010101010101010101010101010) == 0;
    }

}
// @lc code=end

