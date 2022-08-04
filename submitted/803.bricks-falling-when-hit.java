/*
 * @lc app=leetcode id=803 lang=java
 *
 * [803] Bricks Falling When Hit
 */

// @lc code=start
class Solution {

    //并查集

    //首先复制一个grid
    //然后删除被hit掉的,将顶层全部进uf
    //然后为1的全部走一遍
    //此时需要创建一个roof节点,可选0(后续数组1开始) 或者m*n 最后节点作为roof
    //然后逆序加入已经被hit掉的节点,然后判断加入前后的roof群的节点个数差
    //节点差 - 1 就是答案
    //鉴于前后差别是0,因此此处需要max

    // 40/40 cases passed (21 ms)
    // Your runtime beats 81.95 % of java submissions
    // Your memory usage beats 85.96 % of java submissions (59.4 MB)
    public final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m,n;

    public int[] hitBricks(int[][] grid, int[][] hits) {

        m = grid.length;
        n = grid[0].length;

        int[][] copy = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                copy[i][j] = grid[i][j];
            }
        }

        int roof = m * n;

        UnionFind uf = new UnionFind(m * n + 1);
        
        //全部打掉
        for(int i = 0;i < hits.length; i++){
            copy[hits[i][0]][hits[i][1]] = 0;
        }

        //增加一点m*n,作为顶点,其他节点从0开始
        
        //第一层符合条件进uf
        for(int j = 0;j < n; j++){
            if (copy[0][j] == 1){
                uf.union(roof, j);
            }
        }
        
        //下层元素 如果相连进UF       
        for(int i = 1;i < m; i++){
            for(int j = 0;j < n; j++){
                if (copy[i][j] == 1){
                    if (j - 1 >= 0 && copy[i][j-1] == 1){
                        uf.union(i * n + j - 1, i * n + j);
                    }
                
                    if (copy[i-1][j] == 1){
                        uf.union((i-1) * n + j,i * n + j);
                    }
                }            
            }
        }

        //逆序补回
        int hitsLen = hits.length;
        int[] ans = new int[hitsLen];

        for(int i = hits.length - 1;i>=0;i--){
            int x = hits[i][0];
            int y = hits[i][1];

            if (grid[x][y] == 0) {
                continue;
            }
            
            int origin = uf.getSize(roof);
            if (x == 0) {
                uf.union(roof,y);
            }

            // 在 4 个方向上看一下，如果相邻的 4 个方向有砖块，合并它们
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (inArea(newX, newY) && copy[newX][newY] == 1) {
                    uf.union(getIndex(x, y), getIndex(newX, newY));
                }
            }

            // 补回之后与屋顶相连的砖块数
            int current = uf.getSize(roof);

            ans[i] = Math.max(0, current - origin - 1);

            copy[x][y] = 1;
        }    
        return ans;    
    }

    boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    int getIndex(int x, int y) {
        return x * n + y;
    }

    class UnionFind{
        int[] parent;
        int[] size;
    
        UnionFind(int n){
            parent = new int[n];   
            size  = new int[n];   
            for(int i = 0;i < n; i++){
                parent[i] = i;
                size[i] = 1;
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
            size[x] += size[y];
            return true;       
        }
    
        public int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }
}



// @lc code=end

