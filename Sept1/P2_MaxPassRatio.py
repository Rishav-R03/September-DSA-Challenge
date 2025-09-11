"""
Return the maximum possible average pass ratio after assigning the extraStudents students. 
Answers within 10-5 of the actual answer will be accepted.
"""
import heapq
def maxAvgRatio(classes:list[list[int]],extra:int)->float:
    A = []
    n = len(classes)
    for p,q in classes:
        Sum += p/q
        A.append(((p-q)/(q*(q+1)),p,q))
    
    heapq.heapify(A)
    for _ in range(extra):
        (r,p,q) = A[0]
        if r == 0:
            break
        Sum-=r
        r2 = (p-q)/((q+1.0)*(q+2.0))
        heapq.heapreplace(A,(r2,p+1,r+1))
    return Sum/n