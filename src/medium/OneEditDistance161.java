package medium;

import java.util.Objects;

public class OneEditDistance161 {
    public static boolean isOneEditDistance(String s, String t) {

        if(Objects.equals(s, t)) return false;
        if(s.equals(t)) return false;
        if(s.isEmpty() && t.isEmpty()) return false;
        if(Math.abs(s.length()-t.length())>1) return false;

        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();

        if(s.length()==t.length())
            return testSameSize(sarr,tarr);
        if(s.length()>t.length())
            return testDiffSize(sarr,tarr);
        else
            return testDiffSize(tarr, sarr);
    }

    public static boolean testSameSize(char[] sarr, char[] tarr){
        boolean isChangeApplied = false;
        for(int i=0; i<sarr.length; i++){
            if(sarr[i] != tarr[i]) {
                if(isChangeApplied)
                    return false;
                isChangeApplied = true;
            }
        }
        return isChangeApplied;
    }

    public static boolean testDiffSize(char[] bigger, char[] smaller){

        if(bigger.length<smaller.length){
            char[] temp = bigger;
            bigger = smaller;
            smaller = temp;
        }

        boolean isChangeApplied = false;
        for(int i=0, j=0; j<smaller.length; i++, j++){
            if(bigger[i] != smaller[j]) {
                if(isChangeApplied)
                    return false;
                isChangeApplied = true;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditDistance("cab", "ad")); // false
        System.out.println(isOneEditDistance("ad", "cab")); // false

        System.out.println(isOneEditDistance("abc", "ab")); // true
        System.out.println(isOneEditDistance("abc", "ac")); // true
        System.out.println(isOneEditDistance("abc", "bc")); // true
        System.out.println(isOneEditDistance("abc", "af")); // false
        System.out.println(isOneEditDistance("abc", "bf")); // false
        System.out.println(isOneEditDistance("abc", "aa")); // false

        System.out.println(isOneEditDistance("abc", "dbc")); // true
        System.out.println(isOneEditDistance("abc", "adc")); // true
        System.out.println(isOneEditDistance("abc", "abd")); // true
        System.out.println(isOneEditDistance("abc", "add")); // false
        System.out.println(isOneEditDistance("abc", "ddc")); // false
        System.out.println(isOneEditDistance("abc", "dbf")); // false
    }
}
