import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */


// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6
// Example 2:

// Input: lists = []
// Output: []
// Example 3:

// Input: lists = [[]]
// Output: []
 

// Constraints:

// k == lists.length
// 0 <= k <= 104
// 0 <= lists[i].length <= 500
// -104 <= lists[i][j] <= 104
// lists[i] is sorted in ascending order.
// The sum of lists[i].length will not exceed 104.




// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


// 133/133 cases passed (2 ms)
// Your runtime beats 98.47 % of java submissions
// Your memory usage beats 90.12 % of java submissions (44.2 MB)
class Solution {
    //使用Queue实现
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists.length == 0) return null;
        
        Queue<ListNode> queue = new LinkedList<>();

        for(int i = 0;i < lists.length;i++){            
            queue.offer(lists[i]);
        }

        while(queue.size() > 1){

            ListNode head1 = queue.poll();
            ListNode head2 = queue.poll();

            ListNode newDummyHead = new ListNode(0);
            ListNode newNode = newDummyHead;

            while(head1 != null || head2 != null){
                if (head1 != null && head2 != null){
                    if (head1.val <= head2.val){                        
                        newNode.next = head1;
                        head1 = head1.next;
                    }else{
                        newNode.next = head2;
                        head2 = head2.next;
                    }
                }else if (head1 != null && head2 == null){
                    newNode.next = head1;
                    head1 = head1.next;
                }else{//head1 == null && head2 != null
                    newNode.next = head2;
                    head2 = head2.next;
                }
                newNode = newNode.next;                
            }
            queue.add(newDummyHead.next);
        }
        return queue.poll();        
    }
}
// @lc code=end


