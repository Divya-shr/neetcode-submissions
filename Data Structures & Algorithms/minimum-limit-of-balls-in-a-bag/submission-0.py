class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        low, high = 1, max(nums)
        while low < high:
            mid = (low+high)//2
            needed = sum((x-1)//mid for x in nums)
            if needed <= maxOperations: high = mid
            else: low = mid+1
        return low
