class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        arr = [1] * n

        for i in range(n - 1):
            if ratings[i] == ratings[i + 1]:
                continue
            if ratings[i + 1] > ratings[i]:
                arr[i + 1] = arr[i] + 1
            elif arr[i] == arr[i + 1]:
                arr[i + 1] = arr[i]
                arr[i] += 1
                for j in range(i - 1, -1, -1):
                    if ratings[j] > ratings[j + 1]:
                        if arr[j + 1] < arr[j]:
                            break
                        arr[j] += 1

        return sum(arr)