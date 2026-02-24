import java.util.ArrayList;

public class Aman83 {
    public static void main(String[] args) {
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
        solution(root1);
    }

    public static void solution(NodeT n1) {
        ArrayList<Integer> arr1 = NodetoRootPath(n1, 4);
        ArrayList<Integer> arr2 = NodetoRootPath(n1, 5);
        int i = arr1.size() - 1;
        int j = arr2.size() - 1;
        int res = Integer.MAX_VALUE;
        while (i >= 0 && j >= 0) {
            if (arr1.get(i) != arr2.get(j)) {
                break;
            }
            res = arr1.get(i);
            i--;
            j--;
        }
        System.out.println(res);
    }

    public static ArrayList<Integer> NodetoRootPath(NodeT n, int x) {

        if (n.data == x) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(n.data);
            return arr;
        }

        for (int i = 0; i < n.children.length; i++) {
            ArrayList<Integer> chldArr = NodetoRootPath(n.children[i], x);
            if (chldArr.size() > 0) {
                chldArr.add(n.data);
                return chldArr;
            }
        }
        return new ArrayList<>();

    }

    public static NodeT getNewNode(int data) {
        NodeT n1 = new NodeT();
        n1.data = data;
        return n1;
    }
}

class Pair {
    NodeT node;
    int state;

    Pair(NodeT node, int state) {
        this.node = node;
        this.state = state;
    }
}

class NodeT {

    int data;

    NodeT children[] = new NodeT[] {};

}