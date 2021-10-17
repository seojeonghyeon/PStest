package palindrome;

import java.util.Scanner;

public class Main {

    public String solution(String str){
        String answer ="NO";
        str=str.toUpperCase().replaceAll("[^A-Z]","");
        String temp = new StringBuilder(str).reverse().toString(); //뒤집기
        if(str.equals(temp)) answer = "YES";
        return str;

		/*
		 *
		 * 작성한 답안
		 *
		char[] strChar = str.toLowerCase().toCharArray();
		int lt = 0, rt=strChar.length-1;
		while(lt<rt){
			if(!Character.isAlphabetic(strChar[lt]))
				lt++;
			else if(!Character.isAlphabetic(strChar[rt]))
				rt--;
			else if(strChar[lt]!=strChar[rt])
				return "NO";
			else
				lt++; rt--;
		}
		return "YES";
		*/
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(main.solution(str));
    }

}