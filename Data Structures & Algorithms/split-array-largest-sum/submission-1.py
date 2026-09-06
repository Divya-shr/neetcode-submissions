class Solution:
    def splitArray(self, nums: list[int], k: int) -> int:
        left = max(nums)
        right = sum(nums)

        while left < right:
            mid = left + (right - left) // 2

            if self.can_split(nums, k, mid):
                right = mid
            else:
                left = mid + 1

        return left

    def can_split(self, nums: list[int], k: int, max_sum: int) -> bool:
        subarrays = 1
        current_sum = 0

        for num in nums:
            if current_sum + num > max_sum:
                subarrays += 1
                current_sum = num

                if subarrays > k:
                    return False
            else:
                current_sum += num

        return True