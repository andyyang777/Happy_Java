//You are given an n x n 2D matrix representing an image. 
//
// Rotate the image by 90 degrees (clockwise). 
//
// Note: 
//
// You have to rotate the image in-place, which means you have to modify the inp
//ut 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
//
// Example 1: 
//
// 
//Given input matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//rotate the input matrix in-place such that it becomes:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// Example 2: 
//
// 
//Given input matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//rotate the input matrix in-place such that it becomes:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int top = 0;
        int left = 0;
        int right = matrix.length - 1;
        int bottom = matrix.length - 1;
        int n = matrix.length; // number of cells in one line,也就是表明几乘几
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tmp;
            }
            top++;
            left++;
            bottom--;
            right--;
            n -= 2;

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
