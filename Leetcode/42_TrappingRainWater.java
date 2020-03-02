//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it is able to trap after raining. 
//
// 
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In 
//this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos
// for contributing this image! 
//
// Example: 
//
// 
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6 
// Related Topics Array Two Pointers Stack


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0; //小于3的话就只有两个，无法积水，要注意
        int max = 0;
        int leftMax = 0;
        int rightMax = 0;
        int i = 0;
        int j = height.length-1;
        while(i<j) {
            leftMax = Math.max(leftMax,height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {  //取决于短板，所以看小的那一个
                max = max + (leftMax - height[i]);
                i++;
            } else {
                max = max + (rightMax - height[j]);
                j--;
            }

        }return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
