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

    public static void main(String[] args) {
        System.out.println(new Sqrtx().mySqrt(Integer.MAX_VALUE));
        System.out.println(new Sqrtx().mySqrt(0));
        System.out.println(new Sqrtx().mySqrt(1));
        System.out.println(new Sqrtx().mySqrt(2));
        System.out.println(new Sqrtx().mySqrt(3));
        System.out.println(new Sqrtx().mySqrt(4));
        System.out.println(new Sqrtx().mySqrt(8));
    }
}
