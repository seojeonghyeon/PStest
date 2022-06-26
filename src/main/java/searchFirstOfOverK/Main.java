package searchFirstOfOverK;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int searchFirstOfOverK(List<Integer> A, int k){
        int left=0, right=A.size()-1;
        int result = A.get(left) > k ? -1 : (A.get(right) < k ? right+1 : left);

        if(result != left) return result;

        while(left <= right){
            int mid = left + ((right-left) / 2);

            if(A.get(mid) < k){
                left = mid + 1;
            }else if(A.get(mid) == k){
                left = mid + 1;
            }else {
                if(A.get(mid-1) <= k) result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(-14);
        A.add(-10);
        A.add(2);
        A.add(108);
        A.add(108);
        A.add(243);
        A.add(285);
        A.add(285);
        A.add(285);
        A.add(401);
        System.out.println(searchFirstOfOverK(A, 108));
    }
}
