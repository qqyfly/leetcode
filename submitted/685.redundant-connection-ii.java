/*
 * @lc app=leetcode id=685 lang=java
 *
 * [685] Redundant Connection II
 */

// @lc code=start

class Solution {

    //此题分为
    //1： 有入度为2的点 （需要删除某一条入边,并且判断删除后是否正确）
    //2： 有环

    //其中入度为2是此题新加出来的，（相比教684）
    
    //题目要求只要删除一条边即可，因此，入度最大为2


    // 55/55 cases passed (2 ms)
    // Your runtime beats 54.35 % of java submissions
    // Your memory usage beats 83.27 % of java submissions (43.8 MB)
    int n = 0;
    int[][] edges;
    public int[] findRedundantDirectedConnection(int[][] _edges) {
        edges = _edges;
        n = edges.length;   // 节点个数=边数目
        // 入度数组
        int[] inDegree = new int[n + 1];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        // 查找入度为2的节点,并把对应的边索引装进集合(倒序遍历)->list[0]就是后面的边
        List<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {  // 边的索引0~n-1
            if (inDegree[edges[i][1]] == 2) {   // 某条边的指向对应入度为2,说明改变有指向入度为2的节点
                list.add(i);    // 该边索引加入list
            }
        }

        // 说明有两条入度为2的边->情况1
        if (!list.isEmpty()) {
            // 判断删除该边之后是否为有根树
            if (isTree(list.get(0))) {
                return edges[list.get(0)];
            } else {
                return edges[list.get(1)];
            }
        }

        // 成环->情况2
        return edges[getEdge()];

    }

    // 删除索引为k的边之后是否还为有根树
    private boolean isTree(int k) {
        UnionFind uf = new UnionFind(n+1);
        for (int i = 0; i < n; i++) {
            // 删除了索引为k的边
            if (i == k) continue;
            if (!uf.same(edges[i][0], edges[i][1])) {
                uf.union(edges[i][0], edges[i][1]);
            } else {
                // 出现冗余连接->不是有根树
                return false;
            }
        }
        // 没有冗余连接则为有根树
        return true;
    }
    
    // 获取删除后不成环的边索引
    public int getEdge() {
        UnionFind uf = new UnionFind(n+1);
        for (int i = 0; i < n; i++) {
            if (!uf.same(edges[i][0], edges[i][1])) {
                uf.union(edges[i][0], edges[i][1]);
            } else {
                return i;
            }
        }
        return 0;
    }


    class UnionFind{
        int[] parent;        
        int count;

        UnionFind(int n){
            parent = new int[n];                        
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

        public boolean same(int index1, int index2){
            return find(index1) == find(index2);
        }

        public boolean union(int index1, int index2){
            int x = find(index1);
            int y = find(index2);
            if (x == y) return false;
            
            parent[y] = x;
            return true;       
        }
        

    }
}
// @lc code=end

