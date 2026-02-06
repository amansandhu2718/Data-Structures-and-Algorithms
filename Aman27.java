public class Aman27 {
    public static void main(String[] args) {
        NodeL root1 = new NodeL(10, new NodeL(20, new NodeL(30, new NodeL(40, new NodeL(50, null)))));

        NodeL root2 = new NodeL(15,
                new NodeL(25, new NodeL(30, new NodeL(45, new NodeL(50, new NodeL(60, new NodeL(70, null)))))));
        System.out.println();
        System.out.println();
        System.err.println("root 1 : ");
        PrintLinkedList(root1);
        System.err.println("root 2 : ");
        PrintLinkedList(root2);
        System.err.println("merged (created new nodes) : ");
        NodeL head = MergeSortedLinkedlist(root1, root2);
        PrintLinkedList(head);

        System.err.println("root 1 : ");
        PrintLinkedList(root1);
        System.err.println("root 2 : ");
        PrintLinkedList(root2);
        System.err.println("merged : ");

        NodeL head2 = MergeSortedLinkedlistInplace(root1, root2);

        PrintLinkedList(head2);
        System.err.println("root 1 : ");
        PrintLinkedList(root1);
        System.err.println("root 2 : ");
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

    public static NodeL MergeSortedLinkedlistInplace(NodeL root1, NodeL root2) {

        NodeL head = null;
        NodeL tail = null;
        while (root1 != null && root2 != null) {
            // System.out.println("->" + root1.data + " " + root2.data);
            if (root1.data < root2.data) {
                // System.out.println("c1");

                if (head == null) {
                    // System.out.println("c1.1");
                    head = root1;
                    tail = root1;
                    root1 = root1.next;

                } else {
                    // System.out.println("c1.2");
                    tail.next = root1;
                    tail = tail.next;
                    root1 = root1.next;
                }
            } else {
                // System.out.println("c2");
                if (head == null) {
                    head = root2;
                    tail = root2;
                    root2 = root2.next;
                } else {
                    tail.next = root2;
                    tail = root2;
                    root2 = root2.next;
                }
            }
        }
        while (root1 != null) {

            tail.next = root1;
            tail = tail.next;
            root1 = root1.next;
        }
        while (root2 != null) {

            tail.next = root2;
            tail = tail.next;
            root2 = root2.next;
        }

        return head;
    }

    public static NodeL MergeSortedLinkedlist(NodeL root1, NodeL root2) {
        NodeL Pt1 = root1;
        NodeL Pt2 = root2;
        NodeL head = null;
        NodeL tail = null;
        while (Pt1 != null && Pt2 != null) {

            NodeL tobeadded = new NodeL(0, null);

            if (Pt2.data < Pt1.data) {

                tobeadded.data = Pt2.data;
                Pt2 = Pt2.next;
            } else {

                tobeadded.data = Pt1.data;
                Pt1 = Pt1.next;
            }
            if (head == null) {
                head = tobeadded;
                tail = tobeadded;

            } else {

                tail.next = tobeadded;
                tail = tobeadded;
            }

        }

        while (Pt1 != null) {
            NodeL tobeadded = new NodeL(0, null);
            tobeadded.data = Pt1.data;
            Pt1 = Pt1.next;
            tail.next = tobeadded;
            tail = tobeadded;
        }
        while (Pt2 != null) {
            // System.out.println("pt2 data:" + Pt2.data);

            NodeL tobeadded = new NodeL(0, null);
            tobeadded.data = Pt2.data;
            tail.next = tobeadded;
            tail = tobeadded;

            Pt2 = Pt2.next;
        }
        return head;
    }
}