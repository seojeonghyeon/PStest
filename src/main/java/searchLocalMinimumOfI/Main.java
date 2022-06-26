package searchLocalMinimumOfI;

import java.util.*;

public class Main {

    public static int searchLocalMinimumOfI(List<Integer> A, int i){
        int left = 0, right = A.size()-1, result = -1;

        while(left <= right){
            int mid = left + ((right-left) / 2);

            if( A.get(mid-1) >= A.get(mid) && A.get(mid) <= A.get(mid+1)){
                result = mid;
                break;
            }else if( A.get(mid-1) < A.get(mid) && A.get(mid) <= A.get(mid+1)){
                right = mid - 1;
            }else if( A.get(mid-1) >= A.get(mid) && A.get(mid) > A.get(mid+1)){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(-10);
        A.add(-14);
        A.add(-28);
        A.add(108);
        A.add(233);
        A.add(243);
        A.add(285);
        A.add(285);
        A.add(285);
        A.add(401);
        System.out.println(searchLocalMinimumOfI(A, 108));
    }
}
