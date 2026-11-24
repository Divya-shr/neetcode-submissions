class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m, n = len(matrix), len(matrix[0])
        res = 0

        for r in range(m):
            for c in range(n):
                if matrix[r][c] == "0":
                    continue
                k = 1
                while True:
                    if r + k > m or c + k > n:
                        break
                    flag = True

                    for i in range(r, r + k):
                        if matrix[i][c + k - 1] == "0":
                            flag = False
                            break
                    for j in range(c, c + k):
                        if matrix[r + k - 1][j] == "0":
                            flag = False
                            break

                    if not flag:
                        break
                    res = max(res, k * k)
                    k += 1

        return res