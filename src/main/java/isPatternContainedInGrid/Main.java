package isPatternContainedInGrid;

import java.io.IOException;
import java.util.*;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        boolean result = solution(new int[]{1,3,4,6}, new int[][]{{1,2,3},{3,4,5},{5,6,7}});
//        for(String i : result)
            System.out.println(result);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    public boolean solution(int[] S, int[][] A) {
        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> pattern = new ArrayList<>();
        for(int element : S){
            pattern.add(element);
        }
        for(int[] elements : A){
            List<Integer> list = new ArrayList<>();
            for(int element : elements){
                list.add(element);
            }
            grid.add(list);
        }
        return isPatternContainedInGrid(grid, pattern);
    }

    private static class Attempt {
        public Integer x;
        public Integer y;
        public Integer offset;

        public Attempt(Integer x, Integer y, Integer offset){
            this.x =x;
            this.y = y;
            this.offset = offset;
        }

        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(o==null || getClass() !=o.getClass()){
                return false;
            }
            Attempt cachEntry = (Attempt) o;

            if(x != null ? x.equals(cachEntry.x) : cachEntry.x != null){
                return false;
            }
            if(x != null ? x.equals(cachEntry.y) : cachEntry.y != null){
                return false;
            }
            if(offset != null ? offset.equals(cachEntry.offset) : cachEntry.offset != null){
                return false;
            }
            return true;
        }

        @Override
        public int hashCode(){return Objects.hash(x, y, offset);}
    }

    public static boolean isPatternContainedInGrid(List<List<Integer>> grid, List<Integer> pattern){
        //previousAttempts에 있는 모든 엔트리는 격자의 특정 지점에서 발생한 패턴의 접미사를 표현한다. 이는 오프셋으로 알 수 있다.
        // previousAttempts가 존재한다는 건 해당 지점에서 시작하는 접미사는 존재하지 않는다는 뜻이다.
        Set<Attempt> previostAttempts = new HashSet<>();
        for(int i=0; i <grid.size(); ++i){
            for(int j=0; j<grid.size(); ++j){
                if(isPatternSuffixContainedStartingAtXY(grid, i, j, pattern, 0, previostAttempts)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPatternSuffixContainedStartingAtXY(List<List<Integer>> grid, int x, int y,
                                                                List<Integer> pattern, int offset, Set<Attempt> previousAttempts){
        if(pattern.size() == offset){
            //더이상 남아 있는게 없다.
            return true;
        }

        // (x, y)가 격자를 벗어났는지 확인한다.
        if(x<0 || x>=grid.size() || y<0 || y>=grid.get(x).size() || previousAttempts.contains(new Attempt(x, y, offset))
                || !grid.get(x).get(y).equals(pattern.get(offset))){
            return false;
        }

        if(isPatternSuffixContainedStartingAtXY(grid, x-1, y, pattern, offset+1, previousAttempts)
                || isPatternSuffixContainedStartingAtXY(grid, x+1, y, pattern, offset+1, previousAttempts)
                || isPatternSuffixContainedStartingAtXY(grid, x, y+1, pattern, offset+1, previousAttempts)){
            return true;
        }
        previousAttempts.add(new Attempt(x, y, offset));
        return false;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
