# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head):
        prev = None
        curr = head

        while curr:
            # Save the next node
            next_node = curr.next

            # Reverse the pointer
            curr.next = prev

            # Move prev forward
            prev = curr

            # Move curr forward
            curr = next_node

        return prev