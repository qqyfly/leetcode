import java.util.Deque;

/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 */

// @lc code=start
class MyCircularDeque {

    // 51/51 cases passed (10 ms)
    // Your runtime beats 19.12 % of java submissions
    // Your memory usage beats 11.06 % of java submissions (49 MB)
    Deque<Integer> dq;
    int cap = 0;
    
    public MyCircularDeque(int k) {
        dq = new LinkedList<>();
        this.cap = k;                
    }
    
    public boolean insertFront(int value) {
        if (dq.size() == cap) return false;
        dq.addFirst(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if (dq.size() == cap) return false;
        dq.addLast(value);
        return true;
    }
    
    public boolean deleteFront() {
        if (!dq.isEmpty()){
            dq.pollFirst();
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() {
        if (!dq.isEmpty()){
            dq.pollLast();
            return true;
        }
        return false;
    }
    
    public int getFront() {
        if (!dq.isEmpty()){
            return dq.peekFirst();            
        }
        return -1;
    }
    
    public int getRear() {
        if (!dq.isEmpty()){
            return dq.peekLast();            
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return dq.isEmpty();
    }
    
    public boolean isFull() {
        return dq.size() == cap;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

