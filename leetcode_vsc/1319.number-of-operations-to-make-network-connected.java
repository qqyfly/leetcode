import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1319 lang=java
 *
 * [1319] Number of Operations to Make Network Connected
 */

/*
 There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

 

Example 1:


Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
Example 2:


Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
 

Constraints:

1 <= n <= 105
1 <= connections.length <= min(n * (n - 1) / 2, 105)
connections[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated connections.
No two computers are connected by more than one cable.
 */

// @lc code=start
class Solution {
    //BFS 29ms
    //UNion Find 7ms 逻辑简单，优选
    
    //先创建visited数组
    //然后每一次的connection遍历，都需要保证至少一个visited 数组被从false改为true
    //由于限制中写明，连接数只会少不会多，因此，方法有效。太少则直接返回-1
    //使用DFS遍历，类似小岛
    //因为是无向图，connection需要正反都来一次

    // 36/36 cases passed (29 ms)
    // Your runtime beats 40.85 % of java submissions
    // Your memory usage beats 48.08 % of java submissions (68.9 MB)
    List<List<Integer>> links;
    boolean[] visited;
    public int makeConnected_dfs(int n, int[][] connections) {
        int ans = 0;
        int conn_count = connections.length;
        if (conn_count < n - 1) return -1;        
        
        links = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0;i < n;i++) {
            links.add(new ArrayList<>());
        }

        for(int i = 0;i < conn_count;i++){
            int[] conn = connections[i];
            links.get(conn[0]).add(conn[1]);  
            links.get(conn[1]).add(conn[0]);  
        }

        for(int i = 0;i < n;i++){
            if (!visited[i]){
                dfs(i);
                ans ++;
            }            
        }

        return ans - 1;
    }

    void dfs(int id){
        if (visited[id]) return;

        visited[id] = true;

        for(int i:links.get(id)){
            dfs(i);
        }
    }

    // 36/36 cases passed (7 ms)
    // Your runtime beats 77.42 % of java submissions
    // Your memory usage beats 90.87 % of java submissions (60.3 MB)
    public int makeConnected_union(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        int uselessCount = 0;
        for(int i = 0;i < connections.length;i++){
            if (uf.find(connections[i][0]) == uf.find(connections[i][1])){
                uselessCount ++;
            }else{
                uf.union(connections[i][0],connections[i][1]);
            }            
        }

        //isolcated targer 
        int it = uf.count - 1;
        if (uselessCount >= it)
            return it;
        else
            return -1;
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

    public int makeConnected(int n, int[][] connections) {
        //return makeConnected_dfs(n, connections);
        return makeConnected_union(n,connections);
    }
}


// @lc code=end

