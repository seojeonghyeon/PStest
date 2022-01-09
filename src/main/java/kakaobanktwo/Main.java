package kakaobanktwo;

import java.io.IOException;
import java.util.Stack;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        long result = solution(new String[]{"()", "(()", "(", "(())"}, new String[]{")()","()", "(())", ")()"});
//        for(String i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    int right1 = 0;
    int noright1 = 0;
    int right2 = 0;
    int noright2 = 0;
    public long solution(String[] arr1, String[] arr2) {
        long answer = 0;
        boolean[] check1 = new boolean[arr1.length];
        boolean[] check2 = new boolean[arr2.length];
        for(int i=0; i< arr1.length; i++){
            check1[i]=checkRight(1, arr1[i]);
            System.out.println("1 "+check1[i]+" "+ arr1[i]);
        }
        for(int i=0; i< arr2.length; i++){
            check2[i]=checkRight(2, arr2[i]);
            System.out.println("2 "+check2[i]+" "+ arr2[i]);
        }
        answer = combinations();
        for(int i=0; i< arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                if(checkRight(3, arr1[i]+arr2[j])){
                    System.out.println(arr1[i]+arr2[j]);
                    answer++;
                }
            }
        }

        return answer;
    }
    public int combinations(){
        return right1+right2-1; // right1 C 1 + right2 C 2
    }
    public boolean checkRight(int where, String str){
        Stack<Character> stack = new Stack<>();
        if(str.length()==0) return true;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==')' && stack.isEmpty()){
                if(where==1) noright1++;
                else if(where==2) noright2++;
                return false;
            }
            if(str.charAt(i)=='(') stack.push(str.charAt(i));
            else stack.pop();
        }
        if(stack.isEmpty()) {
            if(where==1) right1++;
            else if(where==2) right2++;
            return true;
        }
        else{
            if(where==1) noright1++;
            else if(where==2) noright2++;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
