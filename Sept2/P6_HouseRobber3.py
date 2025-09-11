class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val = val
        self.left = None
        self.right = None 
    
class Solution:
    def dfs(self,root:Optional[TreeNode]):
        if not root:
            return (0,0)
        left = self.dfs(root.left)
        right = self.dfs(root.right)
        return (root.val+left[1]+right[1],max(left[0],right[0])+max(left[1],right[1]))
    def houseRobber3(self,root:TreeNode)->int:
        return max(self.dfs(root))


