package Arrays.StandardQuestions;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args){
        int[] arr = {7,1,5,3,6,4};
        int ans = maxProfit(arr);
        System.out.println("Max Profit :- " + ans);
    }
}
