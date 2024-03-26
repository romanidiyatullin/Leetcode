package ya;

import java.util.Map;
import java.util.HashMap;

public class FirstUniqueChar387 {

    public static void main(String[] args) {
        System.out.println(new FirstUniqueChar387().firstUniqChar("aabb"));
    }

    public int firstUniqChar(String s) {

        if(s.length()==1)
            return 0;

        Map<Character, Integer> m = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            if(!m.containsKey(s.charAt(i)))
                m.put(s.charAt(i), 1);
            else
                m.put(s.charAt(i), m.get(s.charAt(i))+1);
        }

        for(int i=0; i<s.length();i++){
            if(m.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }
}

