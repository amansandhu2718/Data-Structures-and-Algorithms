public class Aman17 {
    public static void main(String[] args) {

        int arr[][] = new int [][]
        {
            {0,0,0,0,0,1,1,1},
            {0,0,0,0,1,1,1,1},
            {0,0,0,1,1,1,1,1},
            {0,1,1,1,1,1,1,1}
        };

        System.out.println(getRowIndexWithMaxOnes(arr));

    }

    public static int getRowIndexWithMaxOnes(int arr[][]){
        int res = -1;
        int i = 0;
        int j = arr[0].length - 1;

        while (i < arr.length && j >= 0) {

            if (arr[i][j] == 1) {
                res = i;  // this row has more 1s so far
                j--;      // move left
            } else {
                i++;      // move down
            }
        }

        return res;
    }

}
