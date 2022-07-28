/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

 /*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]

  */
// @lc code=start

//ALL METHODS DONE
//DFS
//UNION-FIND

class Solution {

    //DFS
    // 113/113 cases passed (1 ms)
    // Your runtime beats 99.97 % of java submissions
    // Your memory usage beats 6.59 % of java submissions (54.9 MB)
    // 对新建的数组进行循环，而不是对isConnected 进行循环，切记
    public int findCircleNum_dfs(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, n, i);
                provinces++;
            }
        }
        return provinces;        
    }
    
    private void dfs(int[][] isConnected,boolean[] visited,int cities, int i){
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, cities, j);
            }
        }
    }  
    
    // 113/113 cases passed (1 ms)
    // Your runtime beats 99.97 % of java submissions
    // Your memory usage beats 84.57 % of java submissions (43.5 MB)
    public int findCircleNum_unionfind(int[][] isConnected) {

        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getProvinceNum();
    }


    public int findCircleNum(int[][] isConnected) {
        //return findCircleNum_dfs(isConnected);
        return findCircleNum_unionfind(isConnected);
    }
}

class UnionFind{
    int[] parent;
    int provinces;

    UnionFind(int n){
        provinces = n;
        parent = new int[n];
        for(int i = 0;i < n;i++){
            parent[i] = i;
        }        
    }

    public void union(int index1,int index2){
        int x = find(index1);
        int y = find(index2);

        if (x == y) return;
        parent[y] = x;
        provinces --;
    }

    public int find(int index){
        if (parent[index] != index){
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }

    public int getProvinceNum(){
        return provinces;
    }
}
// @lc code=end

