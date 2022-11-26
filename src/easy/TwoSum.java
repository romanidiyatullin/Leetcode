package easy;

import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int index = 0; index < nums.length; index++) {

            int diff = target - nums[index];
            if(map.containsKey(diff))
                return new int[]{index, map.get(diff)};
            else{
                map.put(nums[index], index);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result = new TwoSum().twoSum(new int[]{3,2,3},6);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}

/* TRICKY MOMENTS:
*  1. IDEA: for each array element try to check remnant (total - nums[i]) via Map's method containsKey(..)
*  2. Vice versa approach - > here Map's Key is array's element value(!), Map's Value - array's element INDEX!
*     Eliminates need to traverse via entrySet() method!
*  3. AVOIDED issue with key uniqueness (how to store [3,2,3], target 6, [0,2]) via SIMULTANEOUS checks and filling!
*  */