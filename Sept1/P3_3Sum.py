"""
Given an array, we need to find 3 numbers summing to 0.
Return list[list[int]] satisfying given condition
"""

def threeSum(nums:list[int])->list[list[int]]:
    n = len(nums)
    res = []
    nums.sort()
    for i in range(n):
        if i > 0 and nums[i] == nums[i-1]:
            continue # to ignore duplicate values 
        l,r = i+1,n-1
        while l <r:
            curSum = nums[i] + nums[l] + nums[r]
            if curSum == 0:
                res.append([nums[i] , nums[l] ,nums[r]])
                l+=1
                r-=1
                while l < r and nums[l] == nums[l-1]:
                    l+=1
                while l < r and nums[r] == nums[r+1]:
                    r-=1
            elif curSum > 0:
                l+=1
            else:
                r-=1
    return res 

                


            
out = threeSum([-1,0,1,2,-1,-4])
print(out)
