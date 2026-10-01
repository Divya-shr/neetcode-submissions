class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        s.sort()
        res = 0

        for i in g:
            minIdx = -1
            for j in range(len(s)):
                if s[j] < i:
                    continue

                if minIdx == -1 or s[minIdx] > s[j]:
                    minIdx = j

            if minIdx != -1:
                s[minIdx] = -1
                res += 1

        return res