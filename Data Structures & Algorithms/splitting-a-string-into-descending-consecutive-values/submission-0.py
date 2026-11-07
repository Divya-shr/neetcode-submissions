class Solution:
    def splitString(self, s: str) -> bool:
        first = 0
        for cut in range(1,len(s)):
            first = first * 10 + int(s[cut-1])
            # Two adjacent values with more than 10 significant digits cannot fit in 20 characters.
            if first > 10000000000: break
            previous, pos = first, cut
            while pos < len(s) and previous > 0:
                target = previous - 1
                if target == 0:
                    if all(c == "0" for c in s[pos:]): return True
                    break
                value = 0
                while pos < len(s) and value < target:
                    value = value * 10 + int(s[pos])
                    pos += 1
                if value != target: break
                previous = target
                if pos == len(s): return True
        return False
