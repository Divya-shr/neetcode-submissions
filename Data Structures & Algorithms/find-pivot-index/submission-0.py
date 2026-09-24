class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        n = len(nums)
        for i in range(n):
            leftSum = rightSum = 0
            for l in range(i):
                leftSum += nums[l]
            for r in range(i + 1, n):
                rightSum += nums[r]
            if leftSum == rightSum:
                return i
        return -1