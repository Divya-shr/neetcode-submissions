class Solution:
    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        n = len(colors)
        run = answer = 0
        for i in range(n+k-1):
            run = run+1 if i > 0 and colors[i%n] != colors[(i-1)%n] else 1
            if i >= k-1 and run >= k: answer += 1
        return answer
