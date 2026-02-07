public class Aman5{
    

    /**
     * Maximum Subarray Sum - Kadane's Algorithm
    */
    public static void main(String[] args) {
        
        int arr[]= new int []{5, 4, 1, 7, 8};

        int currentMax=arr[0];
        int bestMax=arr[0];
        for(int i=1;i<arr.length;i++){
            if(currentMax>0){
                currentMax=currentMax+arr[i];
            }else{
                currentMax=arr[i];
            }

            if(currentMax>bestMax){
                bestMax=currentMax;
            }
        }

        System.out.println(bestMax);
    }
}


