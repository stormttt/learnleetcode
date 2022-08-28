# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildInorderList(self,root,res):
        if root==None:
            return None
        if root.left:
            self.buildInorderList(root.left)
        res.append(root.val)
        if root.right:
            self.buildInorderList(root.right)
        return res
    
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        bstArray = []
        result = float('inf')
        self.buildInorderList(root,bstArray)
        for i in range(len(bstArray)-1):
            result = min(abs(bstArray[i]-bstArray[i+1]),result)
        return result
#  
class Solution:
    def getMinimumDifference(self, root: TreeNode) -> int:
        res = []   
        r = float("inf")
        # 把二叉搜索树转换成有序数组
        def buildaList(root):  
            if not root: return None
            if root.left: buildaList(root.left)  
            res.append(root.val)  
            if root.right: buildaList(root.right) 
            return res
            
        buildaList(root)
        # 统计有序数组的最小差值
        for i in range(len(res)-1): 
            r = min(abs(res[i]-res[i+1]),r)
        return r