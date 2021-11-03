package reverseNotationOfThree;


import java.io.IOException;
import java.util.Stack;

public class Main {
    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        System.out.println(solution(45));
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    public int solution(int n) {
        int answer = 0;
        int count =0;
        int i=0;
        Stack<Integer> stack = new Stack<>();
        while(n != 0){
            stack.push(n%3);
            n/=3;
        }
        while(!stack.isEmpty()){
            answer += stack.pop()*Math.pow(3, count++);
        }
        return answer;
    }




    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
