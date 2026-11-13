class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        results = []
        for text in (s,t):
            stack = []
            for c in text:
                if c == "#":
                    if stack: stack.pop()
                else: stack.append(c)
            results.append(stack)
        return results[0] == results[1]
