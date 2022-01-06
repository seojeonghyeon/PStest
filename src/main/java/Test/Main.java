package Test;

import java.io.IOException;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        String result = solution("...!@BaT#*..y.abcdefghijklm");
//        for(String i : result)
        System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public String solution(String new_id) {
        String answer;
        char[] str = new_id.toCharArray();
        str = functionOne(str);
        str = functionTwo(str);
        str = functionThree(str);
        answer = functionFour(str);
        if(answer.length() < 3) answer = functionFive(answer);
        return answer;
    }
    public char[] functionOne(char[] str){
        for(int i=0; i<str.length; i++){
            if('A' <= str[i] && str[i] <= 'Z'){ //대문자 -> 소문자
                str[i]=(char)(str[i]+32);
            }else if(!(('a'<=str[i] && str[i]<='z') || ('0'<=str[i] && str[i]<='9') || str[i]=='-' || str[i]=='_' || str[i]=='.')){  //알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
                str[i]=' ';
            }
        }
        return str;
    }
    public char[] functionTwo(char[] str){
        boolean check = false;
        for(int i=0; i<str.length; i++){
            if(str[i]==' ') continue;
            if(check && str[i]=='.'){
                str[i]=' ';
            }else if(!check && str[i]=='.'){
                check=true;
            }else if(check && !(str[i]=='.')){
                check=false;
            }
        }
        return str;
    }
    public char[] functionThree(char[] str){
        boolean fcheck = true;
        boolean bcheck = true;
        int lt = 0;
        int rt = str.length-1;
        while(lt<rt){
            if(str[lt]=='.' && fcheck){
                str[lt]=' ';
            }else if(str[lt]!='.' && fcheck){
                fcheck=false;
            }

            if(str[rt]=='.' && bcheck){
                str[rt]=' ';
            }else if(str[rt]!='.' && bcheck){
                bcheck=false;
            }
            if(!fcheck && !bcheck) break;
            lt++;
            rt--;
        }
        return str;
    }
    public String functionFour(char[] str){
        String result = functionSix(str);
        if(result == ""){
            return "a";
        }
        if(result.length() >= 16){
            return String.valueOf(functionThree(result.substring(0,15).toCharArray()));
        }
        return result;
    }

    public String functionSix(char[] str){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<str.length; i++){
            if(str[i]==' ') continue;
            stringBuilder.append(str[i]);
        }
        return stringBuilder.toString();
    }

    public String functionFive(String result){
        int addlength = 3-result.length();
        if(addlength > 0){
            char[] str = result.toCharArray();
            char[] copyOfStr = new char[addlength+str.length];
            for(int i=0; i<copyOfStr.length; i++){
                if(str.length > i){
                    copyOfStr[i]=str[i];
                }else{
                    copyOfStr[i]=copyOfStr[i-1];
                }
            }
            return copyOfStr.toString();
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
