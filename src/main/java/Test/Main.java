package Test;

import java.io.IOException;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(1);
//        for(String i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    class Node{
        int a;
        Node(int a){
            this.a=a;
        }
    }
    public int solution(int a) {
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Node node3 = node1;
        if(node1.equals(node2)) System.out.println("node1 equals node2");
        if(node1==node2) System.out.println("node1 == node2");
        if(node1.equals(node3)) System.out.println("node1 equals node3");
        if(node1==node3) System.out.println("node1 == node3");
        return 0;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
