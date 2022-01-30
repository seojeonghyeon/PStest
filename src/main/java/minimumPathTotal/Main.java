package minimumPathTotal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(new int[][]{
                {2},
                {4,4},
                {8,5,6},
                {4,2,6,2},
                {1,5,2,3,4}
        });
//        for(String i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(int[][] input) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i=0; i<input.length; ++i){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<input[i].length; ++j){
                temp.add(input[i][j]);
            }
            triangle.add(temp);
        }

        return minimumPathTotal(triangle);
    }

    public static int minimumPathTotal(List<List<Integer>> triangle){
        if(triangle.isEmpty()) return 0;

        //반복을 할 때마다, preRow에는 triangle.get(i-1)의 각 엔트리까지의 경로 중에서 무게가 최소가 되는 경로를 저장하고 있다.
        List<Integer> preRow = new ArrayList<>(triangle.get(0));
        for(int i=1; i<triangle.size(); ++i){
            //triangle.get(i)에 각 엔트리의 최소 경로 합을 저장한다.
            List<Integer> currRow = new ArrayList<>(triangle.get(i));
            //첫 번째 원소
            currRow.set(0, currRow.get(0) + preRow.get(0));
            for(int j=1; j<currRow.size()-1; ++j){
                currRow.set(j, currRow.get(j) + Math.min(preRow.get(j-1), preRow.get(j)));
            }
            //마지막 원소
            currRow.set(currRow.size()-1, currRow.get(currRow.size()-1)+preRow.get(preRow.size()-1));

            preRow = currRow;
        }
        return Collections.min(preRow);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
