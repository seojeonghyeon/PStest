package menuRenewer;

import java.io.IOException;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        String[] result = solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4});
        for(String i : result)
            System.out.println(i);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    static HashMap<String, Integer> hashMap;
    static int maxOrder;
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            hashMap = new HashMap<>();
            maxOrder = 0;
            for (int j = 0; j < orders.length; j++) {
                find(0, "", course[i], 0, orders[j]);
            }
            for (String order : hashMap.keySet()) {
                if (hashMap.get(order) == maxOrder && maxOrder > 1) {
                    list.add(order);
                }
            }
        }
        return listToStringArray(list);
    }

    static void find(int count, String str, int numberOfCourse, int idx, String word) {
        if (count == numberOfCourse) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temps = "";
            for (int i = 0; i < c.length; i++) temps += c[i];
            hashMap.put(temps, hashMap.getOrDefault(temps, 0) + 1);
            maxOrder = Math.max(maxOrder, hashMap.get(temps));
            return;
        }
        for (int i = idx; i < word.length(); i++) {
            char now = word.charAt(i);
            find(count + 1, str + now, numberOfCourse, i + 1, word);
        }
    }

    private String[] listToStringArray(List<String> list){
        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }




    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
