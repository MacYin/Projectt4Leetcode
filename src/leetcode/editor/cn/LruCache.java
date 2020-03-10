//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计

package leetcode.editor.cn;

import java.util.HashMap;

public class LruCache{
    public static void main(String[] args) {
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private HashMap<Integer,Node> cache = new HashMap<>();
    private int count;
    private int capacity;
    private Node head,tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new Node();
        head.prev = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get( key );
        if( node == null ) {
            return -1;
        }
        moveToHead( node );

        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = cache.get( key );
        if( node == null ) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;

            cache.put( key, newNode );
            addNode( newNode );
            ++count;

            if(count > capacity){
                Node tail = popTail();
                // 同步移除map中元素

                cache.remove( tail.key );
                --count;
            }
        }else{
            node.val = value;
            this.moveToHead(node);
        }
    }

    public void moveToHead( Node node ){
        removeNode( node );
        addNode( node );
    }

    public void addNode( Node node ){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    public void removeNode( Node node ){
        node.next.prev = node.prev;
        node.prev.next = node.next;

        node.prev = null;
        node.next = null;
    }

    public Node popTail(){
        Node node = tail.prev;
        removeNode( node );
        return node;
    }
}

class Node{
    int key;
    int val;
    Node prev;
    Node next;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}