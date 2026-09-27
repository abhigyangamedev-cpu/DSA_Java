package Arrays.StandardQuestions;

import Arrays.Arrays;

public class RotateArray {
    public static void swap(int[] arr,int start,int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        swap(nums,0,n-1);
        swap(nums,0,k-1);
        swap(nums,k,n-1);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr,3);

        Arrays.printArrayForLoop(arr);
    }
}
