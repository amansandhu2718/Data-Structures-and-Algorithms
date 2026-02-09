import java.util.ArrayDeque;
import java.util.Queue;

public class Aman11 {
    /**
     * Print leaf nodes
     * remove leaf nodes
     * 
     * @param args
     */
    public static void main(String[] args) {
        Node184 root = new Node184();

        root.data = 10;
        root.children = new Node184[] { getNewNode(20), getNewNode(30), getNewNode(40) };
        root.children[0].children = new Node184[] { getNewNode(50), getNewNode(60) };
        root.children[1].children = new Node184[] { getNewNode(70), getNewNode(80), getNewNode(90) };
        root.children[2].children = new Node184[] { getNewNode(100) };
        root.children[1].children[1].children = new Node184[] { getNewNode(110), getNewNode(120) };

        PrintLeafNodes(root);
        RemoveLeafNodes(root);
        System.out.println("after removing: ");
        TraverseGenericTreePostOrder(root);
    }

    public static void RemoveLeafNodes(Node184 node) {
        if (node.children != null) {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    RemoveLeafNodes(node.children[i]);
                }
            }

            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null
                        && (node.children[i].children == null || node.children[i].children.length == 0)) {
                    node.children[i] = null;
                }
            }
        }

    }

    public static void PrintLeafNodes(Node184 node) {
        if (node.children == null || node.children.length == 0) {
            System.out.println(node.data);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                PrintLeafNodes(node.children[i]);
            }
        }
    }

    public static void TraverseGenericTreePostOrder(Node184 node) {
        if (node == null) {
            return;
        }
        if (node != null && node.children != null && node.children.length > 0) {
            for (int i = 0; i < node.children.length; i++) {
                TraverseGenericTreePostOrder(node.children[i]);
            }
        }
        System.out.println("" + node.data);

    }

    public static Node184 getNewNode(int data) {
        Node184 n1 = new Node184();
        n1.data = data;
        return n1;
    }
}

class Node184 {

    int data;

    Node184 children[];

}