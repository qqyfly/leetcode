/*
 * @lc app=leetcode id=1374 lang=java
 *
 * [1374] Generate a String With Characters That Have Odd Counts
 */
/*
Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.

The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.  

 

Example 1:

Input: n = 4
Output: "pppz"
Explanation: "pppz" is a valid string since the character 'p' occurs three times and the character 'z' occurs once. Note that there are many other valid strings such as "ohhh" and "love".
Example 2:

Input: n = 2
Output: "xy"
Explanation: "xy" is a valid string since the characters 'x' and 'y' occur once. Note that there are many other valid strings such as "ag" and "ur".
Example 3:

Input: n = 7
Output: "holasss"
 

Constraints:

1 <= n <= 500
 */
// @lc code=start
class Solution {

    // 103/103 cases passed (1 ms)
    // Your runtime beats 95.49 % of java submissions
    // Your memory usage beats 55.29 % of java submissions (41.7 MB)
    public String generateTheString(int n) {

        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0){
            for(int i = 0;i < n - 1;i++){
                sb.append('a');
            }
            sb.append('b');
        }else{
            for(int i = 0;i < n;i++){
                sb.append('a');
            }
        }
        return sb.toString();
    }
}
// @lc code=end

