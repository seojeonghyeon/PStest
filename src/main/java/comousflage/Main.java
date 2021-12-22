package comousflage;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "headgear"}, {"green_turban", "eyewear"}});
//        for(int i : result)
        System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(String[][] clothes)
    {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String[] str : clothes)
            hashMap.put(str[1], hashMap.getOrDefault(str[1],0)+1);
        if(hashMap.size()>1) {
            for (String str : hashMap.keySet()) {
                int n = hashMap.get(str);
                answer *= (n + 1);
            }
            answer-=1;
        }else{
            answer = clothes.length;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
