class NestedIterator:
    def __init__(self,nestedList:List[NestedInteger]):self.stack=list(reversed(nestedList))
    def hasNext(self)->bool:
        while self.stack and not self.stack[-1].isInteger():
            self.stack.extend(reversed(self.stack.pop().getList()))
        return bool(self.stack)
    def next(self)->int:
        self.hasNext();return self.stack.pop().getInteger()
