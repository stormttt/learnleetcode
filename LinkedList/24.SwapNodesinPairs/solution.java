/*
 * Given a linked list, swap every two adjacent nodes and return 
 * its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 */


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

 
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = head;
        ListNode prev = dummyNode;
        while(cur != null && cur.next != null){
            //必须使用一个临时node 保证cur.next 最后变化
            ListNode tmp = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = tmp;  
            prev = cur;
            cur = cur.next;
        }

        return dummyNode.next;
        
    }
}