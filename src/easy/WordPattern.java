package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {

        if(pattern == null || s == null || pattern.length() == 0 || s.length() == 0)
            return false;

        if(pattern.length() + s.length() == 2)
            return true;

        String[] words = s.split(" ");

        if(pattern.length() != words.length)
            return false;

        Map<Character, String> map = new HashMap<>();

        for(int i = 0; i<pattern.length(); i++){

            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(words[i]))
                    return false;
            }
            else {
                map.put(pattern.charAt(i), words[i]);
                if(new HashSet<>(map.values()).size() != map.size())
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog dog dog dog"));
    }
}
