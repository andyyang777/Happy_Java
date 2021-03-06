//第一种方法的改进升级版

//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics Linked List Math


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val; //所以这里只是声明了val，并未初始化它的值，所以可以在后面赋值；
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var dummy = new ListNode(0);
        var current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0: l2.val) + carry;
            int val = sum % 10;
            carry = sum / 10;
            current.next = new ListNode(val);
            current = current.next;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
