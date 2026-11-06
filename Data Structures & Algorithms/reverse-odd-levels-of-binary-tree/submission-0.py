# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        nodes=[root];level=0
        while nodes:
            if level%2:
                for i in range(len(nodes)//2):nodes[i].val,nodes[-1-i].val=nodes[-1-i].val,nodes[i].val
            nodes=[child for node in nodes for child in (node.left,node.right) if child];level+=1
        return root
