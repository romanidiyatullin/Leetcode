package easy;

import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0 || nums.length > 30000)
            return -1;

        int duplicates = 0;
        int l = nums.length-1;

        for(int i=0; i<=l; i++)
        {

            if (nums[i] == 999)
            {
                nums[i] = nums[l];
                nums[l] = 999;
                l--;
            }

            for (int j = i + 1; j <= l; j++)
            {
                if (nums[i] == nums[j]) {
                    nums[j] = 999;
                    duplicates++;
                }
            }

            while (nums[l] == 999)
                l--;
        }
        Arrays.sort(nums);
        return (nums.length-duplicates);
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = new RemoveDuplicates().removeDuplicates(nums);
        System.out.println("k = " + k);
        for(int i:nums)
            System.out.println(i);
    }
}
