//Given an array nums of n integers where n > 1, return an array output such tha
//t output[i] is equal to the product of all the elements of nums except nums[i]. 
//
//
// Example: 
//
// 
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
// 
//
// Constraint: It's guaranteed that the product of the elements of any prefix or
// suffix of the array (including the whole array) fits in a 32 bit integer. 
//
// Note: Please solve it without division and in O(n). 
//
// Follow up: 
//Could you solve it with constant space complexity? (The output array does not 
//count as extra space for the purpose of space complexity analysis.) 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;

        for (int i = 1; i<nums.length; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int right = 1;
        for (int i = nums.length-1; i>=0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
