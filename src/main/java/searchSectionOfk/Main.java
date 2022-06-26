package searchSectionOfk;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int[] searchSectionOFk(List<Integer> A, int k){
        int left=0, right=A.size()-1;
        int[] result = new int[]{-1, -1};

        while(left <= right){
            int mid = left + ((right - left) / 2);

            if(A.get(mid) == k){
                result[0] = searchSection(A, k, mid-1, "pre");
                result[1] = searchSection(A, k, mid+1, "next");
                return result;
            }else if(A.get(mid) < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }
    public static int searchSection(List<Integer> A, int k, int position, String vector){
        int prePosition = vector.equals("pre") ? position + 1 : position - 1;
        if(0 <= position && position <= A.size()) {
            int nextPosition = vector.equals("pre") ? position - 1 : position + 1;
            return A.get(position) == k ? searchSection(A, k, nextPosition, vector) : prePosition;
        }
        return prePosition;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(2);
        A.add(4);
        A.add(4);
        A.add(4);
        A.add(7);
        A.add(11);
        A.add(11);
        A.add(13);
        int[] result = searchSectionOFk(A, 11);
        System.out.println(result[0] + " " + result[1]);
    }
}
