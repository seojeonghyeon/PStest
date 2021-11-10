package Test;


import java.io.*;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int[] result = solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        for(int i : result)
            System.out.println(i);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, GenresClass> hashMap = partGenresSet(genres, plays);
        return sort(hashMap, plays.length);
    }
    public int[] sort(HashMap<String, GenresClass> hashMap, int arraySize){
        int count = 0;
        int[] result=new int[arraySize];
        LinkedList<GenresClass> linkedList = new LinkedList<>();
        hashMap.forEach((key, value)->{
            GenresClass genresClass = value;
            for(int i=0; i<linkedList.size(); i++){
                if(linkedList.get(i)!=null && linkedList.get(i).totalCount < genresClass.totalCount){
                    linkedList.add(i,genresClass);
                    break;
                }
            }
        });

        for(int i=0; i<linkedList.size(); i++){
            GenresClass genresClass = linkedList.get(i);
            for(Node node : genresClass.linkedList){
                result[count] = node.id;
            }
        }
        return result;
    }
    public HashMap<String, GenresClass> partGenresSet(String[] genres, int[] plays){
        HashMap<String, GenresClass> hashMap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(hashMap.containsKey(genres[i])){
                GenresClass getGenresClass = hashMap.get(genres[i]);
                getGenresClass.addNode(i, plays[i]);
                getGenresClass.addTotal(plays[i]);
            }else{
                GenresClass genresClass = new GenresClass(genres[i], i, plays[i]);
                genresClass.addTotal(plays[i]);
                hashMap.put(genres[i], genresClass);
            }
        }
        return hashMap;
    }
    class GenresClass{
        private String genres;
        private int totalCount;
        private LinkedList<Node> linkedList;

        GenresClass(String genres, int id, int plays){
            this.genres= genres;
            totalCount = 0;
            linkedList = new LinkedList<>();
            Node node = new Node(id, plays);
            linkedList.add(node);
        }
        void addNode(int id, int plays){
            Node node = new Node(id, plays);
            for(int i = 0; i<linkedList.size(); i++){
                if(linkedList.get(i).plays < node.plays){
                    linkedList.add(i, node);
                }
            }
        }
        void addTotal(int plays){
            totalCount += plays;
        }
        int getTotalCount(){
            return totalCount;
        }
        String getGenres(){
            return genres;
        }
    }
    class Node{
        int id;
        int plays;
        Node next;
        Node(int id, int plays){
            this.id = id;
            this.plays = plays;
        }
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
