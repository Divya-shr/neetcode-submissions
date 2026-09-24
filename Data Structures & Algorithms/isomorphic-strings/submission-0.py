class Solution:
    def helper(self, s: str, t: str) -> bool:
        mp = {}
        for i in range(len(s)):
            if (s[i] in mp) and (mp[s[i]] != t[i]):
                return False
            mp[s[i]] = t[i]
        return True

    def isIsomorphic(self, s: str, t: str) -> bool:
        return self.helper(s, t) and self.helper(t, s)