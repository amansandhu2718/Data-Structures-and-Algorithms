
import java.util.Stack;

public class Aman12 {

    /** 
     * level order lineaise zig zag
     */
    public static void main(String[] args) {
        
        
        Node root = new Node();
    
        root.data=10;
        root.children=new Node[]{ getNewNode(20),getNewNode(30),getNewNode(40)};
        root.children[0].children= new Node[]{getNewNode(50),getNewNode(60)};
        root.children[1].children= new Node[]{getNewNode(70),getNewNode(80),getNewNode(90)};
        root.children[2].children= new Node[]{getNewNode(100)};
        root.children[1].children[1].children= new Node[]{ getNewNode(110),getNewNode(120)};

        
        TraverseGenericTreeLevelOrderLinewise(root);
        
        
    }




    public static Node getNewNode(int data){
        Node n1=new Node();
        n1.data=data;
        return n1;
    }


    public static void TraverseGenericTreeLevelOrderLinewise(Node node){

        Stack <Node> stack = new Stack<Node>() ;
        Stack<Node> childStack = new Stack<Node>();
        stack.add(node);

        int m=1;
        while (stack.size()>0) {
            Node n = stack.pop();
            System.out.print(n.data +" ");
            if(n.children!=null){
                if(m%2==0){
                    for(int i=0;i<n.children.length;i++){
                        childStack.add(n.children[i]);
                    }
                }else{
                    for(int i=n.children.length-1;i>=0;i--){
                        childStack.add(n.children[i]);
                    }
                }
            }
            if(stack.size()==0){
                m++;
                System.out.println();
                stack=childStack;
                childStack= new Stack<>();
            }
        }
   
    }

}
 class  Node {

    int data;

    Node children[];

}