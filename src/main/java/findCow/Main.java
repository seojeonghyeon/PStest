package findCow;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(5,14);
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

//    class Node{
//        int point;
//        int level;
//        Node(int point, int level){
//            this.point=point;
//            this.level=level;
//        }
//    }
//    int cowPoint = 0;
//    public int BFS(int S){
//        int level=0;
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(new Node(S, 0));
//        while(!queue.isEmpty()){
//            Node cur = queue.poll();
//            if(cur.point==cowPoint){
//                level=cur.level;
//                break;
//            }
//            if(0< cur.point && cur.point < 10000) {//넣을때 비교하면
//                queue.add(new Node(cur.point+1, cur.level+1));
//                queue.add(new Node(cur.point-1, cur.level+1));
//                queue.add(new Node(cur.point+5, cur.level+1));
//            }
//        }
//        return level;
//    }
    
    int[] dis={1,-1,5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e){
        ch=new int[10001];
        ch[s]=1;
        Q.offer(s);
        int L=0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int x=Q.poll();
                if(x==e) return L;
                for(int j=0; j<3; j++){
                    int nx=x+dis[j];
                    if(nx>=1 && nx<=10000 && ch[nx]==0){
                        ch[nx]=1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return L;
    }
    public int solution(int S, int E) {
        int answer=0;
//        cowPoint=E;
        return BFS(S,E);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
