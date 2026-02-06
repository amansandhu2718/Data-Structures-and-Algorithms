public class Aman26 {

    public static void main(String[] args) {

        NodeL n = new NodeL(10, new NodeL(20, new NodeL(30, new NodeL(40, new NodeL(50, null)))));
        NodeL rev = Reverse(n);
        PrintLinkedList(rev);

    }

    public static void PrintLinkedList(NodeL n) {
        NodeL head = n;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
    // A --> B --> c --> D --> E --> null

    // A <-- B --> c --> D --> E --> null
    // p c

    public static NodeL Reverse(NodeL root) {

        NodeL prevNode = null;
        NodeL currNode = root;

        while (currNode != null) {
            NodeL nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        return prevNode;
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
