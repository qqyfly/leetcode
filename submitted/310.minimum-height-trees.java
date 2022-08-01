import java.util.Arrays;

/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */
/*
A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

 

Example 1:


Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
Example 2:


Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
 

Constraints:

1 <= n <= 2 * 104
edges.length == n - 1
0 <= ai, bi < n
ai != bi
All the pairs (ai, bi) are distinct.
The given input is guaranteed to be a tree and there will be no repeated edges.
 */
// @lc code=start
class Solution {
    //拓扑排序 ,还是BFS的概念
    // 首先找到连接为1的点进queue,然后循环中删除和这些1点相连的点的连接度，如果为1,则继续进queue
    //最后输出。潜在的意思是 最终点<=2 也就是为2时，不分伯仲，都是最终点

    // 71/71 cases passed (21 ms)
    // Your runtime beats 96.73 % of java submissions
    // Your memory usage beats 70.2 % of java submissions (72.6 MB)
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<Integer>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }

        int[] degree = new int[n];

        List<Integer>[] adj = new List[n];
        
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int remainNodes = n;
        while (remainNodes > 2) {
            int sz = queue.size();
            remainNodes -= sz;
            for (int i = 0; i < sz; i++) {
                int curr = queue.poll();
                for (int v : adj[curr]) {
                    degree[v]--;
                    if (degree[v] == 1) {
                        queue.offer(v);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
        
    }
}
// @lc code=end

