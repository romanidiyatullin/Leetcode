package easy;

public class ClimbingStairs {

    public int climbStairs(int n) {

        if(n<1 || n>45)
            return 0;

        if(n==2)
            return 2;



        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(10));
    }
}
