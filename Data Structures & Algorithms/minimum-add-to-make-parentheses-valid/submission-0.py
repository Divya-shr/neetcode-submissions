class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        opens = additions = 0
        for c in s:
            if c == '(':
                opens += 1
            elif opens:
                opens -= 1
            else:
                additions += 1
        return additions + opens
