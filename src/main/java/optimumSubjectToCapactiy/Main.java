package optimumSubjectToCapactiy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(4, new int[]{60, 50, 70, 30}, new int[]{5,3,4,2}, 5);
//        for(String i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public int solution(int n, int[] values, int[] weights, int capacity){
        List<Item> items = new ArrayList<>();
        for(int i=0; i<n; i++){
            items.add(new Item(weights[i],values[i]));
        }
        return optimumSubjectToCapacity(items, capacity);
    }
    private static class Item{
        public Integer weight;
        public Integer value;
        public Item(Integer weight, Integer value){
            this.weight = weight;
            this.value = value;
        }
    }
    public static int optimumSubjectToCapacity(List<Item> items, int capacity){
        //V[i][j]는 items[0 : i]에서 전체 무게의 합이 j가 되도록 선택했을 때, 최대의 값어치와 같다.
        int[][] V = new int[items.size()][capacity+1];
        for(int[] v : V){
            Arrays.fill(v, -1);
        }
        return optimumSubjectToItemAndCapacity(items, items.size()-1, capacity, V);
    }

    //무게의 제한조건이 available_capacity이고 items[0:k]에서 선택을 했을 때, 최대가 되는 값어치를 반환한다.
    private static int optimumSubjectToItemAndCapacity(List<Item> items, int k, int availableCapacity, int[][] V){
        if(k<0){
            //아이템을 선택하지 않았다.
            return 0;
        }
        if(V[k][availableCapacity]==-1){
            int withoutCurrItem = optimumSubjectToItemAndCapacity(items, k-1, availableCapacity, V);
            int withCurrItem = availableCapacity < items.get(k).weight ? 0 : items.get(k).value + optimumSubjectToItemAndCapacity(items, k-1, availableCapacity-items.get(k).weight, V);
            V[k][availableCapacity] = Math.max(withoutCurrItem, withCurrItem);
        }
        return V[k][availableCapacity];
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
