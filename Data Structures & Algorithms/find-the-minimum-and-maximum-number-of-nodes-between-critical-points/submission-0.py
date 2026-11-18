# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        previous, current = head, head.next
        index, first, last, minimum = 1, -1, -1, 100000
        while current.next:
            value = current.val
            if (value > previous.val and value > current.next.val) or (
                value < previous.val and value < current.next.val
            ):
                if last != -1:
                    minimum = min(minimum, index - last)
                if first == -1:
                    first = index
                last = index
            previous, current = current, current.next
            index += 1
        return [-1, -1] if first == last else [minimum, last - first]
