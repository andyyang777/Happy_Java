暴力解法

class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int major = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int num2 : nums) {
                if (num2 == num) {
                    count += 1;
                }
            }
            if (count > major) {
                return num;
            }
        }
        return -1;
    }
}
