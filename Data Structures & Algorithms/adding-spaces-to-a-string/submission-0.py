class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        pieces = []
        start = 0
        for index in spaces:
            pieces.append(s[start:index])
            pieces.append(" ")
            start = index
        pieces.append(s[start:])
        return "".join(pieces)
