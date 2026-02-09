import java.util.ArrayList;
import java.util.Stack;

public class Aman184 {
    public static void main(String[] args) {

        int arr[] = {
                10,
                20,
                40, -1,
                50, 80, -1, 90, -1, -1,
                -1,
                30,
                60, -1,
                70, -1,
                -1,
                -1
        };

        Node184 root = new Node184(arr[0], null);
        Stack<Node184> st = new Stack<>();
        st.push(root);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node184 n = new Node184(arr[i], null);
                Node184 stpeek = st.peek();
                stpeek.AddChild(n);
                st.push(n);
            }
        }

        // System.out.println("pre:");
        // DisplayTreePreOrder(root);
        // RemoveLeaves(root);
        // System.out.println("pre: after removinf leaves: ");
        // DisplayTreePreOrder(root);

        // System.out.println("pre: after linearize: ");
        // LinearizeOptimized(root);
        // DisplayTreePreOrder(root);
        // // DisplayTreePostOrder(root);

        // System.out.println("pre: path from 50 to root ");
        // ArrayList<Integer> List = NodetoRootPath(root, 50);
        // for (int i : List) {
        // System.out.println(i);
        // }

        // LCA(20, 30, root); // LCA is last common node
        // DisatanceBetweenNodes(20, 30, root); // LCA is last common node

        CalculateDiameterReturnHeight(root);
        System.out.println(Diameter);
    }

    public static void DisplayTreePreOrder(Node184 n) {
        System.out.println(n.data);
        for (int i = 0; i < n.arr.size(); i++) {
            DisplayTreePreOrder(n.arr.get(i));
        }
    }

    public static void DisplayTreePostOrder(Node184 n) {

        for (Node184 child : n.arr) {

            DisplayTreePostOrder(child);

        }

        System.out.println("Post:" + n.data);
    }

    public static void RemoveLeaves(Node184 n) {
        for (int i = n.arr.size() - 1; i >= 0; i--) {
            Node184 child = n.arr.get(i);
            if (child.arr.size() == 0) {
                n.arr.remove(i);
            }
        }
        for (int i = 0; i < n.arr.size(); i++) {
            RemoveLeaves(n.arr.get(i));
        }

    }

    public static void Linearize(Node184 n) {
        for (int i = 0; i < n.arr.size(); i++) {
            Linearize(n.arr.get(i));
        }
        while (n.arr.size() > 1) {
            Node184 lastNode = n.arr.remove(n.arr.size() - 1);
            Node184 secondLastNode = n.arr.get(n.arr.size() - 1);
            Node184 sLTail = getTail(secondLastNode);
            sLTail.arr.add(lastNode);
        }
    }

    public static ArrayList<Integer> NodetoRootPath(Node184 n, int x) {

        if (n.data == x) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(n.data);
            return arr;
        }

        for (int i = 0; i < n.arr.size(); i++) {
            ArrayList<Integer> chldArr = NodetoRootPath(n.arr.get(i), x);
            if (chldArr.size() > 0) {
                chldArr.add(n.data);
                return chldArr;
            }
        }
        return new ArrayList<>();

    }

    public static Node184 LinearizeOptimized(Node184 n) {
        if (n.arr.size() == 0) {
            return n;
        }
        Node184 lastNodeTail = LinearizeOptimized(n.arr.get(n.arr.size() - 1));
        while (n.arr.size() > 1) {
            Node184 lastNode = n.arr.remove(n.arr.size() - 1);
            Node184 secondLastNode = n.arr.get(n.arr.size() - 1);
            Node184 slntail = LinearizeOptimized(secondLastNode);
            slntail.AddChild(lastNode);
        }
        return lastNodeTail;
    }

    public static void LCA(int data1, int data2, Node184 root) {

        ArrayList<Integer> arr1 = NodetoRootPath(root, data1);
        ArrayList<Integer> arr2 = NodetoRootPath(root, data2);

        int i = arr1.size() - 1;
        int j = arr2.size() - 1;
        int res = -1;
        System.err.println(arr1);
        System.err.println(arr2);
        while (i >= 0 && j >= 0 && arr1.get(i) == arr2.get(j)) {
            res = arr1.get(i);
            i--;
            j--;
        }
        System.out.println("LCA : " + res);
    }

    public static void DisatanceBetweenNodes(int data1, int data2, Node184 root) {

        ArrayList<Integer> arr1 = NodetoRootPath(root, data1);
        ArrayList<Integer> arr2 = NodetoRootPath(root, data2);

        int i = arr1.size() - 1;
        int j = arr2.size() - 1;

        System.err.println(arr1);
        System.err.println(arr2);
        while (i >= 0 && j >= 0 && arr1.get(i) == arr2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        System.out.println("distance : " + (i + j));
    }

    public static Node184 getTail(Node184 n) {

        while (n.arr.size() == 1) {
            n = n.arr.get(0);
        }
        return n;
    }

    public static int Diameter = -1;

    // this function is returning height but updating Diameter;
    public static int CalculateDiameterReturnHeight(Node184 n) {
        int dch = -1;
        int sdch = -1;
        for (int i = 0; i < n.arr.size(); i++) {
            int ch = CalculateDiameterReturnHeight(n.arr.get(i));

            if (ch > dch) {
                sdch = dch;
                dch = ch;
            } else if (ch > sdch) {
                sdch = ch;
            }
        }
        int cand = dch + sdch + 2;
        if (cand > Diameter) {
            Diameter = cand;
        }

        return dch + 1;
    }
}

class Node184 {
    int data = 0;
    ArrayList<Node184> arr = new ArrayList<>();

    Node184(int data, ArrayList<Node184> arr) {
        this.data = data;
        if (arr == null) {
            this.arr = new ArrayList<>();
        }
    }

    public void AddChild(Node184 n) {
        arr.add(n);
    }
}