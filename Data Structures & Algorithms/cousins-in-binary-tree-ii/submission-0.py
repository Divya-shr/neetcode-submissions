# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        root.val=0;level=[root]
        while level:
            following=[child for node in level for child in (node.left,node.right) if child]
            total=sum(child.val for child in following)
            for node in level:
                siblings=(node.left.val if node.left else 0)+(node.right.val if node.right else 0)
                if node.left:node.left.val=total-siblings
                if node.right:node.right.val=total-siblings
            level=following
        return root
