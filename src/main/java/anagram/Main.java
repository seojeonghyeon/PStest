package anagram;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        String result = solution("AbaAeCe","baeeoCA");
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public String solution(String str1, String str2) {
        String answer = "YES";
        HashMap<Character, Integer> hashMap = new HashMap<>();
        if(str1.length()!=str2.length()){
            return "NO";
        }
        for(char x : str1.toCharArray()){
            hashMap.put(x,hashMap.getOrDefault(x,0)+1);
        }
        for(char x : str2.toCharArray()){
            if(!hashMap.containsKey(x) || hashMap.get(x)==0) return "NO";
            hashMap.put(x, hashMap.get(x)-1);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
