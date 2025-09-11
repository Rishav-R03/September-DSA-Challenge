"""
Here in this problem we need to tell about maximum amount of water we can store based on given tower
heights
"""

def trappingWater(nums:list[int])->int:
    l = 0
    r = len(nums)-1
    water = 0
    lm = nums[l]
    rm = nums[r]
    while l<r:
        if lm <rm:
            l+=1
            lm = max(lm,nums[l])
            water += lm-nums[l]
        else:
            r-=1
            rm = max(rm,nums[r])
            water +=rm-nums[r]
    return water

