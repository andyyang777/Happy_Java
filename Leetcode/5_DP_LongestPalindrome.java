//Given a string s, find the longest palindromic substring in s. You may assume 
//that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
// Related Topics String Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        int len = s.length();

        char[] sChar = s.toCharArray();
        int start = 0;
        int length = 1; // 用来记录位置从哪到哪
        boolean[][] isPalindrome = new boolean[len][len];
        for(int i = 0; i < len; i++){
            isPalindrome[i][i] = true;
        }
        for(int i = 0; i<len-1; i++){
            if(sChar[i] == sChar[i+1]){
                isPalindrome[i][i+1] = true;
                start = i;
                length = 2;
            }
        }

        for(int i = 3; i<=len; i++){ //i：当前子序列的长度，j：起点从0开始
            for(int j = 0; j+i-1<len; j++){
                if (sChar[j] == sChar[j+i-1] && isPalindrome[j+1][j+i-2] == true){
                    isPalindrome[j][j+i-1] = true;
                    start = j;
                    length = i;
                }
            }
        }
        return s.substring(start,start+length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

