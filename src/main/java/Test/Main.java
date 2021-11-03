package Test;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
//        System.out.println(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }



    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
