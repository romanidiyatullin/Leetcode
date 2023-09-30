package easy;

public class NumberOf1Bits {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {

            // Solution #1
            int count = 0;
            while (n != 0) {
                count++;
                n = (n) & (n - 1);
            }
            return count;



            // Solution #2
            /*
            int mask = 1;
            int count = 0;
            for(int i=0; i<32; i++){
                if((n&mask)!=0)
                    count++;
                mask<<=1;
            }

            return count;
            */

            // Solution #3
            /*
            int count = 0;
            while(n>0){
                count = (n%2)==1?count+1:count;
                n = n/2;
            }
            return count;
            */
        }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().hammingWeight(255));
    }
}
