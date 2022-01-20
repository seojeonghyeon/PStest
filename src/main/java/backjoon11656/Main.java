package backjoon11656;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {

    public void solution(String S){
        List<String> answer = new ArrayList<>();
        for(int i=0; i<S.length(); i++){
            answer.add(S.substring(i, S.length()));
        }
        Collections.sort(answer);
        for(String str : answer) System.out.println(str);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        Main main = new Main();
        main.solution(S);
    }
}
