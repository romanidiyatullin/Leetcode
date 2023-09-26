package medium;

import java.util.*;

public class CountTheNumberOfGoodSequences2539 {
    Map<Character, Integer> m = new HashMap<Character, Integer>();
    int goodCount = 0;

    public int countGoodSubsequences(String s) {
        resolveRecursively(s.toCharArray(), new StringBuilder(""), 0);
        return goodCount;
    }

    public void resolveRecursively(char[] array, StringBuilder subsequence, int positon) {
        if(positon == array.length && subsequence.length() != 0 ){
            Set<Integer> values = new HashSet<Integer>(m.values());
            if (values.size() == 1) goodCount++;

            return;
        }
        if (positon == array.length) {
            return;
        }

        subsequence.append(array[positon]);
        m.put(array[positon], m.getOrDefault(array[positon],0) + 1);
        resolveRecursively(array, subsequence, positon + 1);
        char lastLetter = subsequence.charAt(subsequence.length() - 1);
        m.put(lastLetter, m.get(lastLetter)  - 1);
        if (m.get(lastLetter) == 0) {
            m.remove(lastLetter);
        }
        subsequence.setLength(subsequence.length() - 1);
        resolveRecursively(array, subsequence, positon + 1);
    }

    public static void main(String[] args) {
        System.out.println(new CountTheNumberOfGoodSequences2539().countGoodSubsequences("aabb"));
    }
}
