class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        if k > 3 * (1 << (n-1)): return ""
        answer = ""
        for i in range(n):
            block = 1 << (n-i-1)
            for c in "abc":
                if answer and c == answer[-1]: continue
                if k > block: k -= block
                else:
                    answer += c
                    break
        return answer
