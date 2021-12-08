package allOfAnagram;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution("bacaAacba", "abc");
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(String S, String T) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        for(char x:T.toCharArray())bm.put(x, bm.getOrDefault(x,0)+1);
        int L = T.length()-1;
        for(int i=0; i<L; i++) am.put(S.charAt(i),am.getOrDefault(S.charAt(i),0)+1);
        int lt=0;
        for(int rt=L; rt<S.length(); rt++){
            am.put(S.charAt(rt), am.getOrDefault(S.charAt(rt),0)+1);
            if(am.equals(bm)) answer++;
            am.put(S.charAt(lt),am.get(S.charAt(lt))-1);
            if(am.get(S.charAt(lt))==0) am.remove(S.charAt(lt));
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
