class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        n = len(arr)
        dp = [[2] * n for _ in range(n)]
        best = 0
        for k in range(2, n):
            left, right = 0, k - 1
            while left < right:
                total = arr[left] + arr[right]
                if total < arr[k]:
                    left += 1
                elif total > arr[k]:
                    right -= 1
                else:
                    dp[right][k] = dp[left][right] + 1
                    best = max(best, dp[right][k])
                    left += 1
                    right -= 1
        return best
