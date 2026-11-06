# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        stack=[];current=root;previous=-1;answer=100001
        while current or stack:
            while current:stack.append(current);current=current.left
            current=stack.pop()
            if previous>=0:answer=min(answer,current.val-previous)
            previous=current.val;current=current.right
        return answer
