class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        stack = []
        ending = [0] * len(arr)
        answer = 0
        for i, x in enumerate(arr):
            while stack and arr[stack[-1]] >= x: stack.pop()
            prev = stack[-1] if stack else -1
            ending[i] = x * (i - prev) + (ending[prev] if prev >= 0 else 0)
            answer = (answer + ending[i]) % 1000000007
            stack.append(i)
        return answer
