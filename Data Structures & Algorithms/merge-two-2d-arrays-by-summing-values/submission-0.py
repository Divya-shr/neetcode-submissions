class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        totals = [0] * 1001
        for rows in (nums1, nums2):
            for key, value in rows: totals[key] += value
        return [[key, value] for key, value in enumerate(totals) if value]
