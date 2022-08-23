import java.util.HashMap;

/*
 * @lc app=leetcode id=405 lang=java
 *
 * [405] Convert a Number to Hexadecimal
 */

// @lc code=start
class Solution {

    // 100/100 cases passed (3 ms)
    // Your runtime beats 32.13 % of java submissions
    // Your memory usage beats 80.08 % of java submissions (40.9 MB)

    // 100/100 cases passed (0 ms)
    // Your runtime beats 100 % of java submissions
    // Your memory usage beats 12.08 % of java submissions (42.2 MB)
    public String toHex(int num) {
        /*
        HashMap<String,Character> map = new HashMap<>();
        map.put("0000", '0');
        map.put("0", '0');
        map.put("0001", '1');
        map.put("1", '1');
        map.put("0010", '2');
        map.put("10", '2');
        map.put("0011", '3');
        map.put("11", '3');
        map.put("0100", '4');
        map.put("100", '4');
        map.put("0101", '5');
        map.put("101", '5');
        map.put("0110", '6');
        map.put("110", '6');
        map.put("0111", '7');
        map.put("111", '7');
        map.put("1000", '8');
        map.put("1001", '9');
        map.put("1010", 'a');
        map.put("1011", 'b');
        map.put("1100", 'c');
        map.put("1101", 'd');
        map.put("1110", 'e');
        map.put("1111", 'f');
 */
        StringBuffer sb = new StringBuffer();
        char[] digits = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        if (num == 0){ return "0"; }
        long longnum = num;
        if(num < 0) longnum = (long)(Math.pow(2, 32) + longnum);
                
        while(longnum != 0){
            int remaining = (int)(longnum % 16) ;
            longnum = longnum / 16;
            sb.append(digits[remaining]);
        }

        sb = sb.reverse();
        return sb.toString();


        
       /* String s = Integer.toBinaryString(num);
                        
        int len = s.length();
        int index = len - 1;

        while(index >= 0) {
            StringBuffer tmp = new StringBuffer();

            if (index  - 3 >= 0){
                String tmpStr = tmp.append(s.charAt(index - 3)).
                                    append(s.charAt(index - 2)).
                                    append(s.charAt(index - 1)).
                                    append(s.charAt(index)).toString();
                sb.append(map.get(tmpStr));
                index -= 4;
            }else{
                while(index >= 0){
                    tmp.append(s.charAt(index--));
                }
                tmp = tmp.reverse();
                String tmpStr = tmp.toString();
                sb.append(map.get(tmpStr));  
                
            }
           
        }
        sb = sb.reverse();
        return sb.toString();
         */
    }

}
// @lc code=end


class App {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis(); 
        
        //--------CODE 🡃------------
        Solution sol = new Solution();
        sol.toHex(-2);
        
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