package reverseLongToIntArray;

import java.io.IOException;
import java.util.LinkedList;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int[] result = solution(12345);
        for(int i : result)
            System.out.println(i);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int[] solution(long n) {
        int[] answer;
        int i=0;
        LinkedList<Long> linkedList = new LinkedList<>();
        while(n != 0){
            linkedList.add((long)n%10);
            n /= 10;
            i++;
        }
        answer = new int[i];
        i=0;
        while(!linkedList.isEmpty()){
            long temp = linkedList.remove();
            answer[i] = (int)temp;
            i++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
