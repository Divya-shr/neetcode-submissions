class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        counts = {}
        for x in arr: counts[x] = counts.get(x,0)+1
        frequencies = sorted(counts.values())
        remaining = len(frequencies)
        for count in frequencies:
            if count > k: break
            k -= count; remaining -= 1
        return remaining
