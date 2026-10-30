class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        edges = {}; counts = [0]
        for word in words:
            node = 0
            for ch in word:
                key = node*26 + ord(ch)-97
                if key not in edges: edges[key] = len(counts); counts.append(0)
                node = edges[key]; counts[node] += 1
        answer = []
        for word in words:
            node = score = 0
            for ch in word: node = edges[node*26+ord(ch)-97]; score += counts[node]
            answer.append(score)
        return answer
