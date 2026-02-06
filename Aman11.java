import java.util.ArrayDeque;
import java.util.Queue;

public class Aman11 {
    /**
     * Print leaf nodes
     * remove leaf nodes
     * @param args
     */
 public static void main(String[] args) {
    Node root = new Node();
    
        root.data=10;
        root.children=new Node[]{ getNewNode(20),getNewNode(30),getNewNode(40)};
        root.children[0].children= new Node[]{getNewNode(50),getNewNode(60)};
        root.children[1].children= new Node[]{getNewNode(70),getNewNode(80),getNewNode(90)};
        root.children[2].children= new Node[]{getNewNode(100)};
        root.children[1].children[1].children= new Node[]{ getNewNode(110),getNewNode(120)};

        
        PrintLeafNodes(root);
        RemoveLeafNodes(root);
        System.out.println("after removing: ");
        TraverseGenericTreePostOrder(root);
 }   


 public static void RemoveLeafNodes(Node node){
    if(node.children!=null){
        for(int i=0;i<node.children.length;i++){
            if(node.children[i]!=null){
                RemoveLeafNodes(node.children[i]);
            }
        }

        for(int i=0;i<node.children.length;i++){
            if(node.children[i]!=null && (node.children[i].children==null || node.children[i].children.length==0)){
                node.children[i]=null;
            }
        }
    }

 }
 public static void PrintLeafNodes(Node node){
    if( node.children==null || node.children.length==0 ){
        System.out.println(node.data);
    }else{
        for(int i=0;i<node.children.length;i++){
            PrintLeafNodes(node.children[i]);
        }
    }
 }

 
  public static void TraverseGenericTreePostOrder(Node node){
        if(node==null){
            return;
        }
        if(node!=null&& node.children!=null && node.children.length>0){
            for (int i = 0; i < node.children.length; i++) {
                TraverseGenericTreePostOrder(node.children[i]);
            }
        }
        System.out.println(""+node.data);

    }

    public static Node getNewNode(int data){
        Node n1=new Node();
        n1.data=data;
        return n1;
    }
}
 class  Node {

    int data;

    Node children[];

}