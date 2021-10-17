package mostShortWordDistance;

import java.util.Scanner;

public class Main {


    public void solution(String s, char t){
        int answer[] = new int[s.length()];
        int p=100;
        char strChar[] = s.toCharArray();
        for(int i =0; i< strChar.length; i++) {
            if(strChar[i]==t)
                p=0;
            else
                answer[i]=++p;
        }
        for(int i =strChar.length-1; i >= 0; i--) {
            if(strChar[i]==t)
                p=0;
            else {
                if(answer[i]>++p)
                    answer[i]=p;
            }
        }
        for(int i =0; i < strChar.length;i++)
            System.out.print(answer[i]+" ");
        System.out.println();

    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char t = in.next().charAt(0);
        main.solution(s, t);
    }
}