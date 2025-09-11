class Solution:
    def findClosest(self, x: int, y: int, z: int) -> int:
        p1 = abs(z-x)
        p2 = abs(z-y)
        if p1==p2:
            return 0
        ans = min(p1,p2)
        if ans == p1:
            return 1
        elif ans == p2:
            return 2