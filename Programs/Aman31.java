public class Aman31 {
    public static void main(String[] args) {
        NodeL n = new NodeL(0, null);
        NodeL Root = n;
        for (int i = 1; i <= 1; i++) {
            n.next = new NodeL(i, null);
            n = n.next;
        }

        int k = 3;
        int i = 0;
        NodeL lastNodeL = Root;
        boolean error = false;
        while (i < k) {
            if (lastNodeL == null) {
                System.out.println("ERROR: linkedlist is smaller than k");
                error = true;
                break;
            }
            lastNodeL = lastNodeL.next;
            i++;
        }
        if (error) {
            return;
        }

        NodeL kthNode = Root;

        while (lastNodeL != null) {
            lastNodeL = lastNodeL.next;
            kthNode = kthNode.next;
        }

        System.out.println("kth from last : " + kthNode.data);

        Disaply(Root);
    }

    public static void Disaply(NodeL n) {
        if (n != null) {
            System.out.println(n.data);
        }
        if (n.next != null) {
            Disaply(n.next);
        }
    }

}
