class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        res = len(blocks)
        for i in range(len(blocks) - k + 1):
            count_w = 0
            for j in range(i, i + k):
                if blocks[j] == 'W':
                    count_w += 1
            res = min(res, count_w)
        return res