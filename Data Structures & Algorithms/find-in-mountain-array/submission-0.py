class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:
        n = mountainArr.length()

        # Find peak
        left = 0
        right = n - 1

        while left < right:
            mid = left + (right - left) // 2

            if mountainArr.get(mid) < mountainArr.get(mid + 1):
                left = mid + 1
            else:
                right = mid

        peak = left

        # Search increasing part first
        result = self.binary_search_ascending(
            mountainArr, target, 0, peak
        )

        if result != -1:
            return result

        # Search decreasing part
        return self.binary_search_descending(
            mountainArr, target, peak + 1, n - 1
        )

    def binary_search_ascending(
        self,
        arr: 'MountainArray',
        target: int,
        left: int,
        right: int
    ) -> int:
        while left <= right:
            mid = left + (right - left) // 2
            value = arr.get(mid)

            if value == target:
                return mid
            elif value < target:
                left = mid + 1
            else:
                right = mid - 1

        return -1

    def binary_search_descending(
        self,
        arr: 'MountainArray',
        target: int,
        left: int,
        right: int
    ) -> int:
        while left <= right:
            mid = left + (right - left) // 2
            value = arr.get(mid)

            if value == target:
                return mid
            elif value > target:
                left = mid + 1
            else:
                right = mid - 1

        return -1