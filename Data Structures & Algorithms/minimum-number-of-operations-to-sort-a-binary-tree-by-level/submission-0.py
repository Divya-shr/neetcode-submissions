# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def minimumOperations(self, root: Optional[TreeNode]) -> int:
        answer=0;nodes=[root]
        while nodes:
            order=sorted(range(len(nodes)),key=lambda i:nodes[i].val);seen=set()
            for i in range(len(order)):
                length=0;j=i
                while j not in seen:seen.add(j);length+=1;j=order[j]
                answer+=max(0,length-1)
            nodes=[child for node in nodes for child in (node.left,node.right) if child]
        return answer
