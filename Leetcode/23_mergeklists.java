//Merge k sorted linked lists and return it as one sorted list. Analyze and desc
//ribe its complexity. 
//
// Example: 
//
// 
//Input:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//Output: 1->1->2->3->4->4->5->6
// 
// Related Topics Linked List Divide and Conquer Heap


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.PriorityQueue;

class Solution {
        class NodeComparator implements Comparator<ListNode>{
            @Override
            public int compare(ListNode a, ListNode b)
            {
                return a.val - b.val; //牛逼啊！重写判断值正负，返回boolean
            }
        }
        public ListNode mergeKLists(ListNode[] lists)
        {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;

            int size = lists.length;
            if (lists == null || size == 0) return dummy.next;
            NodeComparator cmp = new NodeComparator();
            PriorityQueue<ListNode> PQ = new PriorityQueue(cmp);
            for (int i = 0; i < size; i++)
            {
                if (lists[i] != null)
                    PQ.add(lists[i]);
            }
            while (PQ.size() != 0)
            {
                ListNode node = PQ.poll();
                current.next = node;
                current = current.next;
                if (node.next != null)
                {
                    PQ.add(node.next);
                }
            }
            return dummy.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
