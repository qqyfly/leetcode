import java.util.HashSet;

/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */
/*
In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 

Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
 

Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected.
 */


// @lc code=start
class Solution {
    //Union-Find
    //注意点：并查集的元素输入的时候是从0->n-1,因此外部合并的时候需要-1
    // 39/39 cases passed (2 ms)
    // Your runtime beats 41.65 % of java submissions
    // Your memory usage beats 20.82 % of java submissions (44.8 MB)

    public int[] findRedundantConnection(int[][] edges) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < edges.length;i++){
            //此处！
            set.add(edges[i][0]-1);
            set.add(edges[i][1]-1);
        }

        int n = set.size();
        
        UnionFind uf = new UnionFind(n);
        
        /* 这个快
        for(int i = 0;i < edges.length;i++){
            int oldCount = uf.count;
            //此处！
            uf.union(edges[i][0]-1, edges[i][1]-1);
            int newCount = uf.count;
            if (oldCount == newCount){
                return edges[i];
            }
        }*/

        for(int i = 0;i < edges.length;i++){
            int oldCount = uf.count;
            //此处！
            if (uf.find(edges[i][0]-1) != uf.find(edges[i][1]-1)){
                uf.union(edges[i][0]-1, edges[i][1]-1);
            }else{
                return edges[i];
            }                                                    
        }

        return new int[]{};
    }
}

class UnionFind{
    int[] parent;
    int count;
    UnionFind(int n){
        parent = new int[n];
        for(int i = 0;i < n; i++){
            parent[i] = i;
        }
        count = n;
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


// @lc code=end
