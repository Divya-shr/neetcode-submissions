class Solution:
    def maxUniqueSplit(self, s: str) -> int:
        used = set()
        def search(start):
            if start == len(s): return 0
            best = -len(s)
            for end in range(start+1, len(s)+1):
                piece = s[start:end]
                if piece not in used:
                    used.add(piece)
                    best = max(best, 1 + search(end))
                    used.remove(piece)
            return best
        return search(0)
