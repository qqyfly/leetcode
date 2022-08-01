/*
 * @lc app=leetcode id=778 lang=java
 *
 * [778] Swim in Rising Water
 */

 /*
You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

 

Example 1:


Input: grid = [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.
Example 2:


Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation: The final route is shown.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 50
0 <= grid[i][j] < n2
Each value grid[i][j] is unique.
  */
// @lc code=start


//Union-Find
//Disjoint 
// 43/43 cases passed (9 ms)
// Your runtime beats 89.84 % of java submissions
// Your memory usage beats 75.81 % of java submissions (44.6 MB)
class Solution {
    private int N;
    public  int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        this.N = grid.length;
        int len = N * N;
        int[] index = new int[len];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                index[grid[i][j]] = getIndex(i, j);
            }
        }
        
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            int x = index[i] / N;
            int y = index[i] % N;

            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && grid[newX][newY] <= i) {
                    unionFind.union(index[i], getIndex(newX, newY));
                }

                if (unionFind.find(0) == unionFind.find(len - 1)){
                    return i;
                }
                
            }
        }
        return -1;
    }

    

    private int getIndex(int x, int y) {
        return x * N + y;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    

}

class UnionFind{
    int[] parent;
    int[] rank;
    int count;

    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(this.rank, 1);        
        count = n;
        for(int i = 0;i < n; i++){
            parent[i] = i;
        }
    }

    public int find(int index){
        if (parent[index] != index){
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }

    public boolean union(int index1, int index2){
        int x = find(index1);
        int y = find(index2);
        if (x == y) return false;

        if (rank[x] < rank[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        rank[x] += rank[y];
        parent[y] = x;
        return true;       
    }
    

}
// @lc code=end

