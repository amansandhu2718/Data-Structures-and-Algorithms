public class Aman195 {
    public static void main(String[] args) {
        // ceil -> just smaller
        // sloor -> just larger

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

        int arr[] = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        Solve(root1, arr, 14); // ceil , floor
        System.out.println("ceil: " + arr[0]);
        System.out.println("floor: " + arr[1]);

    }

    public static void Solve(NodeT n1, int arr[], int target) {
        if (n1.data > target) {
            arr[0] = n1.data;
        }
        if (n1.data < target && n1.data > arr[1]) {
            arr[1] = n1.data;
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