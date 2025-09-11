"""
For given list of strings find longest common prefix
"""
def lcp(strs:list[str])->str:
    res = ""
    first = strs[0]
    last = strs[-1]
    for i in range(min(len(first),len(last))):
        if(first[i]!=last[i]):
            return res 
        res += first[i]
    return res 
print(lcp(["flower","flock"]))