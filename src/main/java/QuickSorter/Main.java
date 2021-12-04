package QuickSorter;

public class Main {
    public static void main(String[] args){
        QuickSorter.quickSort(new int[]{5,2,3,4,1});
    }
}
class QuickSorter{
    public static void quickSort(int[] arr){
        sort(arr, 0, arr.length-1);
        for(int i : arr){
            System.out.println(i);
        }
    }

    private static void sort(int[] arr, int low, int high){
        if(low >= high) return;
        int mid = partition(arr, low, high);
        sort(arr, low, mid-1);
        sort(arr, mid, high);
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[(low + high) / 2];
        while(low <= high){
            while(arr[low] < pivot) low++;
            while(arr[high] > pivot) high--;
            if(low <= high){
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
