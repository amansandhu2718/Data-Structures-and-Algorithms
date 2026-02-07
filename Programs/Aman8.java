import java.util.ArrayDeque;
import java.util.Queue;

public class Aman8 {

    public static void main(String[] args) {
        
        
        Node root = new Node();
    
        root.data=10;
        root.children=new Node[]{ getNewNode(20),getNewNode(30),getNewNode(40)};
        root.children[0].children= new Node[]{getNewNode(50),getNewNode(60)};
        root.children[1].children= new Node[]{getNewNode(70),getNewNode(80),getNewNode(90)};
        root.children[2].children= new Node[]{getNewNode(100)};
        root.children[1].children[1].children= new Node[]{ getNewNode(110),getNewNode(120)};

        
        TraverseGenericTreeLevelOrder(root);
        
        
    }




    public static Node getNewNode(int data){
        Node n1=new Node();
        n1.data=data;
        return n1;
    }


    public static void TraverseGenericTreeLevelOrder(Node node){

        Queue <Node> queue = new ArrayDeque<Node>() ;
    
        queue.add(node);


        while (queue.size()>0) {
            Node n = queue.remove();
            System.out.println(n.data);
            if(n.children!=null){
                for(int i=0;i<n.children.length;i++){
                    queue.add(n.children[i]);
                }
            }
        }
   
    }

}
 class  Node {

    int data;

    Node children[];

}