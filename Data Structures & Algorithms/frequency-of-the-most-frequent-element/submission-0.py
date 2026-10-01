class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort()
        res = 1
        for i in range(len(nums)):
            j = i - 1
            tmpK = k
            while j >= 0 and (tmpK - (nums[i] - nums[j])) >= 0:
                tmpK -= (nums[i] - nums[j])
                j -= 1
            res = max(res, i - j)
        return res