package stackWorkAmounts;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int[] result = solution(new int[]{93,30,55}, new int[]{1,30,5});
        for(int i : result)
            System.out.println(i);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        int point = 0;
        int staticDays = 0;
        int amounts= 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<progresses.length; i++){
            int digitDays = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i] != 0) digitDays++;
            queue.add(digitDays);
        }
        while(!queue.isEmpty()){
            int temp = queue.remove();
            if(staticDays == 0){
                staticDays = temp;
                amounts++;
            }else if(staticDays >= temp){
                amounts++;
            }else{
                answer[point]=amounts;
                staticDays=temp;
                amounts=1;
                point++;
            }

            if(queue.isEmpty()){
                answer[point]=amounts;
                point++;
            }
        }
        if(point < progresses.length){
            answer = Arrays.copyOf(answer, point);
        }
        return answer;
    }



    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
