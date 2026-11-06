# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def tree2str(self, root: Optional[TreeNode]) -> str:
        out=[];stack=[(root,0)]
        while stack:
            node,phase=stack.pop()
            if phase==0:
                out.append(str(node.val))
                if node.left or node.right:
                    out.append('(');stack.append((node,1))
                    if node.left: stack.append((node.left,0))
            elif phase==1:
                out.append(')')
                if node.right: out.append('(');stack.extend([(node,2),(node.right,0)])
            else: out.append(')')
        return ''.join(out)
