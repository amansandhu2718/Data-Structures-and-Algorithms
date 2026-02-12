import java.util.Stack;

public class Aman30 {
    public static void main(String[] args) {
        int arr[] = new int[] { 2, 4 };

        // 1,-1,2,2,-1,-1 smaller on right
        // -1,-1,1,5,1,2 smaller on left

        System.out.println("Right");
        int nsmor[] = nextSmallerElementOnRight(arr);
        // for (int i : nsmor) {
        // System.out.println(i);
        // }

        System.out.println("Left");
        int nsmol[] = nextSmallerElementOnLeft(arr);
        // for (int i : nsmol) {
        // System.out.println(i);
        // }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int width = nsmor[i] - nsmol[i] - 1;
            int height = arr[i];

            int area = width * height;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        System.out.println(maxArea);

    }

    public static int[] nextSmallerElementOnRight(int arr[]) {

        Stack<Integer> st = new Stack<>();
        int res[] = new int[arr.length];
        st.add(arr.length - 1);
        res[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0) {
                if (arr[st.peek()] >= arr[i]) {
                    st.pop();
                } else {
                    break;
                }
            }
            if (st.size() == 0) {
                // System.out.println(-1);
                res[i] = arr.length;
            } else {
                // System.out.println(st.peek());
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }

    public static int[] nextSmallerElementOnLeft(int arr[]) {

        Stack<Integer> st = new Stack<>();
        int res[] = new int[arr.length];
        st.add(0);
        res[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0) {
                if (arr[st.peek()] >= arr[i]) {
                    st.pop();
                } else {
                    break;
                }
            }
            if (st.size() == 0) {
                // System.out.println(-1);
                res[i] = -1;
            } else {
                // System.out.println(st.peek());
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
}
