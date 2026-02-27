import java.util.HashMap;

public class Aman139 {
    public static void main(String[] args) {
        LRUCache ch = new LRUCache(3);
        ch.putValue("a", 1);
        ch.putValue("b", 2);
        ch.putValue("c", 3);
        ch.putValue("d", 4);
        ch.putValue("b", 21);
        System.out.println("b val: " + ch.getValue("b"));
    }
}

class LRUCache {

    private class Node {
        String key;
        int value;
        Node prev, next;

        Node(String k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private HashMap<String, Node> map;
    private Node head, tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(null, 0);
        tail = new Node(null, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int getValue(String key) {
        Node node = map.get(key);
        if (node == null)
            return -1;

        removeNode(node);
        addToFront(node);
        return node.value;
    }

    public void putValue(String key, int value) {
        Node node = map.get(key);

        if (node != null) {
            node.value = value;
            removeNode(node);
            addToFront(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            addToFront(newNode);
            map.put(key, newNode);
        }
    }
}