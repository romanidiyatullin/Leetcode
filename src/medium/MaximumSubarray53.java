package medium;

public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {

        if(nums == null || nums.length >100000)
            return Integer.MIN_VALUE;

        int sum=0;
        int max=Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 4 -1 2 1  : 6
    }
}
