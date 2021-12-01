package searchHighScore;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int[] result = solution(new int[]{1,3,2,4,2});
        for(int i : result)
            System.out.println(i);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int point = 0;
        int[] check = new int[3];
        int max = 0;
        int[] one = new int[]{1,2,3,4,5};
        int[] two = new int[]{2,1,2,3,2,4,2,5};
        int[] three = new int[]{3,3,1,1,2,2,4,4,5,5};

        for(int i=0; i<answers.length; i++){
            int onepoint = i%one.length;
            int twopoint = i%two.length;
            int threepoint = i%three.length;
            check[0] = one[onepoint] == answers[i] ? check[0]+1 : check[0];
            check[1] = two[twopoint] == answers[i] ? check[1]+1 : check[1];
            check[2] = three[threepoint] == answers[i] ? check[2]+1 : check[2];
            max = check[0] >= check[1] ? check[0] : check[1];
            max = check[2] >= max ? check[2] : max;
        }

        point = 0;
        int count = 0;
        for(int i =0; i< 3; i++){
            if(max == check[i]){
                answer[point] = i+1;
                point++;
                count++;
            }
        }
        answer = Arrays.copyOf(answer, count);
        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
