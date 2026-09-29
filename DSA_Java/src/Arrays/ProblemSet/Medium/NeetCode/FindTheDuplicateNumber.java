package Arrays.ProblemSet.Medium.NeetCode;

public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);


        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }


        return slow;
    }

    public static void main(String[] args){

        int[] arr = {1,3,4,2,2};

        System.out.println(findDuplicate(arr));

    }
}
