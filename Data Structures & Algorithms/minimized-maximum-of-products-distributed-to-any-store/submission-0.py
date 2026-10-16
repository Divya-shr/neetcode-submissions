class Solution:
    def minimizedMaximum(self, n: int, quantities: List[int]) -> int:
        low, high = 1, 100000
        while low < high:
            mid = (low+high)//2; used = 0
            for q in quantities:
                used += (q+mid-1)//mid
                if used > n: break
            if used <= n: high = mid
            else: low = mid+1
        return low
