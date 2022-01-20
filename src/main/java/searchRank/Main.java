package searchRank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//2021 Kakao Blind recruitment
public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int[] result = solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}, new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
        for(int i : result)
            System.out.println(i);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    Map<String, ArrayList<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map=new HashMap<>();
        for(String str : info){
            regist("", 0, str.split(" "));
        }

        for(String keyset : map.keySet()) Collections.sort(map.get(keyset));

        for(int i=0; i<query.length; i++){
            String[] splitData = query[i].replaceAll(" and ","").split(" ");
            answer[i] = search(splitData[0],Integer.parseInt(splitData[1]));
        }
        return answer;
    }
    private int search(String query, int score){
        if(!map.containsKey(query)) return 0;
        ArrayList<Integer> scoreList = map.get(query);
        int start=0;
        int end = scoreList.size()-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(scoreList.get(mid) < score){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return scoreList.size()-start;
    }

    private void regist(String cur, int depth, String[] info){
        if(depth == 4){
            ArrayList<Integer> arrayList = map.getOrDefault(cur, new ArrayList<>());
            arrayList.add(Integer.parseInt(info[4]));
            map.put(cur, arrayList);
            return;
        }
        regist(cur+"-", depth+1, info);
        regist(cur+info[depth], depth+1, info);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
