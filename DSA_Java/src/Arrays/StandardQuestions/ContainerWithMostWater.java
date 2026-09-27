package Arrays.StandardQuestions;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int Area = 0;

        while (start < end) {
            int currentWidth = end - start;
            int currentHeight = Math.min(height[start], height[end]);
            int currentArea = currentWidth * currentHeight;

            Area = Math.max(Area, currentArea);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return Area;
    }

    public static void main(String[] args){
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int ans = maxArea(arr);
        System.out.println("Max Area :- " + ans);
    }
}
