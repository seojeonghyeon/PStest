package backjoonTest;

import java.io.*;
import java.util.*;

public class Main {
    public void solution(String str, String bubbleStr) {
        if(str.length() < bubbleStr.length()) {
            System.out.println(str);
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        String bubbleStr = in.readLine();

        Main main = new Main();
        main.solution(str, bubbleStr);
    }
}
