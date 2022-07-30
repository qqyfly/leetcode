import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=916 lang=java
 *
 * [916] Word Subsets
 */

 /*
You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

 

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
 

Constraints:

1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.
  */
// @lc code=start

//HashMap有点慢，改成数组好很多

class Solution {

    // 56/56 cases passed (135 ms)
    // Your runtime beats 13.82 % of java submissions
    // Your memory usage beats 5.69 % of java submissions (119.5 MB)
    public List<String> wordSubsets1(String[] words1, String[] words2) {
        HashMap<Character,Integer> map = new HashMap<>();        
        List<String> ans = new ArrayList<>();

        for(String word:words2){
            HashMap<Character,Integer> newMap = new HashMap<>();
            for(char ch:word.toCharArray()){
                int count = newMap.getOrDefault(ch, 0) + 1;
                newMap.put(ch, count);
                map.put(ch,Math.max(count,map.getOrDefault(ch, 0)));
            }
        }
        
        for(String word:words1){
            HashMap<Character,Integer> map1 = new HashMap<>();
            map1.putAll(map);
            for(char ch:word.toCharArray()){
                Integer val = map1.get(ch);
                if (val != null){
                    val --;
                    if (val == 0){
                        map1.remove(ch);
                    }else{
                        map1.put(ch, val);
                    }
                }                    
            }    
            if (map1.size() == 0) ans.add(word);
        }

        return ans;
    }

    // 56/56 cases passed (15 ms)
    // Your runtime beats 96.34 % of java submissions
    // Your memory usage beats 87.4 % of java submissions (50.7 MB)
    //直接使用数组作为hashmap
    //做法和前面差不多
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = count("");
        for (String b: B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
        search: for (String a: A) {
            int[] aCount = count(a);
            for (int i = 0; i < 26; ++i)
                if (aCount[i] < bmax[i])
                    continue search;
            ans.add(a);
        }

        return ans;
    }

    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
}
// @lc code=end


class App {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis(); 
        
        //--------CODE 🡃------------
        Solution sol = new Solution();

        String[] words1 = new String[] {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = new String[] {"lo","eo"};

        sol.wordSubsets(words1,words2);
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