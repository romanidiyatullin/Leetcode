package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntViaMap {
    public int romanToInt(String s) {

        Map<String, Integer> mapUsual = new HashMap<>();
        mapUsual.put("I",1);
        mapUsual.put("V",5);
        mapUsual.put("X",10);
        mapUsual.put("L",50);
        mapUsual.put("C",100);
        mapUsual.put("D",500);
        mapUsual.put("M",1000);

        Map<String, Integer> mapSpecial = new HashMap<>();
        mapSpecial.put("IV",4);
        mapSpecial.put("IX",9);
        mapSpecial.put("XL",40);
        mapSpecial.put("XC",90);
        mapSpecial.put("CD",400);
        mapSpecial.put("CM",900);

        char[] array = s.toCharArray();
        String word = "";
        int result = 0;

        for(int position = array.length-1; position>-1; position--){
            if(position-1>-1){
                word = String.valueOf(array[position-1]) + String.valueOf(array[position]);
                if(mapSpecial.containsKey(word)) {
                    result += mapSpecial.get(word);
                    position--;
                }
                else {
                    result+=mapUsual.get(String.valueOf(array[position]));
                }

            }
            else{
                word = String.valueOf(array[position]);
                result+=mapUsual.get(word);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(new RomanToIntViaMap().romanToInt("XXIV"));
    }
}
