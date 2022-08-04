/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 */

// @lc code=start
class Solution {
    //题解:数组元素进set,然后判断1-n的数字是否包含即可
    // 33/33 cases passed (20 ms)
    // Your runtime beats 31.01 % of java submissions
    // Your memory usage beats 87.35 % of java submissions (51.3 MB)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++ ){
            if (!set.contains(i + 1)){
                list.add(i + 1);
            }
        }
        return list;
    }
}
// @lc code=end

