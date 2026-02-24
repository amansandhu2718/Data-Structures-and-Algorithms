public class Aman194 {
    public static void main(String[] args) {
        // predecessor -> node before element in preoder
        // successor -> node after element in preoder

        NodeT root1 = getNewNode(1);

        root1.children = new NodeT[] {
                getNewNode(2),
                getNewNode(3),
                getNewNode(12)
        };

        root1.children[0].children = new NodeT[] {
                getNewNode(14),
                getNewNode(15)
        };

        root1.children[2].children = new NodeT[] {
                getNewNode(5),
                getNewNode(4)
        };

        Solve(root1, new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 0 }, 3); // pre , succ , state

    }

    public static void Solve(NodeT n1, int arr[], int target) {
        if (arr[2] == 2) {
            return;
        } else if (arr[2] == 0) {
            if (n1.data == target) {
                System.out.println("PRE:" + arr[0]);
                arr[2] = 1;
            } else {
                arr[0] = n1.data;
            }
        } else if (arr[2] == 1) {
            System.out.println("SUC:" + n1.data);
            arr[2] = 2;
        }
        for (int i = 0; i < n1.children.length; i++) {
            Solve(n1.children[i], arr, target);
        }
    }

    public static NodeT getNewNode(int data) {
        NodeT n1 = new NodeT();
        n1.data = data;
        return n1;
    }
}

class NodeT {

    int data;

    NodeT children[] = new NodeT[] {};

}