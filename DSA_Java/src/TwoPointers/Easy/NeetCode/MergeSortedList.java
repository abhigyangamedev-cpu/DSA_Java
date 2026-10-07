package TwoPointers.Easy.NeetCode;

public class MergeSortedList {

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] result = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        while( i < m && j < n){
            if(nums1[i] < nums2[j]){
                result[k] = nums1[i];
                i++;
            }else{
                result[k] = nums2[j];
                j++;
            }
            k++;
        }

        while( i < m ){
            result[k] = nums1[i];
            i++;
            k++;
        }

        while( j < n){
            result[k] = nums2[j];
            j++;
            k++;
        }

        for(int x = 0 ; x < m + n; x++){
            nums1[x] = result[x];
        }


    }

    public static void main(String[] args){

        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};

        merge(arr1,3,arr2,3);

        printArray(arr1);
    }
}
