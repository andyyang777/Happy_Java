//Design and implement a data structure for Least Recently Used (LRU) cache. It 
//should support the following operations: get and put. 
//
// get(key) - Get the value (will always be positive) of the key if the key exis
//ts in the cache, otherwise return -1. 
//put(key, value) - Set or insert the value if the key is not already present. W
//hen the cache reached its capacity, it should invalidate the least recently used
// item before inserting a new item. 
//
// The cache is initialized with a positive capacity. 
//
// Follow up: 
//Could you do both operations in O(1) time complexity? 
//
// Example: 
//
// 
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
// 
//
// 
// Related Topics Design


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class DoubleLinkedNode { //双向链表
    int key;  // 记录这个点存放的key和value
    int val;
    DoubleLinkedNode front;
    DoubleLinkedNode next;

    public DoubleLinkedNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, DoubleLinkedNode> map = new HashMap<>();
    DoubleLinkedNode head = new DoubleLinkedNode(0, 0);
    DoubleLinkedNode tail = new DoubleLinkedNode(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity; // 类似初始化
        head.next = tail;
        tail.front = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            DoubleLinkedNode node = map.get(key);
            moveNodeToTop(node);
            return node.val;
        } else  return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) deleteLastNode();
            DoubleLinkedNode temp = head.next;
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            head.next = newNode;
            newNode.front = head;
            newNode.next = temp;
            temp.front = newNode;
            map.put(key, newNode);
        } else {
            DoubleLinkedNode node = map.get(key);
            node.val = value;
            moveNodeToTop(node);
        }
    }

    private void deleteLastNode() {
        DoubleLinkedNode lastNode = tail.front;
        lastNode.front.next = tail;
        tail.front = lastNode.front;
        map.remove(lastNode.key);

    }

    private void moveNodeToTop(DoubleLinkedNode node) {
        node.front.next = node.next;
        node.next.front = node.front;
        DoubleLinkedNode temp = head.next;
        head.next = node;
        node.front = head;
        node.next = temp;
        temp.front = node;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
