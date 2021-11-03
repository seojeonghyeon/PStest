package numberOfmeasure;


import java.io.IOException;

public class Main {
    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        System.out.println(solution(13,17));
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(int left, int right) {
        int answer = 0;
        for(int i= left; i<=right; i++){
            boolean output = isOddOfMeasure(i);
            if(output){
                answer+=i;
            }else{
                answer-=i;
            }
        }
        return answer;
    }
    public boolean isOddOfMeasure(int number){
        int count =0;
        for(int i= 1; i<=number; i++){
            if(number%i == 0) count++;
        }
        return count%2 == 0 ? true : false;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
