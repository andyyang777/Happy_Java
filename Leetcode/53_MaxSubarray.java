//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// Example: 
//
// 
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Follow up: 
//
// If you have figured out the O(n) solution, try coding another solution using 
//the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int TempMax = nums[0];
        int FinalMax = nums[0];
        for (int i = 1; i < nums.length; i++){
            TempMax = Math.max((TempMax + nums[i]), nums[i]);
            FinalMax = Math.max(FinalMax, TempMax);
        }
        return FinalMax;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
