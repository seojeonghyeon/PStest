package searchChar;

import java.util.*;

class Main {

    public int solution(String str, char searchChar) {
        int count = 0;
        str=str.toLowerCase();
        searchChar = Character.toLowerCase(searchChar);
        for(char s : str.toCharArray()) {
            if(searchChar == s)	count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char searchChar = in.next().charAt(0);
        System.out.println(main.solution(str, searchChar));
    }

}
