class Solution:
    def countOfAtoms(self, formula: str) -> str:
        counts={};factors=[];factor=1;number=0;i=len(formula)-1
        while i>=0:
            c=formula[i]
            if c.isdigit():
                end=i+1
                while i>=0 and formula[i].isdigit():i-=1
                number=int(formula[i+1:end]);continue
            if c==')':factors.append(number or 1);factor*=number or 1;number=0;i-=1
            elif c=='(':factor//=factors.pop();i-=1
            else:
                end=i+1
                while formula[i].islower():i-=1
                atom=formula[i:end];counts[atom]=counts.get(atom,0)+factor*(number or 1);number=0;i-=1
        return ''.join(atom+(str(counts[atom]) if counts[atom]>1 else '') for atom in sorted(counts))
