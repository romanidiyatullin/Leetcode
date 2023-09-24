package medium;

import java.util.Arrays;

public class ProductOfArray238 {
    public int[] productExceptSelf(int[] nums) {

        if(nums == null || nums.length<2 || nums.length>100000)
            return null;

        int[] answer = new int[nums.length];

        // Time: O(n^2):
/*        for(int i = 0; i<nums.length; i++) {
            int x = 1;
            for(int j=0; j<nums.length;j++) {
                if(i==j) continue;
                x *= nums[j];
            }
            answer[i] = x;
        }
*/
        // Time: O(n)
        // Loop#1 - fill left interval;
        answer[0]=1;
        for(int i=1; i<nums.length; i++){
            answer[i] = nums[i-1]*answer[i-1];
        }
        // Loop#2 - fill right interval:
        int multiplier = 1;
        for(int i = nums.length-1; i>=0; i--){
            answer[i]*=multiplier;
            multiplier*=nums[i];
        }

        return answer;
    }


    public static void main(String[] args) {
        // Given:      3    2   4   5
        // Answer:     40  60  30  24
        // Left loop:  [1]  3   6  24
        // Right loop: 40  20   5  [1]
        // Multiply left * right to get result
        System.out.println(Arrays.toString(new ProductOfArray238().productExceptSelf(new int[]{3,2,4,5})));
    }
}
