public class Aman32 {
    public static void main(String[] args) {

        NodeL n = new NodeL(0, null);
        NodeL Root = n;
        for (int i = 1; i <= 2; i++) {
            n.next = new NodeL(i, null);
            n = n.next;
        }

        System.out.println(MiddleLinkedlist(Root).data);
    }

    public static NodeL MiddleLinkedlist(NodeL root) {
        NodeL fast = root;
        NodeL slow = root;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
