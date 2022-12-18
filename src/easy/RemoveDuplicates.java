package easy;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int indexToInsert = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] != nums[i]){
                nums[indexToInsert] = nums[i];
                indexToInsert++;
            }
        }
        return indexToInsert;
    }

    public static void main(String[] args) {
        //int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {-3,-1,0,0,0,3,3};
        int k = new RemoveDuplicates().removeDuplicates(nums);
        System.out.println("k = " + k);
        for(int i:nums)
            System.out.println(i);
    }
}
