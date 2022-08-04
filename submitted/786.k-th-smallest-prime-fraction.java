import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=786 lang=java
 *
 * [786] K-th Smallest Prime Fraction
 */

// @lc code=start

class Solution {  

    //直接比较
    //注意比较时为了防止double比较,可以采用 a/b > c/d ==> ad > bc
    
    // 59/59 cases passed (882 ms)
    // Your runtime beats 24.56 % of java submissions
    // Your memory usage beats 5.09 % of java submissions (183.1 MB)  
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {        
        int n = arr.length;
        List<int[]> ans = new ArrayList<>();

        for(int i = 0;i < n - 1;i++){
            for(int j = i + 1;j < n;j++){
                int[] pair = new int[]{arr[i],arr[j]};
                ans.add(pair);
            }
        }
        
        Collections.sort(ans, (x, y) -> x[0] * y[1] - y[0] * x[1]);
        
        return ans.get(k - 1);
    }
}
// @lc code=end


class App {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis(); 
        
        //--------CODE 🡃------------
        Solution sol = new Solution();
        int[] arr = {1,2,3,5};

        sol.kthSmallestPrimeFraction(arr,3);
        
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