package postfixForCal;

import java.io.IOException;
import java.util.Stack;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution("352+*9-");
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for(char s : str.toCharArray()){
            if(Character.isDigit(s)){
                stack.push(Character.getNumericValue(s));
            }else{
                int temp = 0;
                int second = stack.pop();
                int first = stack.pop();
                if(s=='+') temp = first+second;
                else if(s=='-') temp = first-second;
                else if(s=='*') temp = first*second;
                else if(s=='/') temp = first/second;
                stack.push(temp);
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
