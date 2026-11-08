class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        items = sorted(items)
        prices, best = [], []
        maximum = 0
        for price, beauty in items:
            maximum = max(maximum, beauty)
            prices.append(price); best.append(maximum)
        answer = []
        for q in queries:
            left, right = 0, len(prices)
            while left < right:
                mid = (left + right) // 2
                if prices[mid] <= q: left = mid + 1
                else: right = mid
            answer.append(best[left-1] if left else 0)
        return answer
