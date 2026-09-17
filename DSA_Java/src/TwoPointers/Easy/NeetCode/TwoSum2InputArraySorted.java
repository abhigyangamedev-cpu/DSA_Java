package TwoPointers.Easy.NeetCode;

public class TwoSum2InputArraySorted {
    public static int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];

        int n = numbers.length;
        int l = 0;
        int r = n -1;

        while( l < r){
            int sum = numbers[l] + numbers[r];

            if(sum == target){
                result[0] = l + 1;
                result[1] = r + 1;
                return result;
            }

            if(sum < target)l++;
            if(sum > target)r--;
        }

        return result;
    }

    public static void main(String[] args){
        int[] arr = {2,7,11,15};
        int[] ans = twoSum(arr,9);

        for(int ele : ans){
            System.out.print(ele + " ");
        }
    }
}
