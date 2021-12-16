package balloonPang;

import java.io.IOException;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33});
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    class Node{
        public int N, leftMin, rightMin;
        public Node(){
            this.N=Integer.MAX_VALUE;
            this.leftMin = Integer.MAX_VALUE;
            this.rightMin = Integer.MAX_VALUE;
        }
        public Node(int N, int Min, int i){
            this.N=N;
            if(i == 0){
                this.leftMin = Min;
                this.rightMin = Integer.MAX_VALUE;
            }else{
                this.leftMin = Integer.MAX_VALUE;
                this.rightMin = Min;
            }
        }
    }
    public int solution(int[] a) {
        if(a.length <= 3) return a.length;
        int lt = 0;
        int rt = a.length-1;
        int answer = 2;
        Node[] nodes = new Node[a.length];
        nodes[0] = new Node(a[0], a[0], 0);
        nodes[a.length-1] = new Node(a[a.length-1],a[a.length-1],a.length-1);

        for(int i=1; i<a.length-1; i++) nodes[i] = new Node();
        while(lt < a.length){
            if(rt==0) nodes[rt].rightMin = nodes[rt + 1].rightMin > nodes[rt].N ? nodes[rt].N : nodes[rt + 1].rightMin;
            if(lt==a.length-1) nodes[lt].leftMin = nodes[lt - 1].leftMin > nodes[lt].N ? nodes[lt].N : nodes[lt - 1].leftMin;
            if(lt != 0 || rt!=a.length-1){
                nodes[lt].N = a[lt];
                nodes[lt].leftMin = nodes[lt - 1].leftMin < nodes[lt].N ? nodes[lt - 1].leftMin : nodes[lt].N;
                nodes[rt].N = a[rt];
                nodes[rt].rightMin = nodes[rt + 1].rightMin < nodes[rt].N ? nodes[rt + 1].rightMin : nodes[rt].N;
            }
            lt++;
            rt--;
        }
        for(int i=1; i<a.length-1; i++)
            if(!(nodes[i-1].leftMin < nodes[i].N && nodes[i+1].rightMin < nodes[i].N)) answer++;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
