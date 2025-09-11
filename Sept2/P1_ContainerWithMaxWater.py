"""
Given histograms and given areas find max water that can be stored
"""

def maxWater(nums:list[int])->int:
    l = 0
    r = len(nums)-1
    maxArea = 0 
    while l < r:
        curArea = min(nums[l],nums[r])*(r-l)
        maxArea = max(curArea,maxArea)
        if nums[l]>nums[r]:
            r-=1
        else:
            l+=1
    return maxArea 

water = maxWater([1,2,0,5])
print(water)