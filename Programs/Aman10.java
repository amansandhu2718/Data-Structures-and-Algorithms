public class Aman10 {

    /**
     * Height of tree
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

        System.out.println(HeightOfTree(root));

    }

    public static Node184 getNewNode(int data) {
        Node184 n1 = new Node184();
        n1.data = data;
        return n1;
    }

    public static int HeightOfTree(Node184 node) {

        int max = 0;
        if (node.children != null) {
            for (int i = 0; i < node.children.length; i++) {
                int h = HeightOfTree(node.children[i]);
                if (h > max) {
                    max = h;
                }
            }
        }

        return max + 1;
    }

}

class Node {

    int data;

    Node184 children[];

}