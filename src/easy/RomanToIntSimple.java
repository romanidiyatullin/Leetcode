package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntSimple {
    public int romanToInt(String s) {

        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] array = s.toCharArray();

        for(int i=0; i<s.length(); i++){

            if(array[i] == 'V' || array[i] == 'X'){
                if( i>0 && array[i-1] == 'I')
                    result-=2;
            }

            if(array[i] == 'L' || array[i] == 'C'){
                if( i>0 && array[i-1] == 'X')
                    result-=20;
            }

            if(array[i] == 'D' || array[i] == 'M'){
                if( i>0 && array[i-1] == 'C')
                    result-=200;
            }

            result+=map.get(array[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToIntSimple().romanToInt("XIV"));
    }
}
