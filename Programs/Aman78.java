public class Aman78 {
    public static void main(String[] args) {
        NodeL n8 = new NodeL(90, null);
        NodeL n7 = new NodeL(80, n8);
        NodeL n6 = new NodeL(70, n7);
        NodeL n5 = new NodeL(60, n6);
        NodeL n4 = new NodeL(50, n5);
        NodeL n3 = new NodeL(40, n4);
        NodeL n2 = new NodeL(30, n3);
        NodeL n1 = new NodeL(20, n2);
        n8.next = n4;
        NodeL head = new NodeL(10, n1);

        if (isCyclePresent(head)) {
            // System.out.println("cycle" + cycleNode(head).data);
            resolveCycle(head);
        }
        display(head);
    }

    public static void display(NodeL root) {
        if (root != null) {
            System.out.println(root.data);
        }

        if (root.next != null) {
            display(root.next);
        }
    }

    public static void resolveCycle(NodeL head) {

        NodeL start = cycleNode(head);

        if (start == null) {
            return;
        }

        NodeL temp = start;

        while (temp.next != start) {
            temp = temp.next;
        }

        temp.next = null; // break the cycle
    }

    public static NodeL cycleNode(NodeL n) {
        if (n == null || n.next == null) {
            return null;
        }
        NodeL slow = n;
        NodeL fast = n;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                // return slow;

                fast = n;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;

            }
        }
        return null;
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
