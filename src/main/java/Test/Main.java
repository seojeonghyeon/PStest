package Test;


import java.io.*;
import java.util.LinkedList;

public class Main {
    public void solution(){

    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

    }
}
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
    }
    void appendToTail(int data){
        Node end = new Node(data);
        Node n = this;
        while(n.next != null){
            n = next;
        }
        n.next = end;
    }
}
