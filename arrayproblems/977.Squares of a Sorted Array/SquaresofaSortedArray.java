class Solution {
    public int[] sortedSquares(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int index = nums.length - 1;
        int[] result = new int[nums.length];
        while(leftIndex <= rightIndex){
            if(nums[leftIndex] * nums[leftIndex] < nums[rightIndex] * nums[rightIndex]){
                result[index] = nums[rightIndex] * nums[rightIndex];
                rightIndex = rightIndex - 1;
                index = index - 1;
            }
            else{
                result[index] = nums[leftIndex] * nums[leftIndex];
                leftIndex = leftIndex + 1;
                index = index -1;
            }
        }
        return result;

    }
}