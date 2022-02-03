package backjoon9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public void solution(String str, String bubbleStr) {
        if(str.length() < bubbleStr.length()) {
            System.out.println(str);
            return;
        }
        String result = bubble(str, bubbleStr);
        System.out.println(result.length() > 0 ? result : "FRULA");
    }
    private String bubble(String str, String bubbleStr){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
            if(stack.size() >= bubbleStr.length()){
                boolean check = true;
                for(int j=0; j<bubbleStr.length(); j++){
                    if(stack.get(stack.size() - bubbleStr.length() + j) != bubbleStr.charAt(j)){
                        check = false;
                        break;
                    }
                }
                if(check){
                    for(int j=0; j<bubbleStr.length(); j++) stack.pop();
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : stack) stringBuilder.append(c);
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        String bubbleStr = in.readLine();

        Main main = new Main();
        main.solution(str, bubbleStr);
    }
}
