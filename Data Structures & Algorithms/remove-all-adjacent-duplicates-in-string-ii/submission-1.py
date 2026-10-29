class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        while s:
            flag = False
            cur = s[0]
            cnt = 1
            for i in range(1, len(s)):
                if cur != s[i]:
                    cnt = 0
                    cur = s[i]
                cnt += 1
                if cnt == k:
                    s = s[:i - cnt + 1] + s[i + 1:]
                    flag = True
                    break

            if not flag:
                break

        return s