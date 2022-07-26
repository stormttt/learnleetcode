# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# 双指针
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = head
        pre = None
        while(cur != None):
            tmp = cur.next
            cur.next = pre
            pre = cur
            cur = tmp
        return pre

# 递归
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def reverse(pre,cur):
            if cur == None:
                return pre
            tmp = cur.next
            cur.next = pre
            return reverse(cur,tmp)
        return reverse(None,head)
