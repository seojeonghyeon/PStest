package isUniqueChar;


import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public int solution(String str){
        if(isUniqueChar(str)){
            return 1;
        }else{
            return 0;
        }
    }


    //isUniqueChar
    public boolean isUniqueChar(String str){
//        //1) use boolean[]
//        if(str.length()>128) return false;
//        boolean[] char_set = new boolean[128];
//        for(int i=0; i< str.length(); i++){
//            int val = str.charAt(i);
//            if(char_set[val])
//                return false;
//            char_set[val]=true;
//        }
//        return true;
        //2) Unicode -> 2^20 + 2^16 = 1,114,112
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for(int i=0; i< str.length(); i++){
            int c = str.charAt(i);
            if(hashMap.containsKey(c)){
                return false;
            }
            hashMap.put(c, true);
        }
        return true;


        //3) use bit manipulation
//        int checker=0;
//        for(int i=0; i<str.length(); i++){
//            int val = str.charAt(i)-'a';
//            if((checker & (1<<val)) >0)
//                return false;
//            checker |= (1<<val);
//        }
//        return true;

        //3)문자열 내 다른 문자 비교. O(n^2)
        //4)문자열 정렬. 앞, 뒤 비교 O(nlogn)
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(main.solution(str));
    }
}
