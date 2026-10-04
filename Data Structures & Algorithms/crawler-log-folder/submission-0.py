class Solution:
    def minOperations(self, logs: List[str]) -> int:
        res = 0
        for log in logs:
            if log == "./":
                continue
            if log == "../":
                res = max(0, res - 1)
            else:
                res += 1
        return res