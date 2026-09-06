package Arrays.StandardQuestions;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int slow = 0;

        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != val) nums[slow++] = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args){
        int[] arr = {0,1,2,2,3,0,4,2};
        int ans = removeElement(arr,2);
        System.out.println("Size of the actual array :-" + arr.length);
        System.out.println("Size of the reduced array :- " + ans);
    }
}
