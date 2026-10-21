class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        n = len(nums)
        for _ in range(k):
            minIdx = 0
            for i in range(1, n):
                if nums[i] < nums[minIdx]:
                    minIdx = i
            nums[minIdx] *= multiplier
        return nums