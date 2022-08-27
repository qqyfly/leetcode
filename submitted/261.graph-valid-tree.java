/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree 会员题
 */


class Solution {
    //UF
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge :edges){
            int x = edge[0];
            int y = edge[1];
            
            if (!uf.union(x,y)){
                return false;
            }                        
        }
        return uf.count == 1;
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
        count --;
        return true;       
    }
    

}
