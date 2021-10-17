package urlify;


import java.io.IOException;
import java.util.Scanner;


public class Main {
    //URLify
    public String solution(String str){
        return urlify(str);
    }
    public String urlify(String str){
        str = str.replace(" ","%20");
        return str;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(main.solution(str));
    }
}
