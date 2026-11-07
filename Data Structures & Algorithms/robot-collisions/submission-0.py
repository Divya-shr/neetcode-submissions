class Solution:
    def survivedRobotsHealths(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        stack=[]
        for i in sorted(range(len(positions)),key=positions.__getitem__):
            if directions[i]=='R':stack.append(i);continue
            while stack and healths[i]:
                j=stack[-1]
                if healths[j]<healths[i]:healths[j]=0;healths[i]-=1;stack.pop()
                elif healths[j]>healths[i]:healths[j]-=1;healths[i]=0
                else:healths[j]=healths[i]=0;stack.pop()
        return [h for h in healths if h]
