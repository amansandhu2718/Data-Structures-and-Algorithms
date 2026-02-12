public class Aman38 {
    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(GetMajorityElement(arr));
    }

    public static int GetMajorityElement(int arr[]) {

        int m_element = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == m_element) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                m_element = arr[i];
                count = 1;
            }
        }

        count = 0;

        for (int num : arr) {
            if (num == m_element) {
                count++;
            }
        }

        return count > arr.length / 2 ? m_element : -1;

    }
}
