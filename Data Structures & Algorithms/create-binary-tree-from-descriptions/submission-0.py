class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        nodes={};children=set()
        for p,c,left in descriptions:
            if p not in nodes:nodes[p]=TreeNode(p)
            if c not in nodes:nodes[c]=TreeNode(c)
            if left:nodes[p].left=nodes[c]
            else:nodes[p].right=nodes[c]
            children.add(c)
        return next(node for value,node in nodes.items() if value not in children)
