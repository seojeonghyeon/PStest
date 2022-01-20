package Test;

import java.io.IOException;
import java.util.*;


public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        String result = solution("02:03:55", "00:14:15", new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
