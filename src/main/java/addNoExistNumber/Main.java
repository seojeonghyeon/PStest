package addNoExistNumber;

import java.io.IOException;

public class Main {
    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        System.out.println(solution(new int[]{5,8,4,0,6,7,9}));
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    public int solution(int[] numbers) {
        int answer = (0+1+2+3+4+5+6+7+8+9);
        for(int i=0; i<numbers.length; i++) answer -= numbers[i];
        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
