# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        sums=[];nodes=[root]
        while nodes:
            sums.append(sum(node.val for node in nodes))
            nodes=[child for node in nodes for child in (node.left,node.right) if child]
        sums.sort(reverse=True)
        return sums[k-1] if len(sums)>=k else -1
