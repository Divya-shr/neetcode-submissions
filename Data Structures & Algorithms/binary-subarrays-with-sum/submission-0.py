class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        n, res = len(nums), 0

        for i in range(n):
            curSum = 0
            for j in range(i, n):
                curSum += nums[j]
                if curSum == goal:
                    res += 1

        return res