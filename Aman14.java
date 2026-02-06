public class Aman14 {
    
    public static void main(String[] args) {
        
                
        Node root = new Node();
    
        root.data=10;
        root.children=new Node[]{ getNewNode(20),getNewNode(30),getNewNode(40)};
        root.children[0].children= new Node[]{getNewNode(50),getNewNode(60)};
        root.children[1].children= new Node[]{getNewNode(70),getNewNode(80),getNewNode(90)};
        root.children[2].children= new Node[]{getNewNode(100)};
        root.children[1].children[1].children= new Node[]{ getNewNode(110),getNewNode(120)};

        System.out.println(GetCount(root));
    }

    public static int GetCount(Node node){
        int max =0;
        if(node.children!=null){
            for(int i=0;i<node.children.length;i++){
                max=max+GetCount(node.children[i]);               
            }
        }        
        return max+1;
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

