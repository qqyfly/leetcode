/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {

    //解法:建立两个pq,一个从小到大,一个从大到小
    
    //新数进来时,判断两个pq长度,如果一致,则要删除一方数据添加到另一方,再加新数
    
    // 21/21 cases passed (183 ms)
    // Your runtime beats 64.44 % of java submissions
    // Your memory usage beats 39.27 % of java submissions (125.4 MB)
    PriorityQueue<Integer> l = new PriorityQueue<>((a,b)->b-a);//顶端为最大
    PriorityQueue<Integer> r = new PriorityQueue<>((a,b)->a-b);//顶端为最小

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        int s1 = l.size(), s2 = r.size();
        if (s1 == s2) {
            if (r.isEmpty() || num <= r.peek()) {
                l.add(num);
            } else {
                l.add(r.poll());
                r.add(num);
            }
        } else {
            if (l.peek() <= num) {
                r.add(num);
            } else {
                r.add(l.poll());
                l.add(num);
            }
        }
    }
    
    public double findMedian() {
        int s1 = l.size(), s2 = r.size();
        if (s1 == s2) {
            return (l.peek() + r.peek()) / 2.0;
        } else {
            return l.peek();
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

