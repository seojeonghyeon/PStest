package palindromeInteger;


import java.io.IOException;

public class Main {
    public void solution(){
        System.out.println(isPalindrome(0));
    }
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x==0){
            return true;
        }
        String xStr = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder();
        while(x != 0){
            int digit = x%10;
            stringBuilder.append(digit);
            x = x/10;
        }
        return xStr.equals(stringBuilder.toString());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
