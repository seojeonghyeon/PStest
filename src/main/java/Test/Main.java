package Test;

import java.io.IOException;
import java.util.*;


public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        List<String> result = solution("bedbathandbeyond.com",new String[]{"bed","bath","beyond","bat","hand"});
        for(String i : result)
            System.out.println(i);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public List<String> solution(String domain, String[] dictionary) {
        Set<String> list = new HashSet<>();
        for(String str : dictionary) list.add(str);
        return decomposeIntoDictionaryWords(domain, list);
    }
    public static List<String> decomposeIntoDictionaryWords(String domain, Set<String> dictionary){
        int[] lastLength = new int[domain.length()];
        Arrays.fill(lastLength, -1);
        for(int i=0; i<domain.length(); ++i){
            if(dictionary.contains(domain.substring(0, i+1))) lastLength[i] = i+1;
            if(lastLength[i] == -1){
                for (int j=0; j<i; ++j){
                    if(lastLength[j] != -1 && dictionary.contains(domain.substring(j+1, i+1))){
                        lastLength[i] = i-j;
                        break;
                    }
                }
            }
        }

        List<String> decompositions = new ArrayList<>();
        if(lastLength[lastLength.length-1] != -1){
            int idx = domain.length()-1;
            while(idx >= 0){
                decompositions.add(domain.substring(idx+1-lastLength[idx], idx+1));
                idx -= lastLength[idx];
            }
            Collections.reverse(decompositions);
        }
        return decompositions;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
