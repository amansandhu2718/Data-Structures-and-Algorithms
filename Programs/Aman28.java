public class Aman28 {
    public static void main(String[] args) {
        // NodeL root = new NodeL(10,
        // new NodeL(20, new NodeL(30, new NodeL(40, new NodeL(50, new NodeL(60, new
        // NodeL(70, null)))))));

        NodeL root = new NodeL(10,
                new NodeL(20, new NodeL(30, null)));

        // 10 20 30 40 50 60 70 input
        // 50 60 70 10 20 30 40 output
        NodeL root2 = Rotate(root, 1);
        PrintLinkedList(root2);
    }

    public static void PrintLinkedList(NodeL n) {

        NodeL head = n;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
        System.out.println();
    }

    public static NodeL Rotate(NodeL root, int k) {

        if (root == null || root.next == null || k == 0)
            return root;

        // Step 1: Find length and tail
        NodeL tail = root;
        int length = 1;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Reduce k
        k = k % length;
        if (k == 0)
            return root;

        // Step 3: Make it circular
        tail.next = root;

        // Step 4: Find new tail
        NodeL newTail = root;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        // Step 5: Set new head
        NodeL newHead = newTail.next;
        newTail.next = null;

        return newHead;
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