import java.util.ArrayDeque;
import java.util.Queue;

public class Aman9 {

    /** 
     * level order lineaise
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

        Queue <Node> queue = new ArrayDeque<Node>() ;
        Queue<Node> childQueue = new ArrayDeque<Node>();
        queue.add(node);


        while (queue.size()>0) {
            Node n = queue.remove();
            System.out.print(n.data +" ");
            if(n.children!=null){
                for(int i=0;i<n.children.length;i++){
                    childQueue.add(n.children[i]);
                }
            }
            if(queue.size()==0){
                System.out.println();
                queue=childQueue;
                childQueue= new ArrayDeque<>();
            }
        }
   
    }

}
 class  Node {

    int data;

    Node children[];

}