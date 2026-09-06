class Solution:
    def rotateRight(self, head: 'ListNode', k: int) -> 'ListNode':
        if head is None or head.next is None or k == 0:
            return head

        length = 1
        tail = head

        while tail.next:
            tail = tail.next
            length += 1

        k %= length

        if k == 0:
            return head

        # Make the list circular
        tail.next = head

        # Find the new tail
        steps = length - k - 1
        new_tail = head

        for _ in range(steps):
            new_tail = new_tail.next

        new_head = new_tail.next

        # Break the circle
        new_tail.next = None

        return new_head