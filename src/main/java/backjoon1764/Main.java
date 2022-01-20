package backjoon1764;

import java.io.IOException;
import java.util.*;


public class Main {

    public void solution(String[] Narray, String[] Marray){
        HashSet<String> hashSet = new HashSet<>();
        List<String> list = new ArrayList<>();
        for(String str : Narray) hashSet.add(str);
        for(String str : Marray) {
            if(hashSet.contains(str)) list.add(str);
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(String str : list) System.out.println(str);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String[] Narray = new String[N];
        String[] Marray = new String[M];
        for(int i=0; i<N; i++){
            Narray[i] = scanner.next();
        }
        for(int i=0; i<M; i++){
            Marray[i] = scanner.next();
        }
        Main main = new Main();
        main.solution(Narray, Marray);
    }
}
