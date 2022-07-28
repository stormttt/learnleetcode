/*
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
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
//双指针
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // move fast to nth node 
        while(n>0){
            fast = fast.next;
            n = n - 1;
        }
        // move fast to end and slow move same steps with fast
        // save the (n-1)th node
        ListNode tmp = null;
        while(fast != null){
            tmp = slow;
            fast = fast.next;
            slow = slow.next;
        }
        tmp.next = slow.next;
        // mei bi yao
        slow.next = null;

        return dummy.next;
    }
}