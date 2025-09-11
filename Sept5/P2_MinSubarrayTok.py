"""
We have an array and k, we need to find min len of subarray 
with sum greater or equal to k
"""

def minLenSubArray(nums:int,k:int)->int:
    l = 0
    total = 0
    res = float("inf")
    for r in range(len(nums)):
        total+=nums[r]
        while total>=k:
            res = min(res,r-l+1)
            total-=nums[l]
            l+=1
    return 0 if res == float('inf') else res 