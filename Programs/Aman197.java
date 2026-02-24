import java.util.Stack;

public class Aman197 {
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

        Stack<Pair> st = new Stack<>();
        Pair p1 = new Pair(n1, -1);
        st.push(p1);

        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == -1) {
                System.out.println(top.node.data); // pre order area
                top.state++;
            } else if (top.state == top.node.children.length) {
                st.pop(); // post order area
            } else {
                Pair c = new Pair(top.node.children[top.state], -1); // calls area
                st.push(c);
                top.state++;
            }
        }

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