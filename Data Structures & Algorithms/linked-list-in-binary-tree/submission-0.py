class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        values = []
        while head:
            values.append(head.val)
            head = head.next
        starts = [root]
        while starts:
            start = starts.pop()
            if start is None:
                continue
            starts.extend((start.left, start.right))
            paths = [(start, 0)]
            while paths:
                node, i = paths.pop()
                if node is None or node.val != values[i]:
                    continue
                if i + 1 == len(values):
                    return True
                paths.extend(((node.left, i + 1), (node.right, i + 1)))
        return False
