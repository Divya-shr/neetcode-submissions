class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        from functools import cache

        @cache
        def solve(text):
            result = []
            for i, op in enumerate(text):
                if op not in "+-*":
                    continue
                for a in solve(text[:i]):
                    for b in solve(text[i + 1 :]):
                        result.append(a + b if op == "+" else a - b if op == "-" else a * b)
            return tuple(result) if result else (int(text),)

        return list(solve(expression))
