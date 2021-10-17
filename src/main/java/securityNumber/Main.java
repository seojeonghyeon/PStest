package securityNumber;


import java.util.Scanner;

public class Main {

    public String solution(int n, String str){
        String answer = "";
        for(int i =0; i < n; i++) {
            String tmp = str.substring(i*7, (i+1)*7);
            tmp=tmp.replace("#", "1");
            tmp=tmp.replace("*", "0");
            char charTmp = (char)(Integer.parseInt(tmp, 2));
            answer +=String.valueOf(charTmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        System.out.println(main.solution(n, str));;
    }
}