class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        nums.sort()
        def at_most(limit):
            left, right, total = 0, len(nums)-1, 0
            while left < right:
                if nums[left]+nums[right] <= limit:
                    total += right-left
                    left += 1
                else: right -= 1
            return total
        return at_most(upper)-at_most(lower-1)
