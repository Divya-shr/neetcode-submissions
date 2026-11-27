class Solution:
    def constructDistancedSequence(self, n: int) -> List[int]:
        answer = [0] * (2 * n - 1)
        used = [False] * (n + 1)

        def search(pos):
            while pos < len(answer) and answer[pos]:
                pos += 1
            if pos == len(answer):
                return True
            for k in range(n, 0, -1):
                end = pos if k == 1 else pos + k
                if used[k] or end >= len(answer) or answer[end]:
                    continue
                answer[pos] = answer[end] = k
                used[k] = True
                if search(pos + 1):
                    return True
                answer[pos] = answer[end] = 0
                used[k] = False
            return False

        search(0)
        return answer
