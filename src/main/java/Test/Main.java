package Test;

import java.io.IOException;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
//        for(int i : result)
        System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    class Node implements Comparable<Node>{
        int id;
        int plays;
        @Override
        public int compareTo(Node ob){
            return ob.plays-this.plays;
        }
    }
    public int solution(String[] genres, int[] plays)
    {
        int answer = 1;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
