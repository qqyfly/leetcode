/*
 * @lc app=leetcode id=483 lang=java
 *
 * [483] Smallest Good Base
 */

// @lc code=start
class Solution {

    //BS解法,最大位数为不到64,因此可以穷举,穷举中加BS

    // 108/108 cases passed (34 ms)
    // Your runtime beats 19.44 % of java submissions
    // Your memory usage beats 36.11 % of java submissions (42.5 MB)
    public String smallestGoodBase(String n) {
        
        //将字符串转为long类型
        long num = Long.parseLong(n);
        //求得数位1的最大数量，即转为2进制时对应的数量
        int mMax = (int) Math.ceil(Math.log(num) / Math.log(2));
        for(int i = mMax; i > 1; i--) {
            //二分法查找是否存在对应k进制，第一个找到存在的就是答案
            long left = 2;
            long right = num - 1;
            while(left <= right) {
                long mid = left + (right - left) / 2;
                if(GoodBaseVal(i, mid) == num) return Long.toString(mid);
                //溢出时也说明要找的k进制比当前mid小
                if(GoodBaseVal(i, mid) == -1 || GoodBaseVal(i, mid) > num) right = mid - 1;
                else left = mid + 1;
            }
            
        }
        return "0";
    }

    //求 数位1数量为 n , 进制为 k 时对应的值
    public long GoodBaseVal(int n, long k) {
        long sum = 1;
        long cur = 1;
        for(int i = 1; i < n; i++) {
            //溢出时返回-1
            if(cur * k / k != cur) return -1;
            cur *= k;
            if(sum > Long.MAX_VALUE - cur) return -1;
            sum += cur;
        }
        return sum;
    }
}
// @lc code=end


class App {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis(); 
        
        //--------CODE 🡃------------
        Solution sol = new Solution();
        sol.smallestGoodBase("2251799813685247");
        
        //--------CODE 🡁------------
        long endTime=System.currentTimeMillis(); 
        long totalTime = endTime - startTime;
        if (totalTime >= 1000){
            totalTime /= 1000;
            System.out.println("Total time: " + totalTime + " Seconds");      
        }else{
            System.out.println("Total time: " + totalTime + " ms");      
        }
        
    }
}