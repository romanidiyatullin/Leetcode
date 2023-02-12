package easy;

public class ClimbingStairs {

    public int slowClimbStairsExample(int n) {

        if(n<1 || n>45)
            return 0;

        if(n<4)
            return n;

        if(n>3)
            return slowF(n-1) + slowF(n-2);

        return 0;
    }

    public int slowF(int n){
        if(n<4)
            return n;

        return slowF(n-1) + slowF(n-2);
    }

    public int fastClimbStairs(int n) {

        if(n<1 || n>45)
            return 0;

        if(n<4)
            return n;

        if(n>3) {
            int[] cache = new int[n];
            return fastF(n - 1, cache) + fastF(n - 2, cache);
        }

        return 0;
    }

    public int fastF(int n, int[] cache){

        if(n<4)
            return n;

        if(cache[n-1]==0){
            cache[n-1] = fastF(n-1, cache) + fastF(n-2, cache);
        }

        return cache [n-1];
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int result = new ClimbingStairs().slowClimbStairsExample(45);
        //int result = new ClimbingStairs().fastClimbStairs(45);
        long endTime = System.nanoTime();
        System.out.println("Elapsed time: " + (endTime-startTime));
        System.out.println("Number of possible ways: " + result);
    }
}
