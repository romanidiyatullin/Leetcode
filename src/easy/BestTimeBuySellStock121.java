package easy;

public class BestTimeBuySellStock121 {
    public int maxProfit(int[] prices) {

        // basic correctness check
        if (prices == null || prices.length < 2 || prices.length > 100000)
            return 0;

        int profit = 0;
        int diff;
        int minimalPrice = Integer.MAX_VALUE;

        for(int i =0; i<prices.length-1; i++){
            minimalPrice = Math.min(prices[i], minimalPrice);
            diff = prices[i] - minimalPrice;
            profit = Math.max(diff, profit);
        }

        return profit;
    }


    public static void main(String[] args) {
        System.out.println(new BestTimeBuySellStock121().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
