package easy;

public class MinCostClimbingStairs746 {
    public int cost(int[] cost){
        int n = cost.length+1;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1]  + Math.min(dp[0],0);
        for(int i =2; i<n-1; i++)
            dp[i] = cost[i] + Math.min(dp[i-2], dp[i-1]);
        // dp[n] - does not exist since indexes are: 0...(n-1) - there are n elements
        // dp[n-1] - top
        // dp[n-2] - pre-top
        // dp[n-3] - pre-pre-top
        return Math.min(dp[n-2],dp[n-3]);
    }

    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs746().cost(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
