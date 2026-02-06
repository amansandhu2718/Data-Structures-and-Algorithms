
import java.util.Stack;

public class Aman23 {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 30, 20, 50, 60, 90, 25 };
        int res[] = PSE(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] PSE(int arr[]) {
        int res[] = new int[arr.length];
        Stack<Integer> st = new Stack<Integer>();

        res[0] = -1;
        st.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && st.peek() >= arr[i]) {
                st.pop();
            }

            if (st.size() > 0) {
                res[i] = st.peek();
            } else {
                res[i] = -1;
            }
            st.push(arr[i]);
        }

        return res;
    }
}
