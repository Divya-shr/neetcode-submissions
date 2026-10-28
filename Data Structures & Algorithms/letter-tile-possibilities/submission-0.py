class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        counts = [0] * 26
        for c in tiles: counts[ord(c)-65] += 1
        def search():
            total = 0
            for i in range(26):
                if counts[i]:
                    counts[i] -= 1
                    total += 1 + search()
                    counts[i] += 1
            return total
        return search()
