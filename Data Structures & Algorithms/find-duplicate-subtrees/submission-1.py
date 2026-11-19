
class Solution:
    def findDuplicateSubtrees(self, root):
        count = {}
        result = []

        def dfs(node):
            if not node:
                return "#"

            left = dfs(node.left)
            right = dfs(node.right)

            serial = str(node.val) + "," + left + "," + right

            count[serial] = count.get(serial, 0) + 1

            if count[serial] == 2:
                result.append(node)

            return serial

        dfs(root)
        return result
