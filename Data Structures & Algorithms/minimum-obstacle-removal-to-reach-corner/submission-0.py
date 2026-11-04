class Solution:
    def minimumObstacles(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        size = rows * cols
        dist = [size] * size
        dist[0] = 0
        buckets = [[] for _ in range(size)]
        buckets[0].append(0)
        for cost in range(size):
            while buckets[cost]:
                p = buckets[cost].pop()
                if dist[p] != cost: continue
                if p == size - 1: return cost
                r,c = divmod(p,cols)
                for rr,cc in ((r-1,c),(r+1,c),(r,c-1),(r,c+1)):
                    if 0 <= rr < rows and 0 <= cc < cols:
                        q = rr*cols+cc
                        nxt = cost + grid[rr][cc]
                        if nxt < dist[q]:
                            dist[q] = nxt
                            buckets[nxt].append(q)
        return -1
