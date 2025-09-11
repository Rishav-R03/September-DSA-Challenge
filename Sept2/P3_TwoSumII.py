"""
Given sorted integer array return indices of elements of array that sum to target.
"""

def binarySearchMethod(nums:list[int],tar:int)->list[int]:
    for i in range(len(nums)):
        l = i+1
        r = len(nums)-1
        tmp = tar - nums[i]
        while l < r:
            mid = l + (r-l)//2
            if nums[mid] == tmp:
                return [i+1,mid+1]
            elif nums[mid] > tmp:
                l =mid+1
            else:
                r = mid -1
    return []


def twoPointerMethod(nums:list[int],tar:int)->list[int]:
    l = 0
    r = len(nums)-1
    while l< r:
        curSum = nums[l] + nums[r]
        if curSum == tar:
            return [l+1,r+1]
        elif curSum>tar:
            r-=1
        else:
            l+=1
    return []