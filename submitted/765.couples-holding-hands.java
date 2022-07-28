/*
 * @lc app=leetcode id=765 lang=java
 *
 * [765] Couples Holding Hands
 */


 /*
There are n couples sitting in 2n seats arranged in a row and want to hold hands.

The people and seats are represented by an integer array row where row[i] is the ID of the person sitting in the ith seat. The couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2n - 2, 2n - 1).

Return the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

 

Example 1:

Input: row = [0,2,1,3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
Example 2:

Input: row = [3,2,0,1]
Output: 0
Explanation: All couples are already seated side by side.
 

Constraints:

2n == row.length
2 <= n <= 30
n is even.
0 <= row[i] < 2n
All the elements of row are unique.
  */
// @lc code=start

//Union Find
// 56/56 cases passed (1 ms)
// Your runtime beats 63.51 % of java submissions
// Your memory usage beats 57.97 % of java submissions (41.6 MB)
//做法：
//首先求出情侣数量 int N = len / 2; 
//初始化unionfind(N)
//对于[0,2,1,3],则处理如下，如果第一对 [0,2]->[0,1]组合并，会导致unionfind情侣数量-1
//对于第二对[1,3]->[0,1] 组合并，由于前面已经合并，因此，unionfind count 不动

//而对于[3,2,0,1]，第一对3,2 -> 1,1 -> 1,1合并，不动
//0,1- 0，0  -> 00合并，不动

//因此结果是N - count

// 56/56 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 87.53 % of java submissions (40 MB)

class Solution {
    public int minSwapsCouples(int[] row) {
        int len = row.length;        
        int N = len / 2;       

        UnionFind uf = new UnionFind(N);

        for (int i = 0; i < len; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return N - uf.count;
    }


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
// @lc code=end

