"""
Given a string with parenthesis check whether it is valid or not
"""

def isValid(strs:str)->bool:
    dic = {"(":")","[":"]","{":"}"}
    stack = [] 
    for ch in strs:
        if ch in dic:
            stack.append(ch)
        elif len(stack)==0 or dic[stack.pop()] != ch:
            return False 
    return len(stack) == 0

print(isValid("(){}{]"))