"""
Reverse given integer
"""

#method 1

def method1(num:int)->int:
    # 123
    strNum = str(num)
    
    digits = []
    for c in strNum:
        digits.append(c)
    if digits[0] == "-":
        l = 1
    else: 
        l = 0
    # l = 0
    r = len(strNum)-1
    while l<r:
        digits[l],digits[r] = digits[r],digits[l]
        l+=1
        r-=1
    num = "".join(digits)
    ans = int(num)
    return ans

print(method1(-1234))


def method2(num:int)->int:
    is_neg = False 
    if num<0:
        is_neg = True 
        num *=-1
    res = 0
    while num>0:
        res = (res*10)+(num%10)
        num = num//10
    
    if res>2**31 -1:
        return 0
    return res*-1 if is_neg else res

print(method2(-1234))