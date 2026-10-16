class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        counts = [0]*101
        for rank in ranks: counts[rank]+=1
        low,high=0,min(ranks)*cars*cars
        while low<high:
            mid=(low+high)//2
            repaired=0
            for rank in range(1,101):
                if not counts[rank]: continue
                left,right=0,cars
                while left<right:
                    value=(left+right+1)//2
                    if rank*value*value<=mid: left=value
                    else: right=value-1
                repaired+=counts[rank]*left
                if repaired>=cars: break
            if repaired>=cars: high=mid
            else: low=mid+1
        return low
