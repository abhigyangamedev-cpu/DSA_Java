package Sorting;

public class InsertionSorting {

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void insertSort(int[] arr){
        if(arr == null || arr.length == 1) return;

        for(int i = 1 ; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }

            arr[++j] = key;
        }
    }

    public static void main(String[] args){
        int[] arr = {1,12,3,4,23,5,6};
        printArray(arr);

        System.out.println("After Sorting");
        insertSort(arr);
        printArray(arr);

    }
}
