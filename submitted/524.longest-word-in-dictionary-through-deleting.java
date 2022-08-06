import java.util.Collections;

/*
 * @lc app=leetcode id=524 lang=java
 *
 * [524] Longest Word in Dictionary through Deleting
 */

// @lc code=start
class Solution {

    //先排序,然后双指针
    // 31/31 cases passed (37 ms)
    // Your runtime beats 38.43 % of java submissions
    // Your memory usage beats 67.78 % of java submissions (51 MB)
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary,(s1,s2)->{
            int l1 = s1.length();
            int l2 = s2.length();
            if (l1 == l2){
                return s1.compareTo(s2);
            }else{
                return l2-l1;
            }
        });
                
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                return t;
            }
        }
        return "";
    }
}
// @lc code=end

