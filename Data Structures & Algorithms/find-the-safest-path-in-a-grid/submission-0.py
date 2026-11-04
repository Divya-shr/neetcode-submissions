class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dist = [-1] * (n*n)
        queue = []
        for r in range(n):
            for c in range(n):
                if grid[r][c]:
                    dist[r*n+c] = 0
                    queue.append(r*n+c)
        def neighbors(p):
            r,c = divmod(p,n)
            for x,y in ((r-1,c),(r+1,c),(r,c-1),(r,c+1)):
                if 0 <= x < n and 0 <= y < n: yield x*n+y
        for p in queue:
            for q in neighbors(p):
                if dist[q] < 0:
                    dist[q] = dist[p]+1
                    queue.append(q)
        buckets = [[] for _ in range(2*n)]
        best = [-1] * (n*n)
        best[0] = dist[0]
        buckets[best[0]].append(0)
        for safety in range(2*n-1,-1,-1):
            while buckets[safety]:
                p = buckets[safety].pop()
                if best[p] != safety: continue
                if p == n*n-1: return safety
                for q in neighbors(p):
                    value = min(safety,dist[q])
                    if value > best[q]:
                        best[q] = value
                        buckets[value].append(q)
        return 0
