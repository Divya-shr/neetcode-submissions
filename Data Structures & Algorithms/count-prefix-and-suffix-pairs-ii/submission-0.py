class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        edges = {}
        ends = [0]
        answer = 0
        for word in words:
            node = 0
            for i, ch in enumerate(word):
                key = node * 676 + (ord(ch) - 97) * 26 + ord(word[-1 - i]) - 97
                if key not in edges:
                    edges[key] = len(ends)
                    ends.append(0)
                node = edges[key]
                answer += ends[node]
            ends[node] += 1
        return answer
