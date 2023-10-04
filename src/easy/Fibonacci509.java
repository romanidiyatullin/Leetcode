package easy;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci509 {


    public int fibNaive(int n) {

        if(n>30) return -1;

        if(n==0 || n==1 ) return n;

        return (fibNaive(n-1)+fibNaive(n-2));
    }


    /* Caching results in HashMap*/
    Map<Integer, Integer> map = new HashMap<>(Map.of(0,0,1,1));

    public int fibHashMap(int n){

        if(n>30) return -1;

        if(n==0 || n==1 ) return n;


        if(map.containsKey(n))
            return map.get(n);
        else {
            map.put(n, fibHashMap(n-1)+fibHashMap(n-2));
        }

        return fibHashMap(n-1)+fibHashMap(n-2);

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //int result = new Fibonacci509().fibNaive(30);
        int result = new Fibonacci509().fibHashMap(30);
        long end = System.currentTimeMillis();
        System.out.println("RESULT: " + result);
        System.out.println("TIME ELAPSED: " + (end-start));
    }
}
