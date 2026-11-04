class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        res = []
        folder_set = set(folder)

        for f in folder:
            res.append(f)
            for i in range(len(f)):
                if f[i] == "/" and f[:i] in folder_set:
                    res.pop()
                    break

        return res