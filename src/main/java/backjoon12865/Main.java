package backjoon12865;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    private static class Item{
        public Integer weight;
        public Integer value;
        public Item(Integer weight, Integer value){
            this.weight=weight;
            this.value=value;
        }
    }

    private int solution(int N, int K, LinkedList<Item> items){
        int[][] V = new int[items.size()][K+1];
        for(int[] v : V) Arrays.fill(v, -1);
        return optimumSubjectToItemAndCapacity(items, N-1, K, V);
    }

    private static int optimumSubjectToItemAndCapacity(LinkedList<Item> items, int k, int availableCapacity, int[][] V){
        if(k<0) return 0;
        if(V[k][availableCapacity] == -1){
            int withoutCurrItem = optimumSubjectToItemAndCapacity(items, k-1, availableCapacity, V);

            int withCurrItem = availableCapacity < items.get(k).weight ? 0 : items.get(k).value + optimumSubjectToItemAndCapacity(items, k-1, availableCapacity-items.get(k).weight, V);

            V[k][availableCapacity] = Math.max(withoutCurrItem, withCurrItem);
        }
        return V[k][availableCapacity];
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = in.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        LinkedList<Item> items = new LinkedList<>();
        for(int i=0; i<N; ++i){
            String[] readline = in.readLine().split(" ");
            items.add(new Item(Integer.parseInt(readline[0]), Integer.parseInt(readline[1])));
        }
        out.write(main.solution(N, K, items) + "\n");
        out.flush();
        in.close();
        out.close();
    }
}
