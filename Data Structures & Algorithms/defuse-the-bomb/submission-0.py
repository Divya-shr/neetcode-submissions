class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        n = len(code)
        answer = [0] * n
        for i in range(n):
            for step in range(1, abs(k) + 1):
                answer[i] += code[(i + (step if k > 0 else -step)) % n]
        return answer
