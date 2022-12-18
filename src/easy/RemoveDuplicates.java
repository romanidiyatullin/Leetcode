package easy;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int duplicates = 0;

        for(int i=0; i<nums.length; i++){

            if(nums[i] == 999){
                for(int k = i+1; k<nums.length; k++){
                    if(nums[k] != 999){
                        nums[i] = nums[k];
                        nums[k] = 999;
                        break;
                    }
                }
            }

            if(nums[i] == 999) break;

            for(int j=i+1; j<nums.length; j++){

                if(nums[i] == nums[j]) {
                    duplicates++;
                    nums[j] = 999;
                }
            }
        }
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
