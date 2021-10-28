package Test;


import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public void solution(){
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")){
            return 0;
        }else if(s.length()==1){
            return 1;
        }
        int lt=0;
        int rt=1;
        int maxCount = 1;
        int result = 0;
        int spaceCount = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)==' '){
                spaceCount++;
            }
        }
        if(spaceCount!=0){
            return spaceCount%2;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put(s.charAt(lt), lt);
        while(lt < s.length()){

            if(rt == s.length()){
                hashMap = new HashMap<>();
                result = maxCount > result ? maxCount : result;
                lt++;
                rt=lt;
            }else if(hashMap.containsKey(s.charAt(rt))){
                hashMap = new HashMap<>();
                result = maxCount > result ? maxCount : result;
                lt++;
                rt=lt;
            }else if(lt == rt){
                maxCount=1;
                hashMap.put(s.charAt(lt),lt);
                rt++;
            }else{
                hashMap.put(s.charAt(rt),rt);
                rt++;
            }
        }
        return maxCount > result ? maxCount : result;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
