package zipString;

import java.util.Scanner;
public class Main {


    public String solution(String str){
        char strChar[] = str.toCharArray();
        char tmp=strChar[0];
        int count=1;
        String answer="";
        for(int i = 1; i<strChar.length; i++) {
            if(strChar[i]==tmp) {
                count++;
            }else{
                answer=answer+""+strChar[i-1];
                if(count!=1)
                    answer+=count;
                tmp=strChar[i];
                count=1;
            }
            if(i==strChar.length-1) {
                answer=answer+""+strChar[i];
                if(count!=1)
                    answer+=count;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(main.solution(str));;
    }

}