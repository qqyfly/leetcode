import java.util.List;

/*
 * @lc app=leetcode id=636 lang=java
 *
 * [636] Exclusive Time of Functions
 */

// @lc code=start
class Solution {

    //解法:
    // 对于一个被中断的任务T1, 以及另一个执行中断的任务T2,当T2开始时,T1的执行时间需要被及时计算,T1结束时间戳要调整到T2开始的时候
    // 当T2结束执行后,T2时间结算完成后,由于T1的时间还未结算,需要将T1的开始时间调整为T2的结束处.

    //此题类似括号,但比括号复杂一些.

    // 120/120 cases passed (13 ms)
    // Your runtime beats 87.51 % of java submissions
    // Your memory usage beats 97.53 % of java submissions (42.7 MB)

    public int[] exclusiveTime(int n, List<String> logs) {

        int[] taskTime = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(String log:logs){
            String[] vals = log.split(":");
            int idx = Integer.parseInt(vals[0]);
            String type  = vals[1];
            int timestamp = Integer.parseInt(vals[2]);

            if ("start".equals(type)) {
                
                if (!stack.isEmpty()) {
                    taskTime[stack.peek()[0]] += timestamp - stack.peek()[1];
                    stack.peek()[1] = timestamp;
                }
                stack.push(new int[]{idx, timestamp});
            }else{ //end                
                int[] result = stack.pop();
                taskTime[result[0]] += timestamp - result[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1;
                }                
            }
        }
        return taskTime;
    }
}
// @lc code=end