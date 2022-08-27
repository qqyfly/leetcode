/*
 * @lc app=leetcode id=1579 lang=java
 *
 * [1579] Remove Max Number of Edges to Keep Graph Fully Traversable
 */

// @lc code=start
class Solution {
    //做法： UF
    //需要注意，倒序edges,先处理3,然后才能得到对的答案
    
    // 84/84 cases passed (45 ms)
    // Your runtime beats 45.22 % of java submissions
    // Your memory usage beats 17.62 % of java submissions (142.4 MB)
    public int maxNumEdgesToRemove(int n, int[][] edges) {

        Arrays.sort(edges,(a,b)->(a[0]-b[0]));
        UnionFind alice = new UnionFind(n + 1);
        UnionFind bob = new UnionFind(n + 1);
        int edgeCount = edges.length;

        int ans = 0;

        for(int i = edgeCount -1;i >=0;i--){
            int[] edge = edges[i];

            int type = edge[0];
            int start = edge[1];
            int end = edge[2];

            if (type == 1){
                if(!alice.union(start,end)){
                    ans ++;
                }
            }else if (type == 2){
                if(!bob.union(start,end)){
                    ans ++;
                }
            }else{ //type == 3
                boolean b1 = alice.union(start,end);
                boolean b2 = bob.union(start,end);
                if (!b1 && !b2){
                    ans ++;
                }
            }            
        }
        if (alice.count != 2 || bob.count != 2){
            return -1;
        }
        return ans;


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

        public boolean union(int index1, int index2){
            int x = find(index1);
            int y = find(index2);
            if (x == y) return false;
            
            parent[y] = x;
            count --;
            return true;       
        }
        

    }
}
// @lc code=end

