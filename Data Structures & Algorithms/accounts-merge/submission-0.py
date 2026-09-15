class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        n = len(accounts)
        emailIdx = {} # email -> id
        emails = [] # set of emails of all accounts
        emailToAcc = {} # email_index -> account_Id

        m = 0
        for accId, a in enumerate(accounts):
            for i in range(1, len(a)):
                email = a[i]
                if email in emailIdx:
                    continue
                emails.append(email)
                emailIdx[email] = m
                emailToAcc[m] = accId
                m += 1

        adj = [[] for _ in range(m)]
        for a in accounts:
            for i in range(2, len(a)):
                id1 = emailIdx[a[i]]
                id2 = emailIdx[a[i - 1]]
                adj[id1].append(id2)
                adj[id2].append(id1)

        emailGroup = defaultdict(list) # index of acc -> list of emails
        visited = [False] * m

        def bfs(start, accId):
            queue = deque([start])
            visited[start] = True
            while queue:
                node = queue.popleft()
                emailGroup[accId].append(emails[node])
                for nei in adj[node]:
                    if not visited[nei]:
                        visited[nei] = True
                        queue.append(nei)

        for i in range(m):
            if not visited[i]:
                bfs(i, emailToAcc[i])

        res = []
        for accId in emailGroup:
            name = accounts[accId][0]
            res.append([name] + sorted(emailGroup[accId]))

        return res