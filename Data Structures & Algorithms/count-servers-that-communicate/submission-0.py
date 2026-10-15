class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        res = 0

        for r in range(m):
            for c in range(n):
                if grid[r][c] == 0:
                    continue

                found = False
                for col in range(n):
                    if col != c and grid[r][col] == 1:
                        found = True
                        break

                if not found:
                    for row in range(m):
                        if row != r and grid[row][c] == 1:
                            found = True
                            break

                if found:
                    res += 1

        return res