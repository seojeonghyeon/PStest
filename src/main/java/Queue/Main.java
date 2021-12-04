package Queue;

import java.io.IOException;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int result = solution(new String[]{"######",">#*###","####*#","#<#>>#",">#*#*<","######"});
//        for(int i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    int count = 0;

    public int solution(String[] drum) {
        int answer = 0;
        char[][] drumArray=new char[drum.length][drum[0].length()];
        for(int i=0; i<drum.length; i++){
            drumArray[i]=drum[i].toCharArray();
        }
        for(int i=0; i<drum.length; i++){
            count = 0;
            answer += move(drumArray, i, 0) == true ? 1 : 0;
        }
        return answer;
    }
    public boolean move(char[][] drum, int x, int y){
        if(drum[y][x]=='#'){
            if(y+1==drum.length){
                return true;
            }
            return move(drum, x, y+1);
        }else if(drum[y][x]=='*'){
            count++;
            if(count == 2){
                return false;
            }
            return move(drum, x, y+1);
        }else if(drum[y][x]=='>'){
            return move(drum, x+1, y);
        }else{
            return move(drum, x-1, y);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
