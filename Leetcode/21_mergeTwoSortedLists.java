//非常容易理解，链表题目套路已经出来了，先定dummy，最后dummy.next作为返回的首个地址，再定一个current，首先指向dummy，之后根据情况变化；
// 有用的一个技巧，boolean ？的使用，例如 check ? l1 : l2表示如果check这个bool值为真，那么选l1，为假选l2！！！！！

//Merge two sorted linked lists and return it as a new list. The new list should
// be made by splicing together the nodes of the first two lists. 
//
// Example:
// 
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
// 
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null)
        {
            boolean check = (l1.val < l2.val);
            current.next = check ? l1 : l2;
            current = current.next;
            l1 = check ? l1.next : l1;
            l2 = check ? l2 : l2.next;
        }
        current.next = (l1 == null) ? l2 : l1;
        return dummy.next;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
