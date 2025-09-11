"""
Given houses in a circular fashion, find max value without 
can be looted without alerting police.
"""

def houseRobber(nums:list[int])->int:
    n = len(nums)

    if n == 1:
        return nums[0]
    def helper(nums:list[int],n:int):
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
        dp = [0]*(n)
        dp[0] = 0
        dp[1] = max(nums[0],nums[1])
        for i in range(2,n+1):
            dp[i] = max(dp[i-1],dp[i-2]+nums[i])
        return dp[n]
    
    return max(helper(nums[1:],n),helper(nums[:-1],n))
