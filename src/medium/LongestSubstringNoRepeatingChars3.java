package medium;

import java.util.Map;
import java.util.HashMap;

public class LongestSubstringNoRepeatingChars3 {
    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> m = new HashMap<>();
        int start = 0;
        int max = 0;

        for(int i=0; i<s.length(); i++){
            if(m.containsKey(s.charAt(i))) {
                start = Math.max(start, m.get(s.charAt(i))+1);
                m.put(s.charAt(i),i);
            }
            m.put(s.charAt(i), i);
            max = Math.max(max, s.substring(start,i+1).length());
        }
        return max;
    }

    public static void main(String[] args) {
       System.out.println(lengthOfLongestSubstring("abcadzxvpma")); //9
       System.out.println(lengthOfLongestSubstring("aaa"));  //1
       System.out.println(lengthOfLongestSubstring("abcdqwertyd")); //10
       System.out.println(lengthOfLongestSubstring("abba")); //2
    }

}
