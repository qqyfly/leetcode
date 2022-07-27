import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=1331 lang=java
 *
 * [1331] Rank Transform of an Array
 */

 /*
Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.
 

Example 1:

Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
Example 2:

Input: arr = [100,100,100]
Output: [1,1,1]
Explanation: Same elements share the same rank.
Example 3:

Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]
 

Constraints:

0 <= arr.length <= 105
-109 <= arr[i] <= 109
  */

// @lc code=start
class Solution {

    // 说明：hashmap中需要放的是位置列表，而非单个位置
    
    // 38/38 cases passed (84 ms)
    // Your runtime beats 21.14 % of java submissions
    // Your memory usage beats 5.03 % of java submissions (94.1 MB)
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < arr.length;i++){
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);            
        }

        Arrays.sort(arr);

        int n = arr.length;
        int[] ans = new int[n];
                                
        int index = 0;
        int rank = 1;
        
        while(index < n){
            List<Integer> list = map.get(arr[index]);
            int rankCount = list.size();
            for(int i:list){
                ans[i] = rank;
            }            
            index += rankCount;
            rank ++;
        }
        return ans;
    }
}
// @lc code=end


class App {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis(); 
        
        //--------CODE 🡃------------
        Solution sol = new Solution();
        int[] arr = new int[]{100,100,100};
        
        sol.arrayRankTransform(arr);
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