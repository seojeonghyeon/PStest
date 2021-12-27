package printIntersectionOfIntValue;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        String[] result = solution(new int[][]{{2,-1,4},{-2,-1,4},{0,-1,1},{5,-8,-12},{5,8,12}});
        for(String i : result)
        System.out.println(i);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    private class Node{
        public long x;
        public long y;
        public long c;

        public Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    static int maxX = Integer.MIN_VALUE;
    static int maxY = Integer.MIN_VALUE;
    static int minX = Integer.MAX_VALUE;
    static int minY = Integer.MAX_VALUE;
    HashMap<Integer, TreeSet<Integer>> hashMap;

    public String[] solution(int[][] line){
        hashMap = new HashMap<>();
        HashSet<Integer> check = new HashSet<>();
        Node[] nodes = new Node[line.length];
        for(int i=0; i<line.length; i++)
            nodes[i] = new Node(line[i][0], line[i][1], line[i][2]);
        for(int i=0; i<line.length; i++){
            for(int j=0; j<line.length; j++){
                if(!check.contains(i*10+j) || i!=j){
                    intersection(nodes[i], nodes[j]);
                    check.add(i*10+j);
                    check.add(j*10+i);
                }
            }
        }
        String[] result = new String[(maxY-minY)+1];
        for(int i=0; i<(maxY-minY)+1; i++){
            StringBuilder stringBuilder = new StringBuilder();
            for(int j=0; j<(maxX-minX)+1; j++){
                if(hashMap.containsKey(i+minY) && hashMap.get(i+minY).contains(j+minX)) {
                    stringBuilder.append('*');
                }else {
                    stringBuilder.append('.');
                }
            }
            result[(maxY-minY)-i] = stringBuilder.toString();
        }
        return result;
    }
    public void intersection(Node a, Node b){
        if((a.x*b.y)-(a.y*b.x) != 0){
            Long tempx = ((a.y*b.c)-(a.c*b.y))/((a.x*b.y)-(a.y*b.x));
            int x = tempx.intValue();
            long digitX = ((a.y*b.c)-(a.c*b.y))%((a.x*b.y)-(a.y*b.x));
            Long tempy = ((a.c*b.x)-(a.x*b.c))/((a.x*b.y)-(a.y*b.x));
            int y = tempy.intValue();
            long digitY = ((a.c*b.x)-(a.x*b.c))%((a.x*b.y)-(a.y*b.x));
            if(digitX==0 && digitY==0){
                TreeSet<Integer> temp = hashMap.getOrDefault(y, new TreeSet<>());
                temp.add(x);
                hashMap.put(y, temp);
                maxX = maxX < x ? x : maxX;
                maxY = maxY < y ? y : maxY;
                minX = minX > x ? x : minX;
                minY = minY > y ? y : minY;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
