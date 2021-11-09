package Test;


import java.io.*;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, GenresClass> hashMap = partGenresSet(genres, plays);
        return sort(hashMap);
    }
    public int[] sort(HashMap<String, GenresClass> hashMap){
        int[] result={};
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

        //배열에 넣기
        for(int i=0; i<linkedList.size(); i++){

        }

        return result;
    }
    public HashMap<String, GenresClass> partGenresSet(String[] genres, int[] plays){
        HashMap<String, GenresClass> hashMap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(hashMap.containsKey(genres[i])){
                GenresClass getGenresClass = hashMap.get(genres[i]);
                Node getNode = getGenresClass.node;
                Node node = new Node(i, plays[i]);
                getGenresClass.addTotal(plays[i]);
                getNode.addNode(node);
            }else{
                GenresClass genresClass = new GenresClass(genres[i], i, plays[i]);
                genresClass.addTotal(plays[i]);
                hashMap.put(genres[i], genresClass);
            }
        }
        return hashMap;
    }
    class GenresClass{
        String genres;
        int totalCount;
        Node node;

        GenresClass(String genres, int id, int plays){
            this.genres= genres;
            totalCount = 0;
            node = new Node(id, plays);
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
        void addNode(Node node){
            Node point = this;
            while(next!=null){
                if(point.plays > node.plays){
                    point = next;
                }else{
                    break;
                }
            }
            Node temp = point.next;
            point.next = node;
            node.next = temp;
        }
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
