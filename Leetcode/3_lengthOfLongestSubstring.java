//Given a string, find the length of the longest substring without repeating cha
//racters. 
//
// 
// Example 1: 
//
// 
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
// 
//
// 
// Example 2: 
//
// 
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// 
// Example 3: 
//
// 
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence
// and not a substring.
// 
// 
// 
// 
// Related Topics Hash Table Two Pointers String Sliding Window


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0;
        int len = s.length();
        boolean[] Arr = new boolean[128];
        int Maxlen = 0;
        while (right < len){
            if (Arr[s.charAt(right)] == false)
            {
                Arr[s.charAt(right)] = true;
                right ++;
            }
            else
            {
                Maxlen = Math.max(Maxlen, (right-left));
                while (left < right && s.charAt(right) != s.charAt(left))
                {
                    Arr[s.charAt(left)] = false;
                    left++;
                }
                left ++;
                right ++;
            }
        }
        Maxlen = Math.max(Maxlen, (right-left));
        return Maxlen;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
