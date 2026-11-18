# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        tail, current, total = dummy, head.next, 0
        while current:
            if current.val == 0:
                tail.next = ListNode(total)
                tail = tail.next
                total = 0
            else:
                total += current.val
            current = current.next
        return dummy.next
