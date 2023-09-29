package easy;
import java.util.*;

public class DegreeOfAnArray697 {

    public int findShortestSubArray(int[] nums) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                map.get(nums[i]).add(i);
            else {
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }

        int frequency = 0;
        for(int j: map.keySet()) {
            int size = map.get(j).size();
            if(size>frequency){
                frequency = size;
            }
        }

        int minLength=Integer.MAX_VALUE;
        for(int j: map.keySet()) {
            int size = map.get(j).size();
            if(size==frequency){
                int length = map.get(j).get(size-1) - map.get(j).get(0);
                length++;
                minLength = Math.min(minLength, length);
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(new DegreeOfAnArray697().findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }
}
