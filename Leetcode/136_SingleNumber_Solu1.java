//使用了一个技术，用了^异或运算，当然我自己是觉得想不出来的，就很无语。

//Given a non-empty array of integers, every element appears twice except for on
//e. Find that single one. 
//
// Note: 
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory? 
//
// Example 1: 
//
// 
//Input: [2,2,1]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,1,2,1,2]
//Output: 4
// 
// Related Topics Hash Table Bit Manipulation


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
