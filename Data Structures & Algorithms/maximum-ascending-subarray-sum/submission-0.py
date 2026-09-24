class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        res = 0
        for i in range(len(nums)):
            curSum = nums[i]
            for j in range(i + 1, len(nums)):
                if nums[j] <= nums[j - 1]:
                    break
                curSum += nums[j]
            res = max(res, curSum)
        return res