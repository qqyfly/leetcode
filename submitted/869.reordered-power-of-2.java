import java.util.Arrays;

/*
 * @lc app=leetcode id=869 lang=java
 *
 * [869] Reordered Power of 2
 */

// @lc code=start
class Solution {
    //算法：
    //计算N的10进制中0～9的数字个数
    //然后分别计算2的幂次对应而数字个数，如果两个数组一致，则认为这个数字可以被转化，返回true，否则返回false
    // 136/136 cases passed (2 ms)
    // Your runtime beats 68.67 % of java submissions
    // Your memory usage beats 46.67 % of java submissions (41.3 MB)
    public boolean reorderedPowerOf2(int n) {
        int[] A = count(n);
        for (int i = 0; i < 31; ++i)
            if (Arrays.equals(A, count(1 << i)))
                return true;
        return false;
    }

     // Returns the count of digits of N
    // Eg. N = 112223334, returns [0,2,3,3,1,0,0,0,0,0]
    public int[] count(int n) {
        int[] ans = new int[10];
        while (n > 0) {
            ans[n % 10]++;
            n /= 10;
        }
        return ans;
    }
}
// @lc code=end

