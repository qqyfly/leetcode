/*
 * @lc app=leetcode id=858 lang=java
 *
 * [858] Mirror Reflection
 */

// @lc code=start
class Solution {

    // 69/69 cases passed (0 ms)
    // Your runtime beats 100 % of java submissions
    // Your memory usage beats 98.61 % of java submissions (38.9 MB)

    //解法:从一个方块变成N个方块叠加,3 * 2 的方块.可以看图就能知道
    
    // p偶数 -> 2
    // p奇数 -> 0 or 1
    // q偶数 -> 0
    // q奇数 -> 1 or 2
    
    //p偶q偶被忽略,直接可以简化,因此此种形式不存在
    
    public int mirrorReflection(int p, int q) {
        int g = gcd(p,q);
        p = p / g;
        q = q / g;
        if (p % 2 == 0) return 2; //p偶数  
        if (q % 2 == 0) return 0; //q偶数
        
        return 1; // p 奇数 q奇数
    }
    
    public int gcd(int a,int b){
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
// @lc code=end

