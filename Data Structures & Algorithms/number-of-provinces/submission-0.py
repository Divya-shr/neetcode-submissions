class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        res = 0
        visited = [False] * n

        def dfs(node):
            visited[node] = True
            for nei in range(n):
                if isConnected[node][nei] and not visited[nei]:
                    dfs(nei)

        for i in range(n):
            if not visited[i]:
                dfs(i)
                res += 1

        return res