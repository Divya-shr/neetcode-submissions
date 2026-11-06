# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        stack = [(root,root)]
        while stack:
            a,b = stack.pop()
            if a is None or b is None:
                if a is not b: return False
                continue
            if a.val != b.val: return False
            stack.append((a.left,b.right)); stack.append((a.right,b.left))
        return True
