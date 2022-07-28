import java.util.HashMap;

/*
 * @lc app=leetcode id=990 lang=java
 *
 * [990] Satisfiability of Equality Equations
 */

/*
You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.

 

Example 1:

Input: equations = ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.
Example 2:

Input: equations = ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 

Constraints:

1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] is a lowercase letter.
equations[i][1] is either '=' or '!'.
equations[i][2] is '='.
equations[i][3] is a lowercase letter.
 */

// @lc code=start
class Solution {
    //Union-Find   

    //思路：Union-find
    //先合并，然后在判断是否是同一父亲
    // 181/181 cases passed (2 ms)
    // Your runtime beats 67.54 % of java submissions
    // Your memory usage beats 36.91 % of java submissions (42.7 MB)
    
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        
        for(String eq:equations){            
            int index1 = eq.charAt(0) - 'a';
            char op = eq.charAt(1);
            int index2 = eq.charAt(3) - 'a';
            if (op == '='){
                uf.union(index1, index2);
            }
        }

                
        for(String eq:equations){            
            int index1 = eq.charAt(0) - 'a';
            char op = eq.charAt(1);
            int index2 = eq.charAt(3) - 'a';
            if (op == '!'){
                if (uf.find(index1) == uf.find(index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    class UnionFind{
        int[] parent;
        
        UnionFind(int n){
            parent = new int[n];
            for(int i = 0;i < n;i++){
                parent[i] = i;
            }            
        }

        public int find(int index){
            if (parent[index] != index){
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }

        public void union(int index1, int index2){
            int x = find(index1);
            int y = find(index2);
            if (x == y) return;
            parent[y] = x;
        }
    }
}
// @lc code=end

