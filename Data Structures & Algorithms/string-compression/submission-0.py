class Solution:
    def compress(self, chars: List[str]) -> int:
        n = len(chars)
        s = ""

        i = 0
        while i < n:
            s += chars[i]
            j = i + 1
            while j < n and chars[i] == chars[j]:
                j += 1

            if j - i > 1:
                s += str(j - i)
            i = j

        i = 0
        while i < len(s):
            chars[i] = s[i]
            i += 1
        return i