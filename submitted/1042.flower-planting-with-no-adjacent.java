/*
 * @lc app=leetcode id=1042 lang=java
 *
 * [1042] Flower Planting With No Adjacent
 */

// @lc code=start
class Solution {

    // 思路:
    // 首先创建map.主键id,value为邻居颜色集合
    // 然后初始map.给每个做path
    // 查看每个节点邻居,没有上色就上一个符合要求的颜色

    // 51/51 cases passed (13 ms)
    // Your runtime beats 95.96 % of java submissions
    // Your memory usage beats 82.5 % of java submissions (65.6 MB)
    public int[] gardenNoAdj1(int N, int[][] paths) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }
        /* 初始化路径信息 */
        for (int[] path: paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];
            /* 查看当前节点的所有邻接点的色彩 */
            for (int adj: graph.get(i)) {
                used[res[adj]] = true;
            }
            /* 为当前节点染色 */
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    res[i] = j;
                }
            }
        }
        return res;
    }
    // 数组版本
    // 51/51 cases passed (12 ms)
    // Your runtime beats 97.31 % of java submissions
    // Your memory usage beats 81.35 % of java submissions (66.6 MB)
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[][] topo = new int[N+1][3] ;
        for( int[] cur : paths ){
            int temp = 0 ;
            while( topo[cur[0]][temp] != 0 ) temp++ ;
            topo[cur[0]][temp] = cur[1] ;
            temp = 0 ;
            while( topo[cur[1]][temp] != 0 ) temp++ ;
            topo[cur[1]][temp] = cur[0] ;
        }
        int[] res1 = new int[N+1] ;
        int[] res = new int[N] ;
        for( int i = 1 ; i <= N ; i++ ){
            int temp = 1 ;
            while( res1[topo[i][0]] == temp || res1[topo[i][1]] == temp || res1[topo[i][2]] == temp ) temp++ ;
            res1[i] = temp ;
        }

        for( int i = 0 ; i < N ; i++ ) res[i] = res1[i+1] ;
        return res ;
    }
}
// @lc code=end

