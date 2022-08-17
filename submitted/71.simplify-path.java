/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

import java.util.Stack;

// @lc code=start
class Solution {
//     257/257 cases passed (5 ms)
//     Your runtime beats 90.8 % of java submissions
//     Your memory usage beats 94.77 % of java submissions (42.3 MB)
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for(String p:paths){            
            if (p.equals("..")){
                if (!stack.isEmpty())
                    stack.pop();                   
            }else if (p.equals(".")){ 
                //N/A
            }else if (p.equals("")){
                //N/A
            }else{
                stack.push(p);
            }                                    
        }
        
        if (stack.isEmpty()) return "/";
        String[] ans = new String[stack.size()];
        for(int i = stack.size() - 1;i >=0;i--){
            ans[i] = stack.pop();
        }
        String an = "/" + String.join("/",ans);
        return an;
    }
}
// @lc code=end

class App {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis(); 
        
        //--------CODE 🡃------------
        Solution sol = new Solution();
        sol.simplifyPath("/home//foo/");
        
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
