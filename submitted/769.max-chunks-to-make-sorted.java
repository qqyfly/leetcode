/*
 * @lc app=leetcode id=769 lang=java
 *
 * [769] Max Chunks To Make Sorted
 */

// @lc code=start

//解法:首先寻找局部最大值,然后循环,一直到这个临时最大值==索引数值,就是符合要求的排序数字组合,ans+1
//然后继续往下循环到底即可

// 52/52 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 43.86 % of java submissions (41.4 MB)
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int max = 0;
        int ans = 0;

        for(int i = 0;i < n;++i){
            max = Math.max(max, arr[i]);
            if (max == i) ans ++;
        }
        return ans;
    }
}
// @lc code=end

