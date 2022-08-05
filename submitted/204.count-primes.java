import java.util.Arrays;

/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start

//解法:首先使用单个检查素数会TLE
//因此没检查到一个素数,相关的倍数都变成和数
//因此先做一个数组,可以大大加快

// 66/66 cases passed (236 ms)
// Your runtime beats 27.95 % of java submissions
// Your memory usage beats 5.23 % of java submissions (100.1 MB)
class Solution {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);

        int ans = 0;
        for(int i = 2;i < n;i++){
            if (isPrime[i] == 1) {
                ans += 1;          
                if ((long) i * i < n) {      
                    for(int j = i * i ;j < n;j+=i){
                        isPrime[j] = 0;
                    }                    
                }
            }
        }
        return ans;
    }
}
// @lc code=end

