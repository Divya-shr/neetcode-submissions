class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        res = []
        m = len(searchWord)
        products.sort()

        for i in range(m):
            cur = []
            for w in products:
                if len(w) <= i:
                    continue

                flag = True
                for j in range(i + 1):
                    if w[j] != searchWord[j]:
                        flag = False
                        break

                if flag:
                    cur.append(w)
                    if len(cur) == 3:
                        break

            if not cur:
                for j in range(i, m):
                    res.append([])
                break
            res.append(cur)

        return res