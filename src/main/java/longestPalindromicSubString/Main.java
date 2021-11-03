package longestPalindromicSubString;


import java.io.IOException;

public class Main {
    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        System.out.println(longestPalindrome("ac"));
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }
    char[] sArray;
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        sArray = s.toCharArray();
        int lt =0, rt =0;
        int maxResult = 0;
        int saveLt =0, saveRt =0;

        while(lt < sArray.length){
            boolean output = isPalindrom(lt, rt);
            if(output && ((rt-lt+1) > maxResult)){
                maxResult =(rt-lt+1);
                saveLt=lt;
                saveRt=rt;
            }
            rt++;
            if(rt == sArray.length){
                lt++;
                rt = lt;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = saveLt; i <= saveRt; i++){
            stringBuilder.append(sArray[i]);
        }
        return stringBuilder.toString();
    }
    public boolean isPalindrom(int lt, int rt){
        if(lt >= rt){
            return true;
        }
        if(sArray[lt]!=sArray[rt]){
            return false;
        }
        return isPalindrom(lt+1, rt-1);
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
