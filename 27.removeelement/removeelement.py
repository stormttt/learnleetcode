class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        fastIndex = 0
        slowIndex = 0
        for fastIndex in range(0,len(nums)):
            if nums[fastIndex] != val:
                nums[slowIndex] = nums[fastIndex]
                slowIndex = slowIndex + 1
        
        return slowIndex