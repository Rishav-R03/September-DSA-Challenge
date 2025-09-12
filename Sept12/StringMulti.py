class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == "0" or num2 == "0":
            return "0"
        N = len(num1) + len(num2)
        ans = [0]*N
        fn = num1[::-1]
        sn = num2[::-1]
        for p2,d2 in enumerate(sn):
            for p1,d1 in enumerate(fn):
                nzero = p1 + p2
                carry = ans[nzero]
                mul = int(d1)*int(d2)+carry
                ans[nzero] = mul%10
                ans[nzero+1] += mul//10
        if ans[-1] == 0:
            ans.pop()
        
        return "".join(str(d) for d in reversed(ans))