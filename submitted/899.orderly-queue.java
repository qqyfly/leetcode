/*
 * @lc app=leetcode id=899 lang=java
 *
 * [899] Orderly Queue
 */

 /*
you are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string..

Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

 

Example 1:

Input: s = "cba", k = 1
Output: "acb"
Explanation: 
In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".
Example 2:

Input: s = "baaca", k = 3
Output: "aaabc"
Explanation: 
In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".
 

Constraints:

1 <= k <= s.length <= 1000
s consist of lowercase English letters.

  */
// @lc code=start


//思路:k=1 只能是一个闭环
//而非1的情况,可以做到最优排序
// 110/110 cases passed (4 ms)
// Your runtime beats 90.48 % of java submissions
// Your memory usage beats 76.87 % of java submissions (43.7 MB)

class Solution {
    public String orderlyQueue(String s, int k) {
        
        char[] sChars = s.toCharArray();

        if (k == 1){
            String ans = s;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                sb.deleteCharAt(0);
                sb.append(c);
                String cur = sb.toString();
                if (cur.compareTo(ans) < 0) {
                    ans = cur;
                }
            }

            return ans;
        }else{
            Arrays.sort(sChars);                    
            return new String(sChars);
        }        
    }
}
// @lc code=end

