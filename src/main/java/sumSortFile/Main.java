package sumSortFile;

import java.io.IOException;
import java.util.*;

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
    class Dungeon{
        int minNeedK;
        int minusK;

        public Dungeon(int minNeedK, int minusK) {
            this.minNeedK = minNeedK;
            this.minusK = minusK;
        }
    }
    public int solution(int k, int[][] dungeons){
        int answer = 0;

        return answer;
    }
    private static class ArrayEntry{
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId){
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays){
        List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
        for(List<Integer> array : sortedArrays){
            iters.add(array.iterator());
        }
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(
                ((int) sortedArrays.size()), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });
        for(int i=0; i<iters.size(); i++){
            if(iters.get(i).hasNext()){
                minHeap.add(new ArrayEntry(iters.get(i).next(),i));
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty()){
            ArrayEntry headEntry = minHeap.poll();
            result.add(headEntry.value);
            if(iters.get(headEntry.arrayId).hasNext()){
                minHeap.add(new ArrayEntry(iters.get(headEntry.arrayId).next(), headEntry.arrayId));
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
