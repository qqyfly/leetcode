/*
 * @lc app=leetcode id=1408 lang=java
 *
 * [1408] String Matching in an Array
 */

// @lc code=start
class Solution {
    
    // 模拟
    // 67/67 cases passed (5 ms)
    // Your runtime beats 76.15 % of java submissions
    // Your memory usage beats 34.45 % of java submissions (43 MB)
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i < words.length;i++){
            for(int j = i + 1; j < words.length;j++){                
                
                int ni = words[i].length();
                int nj = words[j].length();
                if (ni < nj && words[j].indexOf(words[i]) >= 0){
                    set.add(words[i]);
                    
                }else if (ni > nj && words[i].indexOf(words[j]) >= 0){
                    set.add(words[j]);
                }
            }
        }
        
        for(String word:set){
            ans.add(word);
        }
        
        return ans;
    }
}
// @lc code=end

