package ya;

import java.util.Map;
import java.util.HashMap;

public class ValidAnagram242 {

        public static boolean isAnagram(String s, String t) {

            if(t.length()>s.length())
                return false;

            if(t.equals(s))
                return true;

            Map<Character, Integer> m = new HashMap<>();

            for(int i = 0; i < s.length(); i++) {
                if(m.containsKey(s.charAt(i)))
                    m.put(s.charAt(i), m.get(s.charAt(i))+1);
                else
                    m.put(s.charAt(i), 1);
            }

            for(int i = 0; i < t.length(); i++) {
                if(m.containsKey(t.charAt(i))) {
                    if(m.get(t.charAt(i)) == 0)
                        return false;
                    m.put(t.charAt(i), m.get(t.charAt(i))-1);
                }
                else
                    return false;
            }
            m.values().removeIf(e -> e == 0);
            return m.size() == 0;
        }

    public static void main(String[] args) {
        System.out.println(isAnagram("abba", "baba"));
        System.out.println(isAnagram("abbba", "baba"));
    }
}
