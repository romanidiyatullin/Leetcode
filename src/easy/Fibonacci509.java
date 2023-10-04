package easy;

public class Fibonacci509 {
    public int fib(int n) {

        if(n>30) return -1;

        if(n<2) return n;

        if(n<=4) return n-1;

        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci509().fib(6));
    }
}
