class Solution:
    def minFlips(self, s: str) -> int:
        n = len(s)
        mismatch = 0
        answer = n
        for i in range(2 * n):
            mismatch += int(s[i % n]) != i % 2
            if i >= n:
                left = i - n
                mismatch -= int(s[left % n]) != left % 2
            if i >= n - 1: answer = min(answer, mismatch, n - mismatch)
        return answer
