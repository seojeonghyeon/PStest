package Test;

import java.io.*;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution("abcc");
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    char[][] keyboardArray;
    HashMap<String, Integer> hashMap;
    int xpoint = 0;
    int ypoint = 0;
    public int solution(String s) {
        int answer = -1;
        hashMap = new HashMap<>();
        char[] sArray = s.toCharArray();
        keyboardArray = new char[][]{
                {'q','w','e','r','t','y','u','i','o'},
                {'p','a','s','d','f','g','h','j','k'},
                {'l','z','x','c','v','b','n','m','!'}
        };

        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
