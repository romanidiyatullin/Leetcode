package easy;

import java.util.Arrays;

public class CountingBits338 {

    public int[] countBits(int n) {

        if(n>100000)
            return new int[0];

        n++;
        int[] arr = new int[n];
        arr[0] = 0;

        for(int i=1; i<arr.length; i++){
            int j = i;
            int counter =0;
            while(j>0){
                j = j &(j-1);
                counter++;
            }
            arr[i] = counter;
        }
        return arr;
    }

    public int[] countBitsSmart(int n) {

        if(n>100000) return new int[0];

        n++;
        int[] numberOf1InIndex = new int[n];
        numberOf1InIndex[0] = 0;

        // P(x) = P(x/2) + x(mod)2
        for(int x = 1; x<numberOf1InIndex.length; x++){
            numberOf1InIndex[x] = numberOf1InIndex[x/2] + x%2;
        }
        return numberOf1InIndex;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits338().countBits(5)));
        System.out.println(Arrays.toString(new CountingBits338().countBitsSmart(5)));
    }
}
