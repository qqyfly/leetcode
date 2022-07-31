/*
 * @lc app=leetcode id=2358 lang=java
 *
 * [2358] Maximum Number of Groups Entering a Competition
 */
/*
You are given a positive integer array grades which represents the grades of students in a university. You would like to enter all these students into a competition in ordered non-empty groups, such that the ordering meets the following conditions:

The sum of the grades of students in the ith group is less than the sum of the grades of students in the (i + 1)th group, for all groups (except the last).
The total number of students in the ith group is less than the total number of students in the (i + 1)th group, for all groups (except the last).
Return the maximum number of groups that can be formed.

 

Example 1:

Input: grades = [10,6,12,7,3,5]
Output: 3
Explanation: The following is a possible way to form 3 groups of students:
- 1st group has the students with grades = [12]. Sum of grades: 12. Student count: 1
- 2nd group has the students with grades = [6,7]. Sum of grades: 6 + 7 = 13. Student count: 2
- 3rd group has the students with grades = [10,3,5]. Sum of grades: 10 + 3 + 5 = 18. Student count: 3
It can be shown that it is not possible to form more than 3 groups.
Example 2:

Input: grades = [8,8]
Output: 1
Explanation: We can only form 1 group, since forming 2 groups would lead to an equal number of students in both groups.
 

Constraints:

1 <= grades.length <= 105
1 <= grades[i] <= 105
 */
// @lc code=start
class Solution {

    //二分
    // 68/68 cases passed (2 ms)
    // Your runtime beats 14.29 % of java submissions
    // Your memory usage beats 85.71 % of java submissions (50.5 MB)
    public int maximumGroups1(int[] grades) {
        List<Integer> list = new ArrayList<>();
        int n = 1;
        while((n*(n+1)/2)<=100000){
            list.add((n*(n+1)/2));
            n++;
        }
        
        int len = grades.length;
        
        int lo=0,hi=list.size()-1;
        
        while(lo<=hi){
            int m = (lo+hi)>>1;
            if(list.get(m) == len) return m+1;
            else if(list.get(m)>len) hi=m-1;
            else lo=m+1;
        }
        return lo;
    }

    // 68/68 cases passed (0 ms)
    // Your runtime beats 100 % of java submissions
    // Your memory usage beats 42.86 % of java submissions (69.8 MB)
    public int maximumGroups(int[] grades) {
        int k = 0, total = 0, n = grades.length;
        while (total + k + 1 <= n)            
            total += ++k;
        return k;
    }

}
// @lc code=end

