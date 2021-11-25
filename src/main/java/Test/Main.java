package Test;

import java.io.*;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
        System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    public int solution(int[][] triangle) {
        int answer = 0;

        return answer;
    }
    public int dynamic(int[][] triangle, int row, int col){

    }
    class Node{
        int value;
        boolean vistied;
        
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
