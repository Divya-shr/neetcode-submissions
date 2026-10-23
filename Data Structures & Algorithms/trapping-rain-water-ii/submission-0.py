class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        rows, cols = len(heightMap), len(heightMap[0])
        size = rows * cols
        dist = [20001] * size
        buckets = [[] for _ in range(20001)]
        answer = 0
        for r in range(rows):
            for c in range(cols):
                if r in (0,rows-1) or c in (0,cols-1):
                    p = r*cols+c
                    dist[p] = heightMap[r][c]
                    buckets[dist[p]].append(p)
        for cost in range(20001):
            while buckets[cost]:
                p = buckets[cost].pop()
                if dist[p] != cost: continue
                answer += cost - heightMap[p//cols][p%cols]
                r,c = divmod(p,cols)
                for rr,cc in ((r-1,c),(r+1,c),(r,c-1),(r,c+1)):
                    if 0 <= rr < rows and 0 <= cc < cols:
                        q = rr*cols+cc
                        nxt = max(cost, heightMap[rr][cc])
                        if nxt < dist[q]:
                            dist[q] = nxt
                            buckets[nxt].append(q)
        return answer
