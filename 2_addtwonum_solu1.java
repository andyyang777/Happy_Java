//此方法是比较直观的一种，但是其实可以把后两个while合并到第一个里

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
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        var dummy = new ListNode(0);
        var current = dummy;
        int carry = 0;
        while (l1 != null && l2 != null){
            int dig = l1.val + l2.val + carry;
            int val = dig % 10; //此处赋值；
            carry = dig /10;
            current.next = new ListNode(val);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        } // 这步过后已经处理完了两个listnode有的情况，然后到next的两种情况，一种是l1空，但l2不空；
        //或者l2空，但l1不空；
        while (l1 != null){ //listnode1 != null, and l2 = null
            int dig = l1.val + carry;
            int val = dig % 10;
            carry = dig /10;
            current.next = new ListNode(val);
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int dig = l2.val + carry;
            int val = dig % 10;
            carry = dig / 10;
            current.next = new ListNode(val);
            current = current.next;
            l2 = l2.next;
        }
        //至此如果还有进位，就再新建一个结点用来存储carry位；
        if (carry != 0){
            current.next = new ListNode(carry);
        }
        return dummy.next; //dummy一开始是单独设立的一个结点，链接到current，所以要返回
        //dummy的下一位




        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
