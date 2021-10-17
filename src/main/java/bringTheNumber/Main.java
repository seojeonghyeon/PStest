package bringTheNumber;

import java.util.Scanner;

public class Main {

    public int solution(String str){

        int answer = 0;
        for(char x : str.toCharArray())
            if(x>48 && x<=57) answer=answer*10+(x-48);  //Character.isDigit(x) Character is number = true
        return answer;
		/*
		 * Write Answer
		 *
		str=str.replaceAll("[^0-9]","");
		int n = Integer.parseInt(str);
		return n;
		*/
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(main.solution(str));
    }

}
