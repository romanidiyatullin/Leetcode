package medium;

import java.util.Arrays;


public class LongestIncreasingSequence300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int longest = 0;
        for (int c: dp) {
            longest = Math.max(longest, c);
        }

        return longest;
    }

    public static void main(String[] args) {
     // System.out.println(new LongestIncreasingSequence300().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new LongestIncreasingSequence300().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
