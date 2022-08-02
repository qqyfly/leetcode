/*
 * @lc app=leetcode id=668 lang=java
 *
 * [668] Kth Smallest Number in Multiplication Table
 */
/*
Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).

Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.

 

Example 1:


Input: m = 3, n = 3, k = 5
Output: 3
Explanation: The 5th smallest number is 3.
Example 2:


Input: m = 2, n = 3, k = 6
Output: 6
Explanation: The 6th smallest number is 6.
 

Constraints:

1 <= m, n <= 3 * 104
1 <= k <= m * n
 */
// @lc code=start

//BS

// 70/70 cases passed (15 ms)
// Your runtime beats 97.47 % of java submissions
// Your memory usage beats 9.85 % of java submissions (41.5 MB)

//推理过程:
//先除后乘是因为取整除法的缘故.整数除法

// 第i行,对于数字X而言,其小于等于这个X的数字个数为min(X/i,n)
//全部行是 sigma(min(X/i,n))
//当x=10,而第一行只有4个元素,比如1,2,3,4,那么i< x/n.也就是1 < 10/4 = 2
//此时x/i = 10/1 >= 4=n ==> sigma(min(X/i,n)) = x/n * n (在范围外)+ sigma(min(X/i,n)) 
//也就是X在当前行的范围外
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left <= right) {
            int x = (right + left) >> 1 ;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; ++i) {
                count += x / i;
            }

            //此处如果直接使用count == k 会导致好几个符合条件的不在乘法表中的数据出现,因此需要>=
            if (count >= k) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return left;
    }
}
// @lc code=end

