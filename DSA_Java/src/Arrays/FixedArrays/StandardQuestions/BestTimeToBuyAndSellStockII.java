package Arrays.FixedArrays.StandardQuestions;

public class BestTimeToBuyAndSellStockII {
    public static int maxProfitII(int[] prices) {
        int totalProfit = 0;

        for(int i = 0; i < prices.length-1; i++){
            if(prices[i] < prices[i+1]) totalProfit += prices[i+1] - prices[i];
        }

        return totalProfit;

    }

    public static void main(String[] args){
        int[] arr = {7,1,5,3,6,4};
        int ans = maxProfitII(arr);

        System.out.println("Total Profit :- " + ans);
    }
}
