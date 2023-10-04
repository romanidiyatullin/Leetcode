package medium;

import java.util.Arrays;

public class TwoSumII_167 {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length<2) return new int[0];

        int length = nums.length-1;
        for(int i=0, j=length; i<length && j>=0;){
            int sum = nums[i] + nums[j];
            if(sum == target)
                return new int[]{i+1, j+1};

            if(sum<target)
                i++;
            else j++;
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumII_167().twoSum(new int[]{2,3,4},6)));
    }
}
