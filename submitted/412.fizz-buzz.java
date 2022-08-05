import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    // 模拟 ,简单,忽略
    // 8/8 cases passed (1 ms)
    // Your runtime beats 99.98 % of java submissions
    // Your memory usage beats 89.92 % of java submissions (43.5 MB)
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        for(int i = 1;i <= n;i++){
            if (i % 15 == 0){
                ans.add("FizzBuzz");
            }else if (i %3 == 0){
                ans.add("Fizz");
            }else if (i %5 == 0){
                ans.add("Buzz");
            }else{
                ans.add(String.valueOf(i));
            }
            
        }
        return ans;
    }
}
// @lc code=end

