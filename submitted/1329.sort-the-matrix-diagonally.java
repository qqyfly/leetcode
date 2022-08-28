import java.util.Arrays;

/*
 * @lc app=leetcode id=1329 lang=java
 *
 * [1329] Sort the Matrix Diagonally
 */

// @lc code=start
class Solution {

    // 15/15 cases passed (4 ms)
    // Your runtime beats 92.45 % of java submissions
    // Your memory usage beats 39.84 % of java submissions (48.3 MB)
    
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        //分两块做
        //第一块，从左上角开始，往右
        //第二块，从左上角下一行第一元素开始，往下

        //第一块
        for (int i = 0; i < n; i++) {
            int count = Math.min(m,n-i);
            int[] arr = new int[count];
            int ix = i;
            for (int j = 0; j < count; j++) {
                arr[j] = mat[j][ix++];
            }

            Arrays.sort(arr);          
            ix = i;
            for (int j = 0; j < count; j++) {
                mat[j][ix++] = arr[j];
            }            
        }
        
        //第二块
        for (int j = 1; j < m; j++) {
            int count = Math.min(n,m-j);
            int[] arr = new int[count];
            int ix = j;

            for (int i = 0; i < count; i++) {
                arr[i] = mat[ix++][i];
            }

            Arrays.sort(arr);          
            ix = j;
            for (int i = 0; i < count; i++) {
                mat[ix++][i] = arr[i];
            }
        }

        return mat;
    }
}
// @lc code=end


class App {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis(); 
        
        //--------CODE 🡃------------
        Solution sol = new Solution();
        
        int[][] mat = new int[][] {{3,3,1,1},{2,2,1,2},{1,1,1,2}};

        sol.diagonalSort(mat);

        
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