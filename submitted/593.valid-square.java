import java.util.HashSet;

/*
 * @lc app=leetcode id=593 lang=java
 *
 * [593] Valid Square
 */

 /*
Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.

The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.

A valid square has four equal sides with positive length and four equal angles (90-degree angles).

 

Example 1:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: true
Example 2:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
Output: false
Example 3:

Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
Output: true
 

Constraints:

p1.length == p2.length == p3.length == p4.length == 2
-104 <= xi, yi <= 104
  */
// @lc code=start


//题解：
// 常规做法
//需要注意：len 连乘 会越界，因此只能改成 ||
//使用hashset处理，最终是2组数据就是正方形。

// 253/253 cases passed (1 ms)
// Your runtime beats 97.98 % of java submissions
// Your memory usage beats 87.74 % of java submissions (40.5 MB)
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        int[] len = new int[6];
        
        len[0] = distance(p1,p2);
        len[1] = distance(p2,p3);
        len[2] = distance(p3,p4);
        len[3] = distance(p1,p4);
        len[4] = distance(p1,p3);
        len[5] = distance(p2,p4);

        if (len[0] == 0 || len[1] == 0 || len[2] == 0 || len[3] == 0 || len[4] == 0 || len[5] == 0) return false;

        HashSet<Integer> set = new HashSet<>();

        set.add(len[0]);
        set.add(len[1]);
        set.add(len[2]);
        set.add(len[3]);
        set.add(len[4]);
        set.add(len[5]);

        return (set.size() == 2);
    }

    public int distance(int[] p1, int[] p2){
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]) ;
    }
}
// @lc code=end


class App {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis(); 
        
        //--------CODE 🡃------------
        Solution sol = new Solution();
        int[] p1 = new int[]{132,5362};
        int[] p2 = new int[]{1956,4738};
        int[] p3 = new int[]{-492,3538};
        int[] p4 = new int[]{1332,2914};
        sol.validSquare(p1,p2,p3,p4);
        
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