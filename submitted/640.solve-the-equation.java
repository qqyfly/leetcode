import java.util.Stack;

/*
 * @lc app=leetcode id=640 lang=java
 *
 * [640] Solve the Equation
 */

// @lc code=start
class Solution {
    //分别使用左边右边比较麻烦,直接扫描比较简单,当出现=时,前面的数字和X的前置符号全部取反即可
    // 59/59 cases passed (5 ms)
    // Your runtime beats 72.16 % of java submissions
    // Your memory usage beats 41.48 % of java submissions (42.3 MB)
    public String solveEquation(String s) {
        int x = 0, num = 0, n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0, op = 1; i < n; ) {
            if (cs[i] == '+') {
                op = 1; i++;
            } else if (cs[i] == '-') {
                op = -1; i++;
            } else if (cs[i] == '=') {
                x *= -1; num *= -1; op = 1; i++;
            } else {
                int j = i;
                while (j < n && cs[j] != '+' && cs[j] != '-' && cs[j] != '=') j++;
                if (cs[j - 1] == 'x') x += (i < j - 1 ? Integer.parseInt(s.substring(i, j - 1)) : 1) * op;
                else num += Integer.parseInt(s.substring(i, j)) * op;
                i = j;
            }
        }
        if (x == 0) return num == 0 ? "Infinite solutions" : "No solution";    
        else return "x=" + (num / -x);
    }
}
// @lc code=end

