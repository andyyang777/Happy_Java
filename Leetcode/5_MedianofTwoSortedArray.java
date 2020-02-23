使用的是二分法，二分搜索，要求复杂度为O(log (m+n))的题目以后看到可以联想。
要求两个数组联合起来后的中位数有很多种cases，所以不如转换为找第k小的数；
https://www.bilibili.com/video/av70096585?from=search&seid=13497371785587410675


//There are two sorted arrays nums1 and nums2 of size m and n respectively. 
//
// Find the median of the two sorted arrays. The overall run time complexity sho
//uld be O(log (m+n)). 
//
// You may assume nums1 and nums2 cannot be both empty. 
//
// Example 1: 
//
// 
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
// 
//
// Example 2: 
//
// 
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
// 
// Related Topics Array Binary Search Divide and Conquer


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 1) { //说明长度是奇数的
            int mid = length / 2 + 1;
            return findKthSmallest(mid, nums1, nums2);
        } else {
            int mid1 = length / 2;
            int mid2 = length / 2 + 1;
            return (findKthSmallest(mid1, nums1, nums2) + findKthSmallest(mid2, nums1, nums2)) / 2.0;
        }
    }
    private int findKthSmallest ( int k, int[] nums1, int[] nums2){
        if (nums1.length == 0) return nums2[k - 1];
        if (nums2.length == 0) return nums1[k - 1];
        int start = Math.min(nums1[0], nums2[0]);
        int end = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if ((countSmallOrEqual(mid, nums1) + countSmallOrEqual(mid, nums2)) < k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (countSmallOrEqual(start, nums1) + countSmallOrEqual(start, nums2) >= k) return start;
        else return end;
    }
    private int countSmallOrEqual ( int num, int[] arr){
            int start = 0;
            int end = arr.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] <= num) start = mid;
                else end = mid;
            }
            if (arr[start] > num) return start;
            if (arr[end] > num) return end;
            return arr.length;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
