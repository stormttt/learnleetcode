class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        if nums is None or len(nums)==0: 
            return 0 
        lenf=len(nums)+1
        total=0
        i=j=0
        while (j<len(nums)):
            total=total+nums[j]
            j+=1
            while (total>=target):
                lenf=min(lenf,j-i)
                total=total-nums[i]
                i+=1
        if lenf==len(nums)+1:
            return 0
        else: 
            return lenf