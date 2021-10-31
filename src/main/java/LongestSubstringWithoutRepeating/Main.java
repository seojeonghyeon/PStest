package LongestSubstringWithoutRepeating;


import java.io.IOException;
import java.util.HashMap;

public class Main {
    public void solution(){
        System.out.println(lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {
        int lt=0;
        int rt=1;
        int maxCount = 1;
        int result = 0;
        char[] sArray = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put(s.charAt(lt), lt);
        while(lt < sArray.length){

            if(rt == sArray.length){
                hashMap.clear();
                result = maxCount > result ? maxCount : result;
                lt++;
                rt=lt;
            }else if(hashMap.containsKey(sArray[rt])){
                hashMap.clear();
                result = maxCount > result ? maxCount : result;
                lt++;
                rt=lt;
            }else if(lt == rt){
                maxCount=1;
                hashMap.put(sArray[lt],lt);
                rt++;
            }else{
                hashMap.put(sArray[rt],rt);
                maxCount++;
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
