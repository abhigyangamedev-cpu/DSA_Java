package TwoPointers.Easy.NeetCode;

public class RemoveDuplicatesFromSortedArrays {
    public static int removeDuplicates(int[] nums) {
        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }

    public static void main(String[] args){
        int[] arr = {1,1,2};

        System.out.println("Number of elements :- " + removeDuplicates(arr));
    }
}
