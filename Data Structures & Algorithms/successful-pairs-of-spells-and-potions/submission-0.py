class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions = sorted(potions)
        answer = []
        for spell in spells:
            left, right = 0, len(potions)
            while left < right:
                mid = (left + right) // 2
                if spell * potions[mid] >= success: right = mid
                else: left = mid + 1
            answer.append(len(potions) - left)
        return answer
