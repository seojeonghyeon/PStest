package prefixPhoneBook;


import java.io.IOException;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        System.out.println(solution(new String[]{"123", "456", "789"}));
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int j;
        Tree[] trees = new Tree[10];
        for(int i=0; i<phone_book.length; i++){
            char[] phoneBookChar = phone_book[i].toCharArray();
            j = Character.getNumericValue(phoneBookChar[0]);
            if(trees[j]==null) {
                trees[j] = new Tree();
            }
            if(trees[j].treeSet(trees[j].root, phoneBookChar, 0)){
                answer=false;
                break;
            }
        }

        return answer;
    }
    class Node{
        boolean marked;
        Node[] next;
        Node(){
            next = new Node[11];
        }
    }
    class Tree{
        Node root;
        Tree(){
            root = new Node();
            root.marked = true;
            root.next = new Node[11];
        }
        boolean treeSet(Node root, char[] chars, int point){
            if(chars.length-1==point){
                boolean check = false;
                for(int i = 0; i<11; i++){
                    if(root.next[i]!=null){
                        check = true;
                    }
                }
                if(root.next[10]==null) root.next[10]=new Node();
                root.next[10].marked=true;
                if(check) return true;
                return false;
            }
            if(root.next[10]!=null && root.next[10].marked){
                return true;
            }
            root.marked=true;
            int nextPoint = Character.getNumericValue(chars[point+1]);
            if(root.next[nextPoint]==null){
                root.next[nextPoint] = new Node();
                root.next[nextPoint].marked = false;
            }

            return treeSet(root.next[nextPoint], chars, point+1);
        }

    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
