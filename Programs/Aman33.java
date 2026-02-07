public class Aman33 {
    public static void main(String[] args) {
        NodeL n = new NodeL(0, null);
        NodeL Root = n;
        for (int i = 1; i <= 2; i++) {
            n.next = new NodeL(i, null);
            n = n.next;
        }
        displayReverse(Root);

    }

    public static void displayReverse(NodeL Root) {
        if (Root != null && Root.next != null) {
            displayReverse(Root.next);
        }
        if (Root != null) {
            System.out.println(Root.data);
        }
    }
}
