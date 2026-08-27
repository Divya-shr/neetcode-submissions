# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1, l2):

        dummy = ListNode(0)
        curr = dummy

        carry = 0

        while l1 or l2 or carry:

            # Get digits, using 0 if a list is finished
            digit1 = l1.val if l1 else 0
            digit2 = l2.val if l2 else 0

            # Add the digits and carry
            total = digit1 + digit2 + carry

            # Current digit
            digit = total % 10

            # Carry for next position
            carry = total // 10

            # Create the new node
            curr.next = ListNode(digit)
            curr = curr.next

            # Move through the input lists
            if l1:
                l1 = l1.next

            if l2:
                l2 = l2.next

        return dummy.next