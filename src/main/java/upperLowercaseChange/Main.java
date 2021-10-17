package upperLowercaseChange;

import java.util.*;

public class Main {

    public String solution(String str) {
        String result="";
        for(char s : str.toCharArray()) {
            if(41<=(int)s && (int)s <= 90)
                result = result + "" +Character.toLowerCase(s);
            else if(97<=(int)s && (int)s <= 122)
                result = result + "" +Character.toUpperCase(s);
        }
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String str= in.next();
        System.out.println(main.solution(str));
    }

}