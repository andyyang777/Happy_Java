//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Determine if you are able to reach the last index. 
//
// Example 1: 
//
// 
//Input: [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum
//             jump length is 0, which makes it impossible to reach the last ind
//ex.
// 
// Related Topics Array Greedy


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int reach = 0;
        for (int i = 0; i <= reach && i < nums.length; i++) {
            reach = Math.max(reach, nums[i] + i);
            if (reach >= nums.length - 1) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
