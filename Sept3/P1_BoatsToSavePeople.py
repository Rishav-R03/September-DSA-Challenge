"""
You are given an integer array people where people[i] is the weight of the ith person,
and an infinite number of boats where each boat can carry a maximum weight of limit. 
Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person.
"""

def numberOfBoats(nums:list[int],limit:int)->int:
    nums.sort()
    res,l,r = 0,0,len(nums)-1
    while l<=r:
        remain = limit - nums[r]
        r-=1
        res+=1
        if l<=r and remain>=nums[l]:
            l+=1
    return res