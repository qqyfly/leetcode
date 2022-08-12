/*
 * @lc app=leetcode id=1282 lang=java
 *
 * [1282] Group the People Given the Group Size They Belong To
 */

// @lc code=start
class Solution {

    //题解:hashmap  groupsize <->userid
    //然后for循环赋值
    // 103/103 cases passed (14 ms)
    // Your runtime beats 22.56 % of java submissions
    // Your memory usage beats 29.66 % of java submissions (54.3 MB)
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < groupSizes.length;i++){
            List<Integer> list = map.getOrDefault(groupSizes[i],new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i],list);
        }

        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> keys = map.keySet();
        for(int key:keys){            
            List<Integer> values = map.get(key);
            int index = 0;                    
            while(index < values.size()){
                List<Integer> l = new ArrayList<>();
                int idx = 0;
                while(idx < key){
                    l.add(values.get(index));
                    idx ++;
                    index ++;
                }
                ans.add(l);
            }            
        }

        return ans;

    }
}
// @lc code=end

