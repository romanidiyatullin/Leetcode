package easy;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        if(nums == null || nums.length == 0 || val <0 || val >100 )
            return 0;

        int encounters = 0;

        for(int i=0, j=0; i<nums.length; i++) {
            if (nums[i] == val) {
                encounters++;
            }
            else {
                nums[j] = nums[i];
                j++;
            }
        }

        return nums.length-encounters;
    }

    public static void main(String[] args) {
        int[] array = {2,2,1,3,7,2,2};
        int remove = 2;
        System.out.println("First K elements are: " + new RemoveElement().removeElement(array,remove));
        for(int x:array)
            System.out.println(x);
    }
}
