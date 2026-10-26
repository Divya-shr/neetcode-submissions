class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        when=[len(removable)+1]*len(s)
        for i,pos in enumerate(removable):when[pos]=i+1
        lo,hi=0,len(removable)
        while lo<hi:
            mid=(lo+hi+1)//2;j=0
            for i,c in enumerate(s):
                if when[i]>mid and j<len(p) and c==p[j]:j+=1
            if j==len(p):lo=mid
            else:hi=mid-1
        return lo
