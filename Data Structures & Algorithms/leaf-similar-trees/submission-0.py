# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        def leaves(root):
            out=[]; stack=[root]
            while stack:
                node=stack.pop()
                if node.left is None and node.right is None: out.append(node.val)
                if node.right: stack.append(node.right)
                if node.left: stack.append(node.left)
            return out
        return leaves(root1)==leaves(root2)
