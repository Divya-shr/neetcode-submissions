class Solution:
    def minimumDeviation(self, nums: List[int]) -> int:
        import heapq
        values = [v*2 if v%2 else v for v in nums]
        smallest = min(values)
        heap = [-v for v in values]
        heapq.heapify(heap)
        answer = max(values)-smallest
        while True:
            largest = -heap[0]
            answer = min(answer,largest-smallest)
            if answer == 0 or largest%2: return answer
            largest //= 2
            smallest = min(smallest,largest)
            heapq.heapreplace(heap,-largest)
