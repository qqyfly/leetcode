import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //BFS
    // 22/22 cases passed (69 ms)
    // Your runtime beats 6.07 % of java submissions
    // Your memory usage beats 11.29 % of java submissions (43.9 MB)

    //去掉一层for循环
    // 22/22 cases passed (26 ms)
    // Your runtime beats 91.59 % of java submissions
    // Your memory usage beats 82.44 % of java submissions (42.7 MB)
    public Node cloneGraph(Node node) {

        if (node == null) {
            return node;
        }

        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node ans;
        queue.add(node);
        map.put(node, new Node(node.val, new ArrayList()));

        while(!queue.isEmpty()){
            //int size = queue.size();
            //for(int i = 0;i < size; i++){
                Node np = queue.poll();

                for(Node neighbor: np.neighbors){
                    if (!map.containsKey(neighbor)) {
                        // 如果没有被访问过，就克隆并存储在哈希表中
                        map.put(neighbor, new Node(neighbor.val, new ArrayList()));
                        // 将邻居节点加入队列中
                        queue.add(neighbor);
                    }
                    // 更新当前节点的邻居列表
                    if (!map.get(np).neighbors.contains(map.get(neighbor))){
                        map.get(np).neighbors.add(map.get(neighbor));
                    }
                    
                }
            //}
        }

        return map.get(node);

    }
}
// @lc code=end

