class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        res, n = 0, len(customers)
        for i in range(n):
            if not grumpy[i]:
                res += customers[i]

        satisfied = res
        for i in range(n - minutes + 1):
            cur = 0
            for j in range(i, i + minutes):
                if grumpy[j]:
                    cur += customers[j]
            res = max(res, satisfied + cur)

        return res