"""
Rotate the array in place by k steps 
"""
def rotateArray(nums:list[int],k:int)->None:
    n = len(nums)
    k = k%n
    nums[:] = nums[-k:]+nums[:-k]
    print(nums)
rotateArray([1,2,3,4,5],2)
