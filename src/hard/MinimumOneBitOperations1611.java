package hard;

import java.util.Arrays;

public class MinimumOneBitOperations1611 {

    public int minimumOneBitOperations(int n) {

            // Find out required array size to store n in binary format:
            int arraySize = 0;
            for(int x = n; x>0; arraySize++){
                x = x/2;
            }

            int[] num = new int[arraySize];

            // Fill array with binary representation of given number n
            for(int i = arraySize-1; n>0; i--) {
                num[i] = n % 2;
                n = n / 2;
            }

            System.out.println("Binary representation for n: " + Arrays.toString(num));

            // Resolve given task :)
                return 0;

        }

        // Utility method to find out if array elements are finally converted to all zeroes
        public boolean isZero(int[] array){
            int sum=0;
            for(int i:array)
                sum+=i;
            return sum==0;
        }

        // Utility method to find out if Operation#2 is applicable to given index:
        public boolean isOp2Possible(int index, int[] array) {

            // moving to next junior bit who must be 1 for operation2 to be possible:
            index++;

            // check if index is out of bounds:
            if(index==array.length) return false;

            // if this junior is not 1 then no sense to check further - return false:
            if(array[index]!=1) return false;

            // moving to next (#2) junior bit who (as well as  others if they exist) must be 0:
            index++;

            // if non-zero detected then immediately return false:
            while(index<array.length){
                if(array[index]!=0)
                    return false;
                index++;
            }
            return true;
        }

        public int resolve(int[] array){

        int times = 0;

            // While array is not yet all zeroes do:
            while(!isZero(array)) {
                for (int i = 0; i<array.length-1; i++) {
                    while (array[i] == 0) i++;
                    // OK. We have 1 now. Let's try to convert it to 0.
                    // Check if we can apply Op#2 right away:
                    if(isOp2Possible(i, array)) {
                        array[i] = 0;
                        times++;
                    } else {
                        array[array.length-1]=0; // try to apply op#1 to see if it helps
                        times++;
                        if(isOp2Possible(i, array)){
                            array[i]=0;
                            times++;
                        }
                        else {

                        }
                    }
                }
            }

            return times;
        }

    public static void main(String[] args) {
        new MinimumOneBitOperations1611().minimumOneBitOperations(3);
    }
}