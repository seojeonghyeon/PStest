package levenshteinDistance;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution("Carthorse", "Orchestra");
//        for(String i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(String A, String B) {
        return levenshteinDistance(A, B);
    }
    public static int levenshteinDistance(String A, String B){
        int[][] distanceBetweenPrefixes = new int[A.length()][B.length()];
        for(int[] row : distanceBetweenPrefixes){
            Arrays.fill(row,-1);
        }
        return computeDistanceBetweenPrefixes(A, A.length()-1, B, B.length()-1, distanceBetweenPrefixes);
    }
    public static int computeDistanceBetweenPrefixes(String A, int A_idx, String B, int B_idx, int[][] distanceBetweenPrefixes){
        if(A_idx < 0){
            return B_idx+1;
        }else if(B_idx < 0){
            return A_idx+1;
        }
        if(distanceBetweenPrefixes[A_idx][B_idx] == -1){
            if(A.charAt(A_idx) == B.charAt(B_idx)){
                distanceBetweenPrefixes[A_idx][B_idx] = computeDistanceBetweenPrefixes(A, A_idx-1, B, B_idx-1, distanceBetweenPrefixes);
            }else{
                int substituteLast = computeDistanceBetweenPrefixes(A, A_idx-1, B, B_idx-1, distanceBetweenPrefixes);
                int addLast = computeDistanceBetweenPrefixes(A, A_idx, B, B_idx-1, distanceBetweenPrefixes);
                int deleteLast = computeDistanceBetweenPrefixes(A, A_idx-1, B, B_idx, distanceBetweenPrefixes);
                distanceBetweenPrefixes[A_idx][B_idx] = 1 + Math.min(substituteLast, Math.min(addLast, deleteLast));
            }
        }
        return distanceBetweenPrefixes[A_idx][B_idx];
    }



    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
