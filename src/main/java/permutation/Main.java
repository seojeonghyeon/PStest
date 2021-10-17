package permutation;


import java.io.IOException;
import java.util.Scanner;


public class Main {
    //permutation
    public boolean solution(String s, String t){
        return permutation(s, t);
    }
//    1) sort
//    public String sort(String str){
//        char[] chars = str.toCharArray();
//        java.util.Arrays.sort(chars);
//        return new String(chars);
//    }
//    public boolean permutation(String s, String t){
//        if(s.length()!=t.length())
//            return false;
//        return sort(s).equals(sort(t));
//    }
    //2) 등장횟수 검증, 최적화
    public boolean permutation(String s, String t){
        if(s.length()!=t.length())
            return false;
        int[] check = new int[128]; //ASCII라는 것이 입증되어야 가능
        for(char charS : s.toCharArray())
            check[charS]++;
        for(char charT : t.toCharArray()){
            check[charT]--;
            if(check[charT]<0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(main.solution(s, t));
    }
}
