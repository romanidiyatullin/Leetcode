package easy;

public class Sqrtx {

    public int mySqrt(int x) {

        if(x<2)
            return x;

        if(x==2)
            return 1;

        long root = 2;

        while(root*root <= x){
            root++;
        }

        return (int)(root-1);
    }

    /* Solution via Binary Search: O(logN)*/
    public int mySqrt2(int x){

        if(x<2)
            return x;

        int max = x/2; // IMPORTANT FACT: for x>2 root cannot exceed half of x.
        int min = 1;
        long mid = max;

        while((max-min)>1) {

            if ( mid * mid == x)
                return (int)mid;
            else {
                if (mid * mid < x) {
                    min = (int)mid;
                } else {
                    max = (int)mid;
                }
                mid = min + (max-min) /2;
            }
        }
             return (int)mid;
    }


    public static void main(String[] args) {
        Sqrtx sqrtx = new Sqrtx();
        long start = System.nanoTime();
        int result = sqrtx.mySqrt(2147395599);
        long end = System.nanoTime();
        System.out.println(result + " elapsed: " + (end-start));

        start = System.nanoTime();
        result = sqrtx.mySqrt2(2147395599);
        end = System.nanoTime();
        System.out.println(result + " elapsed: " + (end-start));

        System.out.println();
    }
}
