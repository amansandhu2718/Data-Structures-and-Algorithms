import java.util.Stack;

public class Aman15 {
 public static void main(String[] args) {
   
     int arr [] = new int []{ 10,30,20,50,60,90,25};
        int res[]= NGE(arr);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
 }  

 public static int[] NGE(int arr[]){
    Stack <Integer> st = new Stack<Integer>();
    int res [] = new int[arr.length];
    res[arr.length-1]=-1;
    for(int i=arr.length-2;i>=0;i--){
      
        while (st.size()>0 && st.peek()<= arr[i]) {
            st.pop();
        }

        if(st.size()==0 ){
            res[i]=-1;
        }else{
            res[i]=st.peek();
        }

        st.push(arr[i]);
    }
    return res;
 }

}


// 90
// 25