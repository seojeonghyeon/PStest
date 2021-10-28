package twoSum;


import java.io.IOException;
import java.util.HashMap;

public class Main {
    public void solution(){
        int[] result = twoSum(new int[]{6,4,3,8,7,5,2}, 5);
        System.out.println(result[0]+" "+result[1]);
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hashMap.containsKey(target - nums[i])){
                return new int[]{i, hashMap.get(target-nums[i])};
            }else{
                hashMap.put(nums[i],i);
            }
        }
        throw new IllegalAccessError("No two sum solution");
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
