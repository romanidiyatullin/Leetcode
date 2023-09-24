package easy;

import java.util.Map;
import java.util.HashMap;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {

        if(nums == null || nums.length==0 || nums.length > 100000)
            return false;

        if(nums.length==1) return false;

        Map<Integer, Integer> m = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(m.containsKey(nums[i])) return true;
            else m.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        // System.out.println(new ContainsDuplicate217().containsDuplicate(new int[]{1,2,3,4,5,0,1,9,0}));
        System.out.println(new ContainsDuplicate217().containsDuplicate(new int[]{1,2,3,11}));
    }
}
