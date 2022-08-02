/*
Given an m x n matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows.

If there is no common element, return -1.

 

Example 1:

Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
Output: 5
Example 2:

Input: mat = [[1,2,3],[2,3,4],[2,3,5]]
Output: 2
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 104
mat[i] is sorted in strictly increasing order.
 */

// 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：62.1 MB, 在所有 Java 提交中击败了70.30%的用户
// 通过测试用例：12 / 12
 //题解:首先遍历第一行,然后对每一行都进行bs处理,都找到就是第一行的这个元素
class Solution {

    public int smallestCommonElement(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for (int j = 0; j < m; ++j) {
            boolean found = true;
            for (int i = 1; i < n && found; ++i) {
                found = found && Arrays.binarySearch(mat[i], mat[0][j]) >= 0;
            }
            if (found) {
                return mat[0][j];
           }
        }
        return -1;
    }
}