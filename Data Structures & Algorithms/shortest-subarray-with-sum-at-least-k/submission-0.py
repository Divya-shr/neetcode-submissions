class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        n = len(nums)
        prefix = [0]*(n+1)
        for i,x in enumerate(nums): prefix[i+1] = prefix[i]+x
        queue = [0]*(n+1)
        head = tail = 0
        answer = n+1
        for i in range(n+1):
            while head < tail and prefix[i]-prefix[queue[head]] >= k:
                answer = min(answer,i-queue[head]); head += 1
            while head < tail and prefix[i] <= prefix[queue[tail-1]]: tail -= 1
            queue[tail] = i; tail += 1
        return answer if answer <= n else -1
