class Solution:
    def minOperations(self, s: str) -> int:
        cur = cnt1 = 0
        for c in s:
            if int(c) != cur:
                cnt1 += 1
            cur ^= 1

        cur = 1
        cnt2 = 0
        for c in s:
            if int(c) != cur:
                cnt2 += 1
            cur ^= 1

        return min(cnt1, cnt2)