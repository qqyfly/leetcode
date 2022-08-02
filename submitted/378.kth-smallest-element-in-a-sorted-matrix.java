/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */
/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
 

Follow up:

Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.
 */
// @lc code=start
class Solution {

    //DONE

    // BF 暴力
    // 86/86 cases passed (18 ms)
    // Your runtime beats 61.44 % of java submissions
    // Your memory usage beats 52.97 % of java submissions (56.9 MB)

    public int kthSmallest_bf(int[][] matrix, int k) {
        int n = matrix.length;
        int[] nums = new int[n*n];
        int index = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                nums[index++] = matrix[i][j];
            }            
        }

        Arrays.sort(nums);
        return nums[k-1];

    }

    //结构体说明:元素数值,第i行,排在第一的位于第几列
    //堆排序或者归并排序
    // 86/86 cases passed (24 ms)
    // Your runtime beats 47.59 % of java submissions
    // Your memory usage beats 27.45 % of java submissions (57.5 MB)
    public int kthSmallest_mergesort(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
            
    }
    
    // 86/86 cases passed (0 ms)
    // Your runtime beats 100 % of java submissions
    // Your memory usage beats 23.29 % of java submissions (57.6 MB)
    public int kthSmallest_bs(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //每加一次加一列(符合要求的)
    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    public int kthSmallest(int[][] matrix, int k) {
        //return kthSmallest_bf(matrix, k);
        //return kthSmallest_mergesort(matrix, k);
        return kthSmallest_bs(matrix, k);
    }


}
// @lc code=end

