package deleteDups;


import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    public boolean solution(LinkedList<String> n){
        return deleteDups(n);
    }
    private boolean deleteDups(LinkedList<String> n){
        HashSet<String> set = new HashSet();
        LinkedList<String> previous = new LinkedList<>();
        int i=0;
        while(n!=null && i < n.size()){
            if(!set.contains(n.get(i))){
                set.add(n.get(i));
                previous.add(n.get(i));
            }
            i++;
        }
        for(i=0; i<previous.size(); i++)
            System.out.println(previous.get(i));
        return false;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
        LinkedList<String> n = new LinkedList<>();
        n.add("a");
        n.add("b");
        n.add("a");
        n.add("b");
        n.add("c");
        System.out.println(main.solution(n));
    }
}
