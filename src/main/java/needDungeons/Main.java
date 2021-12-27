package needDungeons;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(80, new int[][]{{80,20},{50,40},{30,10}});
//        for(int i : result)
        System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    private class Dungeon{
        public int minNeedK;
        public int minusK;

        public Dungeon(int minNeedK, int minusK) {
            this.minNeedK = minNeedK;
            this.minusK = minusK;
        }
    }
    public int solution(int k, int[][] dungeons){
        Dungeon[] nodes = new Dungeon[dungeons.length];
        for(int i=0; i<dungeons.length; i++)
            nodes[i]=new Dungeon(dungeons[i][0],dungeons[i][1]);
        for(int i=0; i<nodes.length; i++) {
            search(new boolean[nodes.length], i, nodes, k, 0);
            if(maxValue == nodes.length) break;
        }
        return maxValue;
    }
    int maxValue = 0;
    public void search(boolean[] check, int cur, Dungeon[] dungeons, int k, int count){
        boolean[] copyCheck = Arrays.copyOf(check, check.length);
        copyCheck[cur] = true;
        if(dungeons[cur].minNeedK <= k){
            k-=dungeons[cur].minusK;
            count = count+1;
            for(int i=0; i<copyCheck.length; i++){
                if(!copyCheck[i]){
                    search(copyCheck, i, dungeons, k, count);
                }
            }
        }
        maxValue = maxValue < count ? count : maxValue;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
