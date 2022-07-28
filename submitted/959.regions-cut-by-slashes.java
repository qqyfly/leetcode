/*
 * @lc app=leetcode id=959 lang=java
 *
 * [959] Regions Cut By Slashes
 */
/*
An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. These characters divide the square into contiguous regions.

Given the grid grid represented as a string array, return the number of regions.

Note that backslash characters are escaped, so a '\' is represented as '\\'.

 

Example 1:


Input: grid = [" /","/ "]
Output: 2
Example 2:


Input: grid = [" /","  "]
Output: 1
Example 3:


Input: grid = ["/\\","\\/"]
Output: 5
Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
 */
// @lc code=start
class Solution {
    //UNION-FIND
    //LEFT:0 UP:1 RIGHT 2: DOWN:3

    // 137/137 cases passed (5 ms)
    // Your runtime beats 75.34 % of java submissions
    // Your memory usage beats 60.4 % of java submissions (42.4 MB)
    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        int N = 4 * len * len;
        UnionFind uf = new UnionFind(N);
        //inside cell
        int base;
        int index0,index1,index2,index3;

        for(int i = 0;i < len; i++){ // row
            for(int j = 0;j < len;j++){
                base = (i * len + j) * 4;
               
                index0 = base;
                index1 = base + 1;
                index2 = base + 2;
                index3 = base + 3;

                //inside cell
                if (grid[i].charAt(j) == '\\'){                    
                    uf.union(index1, index2);
                    uf.union(index0, index3);
                }else if (grid[i].charAt(j) == '/'){
                    uf.union(index0, index1);
                    uf.union(index2, index3);
                }else{ // ' ' space
                    uf.union(index0, index1);
                    uf.union(index2, index3);
                    uf.union(index1, index2);
                }

                //between cell
                // 向右合并
                if (j + 1 < len) {
                    uf.union(index2, index2 + 2);
                }
                // 向下合并
                if (i + 1 < len) {
                    uf.union(index3, index3 + 4 * len  - 2);
                }
            }
        }

        return uf.count;
    }

    class UnionFind{
        int[] parent;
        int count;
        UnionFind(int n){
            parent = new int[n];
            count = n;
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
            count --;
        }
    }
}
// @lc code=end

