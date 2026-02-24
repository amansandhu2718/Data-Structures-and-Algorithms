public class Aman191 {
    public static void main(String[] args) {

        NodeT root1 = getNewNode(1);

        root1.children = new NodeT[] {
                getNewNode(2),
                getNewNode(3),
                getNewNode(2)
        };

        root1.children[0].children = new NodeT[] {
                getNewNode(4),
                getNewNode(5)
        };

        root1.children[2].children = new NodeT[] {
                getNewNode(5),
                getNewNode(4)
        };
        NodeT root2 = getNewNode(1);

        root2.children = new NodeT[] {
                getNewNode(2),
                getNewNode(3),
                getNewNode(2)
        };

        root2.children[0].children = new NodeT[] {
                getNewNode(4),
                getNewNode(5)
        };

        root2.children[2].children = new NodeT[] {
                getNewNode(5),
                getNewNode(4)
        };

        System.out.println("" + IsMirror(root1, root2));
    }

    public static NodeT getNewNode(int data) {
        NodeT n1 = new NodeT();
        n1.data = data;
        return n1;
    }

    public static boolean IsMirror(NodeT n1, NodeT n2) {
        if (n1.data != n2.data) {
            return false;
        }

        if (n1.children.length != n2.children.length) {
            return false;
        }
        for (int i = 0; i < n1.children.length; i++) {
            int j = n1.children.length - 1 - i;

            NodeT c1 = n1.children[i];
            NodeT c2 = n2.children[j];
            if (!IsMirror(c1, c2)) {
                return false;
            }
        }
        return true;
    }
}

class NodeT {

    int data;

    NodeT children[] = new NodeT[] {};

}