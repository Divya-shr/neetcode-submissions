# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeKLists(self, lists):
        heap = []

        # Put the first node of every list into the heap
        for i, node in enumerate(lists):
            if node:
                heapq.heappush(heap, (node.val, i, node))

        dummy = ListNode(0)
        curr = dummy

        while heap:
            # Get the smallest node
            value, i, node = heapq.heappop(heap)

            # Add it to the result
            curr.next = node
            curr = curr.next

            # Add the next node from the same list
            if node.next:
                heapq.heappush(heap, (node.next.val, i, node.next))

        return dummy.next