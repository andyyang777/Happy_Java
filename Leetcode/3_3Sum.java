//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// Related Topics Array Two Pointers


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        if (nums == null || n < 3) return res;
        int i = 0;
        Arrays.sort(nums);
        while (i < n - 2) {
            int base = nums[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = base + nums[left] + nums[right];
                if (sum == 0) {
                    LinkedList<Integer> list = new LinkedList<Integer>();
                    list.add(base);  list.add(nums[left]);  list.add(nums[right]);
                    res.add(list);
                    left = move2Right(nums, (left + 1));
                    right = move2Left(nums, (right - 1));
                } else if (sum > 0) {
                    right = move2Left(nums, right - 1);
                } else {
                    left = move2Right(nums, left + 1);
                }
            }
            i = move2Right(nums, i+1);
        }
        return res;
    }
    public int move2Right(int[] nums, int leftNext) {
        while((leftNext < nums.length && nums[leftNext] == nums[leftNext - 1])) {
            leftNext++;
        }
        return leftNext;
    }
    public int move2Left(int[] nums, int rightNext) {
        while ((rightNext > 0 && nums[rightNext] == nums[rightNext +1])) {
            rightNext --;

        }
        return rightNext;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
