public class Aman29 {
    public static void main(String[] args) {
        NodeL n8 = new NodeL(90, null);
        NodeL n7 = new NodeL(80, n8);
        NodeL n6 = new NodeL(70, n7);
        NodeL n5 = new NodeL(60, n6);
        NodeL n4 = new NodeL(50, n5);
        NodeL n3 = new NodeL(40, n4);
        NodeL n2 = new NodeL(20, n3);
        NodeL n1 = new NodeL(20, n2);
        n8.next = n4;
        NodeL head = new NodeL(10, n1);
        System.out.println(isCyclePresent(head));
    }

    public static boolean isCyclePresent(NodeL n) {
        if (n == null || n.next == null) {
            return false;
        }
        NodeL slow = n;
        NodeL fast = n;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}

class NodeL {
    int data;
    NodeL next;

    NodeL(int data, NodeL next) {
        this.data = data;
        this.next = next;
    }
}
