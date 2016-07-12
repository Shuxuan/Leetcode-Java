package cache;

import java.util.HashMap;

/**
 * Created by shuxuannie on 7/11/16.
 */
public class LRUCache {

    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hs.containsKey(key)) {
            return -1;
        }

        Node current = hs.get(key);

        //remove current
        current.prev.next = current.next;
        current.next.prev = current.prev;

        //move current to head
        move2head(current);
        return hs.get(key).value;
    }

    public void set(int key, int value) {
        if (get(key) != -1 ) {
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == this.capacity ) {
            //remove tail
            hs.remove(tail.prev.key);
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;

        }

        //insert into head
        Node insert = new Node(key, value);
        hs.put(key, insert);
        move2head(insert);
    }

    public void move2head(Node current) {
        current.next = head.next;
        head.next = current;
        current.prev = head;
        current.next.prev = current;

    }

    public static void main(String[] args) {
        int capacity = 2;
        LRUCache cache = new LRUCache(capacity);
        System.out.println(cache.get(2));
        cache.set(2,6);
        System.out.println(cache.get(1));
        cache.set(1,5);
        cache.set(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
