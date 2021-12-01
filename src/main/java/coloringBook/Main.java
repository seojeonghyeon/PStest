package coloringBook;

import java.io.IOException;

public class Main {

    public void solution(){
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        int[] result = solution(6,6,new int[][]{{0, 0, 0, 0, 0, 1}, {0, 0, 100, 0, 0, 1}, {0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 1},{1, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1}});
        for(int i : result)
            System.out.println(i);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(ms) : "+secDiffTime);
    }

    int numberOfArea = 0;
    int maxSizeOfOneArea = Integer.MIN_VALUE;
    int[][] copyPicture;
    public int[] solution(int m, int n, int[][] picture) {
        copyPicture = picture;
        int[] answer = new int[2];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0){
                    int maxSize = coloringBook(m, n, j, i, copyPicture[i][j], copyPicture);
                    maxSizeOfOneArea = maxSize > maxSizeOfOneArea ? maxSize : maxSizeOfOneArea;
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int coloringBook(int m, int n, int x, int y, int value, int[][] picture){
        int sum = 1;
        picture[y][x]=0;
        if((n > x+1) && (picture[y][x+1] == value)){
            sum += coloringBook(m,n,x+1, y,value, picture);
        }
        if((m > y+1) && (picture[y+1][x] == value)){
            sum += coloringBook(m,n,x, y+1,value, picture);
        }

        if((0 <= x-1) && (picture[y][x-1] == value)){
            sum += coloringBook(m,n,x-1, y,value, picture);
        }
        if((0 <= y-1) && (picture[y-1][x] == value)){
            sum += coloringBook(m,n,x, y-1,value, picture);
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
