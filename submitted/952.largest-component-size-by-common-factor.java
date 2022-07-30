/*
 * @lc app=leetcode id=952 lang=java
 *
 * [952] Largest Component Size by Common Factor
 */

// @lc code=start

//解法：是哦嗯GCD对比太慢
// 因此改方法为：uf的大小为数组最大元素的大小，即1->max
// 此时将每个元素可以整除的数字都uf.union
// 还有一点就是不是n*n，第二种for的循环数值是i*i < 第一组循环数值，将其可能的因子都进行union

//最后判断有同一个祖先的元素个数，返回最大的那个即可

// 108/108 cases passed (197 ms)
// Your runtime beats 92.49 % of java submissions
// Your memory usage beats 92.96 % of java submissions (49.7 MB)

class Solution {
    public int largestComponentSize(int[] nums) {
        int m = Arrays.stream(nums).max().getAsInt();
        UnionFind uf = new UnionFind(m + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }
        int[] counts = new int[m + 1];
        int ans = 0;
        for (int num : nums) {
            int root = uf.find(num);
            counts[root]++;
            ans = Math.max(ans, counts[root]);
        }
        return ans;
    }

   
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
        return true;       
    }
    

}
// @lc code=end

