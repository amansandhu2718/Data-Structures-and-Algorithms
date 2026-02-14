
import java.util.PriorityQueue;

public class Aman62 {
    public static void main(String[] args) {
        // merge k sorted linkedlists
        Node n0 = new Node(0, new Node(2, new Node(3, new Node(5, null))));
        Node n1 = new Node(0, new Node(1, new Node(4, new Node(5, null))));
        Node n2 = new Node(0, new Node(1, new Node(2, new Node(3, new Node(6, new Node(7, null))))));
        Node arr[] = new Node[] { n0, n1, n2 };
        Node result = MergeKSorted(arr);
        display(result);
    }

    public static void display(Node n) {
        if (n == null) {
            return;
        }
        System.out.println(n.data);
        if (n.next != null) {
            display(n.next);
        }
    }

    public static Node MergeKSorted(Node[] lists) {

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for (int i = 0; i < lists.length; i++) {
            pq.add(lists[i]);
        }

        Node head = new Node(-1, null);
        Node temp = head;

        while (pq.size() > 0) {
            Node top = pq.poll();
            Node topNext = top.next;
            temp.next = top;
            temp = temp.next;
            top.next = null;
            if (topNext != null) {
                pq.add(topNext);
            }
        }
        return head.next;
    }

}

class Node implements Comparable<Node> {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public int compareTo(Node o) { // -1, 0,1
        return this.data - o.data;
    }
}
