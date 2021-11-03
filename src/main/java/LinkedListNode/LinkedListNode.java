package LinkedListNode;

class LinkedList {
    Node header;
    static class Node {
        int data;
        Node next = null;
    }
    LinkedList(){
        header = new Node();
    }
    LinkedList(int data){
        header = new Node();
        header.data = data;
    }
    void append(int d){
        Node end = new Node();
        end.data = d;
        Node n = header;
        while(n.next !=null){
            n=n.next;
        }
        n.next = end;
    }
    void delete(int d){
        Node n = header;
        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
            }else{
                n = n.next;
            }
        }
    }
    void retrieve(){
        Node n = header.next;
        while(n.next != null){
            System.out.print(n.data + "->");
            n=n.next;
        }
        System.out.println(n.data);
    }
}
public class LinkedListNode{
    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l1.append(4);
        l1.retrieve();
        l1.delete(1);
        l1.retrieve();
    }
}
