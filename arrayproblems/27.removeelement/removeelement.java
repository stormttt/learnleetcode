// 双指针
class Solution {
    public int removeElement(int[] nums, int val) {
        int fastIndex;
        int slowIndex = 0;
        for(fastIndex = 0; fastIndex<nums.length;fastIndex++){
            if(nums[fastIndex] != val){
                nums[slowIndex]= nums[fastIndex];
                slowIndex++;
            }
            
        }
        return slowIndex;
    }
}