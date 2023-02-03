package Assignment;
public class Node {
    Node next;
    Object data;
    Node (){
    }
    Node (Object data,Node p){
        this.data = data;
        next = p;
    }
   
    Node(Object data){
        this(data,null);
    }
}
