package gatherDictionary;

import java.io.IOException;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution("I");
//        for(String i : result)
        System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(String word) {
        int answer = word.length();
        int[] dic = {781, 156, 31, 6, 1};
        String apla = "AEIOU";
        for(int i=0; i< word.length(); i++)
            answer+=(dic[i]*apla.indexOf(word.charAt(i)));
        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
