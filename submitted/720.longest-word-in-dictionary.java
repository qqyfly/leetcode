/*
 * @lc app=leetcode id=720 lang=java
 *
 * [720] Longest Word in Dictionary
 */

// @lc code=start
class Solution {

    //题解:字符串入set,对set中所有字符串的子串进行判断
    //需要注意. 如果字符串长度一样,需要返回字典序小的单词
    // 59/59 cases passed (13 ms)
    // Your runtime beats 88.45 % of java submissions
    // Your memory usage beats 55.54 % of java submissions (50.1 MB)

    public String longestWord(String[] words) {   
        String ans = "";
        Set<String> set = new HashSet<>();

        //所有字符串入set
        for (String s : words) set.add(s);

        //对set中所有字符串的子串进行判断

        for (String s : set) {
            int n = s.length(), m = ans.length();
            if (n < m) continue;//如果该字符串更短,则continue

            //如果字符串长度一样,需要返回字典序小的单词,因此,此处放弃
            if (n == m && s.compareTo(ans) > 0) continue; 

            //比对子串
            boolean ok = true;
            for (int i = 1; i <= n && ok; i++) {
                String sub = s.substring(0, i);
                if (!set.contains(sub)) ok = false;
            }

            if (ok) ans = s;
        }
        return ans;
    }
}
// @lc code=end

