/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */


 /* 
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

  */

// @lc code=start
import java.util.Arrays;
import java.util.HashMap;

class Solution {

    // 36/36 cases passed (8 ms)
    // Your runtime beats 46.43 % of java submissions
    // Your memory usage beats 37.64 % of java submissions (44.9 MB)
    //method 1 sorting
    public boolean isAnagram1(String s, String t) {
        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        Arrays.sort(s_chars);
        Arrays.sort(t_chars);
        
        if (s_chars.length != t_chars.length)  return false;
        for (int i = 0 ; i < s_chars.length; i++){
            if (s_chars[i] != t_chars[i]) return false;
        }
        return true;          
    }

    //hashmap
    // 36/36 cases passed (19 ms)
    // Your runtime beats 28.98 % of java submissions
    // Your memory usage beats 23.74 % of java submissions (46.2 MB)
    public boolean isAnagram2(String s, String t) {
        boolean ret = true;
        
        if (s.length() != t.length()) return false;

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for(int i = 0; i < t.length(); i++){
            char ch =  t.charAt(i);            
            if (map.containsKey(ch)) {                
                map.replace(ch, map.get(ch) + 1); 
            }
            else map.put(ch, 1);            
        }

        for(int i = 0; i < s.length(); i++){
            char ch =  s.charAt(i);            
            if (map.containsKey(ch) && map.get(ch) > 0){                
                map.replace(ch, map.get(ch) - 1);        
            } else {
                return false;
            }            
        }
        return ret;
    }

    public boolean isAnagram(String s, String t) {
        return isAnagram2(s, t);
    }
}
// @lc code=end

