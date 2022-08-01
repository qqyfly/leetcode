/*
Given two integer arrays nums1 and nums2 of length n, count the pairs of indices (i, j) such that i < j and nums1[i] + nums1[j] > nums2[i] + nums2[j].

Return the number of pairs satisfying the condition.

 

Example 1:

Input: nums1 = [2,1,2,1], nums2 = [1,2,1,2]
Output: 1
Explanation: The pairs satisfying the condition are:
- (0, 2) where 2 + 2 > 1 + 1.
Example 2:

Input: nums1 = [1,10,6,2], nums2 = [1,4,1,5]
Output: 5
Explanation: The pairs satisfying the condition are:
- (0, 1) where 1 + 10 > 1 + 4.
- (0, 2) where 1 + 6 > 1 + 1.
- (1, 2) where 10 + 6 > 4 + 1.
- (1, 3) where 10 + 2 > 4 + 5.
- (2, 3) where 6 + 2 > 1 + 5.
 

Constraints:

n == nums1.length == nums2.length
1 <= n <= 105
1 <= nums1[i], nums2[i] <= 105
*/

// 执行用时：52 ms, 在所有 Java 提交中击败了48.94%的用户
// 内存消耗：58.3 MB, 在所有 Java 提交中击败了42.55%的用户
// 通过测试用例：45 / 45
class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        long count = 0;
        int n = nums1.length;
        int[] differences = new int[n];
        for (int i = 0; i < n; i++) {
            differences[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(differences);
        for (int i = 0; i < n - 1; i++) {
            int target = -differences[i] + 1;            
            int index = binarySearch(differences, n, target, i + 1);
            count += n - index;
        }
        return count;
    }

    public int binarySearch(int[] differences, int n, int target, int startIndex) {
        int low = startIndex, high = n - 1;
        if (differences[high] < target) {
            return n;
        }
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (differences[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1 ;
            }
        }
        return low;
    }
}