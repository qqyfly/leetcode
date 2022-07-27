/**
Given an integer array nums which is sorted in ascending order and all of its elements are unique 
and given also an integer k, return the kth missing number starting from the leftmost number of the array.

Example 1:

Input: nums = [4,7,9,10], k = 1
Output: 5
Explanation: The first missing number is 5.
Example 2:

Input: nums = [4,7,9,10], k = 3
Output: 8
Explanation: The missing numbers are [5,6,8,...], hence the third missing number is 8.
Example 3:

Input: nums = [1,2,4], k = 3
Output: 6
Explanation: The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 
Constraints:

1 <= nums.length <= 5 * 104
1 <= nums[i] <= 107
nums is sorted in ascending order, and all the elements are unique.
1 <= k <= 108

*/

class Solution {

    // 算法：
    // 1.线性
    // 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    // 内存消耗：48.8 MB, 在所有 Java 提交中击败了26.59%的用户
    // 通过测试用例：37 / 37
    //
    // TODO：2.二分 
    
    //算法解析：最主要是计算missing数，使用函数实现
    //使用满足条件的最后一个missing函数返回的数值

    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        // If kth missing number is larger than 
        // the last element of the array
        if (k > missing(n - 1, nums))
            return nums[n - 1] + k - missing(n - 1, nums);

        int idx = 1;
        // find idx such that 
        // missing(idx - 1) < k <= missing(idx)
        while (missing(idx, nums) < k) idx++;

        // kth missing number is larger than nums[idx - 1]
        // and smaller than nums[idx]
        return nums[idx - 1] + k - missing(idx - 1, nums);
    }

    // Return how many numbers are missing until nums[idx]
    int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }    
}
