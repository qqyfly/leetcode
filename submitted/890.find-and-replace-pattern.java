import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/*
 * @lc app=leetcode id=890 lang=java
 *
 * [890] Find and Replace Pattern
 */

 /*
Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
Example 2:

Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]
 

Constraints:

1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.
  */
// @lc code=start

//题解：首先判断长度，不一致往下走
//将pattern和word都转化为统一的格式，一样就添加到结果集

// 47/47 cases passed (2 ms)
// Your runtime beats 74.25 % of java submissions
// Your memory usage beats 6.64 % of java submissions (44 MB)
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int pattern_len = pattern.length();
        List<String> ans = new ArrayList<>();
        String[][] pairs = new String[pattern_len][2];

        String pattern_convert = convert(pattern);
        for(String word:words){
            if (word.length() != pattern_len) continue;
            if (convert(word).equals(pattern_convert)){
                ans.add(word);
            }
        }
        return ans;
    }

    public String convert(String str){
        HashMap<Character,Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char ch_mapping = 'a';
        for(char ch:str.toCharArray()){
            if (map.containsKey(ch)){
                sb.append(map.get(ch));
            }else{
                map.put(ch,ch_mapping);
                sb.append((char)ch_mapping++);                                
            }
        }
        return sb.toString();
    }
}
// @lc code=end

