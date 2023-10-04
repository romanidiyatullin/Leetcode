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
                System.out.println("J=" +j);
                counter++;
            }
            arr[i] = counter;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits338().countBits(5)));
    }
}
