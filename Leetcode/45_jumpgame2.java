//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// Example: 
//
// 
//Input: [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index. 
//
// Note: 
//
// You can assume that you can always reach the last index. 
// Related Topics Array Greedy


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int currMax = 0;
        int nextMax = 0;
        int step = 0;
        int index = 0;
        while (index <= currMax){
            while (index <= currMax){
                nextMax = Math.max(nextMax, index + nums[index]);
                index++;
            }
            currMax = nextMax;
            step++;
            if (currMax >= nums.length-1) return step;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
