class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        count_s, count_t = Counter(s), Counter(t)
        for c in count_t:
            if c not in count_s or count_s[c] < count_t[c]:
                return c