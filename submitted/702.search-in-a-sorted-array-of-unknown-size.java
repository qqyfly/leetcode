/*
This is an interactive problem.

You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:

returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
returns 231 - 1 if the i is out of the boundary of the array.
You are also given an integer target.

Return the index k of the hidden array where secret[k] == target or return -1 otherwise.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: secret = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in secret and its index is 4.
Example 2:

Input: secret = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in secret so return -1.
 

Constraints:

1 <= secret.length <= 104
-104 <= secret[i], target <= 104
secret is sorted in a strictly increasing order.
 */


//执行用时：2 ms, 在所有 Java 提交中击败了75.75%的用户
//内存消耗：42 MB, 在所有 Java 提交中击败了97.39%的用户
//通过测试用例：47 / 47

/**
 *  This is ArrayReader's API interface.
 *  You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 //BS
class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int r = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        while(l <= r){
            int m = l + (r - l) / 2;
            int val = reader.get(m);
            if (val == target){
                return m;
            }
            if (val == max){
                r = m - 1;
            }else if (val > target){
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return -1;
    }
}