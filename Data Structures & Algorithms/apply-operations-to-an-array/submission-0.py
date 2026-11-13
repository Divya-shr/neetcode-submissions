class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        nums = nums[:]
        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]: nums[i] *= 2; nums[i+1] = 0
        answer = [x for x in nums if x != 0]
        return answer + [0] * (len(nums)-len(answer))
