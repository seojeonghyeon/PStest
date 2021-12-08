package removeCharacterInBracket;

import java.io.IOException;
import java.util.Stack;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        String result = solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)");
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public String solution(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(char s : str.toCharArray()){
            if(s=='(') stack.push(0);
            else if(s ==')') stack.pop();
            else if(stack.isEmpty()) stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
