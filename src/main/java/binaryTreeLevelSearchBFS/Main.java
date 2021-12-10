package binaryTreeLevelSearchBFS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(new int[]{23,87,65,12,57,32,99,81},8,32);
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    class Node{
        int data;
        Node lt, rt;
        public Node(int val){
            data= val;
            lt=rt=null;
        }
    }
    Node root;
    public void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L=0;
        while(!Q.isEmpty()){
            int len = Q.size();
            System.out.println(L+" : ");
            for(int i=0; i<len; i++){
                Node cur = Q.poll();
                System.out.print(cur.data+" ");
                if(cur.lt!=null) Q.offer(cur.lt);
                if(cur.rt!=null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }
    }
    public int solution(int[] array,int N, int M) {
        int answer=0;
        root = new Node(1);
        root.lt = new Node(2);
        root.rt= new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt= new Node(5);
        root.rt.lt=new Node(6);
        root.rt.rt=new Node(7);
        BFS(root);
        return answer;

    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
