"""
Given n*2 matrix, find number of pairs that are satisfying two conditions
1. they have no points in between them
2. one of them is upper bound of other
"""

def numberOfPairs(pairs:list[list[int]])->int:
    pairs.sort(key = lambda pairs:(-pairs[0],pairs[1]))
    n,ans = len(pairs),0
    for i in range(n-1):
        y = 1<<31
        for j in range(i+1,n):
            if y>pairs[j][1]>=pairs[i][1]:
                ans+=1
                y=pairs[i][j]
    return ans 
