class Solution:
    def reverseParentheses(self, s: str) -> str:
        pairs = [0] * len(s)
        stack = []
        for i, c in enumerate(s):
            if c == "(": stack.append(i)
            elif c == ")":
                j = stack.pop()
                pairs[i], pairs[j] = j, i
        answer = []
        i, direction = 0, 1
        while i < len(s):
            if s[i] in "()":
                i = pairs[i]
                direction = -direction
            else: answer.append(s[i])
            i += direction
        return "".join(answer)
