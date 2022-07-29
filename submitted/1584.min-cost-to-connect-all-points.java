import java.util.ArrayList;

/*
 * @lc app=leetcode id=1584 lang=java
 *
 * [1584] Min Cost to Connect All Points
 */
/*
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

 

Example 1:


Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: 

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18
 

Constraints:

1 <= points.length <= 1000
-106 <= xi, yi <= 106
All pairs (xi, yi) are distinct.
 */
// @lc code=start


//方法：Union-Find （Kruskal 算法）

// 72/72 cases passed (646 ms)
// Your runtime beats 39.44 % of java submissions
// Your memory usage beats 57.01 % of java submissions (108.2 MB)

class Edge {
    int x; // Point 1
    int y;   // Point 2
    int len;   // Length

    public Edge(int x, int y,int len) {
        this.len = len;
        this.x = x;
        this.y = y;
    }
};

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

class Solution {

    public int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    public int minCostConnectPoints_unionfind(int[][] points) {        
        int n = points.length;

        UnionFind uf = new UnionFind(n);
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j,dist(points, i, j)));
            }
        }        

        Collections.sort(edges,(a,b)->a.len-b.len);

        int ans = 0, num = 1;

        for (Edge edge : edges) {
            int len = edge.len, x = edge.x, y = edge.y;
            if (uf.union(x, y)) {
                ans += len;
                num++;
                if (num == n) {
                    break;
                }
            }
        }

        return ans;
    }

    public int minCostConnectPoints(int[][] points) {
        return minCostConnectPoints_unionfind(points);        
    }
}
// @lc code=end

