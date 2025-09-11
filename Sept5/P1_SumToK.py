"""
We have an array, k and x.
We need to find min value of integer closest to x.
"""
class Solution:
    def findClosestElements(self, arr: list[int], k: int, x: int) -> list[int]:
        l,r = 0,len(arr)-1
        while r-l>=k:
            if abs(x-arr[l]) <= abs(x-arr[r]):
                r-=1
            else:
                l+=1
        return arr[l:r+1]

s = Solution()
out = s.findClosestElements([2,4,5,8],2,6)
print(out)