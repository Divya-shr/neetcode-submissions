# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeInBetween(self, list1: Optional[ListNode], a: int, b: int, list2: Optional[ListNode]) -> Optional[ListNode]:
        prev = list1
        for _ in range(a-1): prev = prev.next
        current = prev.next
        for _ in range(b-a+1):
            following = current.next
            current.next = None
            current = following
        prev.next = list2
        tail = list2
        while tail.next: tail = tail.next
        tail.next = current
        return list1
