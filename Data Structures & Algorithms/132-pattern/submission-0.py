class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        stack = []
        middle = -1000000001
        for x in reversed(nums):
            if x < middle: return True
            while stack and stack[-1] < x: middle = stack.pop()
            stack.append(x)
        return False
