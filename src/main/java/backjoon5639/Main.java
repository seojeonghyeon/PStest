package backjoon5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static class Node{
        int value;
        Node left, right;
        private Node(int value){
            this.value = value;
        }
        private void insert(int value){
            if(this.value > value){
                if(this.left == null) this.left = new Node(value);
                else this.left.insert(value);
            }else{
                if(this.right == null) this.right = new Node(value);
                else this.right.insert(value);
            }
        }
    }

    public void solution(Node root){
        postOrder(root);
    }
    private static void postOrder(Node node){
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(in.readLine()));
        while(true){
            String str = in.readLine();
            if(str == null) break;
            root.insert(Integer.parseInt(str));
        }
        Main main = new Main();
        main.solution(root);
    }
}
