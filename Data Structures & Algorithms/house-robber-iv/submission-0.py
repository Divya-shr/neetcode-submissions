class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        low, high = min(nums), max(nums)
        while low < high:
            mid = (low+high)//2
            count = i = 0
            while i < len(nums):
                if nums[i] <= mid: count += 1; i += 2
                else: i += 1
            if count >= k: high = mid
            else: low = mid+1
        return low
