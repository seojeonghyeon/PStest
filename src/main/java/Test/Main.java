package Test;

import java.io.*;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution("aabbaccc");
        System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    public int solution(String s) {
        int answer = 0;
        String answerString = "";
        if(s.length() < 2){
            return s.length();
        }
        char[] sArray = s.toCharArray();
        answer = sArray.length;
        for(int i = 1; i < (sArray.length/2)+1; i++){
            int point = 0;
            while(point < sArray.length){
                point = point + i;
            }

        }

        return answer;
    }
    public String compress(String str, int increaseSize){
        int finalLength = countCompression(str);
        if(finalLength >= str.length()) return str;
        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;
        for(int i =0; i<str.length(); i++){
            countConsecutive++;
            if(i+1 > str.length() || str.charAt(i) != str.charAt(i+1)){
                compressed.append(countConsecutive);
                compressed.append(str.charAt(i));
                countConsecutive=0;
            }
        }
        return compressed.toString();
    }
    public int countCompression(String str){
        int compressedLength = 0;
        int countConsecutive = 0;
        for(int i=0; i<str.length(); i++){
            countConsecutive++;
            if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive=0;
            }
        }
        return compressedLength;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
