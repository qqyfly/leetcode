/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {

    // 51/51 cases passed (225 ms)
    // Your runtime beats 11.33 % of java submissions
    // Your memory usage beats 8.89 % of java submissions (173.8 MB)

    
    //做法:首先构建PQ,PQ放入元素和索引
    //填入数据,然后堆顶是最大值
    //然后pop出去的时候,判断堆顶的index是否满足要求,不满足就一直pop,一直到满足要求为止
    //赋值,然后循环
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            //这是前一个
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
// @lc code=end

