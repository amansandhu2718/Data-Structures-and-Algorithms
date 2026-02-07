public class Aman28 {
    public static void main(String[] args) {
        // NodeL root = new NodeL(10,
        // new NodeL(20, new NodeL(30, new NodeL(40, new NodeL(50, new NodeL(60, new
        // NodeL(70, null)))))));

        NodeL root = new NodeL(10,
                new NodeL(20, new NodeL(30, null)));

        // 10 20 30 40 50 60 70 input
        // 50 60 70 10 20 30 40 output
        NodeL root2 = Rotate(root, 3);
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
        NodeL head = root;
        NodeL tail = root;

        int count = 1;
        while (count <= k) {
            if (tail == null || tail.next == null) {
                System.out.println("error");
                return null;
            }
            tail = tail.next;
            count++;
        }
        System.out.println(tail.data);
        while (tail.next != null) {
            tail = tail.next;
            head = head.next;
        }
        System.out.println(head.data);

        NodeL newtail = head;
        head = head.next;
        newtail.next = null;

        tail.next = root;
        return head;
    }

}
