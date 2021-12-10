package partUnionDFS;

import java.io.IOException;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(new int[]{23,87,65,12,57,32,99,81},8,32);
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    //부분집합 탐색(DFS)
    static int n;
    static int[] ch;
    public void DFS(int L){
        if(L==n+1){
            String tmp="";
            for(int i=1; i<=n;i++){
                if(ch[i]==1) tmp+=(i+" ");
            }
            if(tmp.length() > 0) System.out.println(tmp);
        }else{
            ch[L]=1;
            DFS(L+1); //LEFT
            ch[L]=0;
            DFS(L+1); //RIGHT
        }
    }
    public int solution(int[] array,int N, int M) {
        int answer=0;
        n=3;
        ch=new int[n+1];
        DFS(1);
        return answer;

    }
    class Point implements Comparable<Point>{
        public int x, y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Point o){
            if(this.x==o.x) return this.y-o.y;
            else return this.x-o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
