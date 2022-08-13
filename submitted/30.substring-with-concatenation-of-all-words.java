
/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// @lc code=start
class Solution {

    //hashmap + 字符串操作

    // 178/178 cases passed (258 ms)
    // Your runtime beats 43.94 % of java submissions
    // Your memory usage beats 86.82 % of java submissions (43.2 MB)
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 1){
            if (words[0].equals(s)) {
                ans.add(0);   
                return ans;             
            }            
        }
        int start = 0;
        int wordLen = words[0].length();
        
        HashMap<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word, 0) + 1);
        }
        for(int end = start + 1;end < s.length();end++){
            if( (end - start + 1) % (wordLen * words.length) != 0){
                continue;
            }
            
            String tmp = s.substring(start,end + 1);
            if (check(tmp,wordLen,map)){
                ans.add(start);
            }   
            start += 1;                     
        }
        return ans;
    }

    // 1: all met,should add to result
    private boolean check(String str,int wordLen,HashMap<String,Integer> map) {        
        HashMap<String,Integer> copy = new HashMap<>(map);
        
        int start = 0;
        
        for(int end = wordLen;end <= str.length();end += wordLen){
            String word = str.substring(start,end);
            if (copy.containsKey(word)){
                int count = copy.get(word);
                if (count == 1){
                    copy.remove(word);
                }else{
                    copy.put(word,count - 1);
                }                
            }
            start += wordLen;
        }
        return copy.size() == 0;
    }
}
// @lc code=end

class App {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis(); 
        
        //--------CODE 🡃------------
        Solution sol = new Solution();
        String s = "a";
        String[] words = new String[]{"a"};
        sol.findSubstring(s, words);
        
        //--------CODE 🡁------------
        long endTime=System.currentTimeMillis(); 
        long totalTime = endTime - startTime;
        if (totalTime >= 1000){
            totalTime /= 1000;
            System.out.println("Total time: " + totalTime + " Seconds");      
        }else{
            System.out.println("Total time: " + totalTime + " ms");      
        }
        
    }
}